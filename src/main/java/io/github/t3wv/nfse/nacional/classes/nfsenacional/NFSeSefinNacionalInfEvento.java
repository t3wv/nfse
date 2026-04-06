
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.time.ZonedDateTime;

@Root(name = "infEvento")
public class NFSeSefinNacionalInfEvento {

    @Element(name = "verAplic", required = false)
    protected String versaoApp;
    @Element(name = "ambGer")
    protected NFSeSefinNacionalInfEventoAmbienteGeracao ambienteGeracao;
    @Element(name = "nSeqEvento")
    protected String numeroSequencialEvento;
    @Element(name = "dhProc")
    protected ZonedDateTime dataHoraProcessamento;
    @Element(name = "nDFe")
    protected String numeroDFe;
    @Element(name = "pedRegEvento")
    protected NFSeSefinNacionalPedRegEvt pedidoRegistroEvento;
    @Attribute(name = "Id")
    protected String id;

    public String getVersaoApp() {
        return versaoApp;
    }

    public NFSeSefinNacionalInfEvento setVersaoApp(String value) {
        this.versaoApp = value;
        return this;
    }

    public NFSeSefinNacionalInfEventoAmbienteGeracao getAmbienteGeracao() {
        return ambienteGeracao;
    }

    public NFSeSefinNacionalInfEvento setAmbienteGeracao(NFSeSefinNacionalInfEventoAmbienteGeracao value) {
        this.ambienteGeracao = value;
        return this;
    }

    public String getNumeroSequencialEvento() {
        return numeroSequencialEvento;
    }

    public NFSeSefinNacionalInfEvento setNumeroSequencialEvento(String numeroSequencialEvento) {
        this.numeroSequencialEvento = numeroSequencialEvento;
        return this;
    }

    public ZonedDateTime getDataHoraProcessamento() {
        return dataHoraProcessamento;
    }

    public NFSeSefinNacionalInfEvento setDataHoraProcessamento(ZonedDateTime value) {
        this.dataHoraProcessamento = value;
        return this;
    }

    public String getNumeroDFe() {
        return numeroDFe;
    }

    public NFSeSefinNacionalInfEvento setNumeroDFe(String numeroDFe) {
        this.numeroDFe = numeroDFe;
        return this;
    }

    public NFSeSefinNacionalPedRegEvt getPedidoRegistroEvento() {
        return pedidoRegistroEvento;
    }

    public NFSeSefinNacionalInfEvento setPedidoRegistroEvento(NFSeSefinNacionalPedRegEvt pedidoRegistroEvento) {
        this.pedidoRegistroEvento = pedidoRegistroEvento;
        return this;
    }

    public String getId() {
        return id;
    }

    /**
     * Identificador do evento: "EVT" + Chave de acesso(50) Tipo do evento (6) + Pedido de Registro do Evento(3) (nPedRegEvento)
     * @param value
     */
    public NFSeSefinNacionalInfEvento setId(String value) {
        this.id = value;
        return this;
    }

}
