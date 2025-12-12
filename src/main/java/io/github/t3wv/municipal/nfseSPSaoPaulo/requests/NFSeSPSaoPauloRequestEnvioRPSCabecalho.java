package io.github.t3wv.municipal.nfseSPSaoPaulo.requests;

import io.github.t3wv.municipal.nfseSPSaoPaulo.classes.TpCPFCNPJ;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.time.LocalDate;


@Root(name = "Cabecalho")
@Namespace(reference = "")
public class NFSeSPSaoPauloRequestEnvioRPSCabecalho {
    @Element(name = "CPFCNPJRemetente")
    private TpCPFCNPJ CPFCNPJRemetente;

    @Element(name = "transacao", required = false)
    private Boolean transacao;

    @Element(name = "dtInicio", required = false)
    private LocalDate dtInicio;

    @Element(name = "dtFim", required = false)
    private LocalDate dtFim;

    @Element(name = "QtdRPS", required = false)
    private Integer QtdRPS;

    @Element(name = "ValorTotalServicos", required = false)
    private BigDecimal ValorTotalServicos;

    @Element(name = "ValorTotalDeducoes", required = false)
    private BigDecimal ValorTotalDeducoes;

    @Attribute(name = "Versao")
    private String Versao;

    public NFSeSPSaoPauloRequestEnvioRPSCabecalho() { }

    public TpCPFCNPJ getCPFCNPJRemetente() {
        return CPFCNPJRemetente;
    }

    public NFSeSPSaoPauloRequestEnvioRPSCabecalho setCPFCNPJRemetente(TpCPFCNPJ CPFCNPJRemetente) {
        this.CPFCNPJRemetente = CPFCNPJRemetente;
        return this;
    }

    public Boolean getTransacao() {
        return transacao;
    }

    public NFSeSPSaoPauloRequestEnvioRPSCabecalho setTransacao(Boolean transacao) {
        this.transacao = transacao;
        return this;
    }

    public LocalDate getDtInicio() {
        return dtInicio;
    }

    public NFSeSPSaoPauloRequestEnvioRPSCabecalho setDtInicio(LocalDate dtInicio) {
        this.dtInicio = dtInicio;
        return this;
    }

    public LocalDate getDtFim() {
        return dtFim;
    }

    public NFSeSPSaoPauloRequestEnvioRPSCabecalho setDtFim(LocalDate dtFim) {
        this.dtFim = dtFim;
        return this;
    }

    public Integer getQtdRPS() {
        return QtdRPS;
    }

    public NFSeSPSaoPauloRequestEnvioRPSCabecalho setQtdRPS(Integer qtdRPS) {
        QtdRPS = qtdRPS;
        return this;
    }

    public BigDecimal getValorTotalServicos() {
        return ValorTotalServicos;
    }

    public NFSeSPSaoPauloRequestEnvioRPSCabecalho setValorTotalServicos(BigDecimal valorTotalServicos) {
        ValorTotalServicos = valorTotalServicos;
        return this;
    }

    public BigDecimal getValorTotalDeducoes() {
        return ValorTotalDeducoes;
    }

    public NFSeSPSaoPauloRequestEnvioRPSCabecalho setValorTotalDeducoes(BigDecimal valorTotalDeducoes) {
        ValorTotalDeducoes = valorTotalDeducoes;
        return this;
    }

    public String getVersao() {
        return Versao;
    }

    public NFSeSPSaoPauloRequestEnvioRPSCabecalho setVersao(String versao) {
        Versao = versao;
        return this;
    }
}
