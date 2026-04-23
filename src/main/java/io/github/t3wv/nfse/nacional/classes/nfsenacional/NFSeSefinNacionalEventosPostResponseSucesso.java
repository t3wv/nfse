package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeSefinNacionalEventosPostResponseSucesso {
    @JsonProperty("tipoAmbiente")
    private Integer tipoAmbiente;

    @JsonProperty("versaoAplicativo")
    private String versaoAplicativo;

    @JsonProperty("dataHoraProcessamento")
    private ZonedDateTime dataHoraProcessamento;

    @JsonProperty("eventoXmlGZipB64")
    private String eventoXmlGZipB64;

    public Integer getTipoAmbiente() {
        return tipoAmbiente;
    }

    public void setTipoAmbiente(Integer tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
    }

    public String getVersaoAplicativo() {
        return versaoAplicativo;
    }

    public void setVersaoAplicativo(String versaoAplicativo) {
        this.versaoAplicativo = versaoAplicativo;
    }

    public ZonedDateTime getDataHoraProcessamento() {
        return dataHoraProcessamento;
    }

    public void setDataHoraProcessamento(ZonedDateTime dataHoraProcessamento) {
        this.dataHoraProcessamento = dataHoraProcessamento;
    }

    public String getEventoXmlGZipB64() {
        return eventoXmlGZipB64;
    }

    public void setEventoXmlGZipB64(String eventoXmlGZipB64) {
        this.eventoXmlGZipB64 = eventoXmlGZipB64;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalPostResponseSucesso{" +
               "tipoAmbiente=" + tipoAmbiente +
               ", versaoAplicativo='" + versaoAplicativo + '\'' +
               ", dataHoraProcessamento=" + dataHoraProcessamento +
               ", nfseXmlGZipB64='" + eventoXmlGZipB64 + '\'' +
               '}';
    }
}
