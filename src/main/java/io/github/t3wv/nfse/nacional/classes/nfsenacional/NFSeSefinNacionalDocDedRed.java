
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.time.LocalDate;

@Root(name = "DocDedRed")
public class NFSeSefinNacionalDocDedRed {

    @Element(name = "chNFSe", required = false)
    protected String chaveNFSe;
    @Element(name = "chNFe", required = false)
    protected String chaveNFe;
    @Element(name = "NFSeMun", required = false)
    protected NFSeSefinNacionalDocOutNFSe nfseMunicipal;
    @Element(name = "NFNFS", required = false)
    protected NFSeSefinNacionalDocNFNFS nfNfsNaoEletronico;
    @Element(name = "nDocFisc", required = false)
    protected String numeroDocumentoFiscal;
    @Element(name = "nDoc", required = false)
    protected String numeroDocumentoNaoFiscal;
    @Element(name = "tpDedRed")
    protected NFSeSefinNacionalDocDedRedTipoDeducaoReducao tipoDeducaoReducao;
    @Element(name = "xDescOutDed", required = false)
    protected String descricaoOutrasDeducoes;
    @Element(name = "dtEmiDoc")
    protected LocalDate dataEmissao;
    @Element(name = "vDedutivelRedutivel")
    protected String valorTotalDedutivel;
    @Element(name = "vDeducaoReducao")
    protected String valorDeducao;
    @Element(name = "fornec", required = false)
    protected NFSeSefinNacionalInfoPessoa fornecedor;

    /**
     * @return Chave de Acesso da NFS-e (Padrão Nacional)
     */
    public String getChaveNFSe() {
        return chaveNFSe;
    }

    /**
     * @param chaveNFSe Chave de Acesso da NFS-e (Padrão Nacional)
     */
    public NFSeSefinNacionalDocDedRed setChaveNFSe(String chaveNFSe) {
        this.chaveNFSe = chaveNFSe;
        return this;
    }

    /**
     * @return Chave de Acesso da NF-e
     */
    public String getChaveNFe() {
        return chaveNFe;
    }

    /**
     * @param chaveNFe Chave de Acesso da NF-e
     */
    public NFSeSefinNacionalDocDedRed setChaveNFe(String chaveNFe) {
        this.chaveNFe = chaveNFe;
        return this;
    }

    /**
     * @return Grupo de informações de Outras NFS-e (Padrão anterior de NFS-e)
     */
    public NFSeSefinNacionalDocOutNFSe getNFSeMunicipal() {
        return nfseMunicipal;
    }

    /**
     * @param nfseMunicipal Grupo de informações de Outras NFS-e (Padrão anterior de NFS-e)
     */
    public NFSeSefinNacionalDocDedRed setNFSeMunicipal(NFSeSefinNacionalDocOutNFSe nfseMunicipal) {
        this.nfseMunicipal = nfseMunicipal;
        return this;
    }

    /**
     * @return Grupo de informações de NF ou NFS (Modelo não eletrônico)
     */
    public NFSeSefinNacionalDocNFNFS getNfNfsNaoEletronico() {
        return nfNfsNaoEletronico;
    }

    /**
     * @param nfNfsNaoEletronico Grupo de informações de NF ou NFS (Modelo não eletrônico)
     */
    public NFSeSefinNacionalDocDedRed setNfNfsNaoEletronico(NFSeSefinNacionalDocNFNFS nfNfsNaoEletronico) {
        this.nfNfsNaoEletronico = nfNfsNaoEletronico;
        return this;
    }

    /**
     * @return Número de documento fiscal
     */
    public String getNumeroDocumentoFiscal() {
        return numeroDocumentoFiscal;
    }

    /**
     * @param numeroDocumentoFiscal Número de documento fiscal
     */
    public NFSeSefinNacionalDocDedRed setNumeroDocumentoFiscal(String numeroDocumentoFiscal) {
        this.numeroDocumentoFiscal = numeroDocumentoFiscal;
        return this;
    }

    /**
     * @return Número de documento não fiscal
     */
    public String getNumeroDocumentoNaoFiscal() {
        return numeroDocumentoNaoFiscal;
    }

    /**
     * @param numeroDocumentoNaoFiscal Número de documento não fiscal
     */
    public NFSeSefinNacionalDocDedRed setNumeroDocumentoNaoFiscal(String numeroDocumentoNaoFiscal) {
        this.numeroDocumentoNaoFiscal = numeroDocumentoNaoFiscal;
        return this;
    }

    /**
     * @return Identificação da Dedução/Redução
     */
    public NFSeSefinNacionalDocDedRedTipoDeducaoReducao getTipoDeducaoReducao() {
        return tipoDeducaoReducao;
    }

    /**
     * @param tipoDeducaoReducao Identificação da Dedução/Redução
     */
    public NFSeSefinNacionalDocDedRed setTipoDeducaoReducao(NFSeSefinNacionalDocDedRedTipoDeducaoReducao tipoDeducaoReducao) {
        this.tipoDeducaoReducao = tipoDeducaoReducao;
        return this;
    }

    /**
     * @return Descrição da Dedução/Redução quando a opção é "99 – Outras Deduções"
     */
    public String getDescricaoOutrasDeducoes() {
        return descricaoOutrasDeducoes;
    }

    /**
     * @param descricaoOutrasDeducoes Descrição da Dedução/Redução quando a opção é "99 – Outras Deduções"
     */
    public NFSeSefinNacionalDocDedRed setDescricaoOutrasDeducoes(String descricaoOutrasDeducoes) {
        this.descricaoOutrasDeducoes = descricaoOutrasDeducoes;
        return this;
    }

    /**
     * @return Data da emissão do documento dedutível
     */
    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    /**
     * @param dataEmissao Data da emissão do documento dedutível
     */
    public NFSeSefinNacionalDocDedRed setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
        return this;
    }

    /**
     * Valor monetário total dedutível/redutível no documento informado (R$).
     * Este é o valor total no documento informado que é passível de dedução/redução.
     *
     * @return Valor total dedutível
     */
    public String getValorTotalDedutivel() {
        return valorTotalDedutivel;
    }

    /**
     * Valor monetário total dedutível/redutível no documento informado (R$).
     * Este é o valor total no documento informado que é passível de dedução/redução.
     *
     * @param valorTotalDedutivel Valor total dedutível
     */
    public NFSeSefinNacionalDocDedRed setValorTotalDedutivel(String valorTotalDedutivel) {
        this.valorTotalDedutivel = valorTotalDedutivel;
        return this;
    }

    /**
     * Valor monetário utilizado para dedução/redução do valor do serviço da NFS-e que está sendo emitida (R$).
     * Deve ser menor ou igual ao valor deduzível/redutível (vDedutivelRedutivel).
     *
     * @return Valor dedução
     */
    public String getValorDeducao() {
        return valorDeducao;
    }

    /**
     * Valor monetário utilizado para dedução/redução do valor do serviço da NFS-e que está sendo emitida (R$).
     * Deve ser menor ou igual ao valor deduzível/redutível (vDedutivelRedutivel).
     *
     * @param valorDeducao Valor dedução
     */
    public NFSeSefinNacionalDocDedRed setValorDeducao(String valorDeducao) {
        this.valorDeducao = valorDeducao;
        return this;
    }

    /**
     * @return fornecedor
     */
    public NFSeSefinNacionalInfoPessoa getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor fornecedor
     */
    public NFSeSefinNacionalDocDedRed setFornecedor(NFSeSefinNacionalInfoPessoa fornecedor) {
        this.fornecedor = fornecedor;
        return this;
    }

}
