package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

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

    public TpDocFiscalOutro setCMunDocFiscal(int value) {
        this.cMunDocFiscal = value;
        return this;
    }

    public String getNDocFiscal() {
        return nDocFiscal;
    }

    public TpDocFiscalOutro setNDocFiscal(String value) {
        this.nDocFiscal = value;
        return this;
    }

    public String getXDocFiscal() {
        return xDocFiscal;
    }

    public TpDocFiscalOutro setXDocFiscal(String value) {
        this.xDocFiscal = value;
        return this;
    }

}
