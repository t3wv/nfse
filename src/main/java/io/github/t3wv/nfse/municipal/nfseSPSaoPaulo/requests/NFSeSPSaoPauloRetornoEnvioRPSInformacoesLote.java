package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.requests;

import io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos.TpCPFCNPJ;
import org.simpleframework.xml.Element;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class NFSeSPSaoPauloRetornoEnvioRPSInformacoesLote {

    @Element(name="NumeroLote", required=false)
    private String numeroLote;

    @Element(name="InscricaoPrestador", required=false)
    private String inscricaoPrestador;

    @Element(name="CPFCNPJRemetente", required=false)
    private TpCPFCNPJ cpfCnpjRemetente;

    @Element(name="DataEnvioLote", required=false)
    private LocalDateTime dataEnvioLote;

    @Element(name="QtdNotasProcessadas", required=false)
    private Integer qtdNotasProcessadas;

    @Element(name="TempoProcessamento", required=false)
    private Long tempoProcessamento;

    @Element(name="ValorTotalServicos", required=false)
    private BigDecimal valorTotalServicos;

    @Element(name="ValorTotalDeducoes", required=false)
    private BigDecimal valorTotalDeducoes;

    public String getNumeroLote() {
        return numeroLote;
    }

    public NFSeSPSaoPauloRetornoEnvioRPSInformacoesLote setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
        return this;
    }

    public String getInscricaoPrestador() {
        return inscricaoPrestador;
    }

    public NFSeSPSaoPauloRetornoEnvioRPSInformacoesLote setInscricaoPrestador(String inscricaoPrestador) {
        this.inscricaoPrestador = inscricaoPrestador;
        return this;
    }

    public TpCPFCNPJ getCpfCnpjRemetente() {
        return cpfCnpjRemetente;
    }

    public NFSeSPSaoPauloRetornoEnvioRPSInformacoesLote setCpfCnpjRemetente(TpCPFCNPJ cpfCnpjRemetente) {
        this.cpfCnpjRemetente = cpfCnpjRemetente;
        return this;
    }

    public LocalDateTime getDataEnvioLote() {
        return dataEnvioLote;
    }

    public NFSeSPSaoPauloRetornoEnvioRPSInformacoesLote setDataEnvioLote(LocalDateTime dataEnvioLote) {
        this.dataEnvioLote = dataEnvioLote;
        return this;
    }

    public Integer getQtdNotasProcessadas() {
        return qtdNotasProcessadas;
    }

    public NFSeSPSaoPauloRetornoEnvioRPSInformacoesLote setQtdNotasProcessadas(Integer qtdNotasProcessadas) {
        this.qtdNotasProcessadas = qtdNotasProcessadas;
        return this;
    }

    public Long getTempoProcessamento() {
        return tempoProcessamento;
    }

    public NFSeSPSaoPauloRetornoEnvioRPSInformacoesLote setTempoProcessamento(Long tempoProcessamento) {
        this.tempoProcessamento = tempoProcessamento;
        return this;
    }

    public BigDecimal getValorTotalServicos() {
        return valorTotalServicos;
    }

    public NFSeSPSaoPauloRetornoEnvioRPSInformacoesLote setValorTotalServicos(BigDecimal valorTotalServicos) {
        this.valorTotalServicos = valorTotalServicos;
        return this;
    }

    public BigDecimal getValorTotalDeducoes() {
        return valorTotalDeducoes;
    }

    public NFSeSPSaoPauloRetornoEnvioRPSInformacoesLote setValorTotalDeducoes(BigDecimal valorTotalDeducoes) {
        this.valorTotalDeducoes = valorTotalDeducoes;
        return this;
    }

    @Override
    public String toString() {
        return "NFSeSPSaoPauloRetornoEnvioRPSInformacoesLote{" +
                "numeroLote='" + numeroLote + '\'' +
                ", inscricaoPrestador='" + inscricaoPrestador + '\'' +
                ", cpfCnpjRemetente=" + cpfCnpjRemetente +
                ", dataEnvioLote=" + dataEnvioLote +
                ", qtdNotasProcessadas=" + qtdNotasProcessadas +
                ", tempoProcessamento=" + tempoProcessamento +
                ", valorTotalServicos=" + valorTotalServicos +
                ", valorTotalDeducoes=" + valorTotalDeducoes +
                '}';
    }
}
