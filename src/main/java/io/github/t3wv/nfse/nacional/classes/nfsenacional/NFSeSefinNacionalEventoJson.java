package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

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
    private String arquivoXml;

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

    public String getArquivoXml() {
        return arquivoXml;
    }

    public NFSeSefinNacionalEventoJson setArquivoXml(String arquivoXml) {
        this.arquivoXml = arquivoXml;
        return this;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalEventoJson{" +
                "chaveAcesso='" + chaveAcesso + '\'' +
                ", tipoEvento='" + tipoEvento + '\'' +
                ", numeroPedidoRegistroEvento=" + numeroPedidoRegistroEvento +
                ", dataHoraProcessamento=" + dataHoraProcessamento +
                ", arquivoXml='" + arquivoXml + '\'' +
                '}';
    }
}
