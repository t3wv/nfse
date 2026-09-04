package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Grupo de informações relativas ao Destinatário do serviço IBSCBS
 */

@Root(name = "InfoIBSCBSInfoDest")
public class NFSeSefinNacionalInfoIBSCBSInfoDest {

    @Element(name = "CNPJ", required = false)
    protected String cnpj;
    @Element(name = "CPF", required = false)
    protected String cpf;
    @Element(name = "NIF", required = false)
    protected String nif;
    @Element(name = "cNaoNIF", required = false)
    protected NFSeSefinNacionalInfoPrestadorCodigoNaoNIF codigoNaoNIF;
    @Element(name = "xNome")
    protected String nome;
    @Element(name = "end", required = false)
    protected NFSeSefinNacionalEndereco endereco;
    @Element(name = "fone", required = false)
    protected String telefone;
    @Element(name = "email", required = false)
    protected String email;

    /**
     * @return CNPJ do destinatário do serviço
     */
    public String getCNPJ() {
        return cnpj;
    }

    /**
     * @param cnpj CNPJ do destinatário do serviço
     */
    public NFSeSefinNacionalInfoIBSCBSInfoDest setCNPJ(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    /**
     * @return CPF do destinatário do serviço
     */
    public String getCPF() {
        return cpf;
    }

    /**
     * @param cpf CPF do destinatário do serviço
     */
    public NFSeSefinNacionalInfoIBSCBSInfoDest setCPF(String cpf) {
        this.cpf = cpf;
        return this;
    }

    /**
     * Número de Identificação Fiscal fornecido por órgão de administração tributária no exterior
     *
     * @return NIF do destinatário do serviço
     */
    public String getNIF() {
        return nif;
    }

    /**
     * Número de Identificação Fiscal fornecido por órgão de administração tributária no exterior
     *
     * @param nif NIF do destinatário do serviço
     */
    public NFSeSefinNacionalInfoIBSCBSInfoDest setNIF(String nif) {
        this.nif = nif;
        return this;
    }

    /**
     * @return Código de motivo para não informação do NIF
     */
    public NFSeSefinNacionalInfoPrestadorCodigoNaoNIF getCodigoNaoNIF() {
        return codigoNaoNIF;
    }

    /**
     * @param codigoNaoNIF motivo para não informação do NIF
     */
    public NFSeSefinNacionalInfoIBSCBSInfoDest setCodigoNaoNIF(NFSeSefinNacionalInfoPrestadorCodigoNaoNIF codigoNaoNIF) {
        this.codigoNaoNIF = codigoNaoNIF;
        return this;
    }

    /**
     * @return Nome/Nome Empresarial do destinatário do serviço
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome Nome/Nome Empresarial do destinatário do serviço
     */
    public NFSeSefinNacionalInfoIBSCBSInfoDest setNome(String nome) {
        this.nome = nome;
        return this;
    }

    /**
     * @return Endereço do destinatário do serviço
     */
    public NFSeSefinNacionalEndereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco Endereço do destinatário do serviço
     */
    public NFSeSefinNacionalInfoIBSCBSInfoDest setEndereco(NFSeSefinNacionalEndereco endereco) {
        this.endereco = endereco;
        return this;
    }

    /**
     * @return Telefone do destinatário do serviço
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone Telefone do destinatário do serviço
     */
    public NFSeSefinNacionalInfoIBSCBSInfoDest setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    /**
     * @return Email do destinatário do serviço
     */
    public String getEmail() {
        return email;
    }

    public NFSeSefinNacionalInfoIBSCBSInfoDest setEmail(String email) {
        this.email = email;
        return this;
    }
}
