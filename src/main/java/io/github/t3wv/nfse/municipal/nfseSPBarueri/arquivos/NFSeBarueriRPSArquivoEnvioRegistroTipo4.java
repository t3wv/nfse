package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.WSBarueri;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.*;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

public class NFSeBarueriRPSArquivoEnvioRegistroTipo4 extends NFSeBarueriRPSArquivoEnvioRegistro<NFSeBarueriRPSArquivoEnvioRegistroTipo4> {

    static final String TIPO_REGISTRO = "4";
    private NFSeBarueriOptanteSimplesNacional optanteSimplesNacional;
    private NFSeBarueriRegimeApuracaoTributariaSimplesNacional regimeApuracaoTributariaSimplesNacional;
    private NFSeBarueriPais paisLocalServicoPrestado;
    private String codigoCidadeLocalServicoPrestado;
    private String codigoCidadeTomador;
    private String nif;
    private String codigoNBS;
    private String codigoPostalTomadorEstrangeiro;
    private String estadoProvinciaRegiaoTomadorEstrangeiro;
    private NFSeBarueriVinculoEntrePartes vinculoEntrePartes;
    private String reservado;
    private String codigoPostalLocalServicoPrestadoExterior;
    private String estadoProvinciaRegiaoLocalServicoPrestadoExterior;
    private String nomeDoEvento;
    private LocalDate dataInicioEvento;
    private LocalDate dataTerminoEvento;
    private NFSeBarueriJustificativaCancelamento justificativaCancelamento;
    private String codigoIndicadorOperacaoFornecimento;
    private String codigoClassificacaoTributariaIBSCBS;
    private String codigoSituacaoTributariaIBSCBS;
    private Boolean operacaoConsumoPessoal;
    private NFSeBarueriIndicadorDestinatarioServico indicadorDestinatarioServico;

