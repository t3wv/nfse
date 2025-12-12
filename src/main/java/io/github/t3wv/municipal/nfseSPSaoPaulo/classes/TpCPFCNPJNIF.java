package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

import org.simpleframework.xml.Element;

public class TpCPFCNPJNIF {

    @Element(name = "CPF", required = false)
    protected String cpf;
    @Element(name = "CNPJ", required = false)
    protected String cnpj;
    @Element(name = "NIF", required = false)
    protected String nif;
    @Element(name = "NaoNIF", required = false)
    protected Integer naoNIF;

    public String getCPF() {
        return cpf;
    }

    public TpCPFCNPJNIF setCPF(String value) {
        this.cpf = value;
        return this;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public TpCPFCNPJNIF setCNPJ(String value) {
        this.cnpj = value;
        return this;
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

}
