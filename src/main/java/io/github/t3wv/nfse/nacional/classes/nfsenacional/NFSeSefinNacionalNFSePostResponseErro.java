package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeSefinNacionalNFSePostResponseErro {
    @JsonProperty("tipoAmbiente")
    private Integer tipoAmbiente;

    @JsonProperty("versaoAplicativo")
    private String versaoAplicativo;

    @JsonProperty("dataHoraProcessamento")
    private ZonedDateTime dataHoraProcessamento;

    @JsonProperty("idDPS")
    private String idDPS;

    @JsonProperty("erros")
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

    public String getIdDPS() {
        return idDPS;
    }

    public void setIdDPS(String idDPS) {
        this.idDPS = idDPS;
    }

    public List<NFSeSefinNacionalMensagemProcessamento> getErros() {
        return erros;
    }

    public void setErros(List<NFSeSefinNacionalMensagemProcessamento> erros) {
        this.erros = erros;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalPostResponseErro{" +
               "tipoAmbiente=" + tipoAmbiente +
               ", versaoAplicativo='" + versaoAplicativo + '\'' +
               ", dataHoraProcessamento=" + dataHoraProcessamento +
               ", idDPS='" + idDPS + '\'' +
               ", erros=" + erros +
               '}';
    }
}
