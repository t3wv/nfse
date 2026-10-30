package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.t3wv.nfse.utils.NFSePersister;
import io.github.t3wv.nfse.utils.NFSeUtils;

import java.io.IOException;

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

    public String getNFSeXmlString() throws IOException {
        return NFSeUtils.decodeXmlGZipB64(nfseXmlGZipB64);
    }

    public NFSeSefinNacionalNFSe getNFSeXMLObject() throws Exception {
        // Não estrito: uma NFS-e emitida num leiaute anterior traz elementos que o modelo atual não tem
        // (ex.: vDedRed, gReeRepRes, finNFSe no IBSCBS antes da NT SE/CGNFS-e 009) e deve continuar legível.
        return new NFSePersister(false).read(NFSeSefinNacionalNFSe.class, this.getNFSeXmlString());
    }
}
