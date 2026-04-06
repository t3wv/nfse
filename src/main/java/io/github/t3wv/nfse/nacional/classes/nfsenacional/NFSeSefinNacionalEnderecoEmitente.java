
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "EnderecoEmitente")
public class NFSeSefinNacionalEnderecoEmitente {

    @Element(required = true)
    protected String xLgr;
    @Element(required = true)
    protected String nro;
    protected String xCpl;
    @Element(required = true)
    protected String xBairro;
    @Element(required = true)
    protected String cMun;
    @Element(name = "UF", required = false)
    protected NFSeSefinNacionalUF uf;
    @Element(name = "CEP", required = false)
    protected String cep;

    public String getXLgr() {
        return xLgr;
    }

    public NFSeSefinNacionalEnderecoEmitente setXLgr(String value) {
        this.xLgr = value;
        return this;
    }

    public String getNro() {
        return nro;
    }

    public NFSeSefinNacionalEnderecoEmitente setNro(String value) {
        this.nro = value;
        return this;
    }

    public String getXCpl() {
        return xCpl;
    }

    public NFSeSefinNacionalEnderecoEmitente setXCpl(String value) {
        this.xCpl = value;
        return this;
    }

    public String getXBairro() {
        return xBairro;
    }

    public NFSeSefinNacionalEnderecoEmitente setXBairro(String value) {
        this.xBairro = value;
        return this;
    }

    public String getCMun() {
        return cMun;
    }

    public NFSeSefinNacionalEnderecoEmitente setCMun(String value) {
        this.cMun = value;
        return this;
    }

    public NFSeSefinNacionalUF getUF() {
        return uf;
    }

    public NFSeSefinNacionalEnderecoEmitente setUF(NFSeSefinNacionalUF value) {
        this.uf = value;
        return this;
    }

    public String getCEP() {
        return cep;
    }

    public NFSeSefinNacionalEnderecoEmitente setCEP(String value) {
        this.cep = value;
        return this;
    }

}
