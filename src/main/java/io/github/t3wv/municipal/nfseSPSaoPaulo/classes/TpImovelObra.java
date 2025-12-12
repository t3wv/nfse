package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

import org.simpleframework.xml.Element;

public class TpImovelObra {

    @Element(name = "inscImobFisc")
    protected String inscImobFisc;
    @Element(name = "ccib")
    protected String ccib;
    @Element(name = "cObra")
    protected String cObra;
    @Element(name = "end")
    protected TpEnderecoSimplesIBSCBS end;

    public String getInscImobFisc() {
        return inscImobFisc;
    }

    public void setInscImobFisc(String value) {
        this.inscImobFisc = value;
    }

    public String getCCIB() {
        return ccib;
    }

    public void setCCIB(String value) {
        this.ccib = value;
    }

    public String getCObra() {
        return cObra;
    }

    public void setCObra(String value) {
        this.cObra = value;
    }

    public TpEnderecoSimplesIBSCBS getEnd() {
        return end;
    }

    public void setEnd(TpEnderecoSimplesIBSCBS value) {
        this.end = value;
    }

}
