package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

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

    public TpEnderecoExterior setCPais(String value) {
        this.cPais = value;
        return this;
    }

    public String getCEndPost() {
        return cEndPost;
    }

    public TpEnderecoExterior setCEndPost(String value) {
        this.cEndPost = value;
        return this;
    }

    public String getXCidade() {
        return xCidade;
    }

    public TpEnderecoExterior setXCidade(String value) {
        this.xCidade = value;
        return this;
    }

    public String getXEstProvReg() {
        return xEstProvReg;
    }

    public TpEnderecoExterior setXEstProvReg(String value) {
        this.xEstProvReg = value;
        return this;
    }

}
