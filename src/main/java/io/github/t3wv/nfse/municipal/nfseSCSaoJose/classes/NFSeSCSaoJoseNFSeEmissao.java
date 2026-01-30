package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class NFSeSCSaoJoseNFSeEmissao {

    @Element(name = "serie_nfse", required = false)
    private String serieNFSe;

    @Element(name = "numero_nfse", required = false)
    private String numeroNFSe;

    @Element(name = "data_nfse", required = false)
    private LocalDate dataNfse;

    @Element(name = "data_fato", required = false)
    private LocalDate dataFato;

    @Element(name = "hora_nfse", required = false)
    private LocalTime horaNfse;

    @Element(name = "situacao_codigo_nfse", required = false)
    private String situacaoCodigoNfse;

    @Element(name = "situacao_descricao_nfse", required = false)
    private String situacaoDescricaoNfse;

    @Element(name = "link_nfse", required = false)
    private String linkNfse;

    @Element(name = "cod_verificador_autenticidade", required = false)
    private String codVerificadorAutenticidade;

    @Element(name = "data_fato_gerador", required = false)
    private LocalDate dataFatoGerador;

    @Element(name = "valor_total", required = false)
    private BigDecimal valorTotal;

    @Element(name = "valor_desconto", required = false)
    private BigDecimal valorDesconto;

    @Element(name = "valor_ir", required = false)
    private BigDecimal valorIR;

    @Element(name = "valor_inss", required = false)
    private BigDecimal valorINSS;

    @Element(name = "valor_contribuicao_social", required = false)
    private BigDecimal valorContribuicaoSocial;

    @Element(name = "valor_rps", required = false)
    private BigDecimal valorRPS;

    @Element(name = "valor_pis", required = false)
    private BigDecimal valorPIS;

    @Element(name = "valor_cofins", required = false)
    private BigDecimal valorCOFINS;

    @Element(name = "observacao", required = false)
    private String observacao;

    @Element(name = "chave_acesso_nfse_nacional", required = false)
    private String chaveAcessoNfseNacional;



    //
    //
    //
    //    @Element(name = "situacao", required = false)
    //    private String situacao;
    //
//
//
//
//    @Element(name = "IBSCBS", required = false)
//    private NFSeSCSaoJoseNFSeNfIBSCBS ibscbs;
//
//    public String getNumero() {
//        return numero;
//    }
//
//    public NFSeSCSaoJoseNFSeNF setNumero(String numero) {
//        this.numero = numero;
//        return this;
//    }
//
    public String getNumeroNFSe() {
        return numeroNFSe;
    }

    public NFSeSCSaoJoseNFSeEmissao setNumeroNFSe(String numeroNFSe) {
        this.numeroNFSe = numeroNFSe;
        return this;
    }
//
//    public String getSituacao() {
//        return situacao;
//    }
//
//    public NFSeSCSaoJoseNFSeNF setSituacao(String situacao) {
//        this.situacao = situacao;
//        return this;
//    }

    public String getSerieNFSe() {
        return serieNFSe;
    }

    public NFSeSCSaoJoseNFSeEmissao setSerieNFSe(String serieNFSe) {
        this.serieNFSe = serieNFSe;
        return this;
    }

    public LocalDate getDataFatoGerador() {
        return dataFatoGerador;
    }

    public NFSeSCSaoJoseNFSeEmissao setDataFatoGerador(LocalDate dataFatoGerador) {
        this.dataFatoGerador = dataFatoGerador;
        return this;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public NFSeSCSaoJoseNFSeEmissao setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public NFSeSCSaoJoseNFSeEmissao setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
        return this;
    }

    public BigDecimal getValorIR() {
        return valorIR;
    }

    public NFSeSCSaoJoseNFSeEmissao setValorIR(BigDecimal valorIR) {
        this.valorIR = valorIR;
        return this;
    }

    public BigDecimal getValorINSS() {
        return valorINSS;
    }

    public NFSeSCSaoJoseNFSeEmissao setValorINSS(BigDecimal valorINSS) {
        this.valorINSS = valorINSS;
        return this;
    }

    public BigDecimal getValorContribuicaoSocial() {
        return valorContribuicaoSocial;
    }

    public NFSeSCSaoJoseNFSeEmissao setValorContribuicaoSocial(BigDecimal valorContribuicaoSocial) {
        this.valorContribuicaoSocial = valorContribuicaoSocial;
        return this;
    }

    public BigDecimal getValorRPS() {
        return valorRPS;
    }

    public NFSeSCSaoJoseNFSeEmissao setValorRPS(BigDecimal valorRPS) {
        this.valorRPS = valorRPS;
        return this;
    }

    public BigDecimal getValorPIS() {
        return valorPIS;
    }

    public NFSeSCSaoJoseNFSeEmissao setValorPIS(BigDecimal valorPIS) {
        this.valorPIS = valorPIS;
        return this;
    }

    public BigDecimal getValorCOFINS() {
        return valorCOFINS;
    }

    public NFSeSCSaoJoseNFSeEmissao setValorCOFINS(BigDecimal valorCOFINS) {
        this.valorCOFINS = valorCOFINS;
        return this;
    }

    public String getObservacao() {
        return observacao;
    }

    public NFSeSCSaoJoseNFSeEmissao setObservacao(String observacao) {
        this.observacao = observacao;
        return this;
    }

//    public NFSeSCSaoJoseNFSeNfIBSCBS getIbscbs() {
//        return ibscbs;
//    }
//
//    public NFSeSCSaoJoseNFSeNF setIbscbs(NFSeSCSaoJoseNFSeNfIBSCBS ibscbs) {
//        this.ibscbs = ibscbs;
//        return this;
//    }
//
    public LocalDate getDataNfse() {
        return dataNfse;
    }

    public NFSeSCSaoJoseNFSeEmissao setDataNfse(LocalDate dataNfse) {
        this.dataNfse = dataNfse;
        return this;
    }

    public LocalTime getHoraNfse() {
        return horaNfse;
    }

    public NFSeSCSaoJoseNFSeEmissao setHoraNfse(LocalTime horaNfse) {
        this.horaNfse = horaNfse;
        return this;
    }

    public String getSituacaoCodigoNfse() {
        return situacaoCodigoNfse;
    }

    public NFSeSCSaoJoseNFSeEmissao setSituacaoCodigoNfse(String situacaoCodigoNfse) {
        this.situacaoCodigoNfse = situacaoCodigoNfse;
        return this;
    }

    public String getSituacaoDescricaoNfse() {
        return situacaoDescricaoNfse;
    }

    public NFSeSCSaoJoseNFSeEmissao setSituacaoDescricaoNfse(String situacaoDescricaoNfse) {
        this.situacaoDescricaoNfse = situacaoDescricaoNfse;
        return this;
    }

    public String getLinkNfse() {
        return linkNfse;
    }

    public NFSeSCSaoJoseNFSeEmissao setLinkNfse(String linkNfse) {
        this.linkNfse = linkNfse;
        return this;
    }

    public String getCodVerificadorAutenticidade() {
        return codVerificadorAutenticidade;
    }

    public NFSeSCSaoJoseNFSeEmissao setCodVerificadorAutenticidade(String codVerificadorAutenticidade) {
        this.codVerificadorAutenticidade = codVerificadorAutenticidade;
        return this;
    }

    public String getChaveAcessoNfseNacional() {
        return chaveAcessoNfseNacional;
    }

    public NFSeSCSaoJoseNFSeEmissao setChaveAcessoNfseNacional(String chaveAcessoNfseNacional) {
        this.chaveAcessoNfseNacional = chaveAcessoNfseNacional;
        return this;
    }

    public LocalDate getDataFato() {
        return dataFato;
    }

    public NFSeSCSaoJoseNFSeEmissao setDataFato(LocalDate dataFato) {
        this.dataFato = dataFato;
        return this;
    }

    public String toXml() throws Exception {
        final var registryMatcher = new NFSeRegistryMatcher();
        registryMatcher.bind(boolean.class, new NFSeBooleanTransformer());
        registryMatcher.bind(Boolean.class, new NFSeBooleanTransformer());
        registryMatcher.bind(BigDecimal.class, new NFSeBigDecimalTransformer());

        NFSePersister serializer = new NFSePersister(true, registryMatcher);
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
