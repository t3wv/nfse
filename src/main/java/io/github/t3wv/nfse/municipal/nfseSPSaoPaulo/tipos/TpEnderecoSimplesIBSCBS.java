package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

import org.simpleframework.xml.Element;

public class TpEnderecoSimplesIBSCBS {

    @Element(name = "CEP")
    protected Integer cep;
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

    public Integer getCEP() {
        return cep;
    }

    public TpEnderecoSimplesIBSCBS setCEP(Integer value) {
        this.cep = value;
        return this;
    }

    public TpEnderecoExterior getEndExt() {
        return endExt;
    }

    public TpEnderecoSimplesIBSCBS setEndExt(TpEnderecoExterior value) {
        this.endExt = value;
        return this;
    }

    public String getXLgr() {
        return xLgr;
    }

    public TpEnderecoSimplesIBSCBS setXLgr(String value) {
        this.xLgr = value;
        return this;
    }

    public String getNro() {
        return nro;
    }

    public TpEnderecoSimplesIBSCBS setNro(String value) {
        this.nro = value;
        return this;
    }

    public String getXCpl() {
        return xCpl;
    }

    public TpEnderecoSimplesIBSCBS setXCpl(String value) {
        this.xCpl = value;
        return this;
    }

    public String getXBairro() {
        return xBairro;
    }

    public TpEnderecoSimplesIBSCBS setXBairro(String value) {
        this.xBairro = value;
        return this;
    }

}
