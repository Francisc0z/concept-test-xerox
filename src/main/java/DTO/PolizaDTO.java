package DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public class PolizaDTO {
    private String empresa;
    private String sucursal;
    private int articulo;
    private int superpoliza;
    private int suplementoSuperpoliza;
    private int rama;
    private int numeroDePoliza;
    private int suplementoPoliza;
    private String nombrePdf;
    private List<Formulario> formularios;

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public int getArticulo() {
        return articulo;
    }

    public void setArticulo(int articulo) {
        this.articulo = articulo;
    }

    public int getSuperpoliza() {
        return superpoliza;
    }

    public void setSuperpoliza(int superpoliza) {
        this.superpoliza = superpoliza;
    }

    public int getSuplementoSuperpoliza() {
        return suplementoSuperpoliza;
    }

    public void setSuplementoSuperpoliza(int suplementoSuperpoliza) {
        this.suplementoSuperpoliza = suplementoSuperpoliza;
    }

    public int getRama() {
        return rama;
    }

    public void setRama(int rama) {
        this.rama = rama;
    }

    public int getNumeroDePoliza() {
        return numeroDePoliza;
    }

    public void setNumeroDePoliza(int numeroDePoliza) {
        this.numeroDePoliza = numeroDePoliza;
    }

    public int getSuplementoPoliza() {
        return suplementoPoliza;
    }

    public void setSuplementoPoliza(int suplementoPoliza) {
        this.suplementoPoliza = suplementoPoliza;
    }

    public String getNombrePdf() {
        return nombrePdf;
    }

    public void setNombrePdf(String nombrePdf) {
        this.nombrePdf = nombrePdf;
    }

    public List<Formulario> getFormularios() {
        return formularios;
    }

    public void setFormularios(List<Formulario> formularios) {
        this.formularios = formularios;
    }
}