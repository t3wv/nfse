package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

import org.simpleframework.xml.Element;

public class TpCPFCNPJ {

    @Element(name = "CPF", required = false)
    protected String cpf;
    @Element(name = "CNPJ", required = false)
    protected String cnpj;

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String value) {
        this.cpf = value;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public TpCPFCNPJ setCNPJ(String value) {
        this.cnpj = value;
        return this;
    }

}