    public NFSeBarueriOptanteSimplesNacional getOptanteSimplesNacional() {
        return optanteSimplesNacional;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setOptanteSimplesNacional(NFSeBarueriOptanteSimplesNacional optanteSimplesNacional) {
        this.optanteSimplesNacional = optanteSimplesNacional;
        return this;
    }

    public NFSeBarueriRegimeApuracaoTributariaSimplesNacional getRegimeApuracaoTributariaSimplesNacional() {
        return regimeApuracaoTributariaSimplesNacional;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setRegimeApuracaoTributariaSimplesNacional(NFSeBarueriRegimeApuracaoTributariaSimplesNacional regimeApuracaoTributariaSimplesNacional) {
        this.regimeApuracaoTributariaSimplesNacional = regimeApuracaoTributariaSimplesNacional;
        return this;
    }

    public NFSeBarueriPais getPaisLocalServicoPrestado() {
        return paisLocalServicoPrestado;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setPaisLocalServicoPrestado(NFSeBarueriPais paisLocalServicoPrestado) {
        this.paisLocalServicoPrestado = paisLocalServicoPrestado;
        return this;
    }

    public String getCodigoCidadeLocalServicoPrestado() {
        return codigoCidadeLocalServicoPrestado;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setCodigoCidadeLocalServicoPrestado(String codigoCidadeLocalServicoPrestado) {
        this.codigoCidadeLocalServicoPrestado = codigoCidadeLocalServicoPrestado;
        return this;
    }

    public String getCodigoCidadeTomador() {
        return codigoCidadeTomador;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setCodigoCidadeTomador(String codigoCidadeTomador) {
        this.codigoCidadeTomador = codigoCidadeTomador;
        return this;
    }

    public String getNif() {
        return nif;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setNif(String nif) {
        this.nif = nif;
        return this;
    }

    public String getCodigoNBS() {
        return codigoNBS;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setCodigoNBS(String codigoNBS) {
        this.codigoNBS = codigoNBS;
        return this;
    }

    public String getCodigoPostalTomadorEstrangeiro() {
        return codigoPostalTomadorEstrangeiro;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setCodigoPostalTomadorEstrangeiro(String codigoPostalTomadorEstrangeiro) {
        this.codigoPostalTomadorEstrangeiro = codigoPostalTomadorEstrangeiro;
        return this;
    }

    public String getEstadoProvinciaRegiaoTomadorEstrangeiro() {
        return estadoProvinciaRegiaoTomadorEstrangeiro;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setEstadoProvinciaRegiaoTomadorEstrangeiro(String estadoProvinciaRegiaoTomadorEstrangeiro) {
        this.estadoProvinciaRegiaoTomadorEstrangeiro = estadoProvinciaRegiaoTomadorEstrangeiro;
        return this;
    }

    public NFSeBarueriVinculoEntrePartes getVinculoEntrePartes() {
        return vinculoEntrePartes;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setVinculoEntrePartes(NFSeBarueriVinculoEntrePartes vinculoEntrePartes) {
        this.vinculoEntrePartes = vinculoEntrePartes;
        return this;
    }

    public String getReservado() {
        return reservado;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setReservado(String reservado) {
        this.reservado = reservado;
        return this;
    }

    public String getCodigoPostalLocalServicoPrestadoExterior() {
        return codigoPostalLocalServicoPrestadoExterior;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setCodigoPostalLocalServicoPrestadoExterior(String codigoPostalLocalServicoPrestadoExterior) {
        this.codigoPostalLocalServicoPrestadoExterior = codigoPostalLocalServicoPrestadoExterior;
        return this;
    }

    public String getEstadoProvinciaRegiaoLocalServicoPrestadoExterior() {
        return estadoProvinciaRegiaoLocalServicoPrestadoExterior;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setEstadoProvinciaRegiaoLocalServicoPrestadoExterior(String estadoProvinciaRegiaoLocalServicoPrestadoExterior) {
        this.estadoProvinciaRegiaoLocalServicoPrestadoExterior = estadoProvinciaRegiaoLocalServicoPrestadoExterior;
        return this;
    }

    public String getNomeDoEvento() {
        return nomeDoEvento;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setNomeDoEvento(String nomeDoEvento) {
        this.nomeDoEvento = nomeDoEvento;
        return this;
    }

    public LocalDate getDataInicioEvento() {
        return dataInicioEvento;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setDataInicioEvento(LocalDate dataInicioEvento) {
        this.dataInicioEvento = dataInicioEvento;
        return this;
    }

    public LocalDate getDataTerminoEvento() {
        return dataTerminoEvento;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setDataTerminoEvento(LocalDate dataTerminoEvento) {
        this.dataTerminoEvento = dataTerminoEvento;
        return this;
    }

    public NFSeBarueriJustificativaCancelamento getJustificativaCancelamento() {
        return justificativaCancelamento;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setJustificativaCancelamento(NFSeBarueriJustificativaCancelamento justificativaCancelamento) {
        this.justificativaCancelamento = justificativaCancelamento;
        return this;
    }

    public String getCodigoIndicadorOperacaoFornecimento() {
        return codigoIndicadorOperacaoFornecimento;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setCodigoIndicadorOperacaoFornecimento(String codigoIndicadorOperacaoFornecimento) {
        this.codigoIndicadorOperacaoFornecimento = codigoIndicadorOperacaoFornecimento;
        return this;
    }

    public String getCodigoClassificacaoTributariaIBSCBS() {
        return codigoClassificacaoTributariaIBSCBS;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setCodigoClassificacaoTributariaIBSCBS(String codigoClassificacaoTributariaIBSCBS) {
        this.codigoClassificacaoTributariaIBSCBS = codigoClassificacaoTributariaIBSCBS;
        return this;
    }

    public String getCodigoSituacaoTributariaIBSCBS() {
        return codigoSituacaoTributariaIBSCBS;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setCodigoSituacaoTributariaIBSCBS(String codigoSituacaoTributariaIBSCBS) {
        this.codigoSituacaoTributariaIBSCBS = codigoSituacaoTributariaIBSCBS;
        return this;
    }

    public Boolean getOperacaoConsumoPessoal() {
        return operacaoConsumoPessoal;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setOperacaoConsumoPessoal(Boolean operacaoConsumoPessoal) {
        this.operacaoConsumoPessoal = operacaoConsumoPessoal;
        return this;
    }

    public NFSeBarueriIndicadorDestinatarioServico getIndicadorDestinatarioServico() {
        return indicadorDestinatarioServico;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 setIndicadorDestinatarioServico(NFSeBarueriIndicadorDestinatarioServico indicadorDestinatarioServico) {
        this.indicadorDestinatarioServico = indicadorDestinatarioServico;
        return this;
    }

    @Override
    public String getTipoRegistro() {
        return TIPO_REGISTRO;
    }

    @Override
    public NFSeBarueriRPSArquivoEnvioRegistroTipo4 fromLinha(String linha) {
        return new NFSeBarueriRPSArquivoEnvioRegistroTipo4()
                .setOptanteSimplesNacional(NFSeBarueriOptanteSimplesNacional.valueOfCodigo(linha.substring(1, 2)))
                .setRegimeApuracaoTributariaSimplesNacional(NFSeBarueriRegimeApuracaoTributariaSimplesNacional.valueOfCodigo(linha.substring(2, 3)))
                .setPaisLocalServicoPrestado(NFSeBarueriPais.valueOfCodigo(linha.substring(3, 6)))
                .setCodigoCidadeLocalServicoPrestado(StringUtils.trimToEmpty(linha.substring(6, 13)))
                .setCodigoCidadeTomador(StringUtils.trimToEmpty(linha.substring(13, 20)))
                .setNif(StringUtils.trimToEmpty(linha.substring(20, 60)))
                .setCodigoNBS(StringUtils.trimToEmpty(linha.substring(60, 69)))
                .setCodigoPostalTomadorEstrangeiro(StringUtils.trimToEmpty(linha.substring(69, 80)))
                .setEstadoProvinciaRegiaoTomadorEstrangeiro(StringUtils.trimToEmpty(linha.substring(80, 140)))
                .setVinculoEntrePartes(NFSeBarueriVinculoEntrePartes.valueOfCodigo(linha.substring(140, 141)))
                .setReservado(StringUtils.trimToEmpty(linha.substring(141, 171)))
                .setCodigoPostalLocalServicoPrestadoExterior(StringUtils.trimToEmpty(linha.substring(171, 182)))
                .setEstadoProvinciaRegiaoLocalServicoPrestadoExterior(StringUtils.trimToEmpty(linha.substring(182, 242)))
                .setNomeDoEvento(StringUtils.trimToEmpty(linha.substring(242, 497)))
                .setDataInicioEvento(StringUtils.isBlank(linha.substring(497, 505)) ? null : LocalDate.parse(linha.substring(497, 505), WSBarueri.FORMATO_DATA))
                .setDataTerminoEvento(StringUtils.isBlank(linha.substring(505, 513)) ? null : LocalDate.parse(linha.substring(505, 513), WSBarueri.FORMATO_DATA))
                .setJustificativaCancelamento(NFSeBarueriJustificativaCancelamento.valueOfCodigo(linha.substring(513, 514)))
                .setCodigoIndicadorOperacaoFornecimento(StringUtils.trimToEmpty(linha.substring(514, 520)))
                .setCodigoClassificacaoTributariaIBSCBS(StringUtils.trimToEmpty(linha.substring(520, 526)))
                .setCodigoSituacaoTributariaIBSCBS(StringUtils.trimToEmpty(linha.substring(526, 529)))
                .setOperacaoConsumoPessoal("1".equals(StringUtils.trimToEmpty(linha.substring(529, 530))) ? Boolean.TRUE : Boolean.FALSE)
                .setIndicadorDestinatarioServico(NFSeBarueriIndicadorDestinatarioServico.valueOfCodigo(linha.substring(530, 531)))
                .setErros(parseErros(linha));
    }

    @Override
    public String toLinha() {
        return String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s",
                getTipoRegistro(),
                this.optanteSimplesNacional.getCodigo(),
                this.regimeApuracaoTributariaSimplesNacional != null ? this.regimeApuracaoTributariaSimplesNacional.getCodigo() : " ",
                this.paisLocalServicoPrestado != null ? this.paisLocalServicoPrestado.getCodigo() : "   ",
                StringUtils.isNotBlank(this.codigoCidadeLocalServicoPrestado) ? StringUtils.leftPad(this.codigoCidadeLocalServicoPrestado, 7, '0') : "       ",
                StringUtils.isNotBlank(this.codigoCidadeTomador) ? StringUtils.leftPad(this.codigoCidadeTomador, 7, '0') : "       ",
                StringUtils.rightPad(StringUtils.trimToEmpty(this.nif), 40),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.codigoNBS), 9, ' '),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.codigoPostalTomadorEstrangeiro), 11),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.estadoProvinciaRegiaoTomadorEstrangeiro), 60),
                this.vinculoEntrePartes != null ? this.vinculoEntrePartes.getCodigo() : " ",
                StringUtils.rightPad(StringUtils.trimToEmpty(this.reservado), 30),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.codigoPostalLocalServicoPrestadoExterior), 11),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.estadoProvinciaRegiaoLocalServicoPrestadoExterior), 60),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.nomeDoEvento), 255),
                this.dataInicioEvento != null ? this.dataInicioEvento.format(WSBarueri.FORMATO_DATA) : "        ",
                this.dataTerminoEvento != null ? this.dataTerminoEvento.format(WSBarueri.FORMATO_DATA) : "        ",
                this.justificativaCancelamento != null ? this.justificativaCancelamento.getCodigo() : " ",
                StringUtils.rightPad(StringUtils.trimToEmpty(this.codigoIndicadorOperacaoFornecimento), 6),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.codigoClassificacaoTributariaIBSCBS), 6),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.codigoSituacaoTributariaIBSCBS), 3),
                this.operacaoConsumoPessoal != null && this.operacaoConsumoPessoal ? "1" : "0",
                this.indicadorDestinatarioServico != null ? this.indicadorDestinatarioServico.getCodigo() : " ");
    }
}
