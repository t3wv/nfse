package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

import org.simpleframework.xml.Element;

public class TpDocOutro {

    @Element(name = "nDoc")
    protected String nDoc;
    @Element(name = "xDoc")
    protected String xDoc;

    public String getNDoc() {
        return nDoc;
    }

    public void setNDoc(String value) {
        this.nDoc = value;
    }

    public String getXDoc() {
        return xDoc;
    }

    public void setXDoc(String value) {
        this.xDoc = value;
    }

}
