package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

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
