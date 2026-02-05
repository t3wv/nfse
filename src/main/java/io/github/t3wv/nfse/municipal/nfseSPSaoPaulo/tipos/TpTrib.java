package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

import org.simpleframework.xml.Element;

public class TpTrib {

    @Element(name = "gIBSCBS", required = true)
    protected TpGIBSCBS gibscbs;

    public TpGIBSCBS getGIBSCBS() {
        return gibscbs;
    }

    public TpTrib setGIBSCBS(TpGIBSCBS value) {
        this.gibscbs = value;
        return this;
    }

}
