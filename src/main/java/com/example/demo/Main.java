package com.example.demo;

import DTO.PolizaDTO;
import DTO.RespuestaHttpDTO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import DTO.RespuestaHttpPolizaDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.barcodes.BarcodeInter25;

public class Main {

	public static RespuestaHttpPolizaDTO obtenerPolizas(){
		String url = "https://api.mockfly.dev/mocks/0ef422eb-e846-4d45-b7ed-44d04aae6b47/quomrest/listaPolizas";

		RequestEntity<Void> request = RequestEntity
				.method(HttpMethod.GET, UriComponentsBuilder.fromHttpUrl(url).build().toUri())
				.build();

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<RespuestaHttpPolizaDTO> responseEntity = null;
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			responseEntity = restTemplate.exchange(request, RespuestaHttpPolizaDTO.class);
			String json = restTemplate.exchange(request, String.class).getBody();
			RespuestaHttpPolizaDTO respuestaHttpDTO = objectMapper.readValue(json, RespuestaHttpPolizaDTO.class);
		} catch (HttpMessageConversionException e) {
			System.out.println("Error de conversión: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Excepción: " + e);
		}

		RespuestaHttpPolizaDTO responseBody = responseEntity.getBody();
		System.out.println(responseEntity.getBody());

		return responseBody;

	}

	public static String obtenerDatos(String htmlContent){
		String url = "https://api.mockfly.dev/mocks/0ef422eb-e846-4d45-b7ed-44d04aae6b47/quomrest/tapaPoliza?empresa=A&sucursal=CA&articulo=1&superpoliza=1067709&suplementoSuperpoliza=1&rama=1&numeroDePoliza=128310&suplementoPoliza=1";

		RequestEntity<Void> request = RequestEntity
				.method(HttpMethod.GET, UriComponentsBuilder.fromHttpUrl(url).build().toUri())
				.build();

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<RespuestaHttpDTO> responseEntity = null;
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			responseEntity = restTemplate.exchange(request, RespuestaHttpDTO.class);
			String json = restTemplate.exchange(request, String.class).getBody();
			RespuestaHttpDTO respuestaHttpDTO = objectMapper.readValue(json, RespuestaHttpDTO.class);
		} catch (HttpMessageConversionException e) {
			System.out.println("Error de conversión: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Excepción: " + e);
		}

		RespuestaHttpDTO responseBody = responseEntity.getBody();
		System.out.println(responseEntity.getBody());
		JsonNode jsonNode = objectMapper.convertValue(responseBody, JsonNode.class);

		Iterator<String> fieldNames = jsonNode.fieldNames();
		while (fieldNames.hasNext()) {
			String fieldName = fieldNames.next();
			String placeholder = "%" + fieldName + "%";
			System.out.println(placeholder);
			if (htmlContent.contains(placeholder)) {
				String value = jsonNode.get(fieldName).asText();
				htmlContent = htmlContent.replace(placeholder, value);
			}
		}

		return htmlContent;
	}

	public static void main(String[] args) throws IOException {
		File htmlFile = new File("examplePoliza.html");

		String htmlContent = new String(Files.readAllBytes(htmlFile.toPath()));
		RespuestaHttpPolizaDTO polizas = obtenerPolizas();
		List<PolizaDTO> listaDePolizas = polizas.getPolizas();
		String htmlContentFinal = obtenerDatos(htmlContent);
		int listSize = listaDePolizas.size();
		int middlePoint = listSize / 2;
		List<PolizaDTO> primeraParte = listaDePolizas.subList(0, middlePoint);
		List<PolizaDTO> segundaParte = listaDePolizas.subList(middlePoint, listSize);

		ExecutorService executor = Executors.newFixedThreadPool(2);

		executor.execute(() -> {
			try {
				procesarParte(primeraParte, "First Thread", htmlContentFinal);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		});

		executor.execute(() -> {
			try {
				procesarParte(segundaParte, "Second Thread", htmlContentFinal);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		});

		executor.shutdown();

	}

	private static void procesarParte(List<PolizaDTO> partOfList, String threadName, String htmlContentFinal) throws FileNotFoundException {
		System.out.println("Hilo " + threadName);

		for (PolizaDTO poliza : partOfList) {
			PdfWriter writer = new PdfWriter(poliza.getNombrePdf());
			PdfDocument pdf = new PdfDocument(writer);

			pdf.setDefaultPageSize(PageSize.A4);

			Document document = new Document(pdf);

			BarcodeInter25 barcode = new BarcodeInter25(pdf);

		    String codePassedBy = poliza.getEmpresa();

			barcode.setCode(codePassedBy);


			Image codeImage = new Image(barcode.createFormXObject(pdf));

			codeImage.setFixedPosition(40, 50);

			document.add(codeImage);
			ConverterProperties converterProperties = new ConverterProperties();

			HtmlConverter.convertToPdf(htmlContentFinal,pdf , converterProperties);
			document.close();

		}
	}

}