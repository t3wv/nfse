package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

import org.simpleframework.xml.Element;

import java.time.LocalDate;

public class TpAtividadeEvento {

    @Element(name = "xNomeEvt")
    protected String xNomeEvt;
    @Element(name = "dtIniEvt")
    protected LocalDate dtIniEvt;
    @Element(name = "dtFimEvt")
    protected LocalDate dtFimEvt;
    @Element(name = "end")
    protected TpEnderecoSimplesIBSCBS end;

    public String getXNomeEvt() {
        return xNomeEvt;
    }

    public TpAtividadeEvento setXNomeEvt(String value) {
        this.xNomeEvt = value;
        return this;
    }

    public LocalDate getDtIniEvt() {
        return dtIniEvt;
    }

    public TpAtividadeEvento setDtIniEvt(LocalDate value) {
        this.dtIniEvt = value;
        return this;
    }

    public LocalDate getDtFimEvt() {
        return dtFimEvt;
    }

    public TpAtividadeEvento setDtFimEvt(LocalDate value) {
        this.dtFimEvt = value;
        return this;
    }

    public TpEnderecoSimplesIBSCBS getEnd() {
        return end;
    }

    public TpAtividadeEvento setEnd(TpEnderecoSimplesIBSCBS value) {
        this.end = value;
        return this;
    }

}
