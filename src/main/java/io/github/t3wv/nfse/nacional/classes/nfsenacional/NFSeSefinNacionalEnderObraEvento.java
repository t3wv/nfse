package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;


@Root(name = "EnderObraEvento")
public class NFSeSefinNacionalEnderObraEvento {

    @Element(name = "CEP", required = false)
    protected String cep;
    @Element(name = "endExt", required = false)
    protected NFSeSefinNacionalEnderExtSimples enderecoExterior;
    @Element(name = "xLgr")
    protected String xLgr;
    @Element(name = "nro")
    protected String nro;
    @Element(name = "xCpl", required = false)
    protected String xCpl;
    @Element(name = "xBairro")
    protected String xBairro;

    /**
     * CEP do endereço da obra
     * @return CEP do endereço da obra
     */
    public String getCEP() {
        return cep;
    }

    /**
     * Define o CEP do endereço da obra
     * @param value CEP do endereço da obra
     */
    public NFSeSefinNacionalEnderObraEvento setCEP(String value) {
        this.cep = value;
        return this;
    }

    /**
     * Endereço no exterior da obra
     * @return Endereço no exterior da obra
     */
    public NFSeSefinNacionalEnderExtSimples getEnderecoExterior() {
        return enderecoExterior;
    }

    /**
     * Define o endereço no exterior da obra
     * @param value Endereço no exterior da obra
     */
    public NFSeSefinNacionalEnderObraEvento setEnderecoExterior(NFSeSefinNacionalEnderExtSimples value) {
        this.enderecoExterior = value;
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

}
