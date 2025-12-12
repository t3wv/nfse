package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

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

    public void setTipoChaveDFe(int value) {
        this.tipoChaveDFe = value;
    }

    public String getXTipoChaveDFe() {
        return xTipoChaveDFe;
    }

    public void setXTipoChaveDFe(String value) {
        this.xTipoChaveDFe = value;
    }

    public String getChaveDFe() {
        return chaveDFe;
    }

    public void setChaveDFe(String value) {
        this.chaveDFe = value;
    }

}
