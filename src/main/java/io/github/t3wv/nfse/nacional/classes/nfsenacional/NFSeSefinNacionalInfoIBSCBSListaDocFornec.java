package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Grupo de informações do fornecedor do documento referenciado (IBSCBS)
 */

@Root(name = "InfoIBSCBSListaDocFornec")
public class NFSeSefinNacionalInfoIBSCBSListaDocFornec {

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

    /**
     * @return CNPJ do fornecedor do serviço
     */
    public String getCNPJ() {
        return cnpj;
    }

    /**
     * @param cnpj CNPJ do fornecedor do serviço
     */
    public NFSeSefinNacionalInfoIBSCBSListaDocFornec setCNPJ(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    /**
     * @return CPF do fornecedor do serviço
     */
    public String getCPF() {
        return cpf;
    }

    /**
     * @param cpf CPF do fornecedor do serviço
     */
    public NFSeSefinNacionalInfoIBSCBSListaDocFornec setCPF(String cpf) {
        this.cpf = cpf;
        return this;
    }

    /**
     * Este elemento só deverá ser preenchido para fornecedores não residentes no Brasil
     *
     * @return NIF do fornecedor do serviço
     */
    public String getNIF() {
        return nif;
    }

    /**
     * Este elemento só deverá ser preenchido para fornecedores não residentes no Brasil
     *
     * @param nif NIF do fornecedor do serviço
     */
    public NFSeSefinNacionalInfoIBSCBSListaDocFornec setNIF(String nif) {
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
    public NFSeSefinNacionalInfoIBSCBSListaDocFornec setCodigoNaoNIF(NFSeSefinNacionalInfoPrestadorCodigoNaoNIF codigoNaoNIF) {
        this.codigoNaoNIF = codigoNaoNIF;
        return this;
    }

    /**
     * @return Nome/Razão Social do fornecedor do serviço
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome Nome/Razão Social do fornecedor do serviço
     */
    public NFSeSefinNacionalInfoIBSCBSListaDocFornec setNome(String nome) {
        this.nome = nome;
        return this;
    }
}
