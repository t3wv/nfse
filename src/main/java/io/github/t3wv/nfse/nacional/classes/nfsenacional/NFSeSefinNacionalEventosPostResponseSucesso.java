package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.t3wv.nfse.utils.NFSePersister;
import io.github.t3wv.nfse.utils.NFSeUtils;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;

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

    @JsonProperty("eventos")
    private List<NFSeSefinNacionalEventoJson> eventos;

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

    public String getEventoXmlString() throws IOException { return NFSeUtils.decodeXmlGZipB64(eventoXmlGZipB64); }

    public NFSeSefinNacionalEvento getEventoXMLObject() throws Exception { return new NFSePersister().read(NFSeSefinNacionalEvento.class, this.getEventoXmlString()); }

    public List<NFSeSefinNacionalEventoJson> getEventos() { return eventos; }

    public NFSeSefinNacionalEventosPostResponseSucesso setEventos(List<NFSeSefinNacionalEventoJson> eventos) {
        this.eventos = eventos;
        return this;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalPostResponseSucesso{" +
               "tipoAmbiente=" + tipoAmbiente +
               ", versaoAplicativo='" + versaoAplicativo + '\'' +
               ", dataHoraProcessamento=" + dataHoraProcessamento +
               ", eventoXmlGZipB64='" + eventoXmlGZipB64 + '\'' +
               '}';
    }
}
