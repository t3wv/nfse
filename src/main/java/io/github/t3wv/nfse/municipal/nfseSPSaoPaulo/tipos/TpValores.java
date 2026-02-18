package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

import org.simpleframework.xml.Element;

public class TpValores {

    @Element(name = "gReeRepRes", required = false)
    protected TpGrupoReeRepRes gReeRepRes;
    @Element(name = "trib")
    protected TpTrib trib;

    public TpGrupoReeRepRes getGReeRepRes() {
        return gReeRepRes;
    }

    public TpValores setGReeRepRes(TpGrupoReeRepRes value) {
        this.gReeRepRes = value;
        return this;
    }

    public TpTrib getTrib() {
        return trib;
    }

    public TpValores setTrib(TpTrib value) {
        this.trib = value;
        return this;
    }

}
