package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

import org.simpleframework.xml.Element;

public class TpEnderecoExterior {

    @Element(required = true)
    protected String cPais;
    @Element(required = true)
    protected String cEndPost;
    @Element(required = true)
    protected String xCidade;
    @Element(required = true)
    protected String xEstProvReg;

    public String getCPais() {
        return cPais;
    }

    public void setCPais(String value) {
        this.cPais = value;
    }

    public String getCEndPost() {
        return cEndPost;
    }

    public void setCEndPost(String value) {
        this.cEndPost = value;
    }

    public String getXCidade() {
        return xCidade;
    }

    public void setXCidade(String value) {
        this.xCidade = value;
    }

    public String getXEstProvReg() {
        return xEstProvReg;
    }

    public void setXEstProvReg(String value) {
        this.xEstProvReg = value;
    }

}
