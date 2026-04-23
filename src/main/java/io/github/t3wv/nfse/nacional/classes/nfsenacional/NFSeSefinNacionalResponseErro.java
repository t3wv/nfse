package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeSefinNacionalResponseErro {
    @JsonProperty("tipoAmbiente")
    private Integer tipoAmbiente;

    @JsonProperty("versaoAplicativo")
    private String versaoAplicativo;

    @JsonProperty("dataHoraProcessamento")
    private ZonedDateTime dataHoraProcessamento;

    @JsonProperty("erro")
    private List<NFSeSefinNacionalMensagemProcessamento> erros;

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

    public List<NFSeSefinNacionalMensagemProcessamento> getErro() {
        return erros;
    }

    public void setErro(List<NFSeSefinNacionalMensagemProcessamento> erro) {
        this.erros = erro;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalPostResponseErro{" +
               "tipoAmbiente=" + tipoAmbiente +
               ", versaoAplicativo='" + versaoAplicativo + '\'' +
               ", dataHoraProcessamento=" + dataHoraProcessamento +
               ", erros=" + erros +
               '}';
    }
}
