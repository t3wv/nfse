
package io.github.t3wv.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Informações das pessoas envolvidas na NFS-e. Pode ser o tomador, o intermediário ou o fornecedor (dedução/redução)
 */

@Root(name = "InfoPessoa")
public class NFSeSefinNacionalInfoPessoa {

    @Element(name = "CNPJ", required = false)
    protected String cnpj;
    @Element(name = "CPF", required = false)
    protected String cpf;
    @Element(name = "NIF", required = false)
    protected String nif;
    @Element(name = "cNaoNIF", required = false)
    protected NFSeSefinNacionalInfoPrestadorCodigoNaoNIF codigoNaoNIF;
    @Element(name = "CAEPF", required = false)
    protected String nroCadastroAtividadeEconomicaPessoaFisica;
    @Element(name = "IM", required = false)
    protected String inscricaoMunicipal;
    @Element(name = "xNome")
    protected String nome;
    @Element(name = "end", required = false)
    protected NFSeSefinNacionalEndereco endereco;
    @Element(name = "fone", required = false)
    protected String telefone;
    @Element(name = "email", required = false)
    protected String email;

    /**
     * @return CNPJ da pessoa
     */
    public String getCNPJ() {
        return cnpj;
    }

    /**
     * @param cnpj CNPJ da pessoa
     */
    public NFSeSefinNacionalInfoPessoa setCNPJ(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    /**
     * @return CPF da pessoa
     */
    public String getCPF() {
        return cpf;
    }

    /**
     * @param cpf CPF da pessoa
     */
    public NFSeSefinNacionalInfoPessoa setCPF(String cpf) {
        this.cpf = cpf;
        return this;
    }

    /**
     * Número de Identificação Fiscal fornecido por órgão de administração tributária no exterior
     *
     * @return NIF da pessoa
     */
    public String getNIF() {
        return nif;
    }

    /**
     * Número de Identificação Fiscal fornecido por órgão de administração tributária no exterior
     *
     * @param nif NIF do prestador de serviço
     */
    public NFSeSefinNacionalInfoPessoa setNIF(String nif) {
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
    public NFSeSefinNacionalInfoPessoa setCodigoNaoNIF(NFSeSefinNacionalInfoPrestadorCodigoNaoNIF codigoNaoNIF) {
        this.codigoNaoNIF = codigoNaoNIF;
        return this;
    }

    /**
     * @return CAEPF - Cadastro de Atividade Econômica da Pessoa Física
     */
    public String getCAEPF() {
        return nroCadastroAtividadeEconomicaPessoaFisica;
    }

    /**
     * @param nroCadastroAtividadeEconomicaPessoaFisica CAEPF - Cadastro de Atividade Econômica da Pessoa Física
     */
    public NFSeSefinNacionalInfoPessoa setCAEPF(String nroCadastroAtividadeEconomicaPessoaFisica) {
        this.nroCadastroAtividadeEconomicaPessoaFisica = nroCadastroAtividadeEconomicaPessoaFisica;
        return this;
    }

    /**
     * @return Inscrição Municipal da pessoa
     */
    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    /**
     * @param value Inscrição Municipal da pessoa
     */
    public NFSeSefinNacionalInfoPessoa setInscricaoMunicipal(String value) {
        this.inscricaoMunicipal = value;
        return this;
    }

    /**
     * @return Nome da pessoa
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome Nome da pessoa
     */
    public NFSeSefinNacionalInfoPessoa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    /**
     * @return Endereço da pessoa
     */
    public NFSeSefinNacionalEndereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco Endereço da pessoa
     */
    public NFSeSefinNacionalInfoPessoa setEndereco(NFSeSefinNacionalEndereco endereco) {
        this.endereco = endereco;
        return this;
    }

    /**
     * @return Telefone da pessoa
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone Telefone da pessoa
     */
    public NFSeSefinNacionalInfoPessoa setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    /**
     * @return Email da pessoa
     */
    public String getEmail() {
        return email;
    }

    public NFSeSefinNacionalInfoPessoa setEmail(String email) {
        this.email = email;
        return this;
    }
}
