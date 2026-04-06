
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "Emitente")
public class NFSeSefinNacionalEmitente {

    @Element(name = "CNPJ", required = false)
    protected String cnpj;
    @Element(name = "CPF", required = false)
    protected String cpf;
    @Element(name = "IM", required = false)
    protected String im;
    @Element(name = "xNome")
    protected String xNome;
    @Element(name = "xFant", required = false)
    protected String xFant;
    @Element(name = "enderNac")
    protected NFSeSefinNacionalEnderecoEmitente enderNac;
    @Element(name="fone")
    protected String fone;
    @Element(name="email")
    protected String email;

    public String getCNPJ() {
        return cnpj;
    }

    public NFSeSefinNacionalEmitente setCNPJ(String value) {
        this.cnpj = value;
        return this;
    }

    public String getCPF() {
        return cpf;
    }

    public NFSeSefinNacionalEmitente setCPF(String value) {
        this.cpf = value;
        return this;
    }

    public String getIM() {
        return im;
    }

    public NFSeSefinNacionalEmitente setIM(String value) {
        this.im = value;
        return this;
    }

    public String getXNome() {
        return xNome;
    }

    public NFSeSefinNacionalEmitente setXNome(String value) {
        this.xNome = value;
        return this;
    }

    public String getXFant() {
        return xFant;
    }

    public NFSeSefinNacionalEmitente setXFant(String value) {
        this.xFant = value;
        return this;
    }

    public NFSeSefinNacionalEnderecoEmitente getEnderNac() {
        return enderNac;
    }

    public NFSeSefinNacionalEmitente setEnderNac(NFSeSefinNacionalEnderecoEmitente value) {
        this.enderNac = value;
        return this;
    }

    public String getFone() {
        return fone;
    }

    public NFSeSefinNacionalEmitente setFone(String value) {
        this.fone = value;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public NFSeSefinNacionalEmitente setEmail(String value) {
        this.email = value;
        return this;
    }

}
