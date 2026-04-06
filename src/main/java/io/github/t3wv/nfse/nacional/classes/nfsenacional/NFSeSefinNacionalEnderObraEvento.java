
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;


@Root(name = "EnderObraEvento")
public class NFSeSefinNacionalEnderObraEvento {

    @Element(required = true)
    protected String cEndPost;
    @Element(required = true)
    protected String xLgr;
    @Element(required = true)
    protected String nro;
    protected String xCpl;
    @Element(required = true)
    protected String xBairro;
    @Element(required = true)
    protected String xCidade;
    @Element(required = true)
    protected String xEstProvReg;

    public String getCEndPost() {
        return cEndPost;
    }

    public NFSeSefinNacionalEnderObraEvento setCEndPost(String value) {
        this.cEndPost = value;
        return this;
    }

    public String getXLgr() {
        return xLgr;
    }

    public NFSeSefinNacionalEnderObraEvento setXLgr(String value) {
        this.xLgr = value;
        return this;
    }

    public String getNro() {
        return nro;
    }

    public NFSeSefinNacionalEnderObraEvento setNro(String value) {
        this.nro = value;
        return this;
    }

    public String getXCpl() {
        return xCpl;
    }

    public NFSeSefinNacionalEnderObraEvento setXCpl(String value) {
        this.xCpl = value;
        return this;
    }

    public String getXBairro() {
        return xBairro;
    }

    public NFSeSefinNacionalEnderObraEvento setXBairro(String value) {
        this.xBairro = value;
        return this;
    }

    public String getXCidade() {
        return xCidade;
    }

    public NFSeSefinNacionalEnderObraEvento setXCidade(String value) {
        this.xCidade = value;
        return this;
    }

    public String getXEstProvReg() {
        return xEstProvReg;
    }

    public NFSeSefinNacionalEnderObraEvento setXEstProvReg(String value) {
        this.xEstProvReg = value;
        return this;
    }

}
