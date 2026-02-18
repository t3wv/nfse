package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

import org.simpleframework.xml.Element;

public class TpDFeNacional {

    @Element(name = "tipoChaveDFe")
    protected int tipoChaveDFe;
    @Element(name = "xTipoChaveDFe")
    protected String xTipoChaveDFe;
    @Element(name = "chaveDFe")
    protected String chaveDFe;

    public int getTipoChaveDFe() {
        return tipoChaveDFe;
    }

    public TpDFeNacional setTipoChaveDFe(int value) {
        this.tipoChaveDFe = value;
        return this;
    }

    public String getXTipoChaveDFe() {
        return xTipoChaveDFe;
    }

    public TpDFeNacional setXTipoChaveDFe(String value) {
        this.xTipoChaveDFe = value;
        return this;
    }

    public String getChaveDFe() {
        return chaveDFe;
    }

    public TpDFeNacional setChaveDFe(String value) {
        this.chaveDFe = value;
        return this;
    }

}
