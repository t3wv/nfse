package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.t3wv.nfse.utils.NFSePersister;
import io.github.t3wv.nfse.utils.NFSeUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;

/**
 * Representa um evento relacionado à NFSe na SEFIN Nacional.
 *
 * Essa classe representa os objetos do array 'eventos' do tipo EventosPostResponseSucesso que
 * no swagger da SEFIN Nacional não está condizente com a documentação apresentada.
 *
 * Em tese deveria ser um campo chamado 'eventoXmlGZipB64' no json de retorno.
 *
 * @see NFSeSefinNacionalNFSePostResponseSucesso
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeSefinNacionalEventoJson {
    @JsonProperty("chaveAcesso")
    private String chaveAcesso;

    @JsonProperty("tipoEvento")
    private String tipoEvento;

    @JsonProperty("numeroPedidoRegistroEvento")
    private int numeroPedidoRegistroEvento;

    @JsonProperty("dataHoraRecebimento")
    private LocalDateTime dataHoraProcessamento;

    @JsonProperty("arquivoXml")
    private String arquivoXmlB64;

    public String getChaveAcesso() {
        return chaveAcesso;
    }

    public NFSeSefinNacionalEventoJson setChaveAcesso(String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
        return this;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public NFSeSefinNacionalEventoJson setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
        return this;
    }

    public int getNumeroPedidoRegistroEvento() {
        return numeroPedidoRegistroEvento;
    }

    public NFSeSefinNacionalEventoJson setNumeroPedidoRegistroEvento(int numeroPedidoRegistroEvento) {
        this.numeroPedidoRegistroEvento = numeroPedidoRegistroEvento;
        return this;
    }

    public LocalDateTime getDataHoraProcessamento() {
        return dataHoraProcessamento;
    }

    public NFSeSefinNacionalEventoJson setDataHoraProcessamento(LocalDateTime dataHoraProcessamento) {
        this.dataHoraProcessamento = dataHoraProcessamento;
        return this;
    }

    public String getArquivoXmlB64() {
        return arquivoXmlB64;
    }

    public NFSeSefinNacionalEventoJson setArquivoXml(String arquivoXml) {
        this.arquivoXmlB64 = arquivoXml;
        return this;
    }

    public String getEventoXmlString() throws IOException {
        return NFSeUtils.decodeXmlGZipB64(new String(Base64.getDecoder().decode(arquivoXmlB64))); // Sim, vem um base64 de um base64
    }

    public NFSeSefinNacionalEvento getEventoXmlObject() throws Exception {
        return new NFSePersister().read(NFSeSefinNacionalEvento.class, this.getEventoXmlString());
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalEventoJson{" +
                "chaveAcesso='" + chaveAcesso + '\'' +
                ", tipoEvento='" + tipoEvento + '\'' +
                ", numeroPedidoRegistroEvento=" + numeroPedidoRegistroEvento +
                ", dataHoraProcessamento=" + dataHoraProcessamento +
                ", arquivoXml='" + arquivoXmlB64 + '\'' +
                '}';
    }
}
