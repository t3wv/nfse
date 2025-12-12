package io.github.t3wv.municipal.nfseSPBarueri.classes;

import io.github.t3wv.municipal.nfseSPBarueri.enums.*;
import io.github.t3wv.utils.NFSePersister;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class NFSeBarueriRPS {

    // Detalhes tipo 2
    private String RPSSerie;
    private String NFSerie;
    private String RPSNumero;
    private LocalDate RPSDataEmissao;
    private LocalTime RPSHoraEmissao;
    private NFSeBarueriRPSSituacao RPSSituacao;
    // Detalhes 2 e 4
    private NFSeBarueriRPSCodigoMotivoCancelamento RPSMotivoCancelamento;
    private String NFSubstituidaNumero;
    private String NFSubstituidaSerie;
    private LocalDate NFSubstituidaDataEmissao;
    private String NFSubstituidaDescricaoCancelamento;
    private String RPSCodigoServicoPrestado;
    private NFSeBarueriRPSLocalPrestacaoServico RPSLocalPrestacaoServico;
    private NFSeBarueriRPSServicoPrestadoViasPublicas RPSServicoPrestadoEmViasPublicas;
    private String RPSEnderecoServicoPrestado;
    private String RPSEnderecoServicoPrestadoNumero;
    private String RPSEnderecoServicoPrestadoComplemento;
    private String RPSEnderecoServicoPrestadoBairro;
    private String RPSEnderecoServicoPrestadoCidade;
    private String RPSEnderecoServicoPrestadoUF;
    // DETALHES 2 E 4
    private String RPSEnderecoServicoPrestadoCodigoPostal;
    private String RPSQuantidadeServicoPrestado;
    private BigDecimal RPSValorServico;
    private BigDecimal RPSValorRetencoes;
    private NFSeBarueriRPSTomadorTipo RPSTomadorTipo;
    // DETALHES 2 E 4
    private String RPSCodigoPaisTomadorEstrangeiro;
    private NFSeBarueriRPSServicoExportacao RPSServicoExportacao;
    private String RPSTomadorDocumento;
    private String RPSTomadorRazaoSocial;
    private String RPSTomadorEndereco;
    private String RPSTomadorEnderecoNumero;
    private String RPSTomadorEnderecoComplemento;
    private String RPSTomadorEnderecoBairro;
    private String RPSTomadorEnderecoCidade;
    private String RPSTomadorEnderecoUF;
    // DETALHES 2 E 4
    private String RPSTomadorEnderecoCodigoPostal;
    private String RPSTomadorEmail; // TODO converter para lista de 3 no máximo
    private String RPSFaturaNumero;
    private BigDecimal RPSFaturaValor;
    private String RPSFaturaFormaPagamento;
    private String RPSDiscriminacaoServicos; // TODO converter para lista 1000 caracteres separados por |

    // Detalhes tipo 3
    private List<NFSeBarueriRPSOutrosValores> outrosValores;

    // Detalhes tipo 4
    private NFSeBarueriRPSOptanteSimplesNacional optanteSimplesNacional;
    private NFSeBarueriRPSRegimeApuracaoTributariaSimplesNacional regimeApuracaoTributariaSimplesNacional;
    private String servicoPrestadoCidadeCodigoIBGE;
    private String tomadorCidadeCodigoIBGE;
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

    public String getRPSSerie() {
        return RPSSerie;
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

    public NFSeBarueriRPS setRPSSerie(String RPSSerie) {
        this.RPSSerie = RPSSerie;
        return this;
    }

    public String getNFSerie() {
        return NFSerie;
    }

    public NFSeBarueriRPS setNFSerie(String NFSerie) {
        this.NFSerie = NFSerie;
        return this;
    }

    public String getRPSNumero() {
        return RPSNumero;
    }

    public NFSeBarueriRPS setRPSNumero(String RPSNumero) {
        this.RPSNumero = RPSNumero;
        return this;
    }

    public LocalDate getRPSDataEmissao() {
        return RPSDataEmissao;
    }

    public NFSeBarueriRPS setRPSDataEmissao(LocalDate RPSDataEmissao) {
        this.RPSDataEmissao = RPSDataEmissao;
        return this;
    }

    public LocalTime getRPSHoraEmissao() {
        return RPSHoraEmissao;
    }

    public NFSeBarueriRPS setRPSHoraEmissao(LocalTime RPSHoraEmissao) {
        this.RPSHoraEmissao = RPSHoraEmissao;
        return this;
    }

    public NFSeBarueriRPSSituacao getRPSSituacao() {
        return RPSSituacao;
    }

    public NFSeBarueriRPS setRPSSituacao(NFSeBarueriRPSSituacao RPSSituacao) {
        this.RPSSituacao = RPSSituacao;
        return this;
    }

    public NFSeBarueriRPSCodigoMotivoCancelamento getRPSMotivoCancelamento() {
        return RPSMotivoCancelamento;
    }

    public NFSeBarueriRPS setRPSMotivoCancelamento(NFSeBarueriRPSCodigoMotivoCancelamento RPSMotivoCancelamento) {
        this.RPSMotivoCancelamento = RPSMotivoCancelamento;
        return this;
    }

    public String getNFSubstituidaNumero() {
        return NFSubstituidaNumero;
    }

    public NFSeBarueriRPS setNFSubstituidaNumero(String NFSubstituidaNumero) {
        this.NFSubstituidaNumero = NFSubstituidaNumero;
        return this;
    }

    public String getNFSubstituidaSerie() {
        return NFSubstituidaSerie;
    }

    public NFSeBarueriRPS setNFSubstituidaSerie(String NFSubstituidaSerie) {
        this.NFSubstituidaSerie = NFSubstituidaSerie;
        return this;
    }

    public LocalDate getNFSubstituidaDataEmissao() {
        return NFSubstituidaDataEmissao;
    }

    public NFSeBarueriRPS setNFSubstituidaDataEmissao(LocalDate NFSubstituidaDataEmissao) {
        this.NFSubstituidaDataEmissao = NFSubstituidaDataEmissao;
        return this;
    }

    public String getNFSubstituidaDescricaoCancelamento() {
        return NFSubstituidaDescricaoCancelamento;
    }

    public NFSeBarueriRPS setNFSubstituidaDescricaoCancelamento(String NFSubstituidaDescricaoCancelamento) {
        this.NFSubstituidaDescricaoCancelamento = NFSubstituidaDescricaoCancelamento;
        return this;
    }

    public String getRPSCodigoServicoPrestado() {
        return RPSCodigoServicoPrestado;
    }

    public NFSeBarueriRPS setRPSCodigoServicoPrestado(String RPSCodigoServicoPrestado) {
        this.RPSCodigoServicoPrestado = RPSCodigoServicoPrestado;
        return this;
    }

    public NFSeBarueriRPSLocalPrestacaoServico getRPSLocalPrestacaoServico() {
        return RPSLocalPrestacaoServico;
    }

    public NFSeBarueriRPS setRPSLocalPrestacaoServico(NFSeBarueriRPSLocalPrestacaoServico RPSLocalPrestacaoServico) {
        this.RPSLocalPrestacaoServico = RPSLocalPrestacaoServico;
        return this;
    }

    public NFSeBarueriRPSServicoPrestadoViasPublicas getRPSServicoPrestadoEmViasPublicas() {
        return RPSServicoPrestadoEmViasPublicas;
    }

    public NFSeBarueriRPS setRPSServicoPrestadoEmViasPublicas(NFSeBarueriRPSServicoPrestadoViasPublicas RPSServicoPrestadoEmViasPublicas) {
        this.RPSServicoPrestadoEmViasPublicas = RPSServicoPrestadoEmViasPublicas;
        return this;
    }

    public String getRPSEnderecoServicoPrestado() {
        return RPSEnderecoServicoPrestado;
    }

    public NFSeBarueriRPS setRPSEnderecoServicoPrestado(String RPSEnderecoServicoPrestado) {
        this.RPSEnderecoServicoPrestado = RPSEnderecoServicoPrestado;
        return this;
    }

    public String getRPSEnderecoServicoPrestadoNumero() {
        return RPSEnderecoServicoPrestadoNumero;
    }

    public NFSeBarueriRPS setRPSEnderecoServicoPrestadoNumero(String RPSEnderecoServicoPrestadoNumero) {
        this.RPSEnderecoServicoPrestadoNumero = RPSEnderecoServicoPrestadoNumero;
        return this;
    }

    public String getRPSEnderecoServicoPrestadoComplemento() {
        return RPSEnderecoServicoPrestadoComplemento;
    }

    public NFSeBarueriRPS setRPSEnderecoServicoPrestadoComplemento(String RPSEnderecoServicoPrestadoComplemento) {
        this.RPSEnderecoServicoPrestadoComplemento = RPSEnderecoServicoPrestadoComplemento;
        return this;
    }

    public String getRPSEnderecoServicoPrestadoBairro() {
        return RPSEnderecoServicoPrestadoBairro;
    }

    public NFSeBarueriRPS setRPSEnderecoServicoPrestadoBairro(String RPSEnderecoServicoPrestadoBairro) {
        this.RPSEnderecoServicoPrestadoBairro = RPSEnderecoServicoPrestadoBairro;
        return this;
    }

    public String getRPSEnderecoServicoPrestadoCidade() {
        return RPSEnderecoServicoPrestadoCidade;
    }

    public NFSeBarueriRPS setRPSEnderecoServicoPrestadoCidade(String RPSEnderecoServicoPrestadoCidade) {
        this.RPSEnderecoServicoPrestadoCidade = RPSEnderecoServicoPrestadoCidade;
        return this;
    }

    public String getRPSEnderecoServicoPrestadoUF() {
        return RPSEnderecoServicoPrestadoUF;
    }

    public NFSeBarueriRPS setRPSEnderecoServicoPrestadoUF(String RPSEnderecoServicoPrestadoUF) {
        this.RPSEnderecoServicoPrestadoUF = RPSEnderecoServicoPrestadoUF;
        return this;
    }

    public String getRPSEnderecoServicoPrestadoCodigoPostal() {
        return RPSEnderecoServicoPrestadoCodigoPostal;
    }

    public NFSeBarueriRPS setRPSEnderecoServicoPrestadoCodigoPostal(String RPSEnderecoServicoPrestadoCodigoPostal) {
        this.RPSEnderecoServicoPrestadoCodigoPostal = RPSEnderecoServicoPrestadoCodigoPostal;
        return this;
    }

    public String getRPSQuantidadeServicoPrestado() {
        return RPSQuantidadeServicoPrestado;
    }

    public NFSeBarueriRPS setRPSQuantidadeServicoPrestado(String RPSQuantidadeServicoPrestado) {
        this.RPSQuantidadeServicoPrestado = RPSQuantidadeServicoPrestado;
        return this;
    }

    public BigDecimal getRPSValorServico() {
        return RPSValorServico;
    }

    public NFSeBarueriRPS setRPSValorServico(BigDecimal RPSValorServico) {
        this.RPSValorServico = RPSValorServico;
        return this;
    }

    public BigDecimal getRPSValorRetencoes() {
        return RPSValorRetencoes;
    }

    public NFSeBarueriRPS setRPSValorRetencoes(BigDecimal RPSValorRetencoes) {
        this.RPSValorRetencoes = RPSValorRetencoes;
        return this;
    }

    public NFSeBarueriRPSTomadorTipo getRPSTomadorTipo() {
        return RPSTomadorTipo;
    }

    public NFSeBarueriRPS setRPSTomadorTipo(NFSeBarueriRPSTomadorTipo RPSTomadorTipo) {
        this.RPSTomadorTipo = RPSTomadorTipo;
        return this;
    }

    public String getRPSCodigoPaisTomadorEstrangeiro() {
        return RPSCodigoPaisTomadorEstrangeiro;
    }

    public NFSeBarueriRPS setRPSCodigoPaisTomadorEstrangeiro(String RPSCodigoPaisTomadorEstrangeiro) {
        this.RPSCodigoPaisTomadorEstrangeiro = RPSCodigoPaisTomadorEstrangeiro;
        return this;
    }

    public NFSeBarueriRPSServicoExportacao getRPSServicoExportacao() {
        return RPSServicoExportacao;
    }

    public NFSeBarueriRPS setRPSServicoExportacao(NFSeBarueriRPSServicoExportacao RPSServicoExportacao) {
        this.RPSServicoExportacao = RPSServicoExportacao;
        return this;
    }

    public String getRPSTomadorDocumento() {
        return RPSTomadorDocumento;
    }

    public NFSeBarueriRPS setRPSTomadorDocumento(String RPSTomadorDocumento) {
        this.RPSTomadorDocumento = RPSTomadorDocumento;
        return this;
    }

    public String getRPSTomadorRazaoSocial() {
        return RPSTomadorRazaoSocial;
    }

    public NFSeBarueriRPS setRPSTomadorRazaoSocial(String RPSTomadorRazaoSocial) {
        this.RPSTomadorRazaoSocial = RPSTomadorRazaoSocial;
        return this;
    }

    public String getRPSTomadorEndereco() {
        return RPSTomadorEndereco;
    }

    public NFSeBarueriRPS setRPSTomadorEndereco(String RPSTomadorEndereco) {
        this.RPSTomadorEndereco = RPSTomadorEndereco;
        return this;
    }

    public String getRPSTomadorEnderecoNumero() {
        return RPSTomadorEnderecoNumero;
    }

    public NFSeBarueriRPS setRPSTomadorEnderecoNumero(String RPSTomadorEnderecoNumero) {
        this.RPSTomadorEnderecoNumero = RPSTomadorEnderecoNumero;
        return this;
    }

    public String getRPSTomadorEnderecoComplemento() {
        return RPSTomadorEnderecoComplemento;
    }

    public NFSeBarueriRPS setRPSTomadorEnderecoComplemento(String RPSTomadorEnderecoComplemento) {
        this.RPSTomadorEnderecoComplemento = RPSTomadorEnderecoComplemento;
        return this;
    }

    public String getRPSTomadorEnderecoBairro() {
        return RPSTomadorEnderecoBairro;
    }

    public NFSeBarueriRPS setRPSTomadorEnderecoBairro(String RPSTomadorEnderecoBairro) {
        this.RPSTomadorEnderecoBairro = RPSTomadorEnderecoBairro;
        return this;
    }

    public String getRPSTomadorEnderecoCidade() {
        return RPSTomadorEnderecoCidade;
    }

    public NFSeBarueriRPS setRPSTomadorEnderecoCidade(String RPSTomadorEnderecoCidade) {
        this.RPSTomadorEnderecoCidade = RPSTomadorEnderecoCidade;
        return this;
    }

    public String getRPSTomadorEnderecoUF() {
        return RPSTomadorEnderecoUF;
    }

    public NFSeBarueriRPS setRPSTomadorEnderecoUF(String RPSTomadorEnderecoUF) {
        this.RPSTomadorEnderecoUF = RPSTomadorEnderecoUF;
        return this;
    }

    public String getRPSTomadorEnderecoCodigoPostal() {
        return RPSTomadorEnderecoCodigoPostal;
    }

    public NFSeBarueriRPS setRPSTomadorEnderecoCodigoPostal(String RPSTomadorEnderecoCodigoPostal) {
        this.RPSTomadorEnderecoCodigoPostal = RPSTomadorEnderecoCodigoPostal;
        return this;
    }

    public String getRPSTomadorEmail() {
        return RPSTomadorEmail;
    }

    public NFSeBarueriRPS setRPSTomadorEmail(String RPSTomadorEmail) {
        this.RPSTomadorEmail = RPSTomadorEmail;
        return this;
    }

    public String getRPSFaturaNumero() {
        return RPSFaturaNumero;
    }

    public NFSeBarueriRPS setRPSFaturaNumero(String RPSFaturaNumero) {
        this.RPSFaturaNumero = RPSFaturaNumero;
        return this;
    }

    public BigDecimal getRPSFaturaValor() {
        return RPSFaturaValor;
    }

    public NFSeBarueriRPS setRPSFaturaValor(BigDecimal RPSFaturaValor) {
        this.RPSFaturaValor = RPSFaturaValor;
        return this;
    }

    public String getRPSFaturaFormaPagamento() {
        return RPSFaturaFormaPagamento;
    }

    public NFSeBarueriRPS setRPSFaturaFormaPagamento(String RPSFaturaFormaPagamento) {
        this.RPSFaturaFormaPagamento = RPSFaturaFormaPagamento;
        return this;
    }

    public String getRPSDiscriminacaoServicos() {
        return RPSDiscriminacaoServicos;
    }

    public NFSeBarueriRPS setRPSDiscriminacaoServicos(String RPSDiscriminacaoServicos) {
        this.RPSDiscriminacaoServicos = RPSDiscriminacaoServicos;
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

