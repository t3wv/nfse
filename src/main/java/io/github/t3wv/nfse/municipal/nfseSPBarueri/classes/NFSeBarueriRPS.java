package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.*;
import io.github.t3wv.nfse.utils.NFSePersister;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class NFSeBarueriRPS {

    // Detalhes tipo 2
    private String notaSerie;
    private String rpsSerie;
    private String rpsNumero;
    private LocalDate rpsDataEmissao;
    private LocalTime rpsHoraEmissao;
    private NFSeBarueriRPSSituacao rpsSituacao;

    // Detalhes 2 e 4
    private NFSeBarueriRPSCodigoMotivoCancelamento motivoCancelamento;
    private String notaSubstituidaNumero;
    private String notaSubstituidaSerie;
    private LocalDate notaSubstituidaDataEmissao;
    private String notaSubstituidaDescricaoCancelamento;
    private String codigoServicoPrestado;
    private NFSeBarueriRPSLocalPrestacaoServico localPrestacaoServico;
    private NFSeBarueriRPSServicoPrestadoViasPublicas servicoPrestadoEmViasPublicas;
    private String enderecoServicoPrestado;
    private String enderecoServicoPrestadoNumero;
    private String enderecoServicoPrestadoComplemento;
    private String enderecoServicoPrestadoBairro;
    private String enderecoServicoPrestadoCidade;
    private String enderecoServicoPrestadoUF;

    // DETALHES 2 E 4
    private String enderecoServicoPrestadoCodigoPostal;
    private String quantidadeServicoPrestado;
    private BigDecimal valorServico;
    private BigDecimal valorRetencoes;
    private NFSeBarueriRPSTomadorTipo tomadorTipo;

    // DETALHES 2 E 4
    private NFSeBarueriRPSPais paisTomadorEstrangeiro;
    private NFSeBarueriRPSServicoExportacao servicoExportacao;
    private String tomadorDocumento;
    private String tomadorRazaoSocial;
    private String tomadorEndereco;
    private String tomadorEnderecoNumero;
    private String tomadorEnderecoComplemento;
    private String tomadorEnderecoBairro;
    private String tomadorEnderecoCidade;
    private String tomadorCidadeCodigoIBGE;
    private String tomadorEnderecoUF;

    // DETALHES 2 E 4
    private String tomadorEnderecoCodigoPostal;
    private String tomadorEmail;
    private String faturaNumero;
    private BigDecimal faturaValor;
    private String faturaFormaPagamento;
    private String discriminacaoServicos;

    // Detalhes tipo 3
    private List<NFSeBarueriRPSOutrosValores> outrosValores;

    // Detalhes tipo 4
    private NFSeBarueriRPSOptanteSimplesNacional optanteSimplesNacional;
    private NFSeBarueriRPSRegimeApuracaoTributariaSimplesNacional regimeApuracaoTributariaSimplesNacional;
    private String servicoPrestadoCidadeCodigoIBGE;
    private String NIF; // cruzar com documento tomador detalhe 2
    private String codigoNBS;
    private String tomadorEstrangeiroEstadoProvinciaRegiao;
    private NFSeBarueriRPSVinculoEntrePartes vinculoEntrePartes;
    private String estadoProvinciaRegiaoServicoPrestadoExterior;
    private String nomeDoEvento;
    private LocalDate dataInicioEvento;
    private LocalDate dataTerminoEvento;
    private NFSeBarueriRPSJustificativaCancelamento justificativaCancelamento;
    private String codigoIndicadorOperacaoFornecimento;
    private String codigoClassificacaoTributariaIBSCBS;
    private String codigoSituacaoTributariaIBSCBS;
    private boolean operacaoConsumoPessoal;
    private NFSeBarueriRPSIndicadorDestinatarioServico indicadorDestinatarioServico;
    private String codigoClassificacaoCreditoPresumido;
    private NFSeBarueriRPSEnteGovernamentalTipo enteGovernamentalTipo;
    private NFSeBarueriRPSEnteGovernamentalOperacaoTipo enteGovernamentalOperacaoTipo;
    private String chaveNFSeReferenciada;
    private String codigoNCM;
    private String descricaoBemMovel;
    private String quantidadeBemMovel;
    private Boolean doacao;

    private Boolean destinatarioEstrangeiro;
    private String destinatarioDocumento;
    private String destinatarioRazaoSocial;
    private String destinatarioEnderecoRua;
    private String destinatarioEnderecoNumero;
    private String destinatarioEnderecoComplemento;
    private String destinatarioEnderecoBairro;
    private String destinatarioEnderecoCidade;
    private String destinatarioCidadeCodigo;
    private String destinatarioUF;
    private String destinatarioPaisCodigo;
    private String destinatarioCEP;
    private String destinatarioEmail;
    private String destinatarioNIF;
    private String destinatarioEstrangeiroCodigoPostal;
    private String destinatarioEstrangeiroEstadoProvinciaRegiao;

    public String getChaveNFSeReferenciada() {
        return chaveNFSeReferenciada;
    }

    public String getCodigoClassificacaoCreditoPresumido() {
        return codigoClassificacaoCreditoPresumido;
    }

    public String getCodigoClassificacaoTributariaIBSCBS() {
        return codigoClassificacaoTributariaIBSCBS;
    }

    public String getCodigoNCM() {
        return codigoNCM;
    }

    public String getCodigoSituacaoTributariaIBSCBS() {
        return codigoSituacaoTributariaIBSCBS;
    }

    public String getDescricaoBemMovel() {
        return descricaoBemMovel;
    }

    public String getDestinatarioCEP() {
        return destinatarioCEP;
    }

    public String getDestinatarioCidadeCodigo() {
        return destinatarioCidadeCodigo;
    }

    public String getDestinatarioDocumento() {
        return destinatarioDocumento;
    }

    public String getDestinatarioEmail() {
        return destinatarioEmail;
    }

    public String getDestinatarioEnderecoBairro() {
        return destinatarioEnderecoBairro;
    }

    public String getDestinatarioEnderecoCidade() {
        return destinatarioEnderecoCidade;
    }

    public String getDestinatarioEnderecoComplemento() {
        return destinatarioEnderecoComplemento;
    }

    public String getDestinatarioEnderecoNumero() {
        return destinatarioEnderecoNumero;
    }

    public String getDestinatarioEnderecoRua() {
        return destinatarioEnderecoRua;
    }

    public String getDestinatarioEstrangeiroCodigoPostal() {
        return destinatarioEstrangeiroCodigoPostal;
    }

    public String getDestinatarioEstrangeiroEstadoProvinciaRegiao() {
        return destinatarioEstrangeiroEstadoProvinciaRegiao;
    }

    public String getDestinatarioNIF() {
        return destinatarioNIF;
    }

    public String getDestinatarioPaisCodigo() {
        return destinatarioPaisCodigo;
    }

    public String getDestinatarioRazaoSocial() {
        return destinatarioRazaoSocial;
    }

    public String getDestinatarioUF() {
        return destinatarioUF;
    }

    public NFSeBarueriRPSIndicadorDestinatarioServico getIndicadorDestinatarioServico() {
        return indicadorDestinatarioServico;
    }

    public NFSeBarueriRPSJustificativaCancelamento getJustificativaCancelamento() {
        return justificativaCancelamento;
    }

    public String getQuantidadeBemMovel() {
        return quantidadeBemMovel;
    }

    public String getRpsSerie() {
        return rpsSerie;
    }

    public NFSeBarueriRPSEnteGovernamentalTipo getEnteGovernamentalTipo() {
        return enteGovernamentalTipo;
    }

    public Boolean isDestinatarioEstrangeiro() {
        return this.destinatarioEstrangeiro;
    }

    public Boolean isDoacao() {
        return this.doacao;
    }

    public void setChaveNFSeReferenciada(String chaveNFSeReferenciada) {
        this.chaveNFSeReferenciada = chaveNFSeReferenciada;
    }

    public void setCodigoClassificacaoCreditoPresumido(String codigoClassificacaoCreditoPresumido) {
        this.codigoClassificacaoCreditoPresumido = codigoClassificacaoCreditoPresumido;
    }

    public void setCodigoClassificacaoTributariaIBSCBS(String codigoClassificacaoTributariaIBSCBS) {
        this.codigoClassificacaoTributariaIBSCBS = codigoClassificacaoTributariaIBSCBS;
    }

    public void setCodigoNCM(String codigoNCM) {
        this.codigoNCM = codigoNCM;
    }

    public void setCodigoSituacaoTributariaIBSCBS(String codigoSituacaoTributariaIBSCBS) {
        this.codigoSituacaoTributariaIBSCBS = codigoSituacaoTributariaIBSCBS;
    }

    public void setDescricaoBemMovel(String descricaoBemMovel) {
        this.descricaoBemMovel = descricaoBemMovel;
    }

    public void setDestinatarioCEP(String destinatarioCEP) {
        this.destinatarioCEP = destinatarioCEP;
    }

    public void setDestinatarioCidadeCodigo(String destinatarioCidadeCodigo) {
        this.destinatarioCidadeCodigo = destinatarioCidadeCodigo;
    }

    public void setDestinatarioDocumento(String destinatarioDocumento) {
        this.destinatarioDocumento = destinatarioDocumento;
    }

    public void setDestinatarioEmail(String destinatarioEmail) {
        this.destinatarioEmail = destinatarioEmail;
    }

    public void setDestinatarioEnderecoBairro(String destinatarioEnderecoBairro) {
        this.destinatarioEnderecoBairro = destinatarioEnderecoBairro;
    }

    public void setDestinatarioEnderecoCidade(String destinatarioEnderecoCidade) {
        this.destinatarioEnderecoCidade = destinatarioEnderecoCidade;
    }

    public void setDestinatarioEnderecoComplemento(String destinatarioEnderecoComplemento) {
        this.destinatarioEnderecoComplemento = destinatarioEnderecoComplemento;
    }

    public void setDestinatarioEnderecoNumero(String destinatarioEnderecoNumero) {
        this.destinatarioEnderecoNumero = destinatarioEnderecoNumero;
    }

    public void setDestinatarioEnderecoRua(String destinatarioEnderecoRua) {
        this.destinatarioEnderecoRua = destinatarioEnderecoRua;
    }

    public void setDestinatarioEstrangeiroCodigoPostal(String destinatarioEstrangeiroCodigoPostal) {
        this.destinatarioEstrangeiroCodigoPostal = destinatarioEstrangeiroCodigoPostal;
    }

    public void setDestinatarioEstrangeiroEstadoProvinciaRegiao(String destinatarioEstrangeiroEstadoProvinciaRegiao) {
        this.destinatarioEstrangeiroEstadoProvinciaRegiao = destinatarioEstrangeiroEstadoProvinciaRegiao;
    }

    public void setDestinatarioNIF(String destinatarioNIF) {
        this.destinatarioNIF = destinatarioNIF;
    }

    public void setDestinatarioPaisCodigo(String destinatarioPaisCodigo) {
        this.destinatarioPaisCodigo = destinatarioPaisCodigo;
    }

    public void setDestinatarioRazaoSocial(String destinatarioRazaoSocial) {
        this.destinatarioRazaoSocial = destinatarioRazaoSocial;
    }

    public void setDestinatarioUF(String destinatarioUF) {
        this.destinatarioUF = destinatarioUF;
    }

    public void setIndicadorDestinatarioServico(NFSeBarueriRPSIndicadorDestinatarioServico indicadorDestinatarioServico) {
        this.indicadorDestinatarioServico = indicadorDestinatarioServico;
    }

    public NFSeBarueriRPS setJustificativaCancelamento(NFSeBarueriRPSJustificativaCancelamento rpsJustificativaCancelamento) {
        this.justificativaCancelamento = rpsJustificativaCancelamento;
        return this;
    }

    public void setQuantidadeBemMovel(String quantidadeBemMovel) {
        this.quantidadeBemMovel = quantidadeBemMovel;
    }

    public NFSeBarueriRPS setRpsSerie(String rpsSerie) {
        this.rpsSerie = rpsSerie;
        return this;
    }

    public String getNotaSerie() {
        return notaSerie;
    }

    public NFSeBarueriRPS setNotaSerie(String notaSerie) {
        this.notaSerie = notaSerie;
        return this;
    }

    public String getRpsNumero() {
        return rpsNumero;
    }

    public NFSeBarueriRPS setRpsNumero(String rpsNumero) {
        this.rpsNumero = rpsNumero;
        return this;
    }

    public LocalDate getRpsDataEmissao() {
        return rpsDataEmissao;
    }

    public NFSeBarueriRPS setRpsDataEmissao(LocalDate rpsDataEmissao) {
        this.rpsDataEmissao = rpsDataEmissao;
        return this;
    }

    public LocalTime getRpsHoraEmissao() {
        return rpsHoraEmissao;
    }

    public NFSeBarueriRPS setRpsHoraEmissao(LocalTime rpsHoraEmissao) {
        this.rpsHoraEmissao = rpsHoraEmissao;
        return this;
    }

    public NFSeBarueriRPSSituacao getRpsSituacao() {
        return rpsSituacao;
    }

    public NFSeBarueriRPS setRpsSituacao(NFSeBarueriRPSSituacao rpsSituacao) {
        this.rpsSituacao = rpsSituacao;
        return this;
    }

    public NFSeBarueriRPSCodigoMotivoCancelamento getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public NFSeBarueriRPS setMotivoCancelamento(NFSeBarueriRPSCodigoMotivoCancelamento motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
        return this;
    }

    public String getNotaSubstituidaNumero() {
        return notaSubstituidaNumero;
    }

    public NFSeBarueriRPS setNotaSubstituidaNumero(String notaSubstituidaNumero) {
        this.notaSubstituidaNumero = notaSubstituidaNumero;
        return this;
    }

    public String getNotaSubstituidaSerie() {
        return notaSubstituidaSerie;
    }

    public NFSeBarueriRPS setNotaSubstituidaSerie(String notaSubstituidaSerie) {
        this.notaSubstituidaSerie = notaSubstituidaSerie;
        return this;
    }

    public LocalDate getNotaSubstituidaDataEmissao() {
        return notaSubstituidaDataEmissao;
    }

    public NFSeBarueriRPS setNotaSubstituidaDataEmissao(LocalDate notaSubstituidaDataEmissao) {
        this.notaSubstituidaDataEmissao = notaSubstituidaDataEmissao;
        return this;
    }

    public String getNotaSubstituidaDescricaoCancelamento() {
        return notaSubstituidaDescricaoCancelamento;
    }

    public NFSeBarueriRPS setNotaSubstituidaDescricaoCancelamento(String notaSubstituidaDescricaoCancelamento) {
        this.notaSubstituidaDescricaoCancelamento = notaSubstituidaDescricaoCancelamento;
        return this;
    }

    public String getCodigoServicoPrestado() {
        return codigoServicoPrestado;
    }

    public NFSeBarueriRPS setCodigoServicoPrestado(String codigoServicoPrestado) {
        this.codigoServicoPrestado = codigoServicoPrestado;
        return this;
    }

    public NFSeBarueriRPSLocalPrestacaoServico getLocalPrestacaoServico() {
        return localPrestacaoServico;
    }

    public NFSeBarueriRPS setLocalPrestacaoServico(NFSeBarueriRPSLocalPrestacaoServico localPrestacaoServico) {
        this.localPrestacaoServico = localPrestacaoServico;
        return this;
    }

    public NFSeBarueriRPSServicoPrestadoViasPublicas getServicoPrestadoEmViasPublicas() {
        return servicoPrestadoEmViasPublicas;
    }

    public NFSeBarueriRPS setServicoPrestadoEmViasPublicas(NFSeBarueriRPSServicoPrestadoViasPublicas servicoPrestadoEmViasPublicas) {
        this.servicoPrestadoEmViasPublicas = servicoPrestadoEmViasPublicas;
        return this;
    }

    public String getEnderecoServicoPrestado() {
        return enderecoServicoPrestado;
    }

    public NFSeBarueriRPS setEnderecoServicoPrestado(String enderecoServicoPrestado) {
        this.enderecoServicoPrestado = enderecoServicoPrestado;
        return this;
    }

    public String getEnderecoServicoPrestadoNumero() {
        return enderecoServicoPrestadoNumero;
    }

    public NFSeBarueriRPS setEnderecoServicoPrestadoNumero(String enderecoServicoPrestadoNumero) {
        this.enderecoServicoPrestadoNumero = enderecoServicoPrestadoNumero;
        return this;
    }

    public String getEnderecoServicoPrestadoComplemento() {
        return enderecoServicoPrestadoComplemento;
    }

    public NFSeBarueriRPS setEnderecoServicoPrestadoComplemento(String enderecoServicoPrestadoComplemento) {
        this.enderecoServicoPrestadoComplemento = enderecoServicoPrestadoComplemento;
        return this;
    }

    public String getEnderecoServicoPrestadoBairro() {
        return enderecoServicoPrestadoBairro;
    }

    public NFSeBarueriRPS setEnderecoServicoPrestadoBairro(String enderecoServicoPrestadoBairro) {
        this.enderecoServicoPrestadoBairro = enderecoServicoPrestadoBairro;
        return this;
    }

    public String getEnderecoServicoPrestadoCidade() {
        return enderecoServicoPrestadoCidade;
    }

    public NFSeBarueriRPS setEnderecoServicoPrestadoCidade(String enderecoServicoPrestadoCidade) {
        this.enderecoServicoPrestadoCidade = enderecoServicoPrestadoCidade;
        return this;
    }

    public String getEnderecoServicoPrestadoUF() {
        return enderecoServicoPrestadoUF;
    }

    public NFSeBarueriRPS setEnderecoServicoPrestadoUF(String enderecoServicoPrestadoUF) {
        this.enderecoServicoPrestadoUF = enderecoServicoPrestadoUF;
        return this;
    }

    public String getEnderecoServicoPrestadoCodigoPostal() {
        return enderecoServicoPrestadoCodigoPostal;
    }

    public NFSeBarueriRPS setEnderecoServicoPrestadoCodigoPostal(String enderecoServicoPrestadoCodigoPostal) {
        this.enderecoServicoPrestadoCodigoPostal = enderecoServicoPrestadoCodigoPostal;
        return this;
    }

    public String getQuantidadeServicoPrestado() {
        return quantidadeServicoPrestado;
    }

    public NFSeBarueriRPS setQuantidadeServicoPrestado(String quantidadeServicoPrestado) {
        this.quantidadeServicoPrestado = quantidadeServicoPrestado;
        return this;
    }

    public BigDecimal getValorServico() {
        return valorServico;
    }

    public NFSeBarueriRPS setValorServico(BigDecimal valorServico) {
        this.valorServico = valorServico;
        return this;
    }

    public BigDecimal getValorRetencoes() {
        return valorRetencoes;
    }

    public NFSeBarueriRPS setValorRetencoes(BigDecimal valorRetencoes) {
        this.valorRetencoes = valorRetencoes;
        return this;
    }

    public NFSeBarueriRPSTomadorTipo getTomadorTipo() {
        return tomadorTipo;
    }

    public NFSeBarueriRPS setTomadorTipo(NFSeBarueriRPSTomadorTipo tomadorTipo) {
        this.tomadorTipo = tomadorTipo;
        return this;
    }

    public NFSeBarueriRPSPais getPaisTomadorEstrangeiro() {
        return paisTomadorEstrangeiro;
    }

    public NFSeBarueriRPS setPaisTomadorEstrangeiro(NFSeBarueriRPSPais paisTomadorEstrangeiro) {
        this.paisTomadorEstrangeiro = paisTomadorEstrangeiro;
        return this;
    }

    public NFSeBarueriRPSServicoExportacao getServicoExportacao() {
        return servicoExportacao;
    }

    public NFSeBarueriRPS setServicoExportacao(NFSeBarueriRPSServicoExportacao servicoExportacao) {
        this.servicoExportacao = servicoExportacao;
        return this;
    }

    public String getTomadorDocumento() {
        return tomadorDocumento;
    }

    public NFSeBarueriRPS setTomadorDocumento(String tomadorDocumento) {
        this.tomadorDocumento = tomadorDocumento;
        return this;
    }

    public String getTomadorRazaoSocial() {
        return tomadorRazaoSocial;
    }

    public NFSeBarueriRPS setTomadorRazaoSocial(String tomadorRazaoSocial) {
        this.tomadorRazaoSocial = tomadorRazaoSocial;
        return this;
    }

    public String getTomadorEndereco() {
        return tomadorEndereco;
    }

    public NFSeBarueriRPS setTomadorEndereco(String tomadorEndereco) {
        this.tomadorEndereco = tomadorEndereco;
        return this;
    }

    public String getTomadorEnderecoNumero() {
        return tomadorEnderecoNumero;
    }

    public NFSeBarueriRPS setTomadorEnderecoNumero(String tomadorEnderecoNumero) {
        this.tomadorEnderecoNumero = tomadorEnderecoNumero;
        return this;
    }

    public String getTomadorEnderecoComplemento() {
        return tomadorEnderecoComplemento;
    }

    public NFSeBarueriRPS setTomadorEnderecoComplemento(String tomadorEnderecoComplemento) {
        this.tomadorEnderecoComplemento = tomadorEnderecoComplemento;
        return this;
    }

    public String getTomadorEnderecoBairro() {
        return tomadorEnderecoBairro;
    }

    public NFSeBarueriRPS setTomadorEnderecoBairro(String tomadorEnderecoBairro) {
        this.tomadorEnderecoBairro = tomadorEnderecoBairro;
        return this;
    }

    public String getTomadorEnderecoCidade() {
        return tomadorEnderecoCidade;
    }

    public NFSeBarueriRPS setTomadorEnderecoCidade(String tomadorEnderecoCidade) {
        this.tomadorEnderecoCidade = tomadorEnderecoCidade;
        return this;
    }

    public String getTomadorEnderecoUF() {
        return tomadorEnderecoUF;
    }

    public NFSeBarueriRPS setTomadorEnderecoUF(String tomadorEnderecoUF) {
        this.tomadorEnderecoUF = tomadorEnderecoUF;
        return this;
    }

    public String getTomadorEnderecoCodigoPostal() {
        return tomadorEnderecoCodigoPostal;
    }

    public NFSeBarueriRPS setTomadorEnderecoCodigoPostal(String tomadorEnderecoCodigoPostal) {
        this.tomadorEnderecoCodigoPostal = tomadorEnderecoCodigoPostal;
        return this;
    }

    public String getTomadorEmail() {
        return tomadorEmail;
    }

    public NFSeBarueriRPS setTomadorEmail(String tomadorEmail) {
        this.tomadorEmail = tomadorEmail;
        return this;
    }

    public String getFaturaNumero() {
        return faturaNumero;
    }

    public NFSeBarueriRPS setFaturaNumero(String faturaNumero) {
        this.faturaNumero = faturaNumero;
        return this;
    }

    public BigDecimal getFaturaValor() {
        return faturaValor;
    }

    public NFSeBarueriRPS setFaturaValor(BigDecimal faturaValor) {
        this.faturaValor = faturaValor;
        return this;
    }

    public String getFaturaFormaPagamento() {
        return faturaFormaPagamento;
    }

    public NFSeBarueriRPS setFaturaFormaPagamento(String faturaFormaPagamento) {
        this.faturaFormaPagamento = faturaFormaPagamento;
        return this;
    }

    public String getDiscriminacaoServicos() {
        return discriminacaoServicos;
    }

    public NFSeBarueriRPS setDiscriminacaoServicos(String discriminacaoServicos) {
        this.discriminacaoServicos = discriminacaoServicos;
        return this;
    }

    public List<NFSeBarueriRPSOutrosValores> getOutrosValores() {
        return outrosValores;
    }

    public NFSeBarueriRPS setOutrosValores(List<NFSeBarueriRPSOutrosValores> outrosValores) {
        this.outrosValores = outrosValores;
        return this;
    }

    public NFSeBarueriRPSOptanteSimplesNacional getOptanteSimplesNacional() {
        return optanteSimplesNacional;
    }

    public NFSeBarueriRPS setOptanteSimplesNacional(NFSeBarueriRPSOptanteSimplesNacional optanteSimplesNacional) {
        this.optanteSimplesNacional = optanteSimplesNacional;
        return this;
    }

    public NFSeBarueriRPSRegimeApuracaoTributariaSimplesNacional getRegimeApuracaoTributariaSimplesNacional() {
        return regimeApuracaoTributariaSimplesNacional;
    }

    public NFSeBarueriRPS setRegimeApuracaoTributariaSimplesNacional(NFSeBarueriRPSRegimeApuracaoTributariaSimplesNacional regimeApuracaoTributariaSimplesNacional) {
        this.regimeApuracaoTributariaSimplesNacional = regimeApuracaoTributariaSimplesNacional;
        return this;
    }

    public String getServicoPrestadoCidadeCodigoIBGE() {
        return servicoPrestadoCidadeCodigoIBGE;
    }

    public NFSeBarueriRPS setServicoPrestadoCidadeCodigoIBGE(String servicoPrestadoCidadeCodigoIBGE) {
        this.servicoPrestadoCidadeCodigoIBGE = servicoPrestadoCidadeCodigoIBGE;
        return this;
    }

    public String getTomadorCidadeCodigoIBGE() {
        return tomadorCidadeCodigoIBGE;
    }

    public void setEnteGovernamentalTipo(NFSeBarueriRPSEnteGovernamentalTipo enteGovernamentalTipo) {
        this.enteGovernamentalTipo = enteGovernamentalTipo;
    }

    public NFSeBarueriRPS setTomadorCidadeCodigoIBGE(String tomadorCidadeCodigoIBGE) {
        this.tomadorCidadeCodigoIBGE = tomadorCidadeCodigoIBGE;
        return this;
    }

    public String getNIF() {
        return NIF;
    }

    public NFSeBarueriRPS setNIF(String NIF) {
        this.NIF = NIF;
        return this;
    }

    public String getCodigoNBS() {
        return codigoNBS;
    }

    public NFSeBarueriRPS setCodigoNBS(String codigoNBS) {
        this.codigoNBS = codigoNBS;
        return this;
    }

    public String getTomadorEstrangeiroEstadoProvinciaRegiao() {
        return tomadorEstrangeiroEstadoProvinciaRegiao;
    }

    public NFSeBarueriRPS setTomadorEstrangeiroEstadoProvinciaRegiao(String tomadorEstrangeiroEstadoProvinciaRegiao) {
        this.tomadorEstrangeiroEstadoProvinciaRegiao = tomadorEstrangeiroEstadoProvinciaRegiao;
        return this;
    }

    public NFSeBarueriRPSVinculoEntrePartes getVinculoEntrePartes() {
        return vinculoEntrePartes;
    }

    public NFSeBarueriRPS setVinculoEntrePartes(NFSeBarueriRPSVinculoEntrePartes vinculoEntrePartes) {
        this.vinculoEntrePartes = vinculoEntrePartes;
        return this;
    }

    public String getEstadoProvinciaRegiaoServicoPrestadoExterior() {
        return estadoProvinciaRegiaoServicoPrestadoExterior;
    }

    public NFSeBarueriRPS setEstadoProvinciaRegiaoServicoPrestadoExterior(String estadoProvinciaRegiaoServicoPrestadoExterior) {
        this.estadoProvinciaRegiaoServicoPrestadoExterior = estadoProvinciaRegiaoServicoPrestadoExterior;
        return this;
    }

    public String getNomeDoEvento() {
        return nomeDoEvento;
    }

    public NFSeBarueriRPS setNomeDoEvento(String nomeDoEvento) {
        this.nomeDoEvento = nomeDoEvento;
        return this;
    }

    public LocalDate getDataInicioEvento() {
        return dataInicioEvento;
    }

    public NFSeBarueriRPS setDataInicioEvento(LocalDate dataInicioEvento) {
        this.dataInicioEvento = dataInicioEvento;
        return this;
    }

    public LocalDate getDataTerminoEvento() {
        return dataTerminoEvento;
    }

    public NFSeBarueriRPS setDataTerminoEvento(LocalDate dataTerminoEvento) {
        this.dataTerminoEvento = dataTerminoEvento;
        return this;
    }

    public String getCodigoIndicadorOperacaoFornecimento() {
        return codigoIndicadorOperacaoFornecimento;
    }

    public NFSeBarueriRPS setCodigoIndicadorOperacaoFornecimento(String codigoIndicadorOperacaoFornecimento) {
        this.codigoIndicadorOperacaoFornecimento = codigoIndicadorOperacaoFornecimento;
        return this;
    }

    public boolean isOperacaoConsumoPessoal() {
        return operacaoConsumoPessoal;
    }

    public NFSeBarueriRPS setOperacaoConsumoPessoal(boolean operacaoConsumoPessoal) {
        this.operacaoConsumoPessoal = operacaoConsumoPessoal;
        return this;
    }

    public NFSeBarueriRPSEnteGovernamentalOperacaoTipo getEnteGovernamentalOperacaoTipo() {
        return enteGovernamentalOperacaoTipo;
    }

    public NFSeBarueriRPS setEnteGovernamentalOperacaoTipo(NFSeBarueriRPSEnteGovernamentalOperacaoTipo enteGovernamentalOperacaoTipo) {
        this.enteGovernamentalOperacaoTipo = enteGovernamentalOperacaoTipo;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}

