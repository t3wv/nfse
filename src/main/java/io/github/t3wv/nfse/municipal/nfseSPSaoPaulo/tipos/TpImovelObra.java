package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

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

    public TpImovelObra setInscImobFisc(String value) {
        this.inscImobFisc = value;
        return this;
    }

    public String getCCIB() {
        return ccib;
    }

    public TpImovelObra setCCIB(String value) {
        this.ccib = value;
        return this;
    }

    public String getCObra() {
        return cObra;
    }

    public TpImovelObra setCObra(String value) {
        this.cObra = value;
        return this;
    }

    public TpEnderecoSimplesIBSCBS getEnd() {
        return end;
    }

    public TpImovelObra setEnd(TpEnderecoSimplesIBSCBS value) {
        this.end = value;
        return this;
    }

}
