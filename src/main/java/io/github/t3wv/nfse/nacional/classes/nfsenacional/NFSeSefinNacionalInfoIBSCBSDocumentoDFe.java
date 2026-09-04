package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalInfoIBSCBSDocumentoDFe extends NFSeSefinNacionalInfoIBSCBSDocumento {
    @Element(name = "tipoChaveDFe")
    protected NFSeSefinNacionalInfoIBSCBSTipoChaveDFe tipoChaveDFe;
    @Element(name = "xTipoChaveDFe", required = false)
    protected String xTipoChaveDFe;
    @Element(name = "chaveDFe")
    protected String chaveDFe;

    public NFSeSefinNacionalInfoIBSCBSTipoChaveDFe getTipoChaveDFe() {
        return tipoChaveDFe;
    }

    public NFSeSefinNacionalInfoIBSCBSDocumentoDFe setTipoChaveDFe(NFSeSefinNacionalInfoIBSCBSTipoChaveDFe tipoChaveDFe) {
        this.tipoChaveDFe = tipoChaveDFe;
        return this;
    }

    public String getxTipoChaveDFe() {
        return xTipoChaveDFe;
    }

    public NFSeSefinNacionalInfoIBSCBSDocumentoDFe setxTipoChaveDFe(String xTipoChaveDFe) {
        this.xTipoChaveDFe = xTipoChaveDFe;
        return this;
    }

    public String getChaveDFe() {
        return chaveDFe;
    }

    public NFSeSefinNacionalInfoIBSCBSDocumentoDFe setChaveDFe(String chaveDFe) {
        this.chaveDFe = chaveDFe;
        return this;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalInfoIBSCBSDocumentoDFe{" +
                "tipoChaveDFe=" + tipoChaveDFe +
                ", xTipoChaveDFe='" + xTipoChaveDFe + '\'' +
                ", chaveDFe='" + chaveDFe + '\'' +
                '}';
    }
}
