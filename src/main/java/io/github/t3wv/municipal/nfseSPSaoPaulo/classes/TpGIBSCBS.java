package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

import org.simpleframework.xml.Element;

public class TpGIBSCBS {

    @Element(name = "cClassTrib")
    protected String cClassTrib;
    @Element(name = "gTribRegular", required = false)
    protected TpGTribRegular gTribRegular;

    public String getCClassTrib() {
        return cClassTrib;
    }

    public TpGIBSCBS setCClassTrib(String value) {
        this.cClassTrib = value;
        return this;
    }

    public TpGTribRegular getGTribRegular() {
        return gTribRegular;
    }

    public void setGTribRegular(TpGTribRegular value) {
        this.gTribRegular = value;
    }

}
