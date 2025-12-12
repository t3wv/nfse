package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

import org.simpleframework.xml.Element;

public class TpValores {

    @Element(name = "gReeRepRes", required = false)
    protected TpGrupoReeRepRes gReeRepRes;
    @Element(name = "trib")
    protected TpTrib trib;

    public TpGrupoReeRepRes getGReeRepRes() {
        return gReeRepRes;
    }

    public void setGReeRepRes(TpGrupoReeRepRes value) {
        this.gReeRepRes = value;
    }

    public TpTrib getTrib() {
        return trib;
    }

    public TpValores setTrib(TpTrib value) {
        this.trib = value;
        return this;
    }

}
