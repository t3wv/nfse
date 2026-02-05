package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class TpRetornoComplementarIBSCBS {
    @Element(name = "Adquirente")
    protected TpInformacoesPessoa Adquirente;
    @Element(name = "ValorBCIBSCBS")
    protected BigDecimal ValorBCIBSCBS;
    @Element(name = "ValorAliqEstadualIBS")
    protected BigDecimal ValorAliqEstadualIBS;
    @Element(name = "ValorPercRedEstadualIBS")
    protected BigDecimal ValorPercRedEstadualIBS;
    @Element(name = "ValorAliqEfetivaEstadualIBS")
    protected BigDecimal ValorAliqEfetivaEstadualIBS;
    @Element(name = "ValorEstadualIBS")
    protected BigDecimal ValorEstadualIBS;
    @Element(name = "ValorAliqMunicipalIBS")
    protected BigDecimal ValorAliqMunicipalIBS;
    @Element(name = "ValorPercRedMunicipalIBS")
    protected BigDecimal ValorPercRedMunicipalIBS;
    @Element(name = "ValorAliqEfetivaMunicipalIBS")
    protected BigDecimal ValorAliqEfetivaMunicipalIBS;
    @Element(name = "ValorMunicipalIBS")
    protected BigDecimal ValorMunicipalIBS;
    @Element(name = "ValorIBS")
    protected BigDecimal ValorIBS;
    @Element(name = "ValorAliqCBS")
    protected BigDecimal ValorAliqCBS;
    @Element(name = "ValorPercRedCBS")
    protected BigDecimal ValorPercRedCBS;
    @Element(name = "ValorAliqEfetivaCBS")
    protected BigDecimal ValorAliqEfetivaCBS;
    @Element(name = "ValorCBS")
    protected BigDecimal ValorCBS;
    @Element(name = "ValorPercDiferimentoEstadual")
    protected BigDecimal ValorPercDiferimentoEstadual;
    @Element(name = "ValorDiferimentoEstadual")
    protected BigDecimal ValorDiferimentoEstadual;
    @Element(name = "ValorPercDiferimentoMunicipal")
    protected BigDecimal ValorPercDiferimentoMunicipal;
    @Element(name = "ValorDiferimentoMunicipal")
    protected BigDecimal ValorDiferimentoMunicipal;
    @Element(name = "ValorPercDiferimentoCBS")
    protected BigDecimal ValorPercDiferimentoCBS;
    @Element(name = "ValorDiferimentoCBS")
    protected BigDecimal ValorDiferimentoCBS;
    @Element(name = "CodigoClassCredPresumidoIBS")
    protected BigDecimal CodigoClassCredPresumidoIBS;
    @Element(name = "ValorPercCredPresumidoIBS")
    protected BigDecimal ValorPercCredPresumidoIBS;
    @Element(name = "ValorCredPresumidoIBS")
    protected BigDecimal ValorCredPresumidoIBS;
    @Element(name = "CodigoClassCredPresumidoCBS")
    protected BigDecimal CodigoClassCredPresumidoCBS;
    @Element(name = "ValorPercCredPresumidoCBS")
    protected BigDecimal ValorPercCredPresumidoCBS;
    @Element(name = "ValorCredPresumidoCBS")
    protected BigDecimal ValorCredPresumidoCBS;
    @Element(name = "ValorAliqEstadualRegularIBS")
    protected BigDecimal ValorAliqEstadualRegularIBS;
    @Element(name = "ValorAliqMunicipalRegularIBS")
    protected BigDecimal ValorAliqMunicipalRegularIBS;
    @Element(name = "ValorAliqRegularCBS")
    protected BigDecimal ValorAliqRegularCBS;
    @Element(name = "ValorEstadualRegularIBS")
    protected BigDecimal ValorEstadualRegularIBS;
    @Element(name = "ValorMunicipalRegularIBS")
    protected BigDecimal ValorMunicipalRegularIBS;
    @Element(name = "ValorRegularCBS")
    protected BigDecimal ValorRegularCBS;
    @Element(name = "ValorTotalReeRepRes")
    protected BigDecimal ValorTotalReeRepRes;
    @Element(name = "ValorAliqEstadualIBSCompraGov")
    protected BigDecimal ValorAliqEstadualIBSCompraGov;
    @Element(name = "ValorEstadualBSCompraGov")
    protected BigDecimal ValorEstadualBSCompraGov;
    @Element(name = "ValorAliqMunicipalIBSCompraGov")
    protected BigDecimal ValorAliqMunicipalIBSCompraGov;
    @Element(name = "ValorMunicipalIBSCompraGov")
    protected BigDecimal ValorMunicipalIBSCompraGov;
    @Element(name = "ValorAliqCBSCompraGov")
    protected BigDecimal ValorAliqCBSCompraGov;
    @Element(name = "ValorCBSCompraGov")
    protected BigDecimal ValorCBSCompraGov;

    public TpInformacoesPessoa getAdquirente() {
        return Adquirente;
    }

    public TpRetornoComplementarIBSCBS setAdquirente(TpInformacoesPessoa adquirente) {
        Adquirente = adquirente;
        return this;
    }

    public BigDecimal getValorBCIBSCBS() {
        return ValorBCIBSCBS;
    }

    public TpRetornoComplementarIBSCBS setValorBCIBSCBS(BigDecimal valorBCIBSCBS) {
        ValorBCIBSCBS = valorBCIBSCBS;
        return this;
    }

    public BigDecimal getValorAliqEstadualIBS() {
        return ValorAliqEstadualIBS;
    }

    public TpRetornoComplementarIBSCBS setValorAliqEstadualIBS(BigDecimal valorAliqEstadualIBS) {
        ValorAliqEstadualIBS = valorAliqEstadualIBS;
        return this;
    }

    public BigDecimal getValorPercRedEstadualIBS() {
        return ValorPercRedEstadualIBS;
    }

    public TpRetornoComplementarIBSCBS setValorPercRedEstadualIBS(BigDecimal valorPercRedEstadualIBS) {
        ValorPercRedEstadualIBS = valorPercRedEstadualIBS;
        return this;
    }

    public BigDecimal getValorAliqEfetivaEstadualIBS() {
        return ValorAliqEfetivaEstadualIBS;
    }

    public TpRetornoComplementarIBSCBS setValorAliqEfetivaEstadualIBS(BigDecimal valorAliqEfetivaEstadualIBS) {
        ValorAliqEfetivaEstadualIBS = valorAliqEfetivaEstadualIBS;
        return this;
    }

    public BigDecimal getValorEstadualIBS() {
        return ValorEstadualIBS;
    }

    public TpRetornoComplementarIBSCBS setValorEstadualIBS(BigDecimal valorEstadualIBS) {
        ValorEstadualIBS = valorEstadualIBS;
        return this;
    }

    public BigDecimal getValorAliqMunicipalIBS() {
        return ValorAliqMunicipalIBS;
    }

    public TpRetornoComplementarIBSCBS setValorAliqMunicipalIBS(BigDecimal valorAliqMunicipalIBS) {
        ValorAliqMunicipalIBS = valorAliqMunicipalIBS;
        return this;
    }

    public BigDecimal getValorPercRedMunicipalIBS() {
        return ValorPercRedMunicipalIBS;
    }

    public TpRetornoComplementarIBSCBS setValorPercRedMunicipalIBS(BigDecimal valorPercRedMunicipalIBS) {
        ValorPercRedMunicipalIBS = valorPercRedMunicipalIBS;
        return this;
    }

    public BigDecimal getValorAliqEfetivaMunicipalIBS() {
        return ValorAliqEfetivaMunicipalIBS;
    }

    public TpRetornoComplementarIBSCBS setValorAliqEfetivaMunicipalIBS(BigDecimal valorAliqEfetivaMunicipalIBS) {
        ValorAliqEfetivaMunicipalIBS = valorAliqEfetivaMunicipalIBS;
        return this;
    }

    public BigDecimal getValorMunicipalIBS() {
        return ValorMunicipalIBS;
    }

    public TpRetornoComplementarIBSCBS setValorMunicipalIBS(BigDecimal valorMunicipalIBS) {
        ValorMunicipalIBS = valorMunicipalIBS;
        return this;
    }

    public BigDecimal getValorIBS() {
        return ValorIBS;
    }

    public TpRetornoComplementarIBSCBS setValorIBS(BigDecimal valorIBS) {
        ValorIBS = valorIBS;
        return this;
    }

    public BigDecimal getValorAliqCBS() {
        return ValorAliqCBS;
    }

    public TpRetornoComplementarIBSCBS setValorAliqCBS(BigDecimal valorAliqCBS) {
        ValorAliqCBS = valorAliqCBS;
        return this;
    }

    public BigDecimal getValorPercRedCBS() {
        return ValorPercRedCBS;
    }

    public TpRetornoComplementarIBSCBS setValorPercRedCBS(BigDecimal valorPercRedCBS) {
        ValorPercRedCBS = valorPercRedCBS;
        return this;
    }

    public BigDecimal getValorAliqEfetivaCBS() {
        return ValorAliqEfetivaCBS;
    }

    public TpRetornoComplementarIBSCBS setValorAliqEfetivaCBS(BigDecimal valorAliqEfetivaCBS) {
        ValorAliqEfetivaCBS = valorAliqEfetivaCBS;
        return this;
    }

    public BigDecimal getValorCBS() {
        return ValorCBS;
    }

    public TpRetornoComplementarIBSCBS setValorCBS(BigDecimal valorCBS) {
        ValorCBS = valorCBS;
        return this;
    }

    public BigDecimal getValorPercDiferimentoEstadual() {
        return ValorPercDiferimentoEstadual;
    }

    public TpRetornoComplementarIBSCBS setValorPercDiferimentoEstadual(BigDecimal valorPercDiferimentoEstadual) {
        ValorPercDiferimentoEstadual = valorPercDiferimentoEstadual;
        return this;
    }

    public BigDecimal getValorDiferimentoEstadual() {
        return ValorDiferimentoEstadual;
    }

    public TpRetornoComplementarIBSCBS setValorDiferimentoEstadual(BigDecimal valorDiferimentoEstadual) {
        ValorDiferimentoEstadual = valorDiferimentoEstadual;
        return this;
    }

    public BigDecimal getValorPercDiferimentoMunicipal() {
        return ValorPercDiferimentoMunicipal;
    }

    public TpRetornoComplementarIBSCBS setValorPercDiferimentoMunicipal(BigDecimal valorPercDiferimentoMunicipal) {
        ValorPercDiferimentoMunicipal = valorPercDiferimentoMunicipal;
        return this;
    }

    public BigDecimal getValorDiferimentoMunicipal() {
        return ValorDiferimentoMunicipal;
    }

    public TpRetornoComplementarIBSCBS setValorDiferimentoMunicipal(BigDecimal valorDiferimentoMunicipal) {
        ValorDiferimentoMunicipal = valorDiferimentoMunicipal;
        return this;
    }

    public BigDecimal getValorPercDiferimentoCBS() {
        return ValorPercDiferimentoCBS;
    }

    public TpRetornoComplementarIBSCBS setValorPercDiferimentoCBS(BigDecimal valorPercDiferimentoCBS) {
        ValorPercDiferimentoCBS = valorPercDiferimentoCBS;
        return this;
    }

    public BigDecimal getValorDiferimentoCBS() {
        return ValorDiferimentoCBS;
    }

    public TpRetornoComplementarIBSCBS setValorDiferimentoCBS(BigDecimal valorDiferimentoCBS) {
        ValorDiferimentoCBS = valorDiferimentoCBS;
        return this;
    }

    public BigDecimal getCodigoClassCredPresumidoIBS() {
        return CodigoClassCredPresumidoIBS;
    }

    public TpRetornoComplementarIBSCBS setCodigoClassCredPresumidoIBS(BigDecimal codigoClassCredPresumidoIBS) {
        CodigoClassCredPresumidoIBS = codigoClassCredPresumidoIBS;
        return this;
    }

    public BigDecimal getValorPercCredPresumidoIBS() {
        return ValorPercCredPresumidoIBS;
    }

    public TpRetornoComplementarIBSCBS setValorPercCredPresumidoIBS(BigDecimal valorPercCredPresumidoIBS) {
        ValorPercCredPresumidoIBS = valorPercCredPresumidoIBS;
        return this;
    }

    public BigDecimal getValorCredPresumidoIBS() {
        return ValorCredPresumidoIBS;
    }

    public TpRetornoComplementarIBSCBS setValorCredPresumidoIBS(BigDecimal valorCredPresumidoIBS) {
        ValorCredPresumidoIBS = valorCredPresumidoIBS;
        return this;
    }

    public BigDecimal getCodigoClassCredPresumidoCBS() {
        return CodigoClassCredPresumidoCBS;
    }

    public TpRetornoComplementarIBSCBS setCodigoClassCredPresumidoCBS(BigDecimal codigoClassCredPresumidoCBS) {
        CodigoClassCredPresumidoCBS = codigoClassCredPresumidoCBS;
        return this;
    }

    public BigDecimal getValorPercCredPresumidoCBS() {
        return ValorPercCredPresumidoCBS;
    }

    public TpRetornoComplementarIBSCBS setValorPercCredPresumidoCBS(BigDecimal valorPercCredPresumidoCBS) {
        ValorPercCredPresumidoCBS = valorPercCredPresumidoCBS;
        return this;
    }

    public BigDecimal getValorCredPresumidoCBS() {
        return ValorCredPresumidoCBS;
    }

    public TpRetornoComplementarIBSCBS setValorCredPresumidoCBS(BigDecimal valorCredPresumidoCBS) {
        ValorCredPresumidoCBS = valorCredPresumidoCBS;
        return this;
    }

    public BigDecimal getValorAliqEstadualRegularIBS() {
        return ValorAliqEstadualRegularIBS;
    }

    public TpRetornoComplementarIBSCBS setValorAliqEstadualRegularIBS(BigDecimal valorAliqEstadualRegularIBS) {
        ValorAliqEstadualRegularIBS = valorAliqEstadualRegularIBS;
        return this;
    }

    public BigDecimal getValorAliqMunicipalRegularIBS() {
        return ValorAliqMunicipalRegularIBS;
    }

    public TpRetornoComplementarIBSCBS setValorAliqMunicipalRegularIBS(BigDecimal valorAliqMunicipalRegularIBS) {
        ValorAliqMunicipalRegularIBS = valorAliqMunicipalRegularIBS;
        return this;
    }

    public BigDecimal getValorAliqRegularCBS() {
        return ValorAliqRegularCBS;
    }

    public TpRetornoComplementarIBSCBS setValorAliqRegularCBS(BigDecimal valorAliqRegularCBS) {
        ValorAliqRegularCBS = valorAliqRegularCBS;
        return this;
    }

    public BigDecimal getValorEstadualRegularIBS() {
        return ValorEstadualRegularIBS;
    }

    public TpRetornoComplementarIBSCBS setValorEstadualRegularIBS(BigDecimal valorEstadualRegularIBS) {
        ValorEstadualRegularIBS = valorEstadualRegularIBS;
        return this;
    }

    public BigDecimal getValorMunicipalRegularIBS() {
        return ValorMunicipalRegularIBS;
    }

    public TpRetornoComplementarIBSCBS setValorMunicipalRegularIBS(BigDecimal valorMunicipalRegularIBS) {
        ValorMunicipalRegularIBS = valorMunicipalRegularIBS;
        return this;
    }

    public BigDecimal getValorRegularCBS() {
        return ValorRegularCBS;
    }

    public TpRetornoComplementarIBSCBS setValorRegularCBS(BigDecimal valorRegularCBS) {
        ValorRegularCBS = valorRegularCBS;
        return this;
    }

    public BigDecimal getValorTotalReeRepRes() {
        return ValorTotalReeRepRes;
    }

    public TpRetornoComplementarIBSCBS setValorTotalReeRepRes(BigDecimal valorTotalReeRepRes) {
        ValorTotalReeRepRes = valorTotalReeRepRes;
        return this;
    }

    public BigDecimal getValorAliqEstadualIBSCompraGov() {
        return ValorAliqEstadualIBSCompraGov;
    }

    public TpRetornoComplementarIBSCBS setValorAliqEstadualIBSCompraGov(BigDecimal valorAliqEstadualIBSCompraGov) {
        ValorAliqEstadualIBSCompraGov = valorAliqEstadualIBSCompraGov;
        return this;
    }

    public BigDecimal getValorEstadualBSCompraGov() {
        return ValorEstadualBSCompraGov;
    }

    public TpRetornoComplementarIBSCBS setValorEstadualBSCompraGov(BigDecimal valorEstadualBSCompraGov) {
        ValorEstadualBSCompraGov = valorEstadualBSCompraGov;
        return this;
    }

    public BigDecimal getValorAliqMunicipalIBSCompraGov() {
        return ValorAliqMunicipalIBSCompraGov;
    }

    public TpRetornoComplementarIBSCBS setValorAliqMunicipalIBSCompraGov(BigDecimal valorAliqMunicipalIBSCompraGov) {
        ValorAliqMunicipalIBSCompraGov = valorAliqMunicipalIBSCompraGov;
        return this;
    }

    public BigDecimal getValorMunicipalIBSCompraGov() {
        return ValorMunicipalIBSCompraGov;
    }

    public TpRetornoComplementarIBSCBS setValorMunicipalIBSCompraGov(BigDecimal valorMunicipalIBSCompraGov) {
        ValorMunicipalIBSCompraGov = valorMunicipalIBSCompraGov;
        return this;
    }

    public BigDecimal getValorAliqCBSCompraGov() {
        return ValorAliqCBSCompraGov;
    }

    public TpRetornoComplementarIBSCBS setValorAliqCBSCompraGov(BigDecimal valorAliqCBSCompraGov) {
        ValorAliqCBSCompraGov = valorAliqCBSCompraGov;
        return this;
    }

    public BigDecimal getValorCBSCompraGov() {
        return ValorCBSCompraGov;
    }

    public TpRetornoComplementarIBSCBS setValorCBSCompraGov(BigDecimal valorCBSCompraGov) {
        ValorCBSCompraGov = valorCBSCompraGov;
        return this;
    }

    @Override
    public String toString() {
        return "TpRetornoComplementarIBSCBS{" +
                "ValorCBSCompraGov=" + ValorCBSCompraGov +
                ", ValorAliqCBSCompraGov=" + ValorAliqCBSCompraGov +
                ", ValorMunicipalIBSCompraGov=" + ValorMunicipalIBSCompraGov +
                ", ValorAliqMunicipalIBSCompraGov=" + ValorAliqMunicipalIBSCompraGov +
                ", ValorEstadualBSCompraGov=" + ValorEstadualBSCompraGov +
                ", ValorAliqEstadualIBSCompraGov=" + ValorAliqEstadualIBSCompraGov +
                ", ValorTotalReeRepRes=" + ValorTotalReeRepRes +
                ", ValorRegularCBS=" + ValorRegularCBS +
                ", ValorMunicipalRegularIBS=" + ValorMunicipalRegularIBS +
                ", ValorEstadualRegularIBS=" + ValorEstadualRegularIBS +
                ", ValorAliqRegularCBS=" + ValorAliqRegularCBS +
                ", ValorAliqMunicipalRegularIBS=" + ValorAliqMunicipalRegularIBS +
                ", ValorAliqEstadualRegularIBS=" + ValorAliqEstadualRegularIBS +
                ", ValorCredPresumidoCBS=" + ValorCredPresumidoCBS +
                ", ValorPercCredPresumidoCBS=" + ValorPercCredPresumidoCBS +
                ", CodigoClassCredPresumidoCBS=" + CodigoClassCredPresumidoCBS +
                ", ValorCredPresumidoIBS=" + ValorCredPresumidoIBS +
                ", ValorPercCredPresumidoIBS=" + ValorPercCredPresumidoIBS +
                ", CodigoClassCredPresumidoIBS=" + CodigoClassCredPresumidoIBS +
                ", ValorDiferimentoCBS=" + ValorDiferimentoCBS +
                ", ValorPercDiferimentoCBS=" + ValorPercDiferimentoCBS +
                ", ValorDiferimentoMunicipal=" + ValorDiferimentoMunicipal +
                ", ValorPercDiferimentoMunicipal=" + ValorPercDiferimentoMunicipal +
                ", ValorDiferimentoEstadual=" + ValorDiferimentoEstadual +
                ", ValorPercDiferimentoEstadual=" + ValorPercDiferimentoEstadual +
                ", ValorCBS=" + ValorCBS +
                ", ValorAliqEfetivaCBS=" + ValorAliqEfetivaCBS +
                ", ValorPercRedCBS=" + ValorPercRedCBS +
                ", ValorAliqCBS=" + ValorAliqCBS +
                ", ValorIBS=" + ValorIBS +
                ", ValorMunicipalIBS=" + ValorMunicipalIBS +
                ", ValorAliqEfetivaMunicipalIBS=" + ValorAliqEfetivaMunicipalIBS +
                ", ValorPercRedMunicipalIBS=" + ValorPercRedMunicipalIBS +
                ", ValorAliqMunicipalIBS=" + ValorAliqMunicipalIBS +
                ", ValorEstadualIBS=" + ValorEstadualIBS +
                ", ValorAliqEfetivaEstadualIBS=" + ValorAliqEfetivaEstadualIBS +
                ", ValorPercRedEstadualIBS=" + ValorPercRedEstadualIBS +
                ", ValorAliqEstadualIBS=" + ValorAliqEstadualIBS +
                ", ValorBCIBSCBS=" + ValorBCIBSCBS +
                ", Adquirente=" + Adquirente +
                '}';
    }
}
