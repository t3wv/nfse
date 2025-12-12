package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

import org.simpleframework.xml.Element;

public class TpDocFiscalOutro {
    @Element(name = "cMunDocFiscal")
    protected int cMunDocFiscal;
    @Element(name = "nDocFiscal")
    protected String nDocFiscal;
    @Element(name = "xDocFiscal")
    protected String xDocFiscal;

    public int getCMunDocFiscal() {
        return cMunDocFiscal;
    }

    public void setCMunDocFiscal(int value) {
        this.cMunDocFiscal = value;
    }

    public String getNDocFiscal() {
        return nDocFiscal;
    }

    public void setNDocFiscal(String value) {
        this.nDocFiscal = value;
    }

    public String getXDocFiscal() {
        return xDocFiscal;
    }

    public void setXDocFiscal(String value) {
        this.xDocFiscal = value;
    }

}
