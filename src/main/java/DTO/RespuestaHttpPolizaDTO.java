package DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public class RespuestaHttpPolizaDTO {
    private List<PolizaDTO> polizas;

    public List<PolizaDTO> getPolizas() {
        return polizas;
    }

    public void setPolizas(List<PolizaDTO> polizas) {
        this.polizas = polizas;
    }
}
