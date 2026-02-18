package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

import org.simpleframework.xml.Element;

public class TpInformacoesPessoa {

    @Element(name = "CPF")
    protected String cpf;
    @Element(name = "CNPJ")
    protected String cnpj;
    @Element(name = "NIF")
    protected String nif;
    @Element(name = "NaoNIF")
    protected Integer naoNIF;
    @Element(name = "xNome", required = true)
    protected String xNome;
    @Element(name = "end")
    protected TpEnderecoIBSCBS end;
    @Element(name = "email")
    protected String email;

    public String getCPF() {
        return cpf;
    }

    public TpInformacoesPessoa setCPF(String value) {
        this.cpf = value;
        return this;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public TpInformacoesPessoa setCNPJ(String value) {
        this.cnpj = value;
        return this;
    }

    public String getNIF() {
        return nif;
    }

    public TpInformacoesPessoa setNIF(String value) {
        this.nif = value;
        return this;
    }

    public Integer getNaoNIF() {
        return naoNIF;
    }

    public TpInformacoesPessoa setNaoNIF(Integer value) {
        this.naoNIF = value;
        return this;
    }

    public String getXNome() {
        return xNome;
    }

    public TpInformacoesPessoa setXNome(String value) {
        this.xNome = value;
        return this;
    }

    public TpEnderecoIBSCBS getEnd() {
        return end;
    }

    public TpInformacoesPessoa setEnd(TpEnderecoIBSCBS value) {
        this.end = value;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public TpInformacoesPessoa setEmail(String value) {
        this.email = value;
        return this;
    }

}
