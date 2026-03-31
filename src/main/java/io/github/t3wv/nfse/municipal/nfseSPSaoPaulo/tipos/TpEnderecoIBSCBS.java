package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

import org.simpleframework.xml.Element;

public class TpEnderecoIBSCBS {

    @Element(name = "endNac", required = false)
    protected TpEnderecoNacional endNac;
    @Element(name = "endExt", required = false)
    protected TpEnderecoExterior endExt;
    @Element(name = "xLgr", required = false)
    protected String xLgr;
    @Element(name = "nro", required = false)
    protected String nro;
    @Element(name = "xCpl", required = false)
    protected String xCpl;
    @Element(name = "xBairro", required = false)
    protected String xBairro;

    public TpEnderecoNacional getEndNac() {
        return endNac;
    }

    public TpEnderecoIBSCBS setEndNac(TpEnderecoNacional value) {
        this.endNac = value;
        return this;
    }

    public TpEnderecoExterior getEndExt() {
        return endExt;
    }

    public TpEnderecoIBSCBS setEndExt(TpEnderecoExterior value) {
        this.endExt = value;
        return this;
    }

    public String getXLgr() {
        return xLgr;
    }

    public TpEnderecoIBSCBS setXLgr(String value) {
        this.xLgr = value;
        return this;
    }

    public String getNro() {
        return nro;
    }

    public TpEnderecoIBSCBS setNro(String value) {
        this.nro = value;
        return this;
    }

    public String getXCpl() {
        return xCpl;
    }

    public TpEnderecoIBSCBS setXCpl(String value) {
        this.xCpl = value;
        return this;
    }

    public String getXBairro() {
        return xBairro;
    }

    public TpEnderecoIBSCBS setXBairro(String value) {
        this.xBairro = value;
        return this;
    }

}
