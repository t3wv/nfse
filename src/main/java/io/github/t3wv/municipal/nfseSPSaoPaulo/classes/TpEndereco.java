package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

import org.simpleframework.xml.Element;

public class TpEndereco {

    @Element(name = "TipoLogradouro", required = false)
    protected String tipoLogradouro;
    @Element(name = "Logradouro", required = false)
    protected String logradouro;
    @Element(name = "NumeroEndereco", required = false)
    protected String numeroEndereco;
    @Element(name = "ComplementoEndereco", required = false)
    protected String complementoEndereco;
    @Element(name = "Bairro", required = false)
    protected String bairro;
    @Element(name = "Cidade", required = false)
    protected Integer cidade;
    @Element(name = "UF", required = false)
    protected String uf;
    @Element(name = "CEP", required = false)
    protected String cep;
    @Element(name = "EnderecoExterior", required = false)
    protected TpEnderecoExterior enderecoExterior;

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public TpEndereco setTipoLogradouro(String value) {
        this.tipoLogradouro = value;
        return this;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public TpEndereco setLogradouro(String value) {
        this.logradouro = value;
        return this;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public TpEndereco setNumeroEndereco(String value) {
        this.numeroEndereco = value;
        return this;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public TpEndereco setComplementoEndereco(String value) {
        this.complementoEndereco = value;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public TpEndereco setBairro(String value) {
        this.bairro = value;
        return this;
    }

    public Integer getCidade() {
        return cidade;
    }

    public TpEndereco setCidade(Integer value) {
        this.cidade = value;
        return this;
    }

    public String getUF() {
        return uf;
    }

    public TpEndereco setUF(String value) {
        this.uf = value;
        return this;
    }

    public String getCEP() {
        return cep;
    }

    public TpEndereco setCEP(String value) {
        this.cep = value;
        return this;
    }

    public TpEnderecoExterior getEnderecoExterior() {
        return enderecoExterior;
    }

    public TpEndereco setEnderecoExterior(TpEnderecoExterior value) {
        this.enderecoExterior = value;
        return this;
    }

}
