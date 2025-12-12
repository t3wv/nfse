package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

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

    public void setCPF(String value) {
        this.cpf = value;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(String value) {
        this.cnpj = value;
    }

    public String getNIF() {
        return nif;
    }

    public void setNIF(String value) {
        this.nif = value;
    }

    public Integer getNaoNIF() {
        return naoNIF;
    }

    public void setNaoNIF(Integer value) {
        this.naoNIF = value;
    }

    public String getXNome() {
        return xNome;
    }

    public void setXNome(String value) {
        this.xNome = value;
    }

}
