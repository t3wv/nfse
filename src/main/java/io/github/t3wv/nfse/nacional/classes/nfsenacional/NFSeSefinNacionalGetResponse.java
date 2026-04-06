package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeSefinNacionalGetResponse {
    @JsonProperty("tipoAmbiente")
    private Integer tipoAmbiente;

    @JsonProperty("versaoAplicativo")
    private String versaoAplicativo;

    @JsonProperty("dataHoraProcessamento")
    private String dataHoraProcessamento;

    @JsonProperty("chaveAcesso")
    private String chaveAcesso;

    @JsonProperty("nfseXmlGZipB64")
    private String nfseXmlGZipB64;

    public Integer getTipoAmbiente() {
        return tipoAmbiente;
    }

    public NFSeSefinNacionalGetResponse setTipoAmbiente(Integer tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
        return this;
    }

    public String getVersaoAplicativo() {
        return versaoAplicativo;
    }

    public NFSeSefinNacionalGetResponse setVersaoAplicativo(String versaoAplicativo) {
        this.versaoAplicativo = versaoAplicativo;
        return this;
    }

    public String getDataHoraProcessamento() {
        return dataHoraProcessamento;
    }

    public NFSeSefinNacionalGetResponse setDataHoraProcessamento(String dataHoraProcessamento) {
        this.dataHoraProcessamento = dataHoraProcessamento;
        return this;
    }

    public String getChaveAcesso() {
        return chaveAcesso;
    }

    public NFSeSefinNacionalGetResponse setChaveAcesso(String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
        return this;
    }

    public String getNfseXmlGZipB64() {
        return nfseXmlGZipB64;
    }

    public NFSeSefinNacionalGetResponse setNfseXmlGZipB64(String nfseXmlGZipB64) {
        this.nfseXmlGZipB64 = nfseXmlGZipB64;
        return this;
    }
}
