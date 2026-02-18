package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

import org.simpleframework.xml.Element;

public class TpCPFCNPJ {

    @Element(name = "CPF", required = false)
    protected String cpf;
    @Element(name = "CNPJ", required = false)
    protected String cnpj;

    public String getCPF() {
        return cpf;
    }

    public TpCPFCNPJ setCPF(String value) {
        this.cpf = value;
        return this;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public TpCPFCNPJ setCNPJ(String value) {
        this.cnpj = value;
        return this;
    }

}
