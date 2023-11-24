package DTO;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class RespuestaHttpDTO {
        private String descripcionRama;
        private String cuit;
        private String nombreAsegurado;
        private String domicilio;
        private String provincia;
        private Integer cp;
        private String tipoDocumento;
        private String numeroDocumento;
        private String referencia;
        private Integer numeroDePoliza;
        private Integer suplemento;

        private String vigenciaDesde;

        private String vigenciaHasta;
        private String lugarFechaDeEmision;
        private BigDecimal sumaAsegurada;
        private BigDecimal prima;
        private BigDecimal recargoFinanciero;
        private BigDecimal iva;
        private BigDecimal impuestosSellados;
        private BigDecimal premioTotal;
        private String clausulas;
        private String anexos;
        private String acreedorPrendario;

    public String getDescripcionRama() {
        return descripcionRama;
    }

    public void setDescripcionRama(String descripcionRama) {
        this.descripcionRama = descripcionRama;
    }

    public String getCUIT() {
        return cuit;
    }

    public void setCUIT(String CUIT) {
        this.cuit = cuit;
    }

    public String getNombreAsegurado() {
        return nombreAsegurado;
    }

    public void setNombreAsegurado(String nombreAsegurado) {
        this.nombreAsegurado = nombreAsegurado;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Integer getNumeroDePoliza() {
        return numeroDePoliza;
    }

    public void setNumeroDePoliza(Integer numeroDePoliza) {
        this.numeroDePoliza = numeroDePoliza;
    }

    public Integer getSuplemento() {
        return suplemento;
    }

    public void setSuplemento(Integer suplemento) {
        this.suplemento = suplemento;
    }

    public String getVigenciaDesde() {
        return vigenciaDesde;
    }

    public void setVigenciaDesde(String vigenciaDesde) {
        this.vigenciaDesde = vigenciaDesde;
    }

    public String getVigenciaHasta() {
        return vigenciaHasta;
    }

    public void setVigenciaHasta(String vigenciaHasta) {
        this.vigenciaHasta = vigenciaHasta;
    }

    public String getLugarFechaDeEmision() {
        return lugarFechaDeEmision;
    }

    public void setLugarFechaDeEmision(String lugarFechaDeEmision) {
        this.lugarFechaDeEmision = lugarFechaDeEmision;
    }

    public BigDecimal getSumaAsegurada() {
        return sumaAsegurada;
    }

    public void setSumaAsegurada(BigDecimal sumaAsegurada) {
        this.sumaAsegurada = sumaAsegurada;
    }

    public BigDecimal getPrima() {
        return prima;
    }

    public void setPrima(BigDecimal prima) {
        this.prima = prima;
    }

    public BigDecimal getRecargoFinanciero() {
        return recargoFinanciero;
    }

    public void setRecargoFinanciero(BigDecimal recargoFinanciero) {
        this.recargoFinanciero = recargoFinanciero;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getImpuestosSellados() {
        return impuestosSellados;
    }

    public void setImpuestosSellados(BigDecimal impuestosSellados) {
        this.impuestosSellados = impuestosSellados;
    }

    public BigDecimal getPremioTotal() {
        return premioTotal;
    }

    public void setPremioTotal(BigDecimal premioTotal) {
        this.premioTotal = premioTotal;
    }

    public String getClausulas() {
        return clausulas;
    }

    public void setClausulas(String clausulas) {
        this.clausulas = clausulas;
    }

    public String getAnexos() {
        return anexos;
    }

    public void setAnexos(String anexos) {
        this.anexos = anexos;
    }

    public String getAcreedorPrendario() {
        return acreedorPrendario;
    }

    public void setAcreedorPrendario(String acreedorPrendario) {
        this.acreedorPrendario = acreedorPrendario;
    }
}