package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

import org.simpleframework.xml.Element;

public class TpDocOutro {

    @Element(name = "nDoc")
    protected String nDoc;
    @Element(name = "xDoc")
    protected String xDoc;

    public String getNDoc() {
        return nDoc;
    }

    public TpDocOutro setNDoc(String value) {
        this.nDoc = value;
        return this;
    }

    public String getXDoc() {
        return xDoc;
    }

    public TpDocOutro setXDoc(String value) {
        this.xDoc = value;
        return this;
    }

}
