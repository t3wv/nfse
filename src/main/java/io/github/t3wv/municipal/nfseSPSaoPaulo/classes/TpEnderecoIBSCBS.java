package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

import org.simpleframework.xml.Element;

public class TpEnderecoIBSCBS {

    @Element(name = "endNac")
    protected TpEnderecoNacional endNac;
    @Element(name = "endExt")
    protected TpEnderecoExterior endExt;
    @Element(name = "xLgr")
    protected String xLgr;
    @Element(name = "nro")
    protected String nro;
    @Element(name = "xCpl")
    protected String xCpl;
    @Element(name = "xBairro")
    protected String xBairro;

    public TpEnderecoNacional getEndNac() {
        return endNac;
    }

    public void setEndNac(TpEnderecoNacional value) {
        this.endNac = value;
    }

    public TpEnderecoExterior getEndExt() {
        return endExt;
    }

    public void setEndExt(TpEnderecoExterior value) {
        this.endExt = value;
    }

    public String getXLgr() {
        return xLgr;
    }

    public void setXLgr(String value) {
        this.xLgr = value;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String value) {
        this.nro = value;
    }

    public String getXCpl() {
        return xCpl;
    }

    public void setXCpl(String value) {
        this.xCpl = value;
    }

    public String getXBairro() {
        return xBairro;
    }

    public void setXBairro(String value) {
        this.xBairro = value;
    }

}
