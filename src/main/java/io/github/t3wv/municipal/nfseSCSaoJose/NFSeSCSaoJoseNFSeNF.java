package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NFSeSCSaoJoseNFSeNF {

    @Element(name = "serie_nfse", required = false)
    private String serieNFSe;

    @Element(name = "data_fato_gerador", required = false)
    private LocalDate dataFatoGerador;

    @Element(name = "valor_total")
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

    @Element(name = "IBSCBS", required = false)
    private NFSeSCSaoJoseNFSeNfIBSCBS ibscbs;

    public String getSerieNFSe() {
        return serieNFSe;
    }

    public NFSeSCSaoJoseNFSeNF setSerieNFSe(String serieNFSe) {
        this.serieNFSe = serieNFSe;
        return this;
    }

    public LocalDate getDataFatoGerador() {
        return dataFatoGerador;
    }

    public NFSeSCSaoJoseNFSeNF setDataFatoGerador(LocalDate dataFatoGerador) {
        this.dataFatoGerador = dataFatoGerador;
        return this;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public NFSeSCSaoJoseNFSeNF setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public NFSeSCSaoJoseNFSeNF setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
        return this;
    }

    public BigDecimal getValorIR() {
        return valorIR;
    }

    public NFSeSCSaoJoseNFSeNF setValorIR(BigDecimal valorIR) {
        this.valorIR = valorIR;
        return this;
    }

    public BigDecimal getValorINSS() {
        return valorINSS;
    }

    public NFSeSCSaoJoseNFSeNF setValorINSS(BigDecimal valorINSS) {
        this.valorINSS = valorINSS;
        return this;
    }

    public BigDecimal getValorContribuicaoSocial() {
        return valorContribuicaoSocial;
    }

    public NFSeSCSaoJoseNFSeNF setValorContribuicaoSocial(BigDecimal valorContribuicaoSocial) {
        this.valorContribuicaoSocial = valorContribuicaoSocial;
        return this;
    }

    public BigDecimal getValorRPS() {
        return valorRPS;
    }

    public NFSeSCSaoJoseNFSeNF setValorRPS(BigDecimal valorRPS) {
        this.valorRPS = valorRPS;
        return this;
    }

    public BigDecimal getValorPIS() {
        return valorPIS;
    }

    public NFSeSCSaoJoseNFSeNF setValorPIS(BigDecimal valorPIS) {
        this.valorPIS = valorPIS;
        return this;
    }

    public BigDecimal getValorCOFINS() {
        return valorCOFINS;
    }

    public NFSeSCSaoJoseNFSeNF setValorCOFINS(BigDecimal valorCOFINS) {
        this.valorCOFINS = valorCOFINS;
        return this;
    }

    public String getObservacao() {
        return observacao;
    }

    public NFSeSCSaoJoseNFSeNF setObservacao(String observacao) {
        this.observacao = observacao;
        return this;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBS getIbscbs() {
        return ibscbs;
    }

    public NFSeSCSaoJoseNFSeNF setIbscbs(NFSeSCSaoJoseNFSeNfIBSCBS ibscbs) {
        this.ibscbs = ibscbs;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
