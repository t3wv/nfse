package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

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

    public void setXNomeEvt(String value) {
        this.xNomeEvt = value;
    }

    public LocalDate getDtIniEvt() {
        return dtIniEvt;
    }

    public void setDtIniEvt(LocalDate value) {
        this.dtIniEvt = value;
    }

    public LocalDate getDtFimEvt() {
        return dtFimEvt;
    }

    public void setDtFimEvt(LocalDate value) {
        this.dtFimEvt = value;
    }

    public TpEnderecoSimplesIBSCBS getEnd() {
        return end;
    }

    public void setEnd(TpEnderecoSimplesIBSCBS value) {
        this.end = value;
    }

}
