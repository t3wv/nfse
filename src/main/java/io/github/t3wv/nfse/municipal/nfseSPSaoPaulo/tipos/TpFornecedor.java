package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

import org.simpleframework.xml.Element;

public class TpFornecedor {

    @Element(name = "CPF")
    protected String cpf;
    @Element(name = "CNPJ")
    protected String cnpj;
    @Element(name = "NIF")
    protected String nif;
    @Element(name = "NaoNIF")
    protected Integer naoNIF;
    @Element(name = "xNome")
    protected String xNome;

    public String getCPF() {
        return cpf;
    }

    public TpFornecedor setCPF(String value) {
        this.cpf = value;
        return this;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public TpFornecedor setCNPJ(String value) {
        this.cnpj = value;
        return this;
    }

    public String getNIF() {
        return nif;
    }

    public TpFornecedor setNIF(String value) {
        this.nif = value;
        return this;
    }

    public Integer getNaoNIF() {
        return naoNIF;
    }

    public TpFornecedor setNaoNIF(Integer value) {
        this.naoNIF = value;
        return this;
    }

    public String getXNome() {
        return xNome;
    }

    public TpFornecedor setXNome(String value) {
        this.xNome = value;
        return this;
    }

}
