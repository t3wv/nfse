package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.WSBarueri;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.*;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;

public class NFSeBarueriRPSArquivoEnvioRegistroTipo2 extends NFSeBarueriRPSArquivoEnvioRegistro<NFSeBarueriRPSArquivoEnvioRegistroTipo2> {

    public static final String TIPO_REGISTRO = "2";

    private String tipoRPS, serieRPS, serieNFe;
    private Long numeroRPS;
    private LocalDate dataRPS;
    private LocalTime horaRPS;
    private NFSeBarueriSituacao situacaoRPS;
    private NFSeBarueriMotivoCancelamento motivoCancelamento;
    private String numeroNfeASerCanceladaOuSubstituida;
    private String serieNfeASerCanceladaOuSubstituida;
    private LocalDate dataEmissaoNFeASerCanceladaOuSubstituida;
    private String descricaoCancelamento;
    private String codigoServicoPrestado;
    private NFSeBarueriLocalPrestacaoServico localPrestacaoServico;
    private Boolean servicoPrestadoEmViaPublica;

    private String enderecoLogradouroLocalServicoPrestado;
    private String enderecoNumeroLocalServicoPrestado;
    private String enderecoComplementoLocalServicoPrestado;
    private String enderecoBairroLocalServicoPrestado;
    private String enderecoCidadeLocalServicoPrestado;
    private String enderecoUFLocalServicoPrestado;
    private String enderecoCEPLocalServicoPrestado;

    private Integer quantidadeServicoPrestado;
    private BigDecimal valorServicoPrestado;

    private String reservado;

    private BigDecimal valorRetencoes;

    private Boolean tomadorEstrangeiro;
    private NFSeBarueriPais paisTomadorEstrangeiro;
    private Boolean servicoExportacao;
    private NFSeBarueriPessoaTipo indicadorCpfCnpjTomador;
    private String cpfCnpjTomador;
    private String razaoSocialTomador;
    private String enderecoLogradouroTomador;
    private String enderecoNumeroTomador;
    private String enderecoComplementoTomador;
    private String enderecoBairroTomador;
    private String enderecoCidadeTomador;
    private String enderecoUFTomador;
    private String enderecoCEPTomador;
    private String emailTomador;
    private String numeroFatura;
    private BigDecimal valorFatura;
    private String formaPagamentoFatura;

    private String discriminacaoServico;

    public String getTipoRPS() {
        return tipoRPS;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setTipoRPS(String tipoRPS) {
        this.tipoRPS = tipoRPS;
        return this;
    }

    public String getSerieRPS() {
        return serieRPS;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setSerieRPS(String serieRPS) {
        this.serieRPS = serieRPS;
        return this;
    }

    public String getSerieNFe() {
        return serieNFe;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setSerieNFe(String serieNFe) {
        this.serieNFe = serieNFe;
        return this;
    }

    public Long getNumeroRPS() {
        return numeroRPS;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setNumeroRPS(Long numeroRPS) {
        this.numeroRPS = numeroRPS;
        return this;
    }

    public LocalDate getDataRPS() {
        return dataRPS;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setDataRPS(LocalDate dataRPS) {
        this.dataRPS = dataRPS;
        return this;
    }

    public LocalTime getHoraRPS() {
        return horaRPS;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setHoraRPS(LocalTime horaRPS) {
        this.horaRPS = horaRPS;
        return this;
    }

    public NFSeBarueriSituacao getSituacaoRPS() {
        return situacaoRPS;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setSituacaoRPS(NFSeBarueriSituacao situacaoRPS) {
        this.situacaoRPS = situacaoRPS;
        return this;
    }

    public NFSeBarueriMotivoCancelamento getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setMotivoCancelamento(NFSeBarueriMotivoCancelamento motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
        return this;
    }

    public String getNumeroNfeASerCanceladaOuSubstituida() {
        return numeroNfeASerCanceladaOuSubstituida;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setNumeroNfeASerCanceladaOuSubstituida(String numeroNfeASerCanceladaOuSubstituida) {
        this.numeroNfeASerCanceladaOuSubstituida = numeroNfeASerCanceladaOuSubstituida;
        return this;
    }

    public String getSerieNfeASerCanceladaOuSubstituida() {
        return serieNfeASerCanceladaOuSubstituida;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setSerieNfeASerCanceladaOuSubstituida(String serieNfeASerCanceladaOuSubstituida) {
        this.serieNfeASerCanceladaOuSubstituida = serieNfeASerCanceladaOuSubstituida;
        return this;
    }

    public LocalDate getDataEmissaoNFeASerCanceladaOuSubstituida() {
        return dataEmissaoNFeASerCanceladaOuSubstituida;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setDataEmissaoNFeASerCanceladaOuSubstituida(LocalDate dataEmissaoNFeASerCanceladaOuSubstituida) {
        this.dataEmissaoNFeASerCanceladaOuSubstituida = dataEmissaoNFeASerCanceladaOuSubstituida;
        return this;
    }

    public String getDescricaoCancelamento() {
        return descricaoCancelamento;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setDescricaoCancelamento(String descricaoCancelamento) {
        this.descricaoCancelamento = descricaoCancelamento;
        return this;
    }

    public String getCodigoServicoPrestado() {
        return codigoServicoPrestado;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setCodigoServicoPrestado(String codigoServicoPrestado) {
        this.codigoServicoPrestado = codigoServicoPrestado;
        return this;
    }

    public NFSeBarueriLocalPrestacaoServico getLocalPrestacaoServico() {
        return localPrestacaoServico;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setLocalPrestacaoServico(NFSeBarueriLocalPrestacaoServico localPrestacaoServico) {
        this.localPrestacaoServico = localPrestacaoServico;
        return this;
    }

    public Boolean getServicoPrestadoEmViaPublica() {
        return servicoPrestadoEmViaPublica;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setServicoPrestadoEmViaPublica(Boolean servicoPrestadoEmViaPublica) {
        this.servicoPrestadoEmViaPublica = servicoPrestadoEmViaPublica;
        return this;
    }

    public String getEnderecoLogradouroLocalServicoPrestado() {
        return enderecoLogradouroLocalServicoPrestado;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setEnderecoLogradouroLocalServicoPrestado(String enderecoLogradouroLocalServicoPrestado) {
        this.enderecoLogradouroLocalServicoPrestado = enderecoLogradouroLocalServicoPrestado;
        return this;
    }

    public String getEnderecoNumeroLocalServicoPrestado() {
        return enderecoNumeroLocalServicoPrestado;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setEnderecoNumeroLocalServicoPrestado(String enderecoNumeroLocalServicoPrestado) {
        this.enderecoNumeroLocalServicoPrestado = enderecoNumeroLocalServicoPrestado;
        return this;
    }

    public String getEnderecoComplementoLocalServicoPrestado() {
        return enderecoComplementoLocalServicoPrestado;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setEnderecoComplementoLocalServicoPrestado(String enderecoComplementoLocalServicoPrestado) {
        this.enderecoComplementoLocalServicoPrestado = enderecoComplementoLocalServicoPrestado;
        return this;
    }

    public String getEnderecoBairroLocalServicoPrestado() {
        return enderecoBairroLocalServicoPrestado;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setEnderecoBairroLocalServicoPrestado(String enderecoBairroLocalServicoPrestado) {
        this.enderecoBairroLocalServicoPrestado = enderecoBairroLocalServicoPrestado;
        return this;
    }

    public String getEnderecoCidadeLocalServicoPrestado() {
        return enderecoCidadeLocalServicoPrestado;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setEnderecoCidadeLocalServicoPrestado(String enderecoCidadeLocalServicoPrestado) {
        this.enderecoCidadeLocalServicoPrestado = enderecoCidadeLocalServicoPrestado;
        return this;
    }

    public String getEnderecoUFLocalServicoPrestado() {
        return enderecoUFLocalServicoPrestado;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setEnderecoUFLocalServicoPrestado(String enderecoUFLocalServicoPrestado) {
        this.enderecoUFLocalServicoPrestado = enderecoUFLocalServicoPrestado;
        return this;
    }

    public String getEnderecoCEPLocalServicoPrestado() {
        return enderecoCEPLocalServicoPrestado;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setEnderecoCEPLocalServicoPrestado(String enderecoCEPLocalServicoPrestado) {
        this.enderecoCEPLocalServicoPrestado = enderecoCEPLocalServicoPrestado;
        return this;
    }

    public Integer getQuantidadeServicoPrestado() {
        return quantidadeServicoPrestado;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setQuantidadeServicoPrestado(Integer quantidadeServicoPrestado) {
        this.quantidadeServicoPrestado = quantidadeServicoPrestado;
        return this;
    }

    public BigDecimal getValorServicoPrestado() {
        return valorServicoPrestado;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setValorServicoPrestado(BigDecimal valorServicoPrestado) {
        this.valorServicoPrestado = valorServicoPrestado;
        return this;
    }

    public String getReservado() {
        return reservado;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setReservado(String reservado) {
        this.reservado = reservado;
        return this;
    }

    public BigDecimal getValorRetencoes() {
        return valorRetencoes;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setValorRetencoes(BigDecimal valorRetencoes) {
        this.valorRetencoes = valorRetencoes;
        return this;
    }

    public Boolean getTomadorEstrangeiro() {
        return tomadorEstrangeiro;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setTomadorEstrangeiro(Boolean tomadorEstrangeiro) {
        this.tomadorEstrangeiro = tomadorEstrangeiro;
        return this;
    }

    public NFSeBarueriPais getPaisTomadorEstrangeiro() {
        return paisTomadorEstrangeiro;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setPaisTomadorEstrangeiro(NFSeBarueriPais paisTomadorEstrangeiro) {
        this.paisTomadorEstrangeiro = paisTomadorEstrangeiro;
        return this;
    }

    public Boolean getServicoExportacao() {
        return servicoExportacao;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setServicoExportacao(Boolean servicoExportacao) {
        this.servicoExportacao = servicoExportacao;
        return this;
    }

    public NFSeBarueriPessoaTipo getIndicadorCpfCnpjTomador() {
        return indicadorCpfCnpjTomador;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setIndicadorCpfCnpjTomador(NFSeBarueriPessoaTipo indicadorCpfCnpjTomador) {
        this.indicadorCpfCnpjTomador = indicadorCpfCnpjTomador;
        return this;
    }

    public String getCpfCnpjTomador() {
        return cpfCnpjTomador;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setCpfCnpjTomador(String cpfCnpjTomador) {
        this.cpfCnpjTomador = cpfCnpjTomador;
        return this;
    }

    public String getRazaoSocialTomador() {
        return razaoSocialTomador;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setRazaoSocialTomador(String razaoSocialTomador) {
        this.razaoSocialTomador = razaoSocialTomador;
        return this;
    }

    public String getEnderecoLogradouroTomador() {
        return enderecoLogradouroTomador;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setEnderecoLogradouroTomador(String enderecoLogradouroTomador) {
        this.enderecoLogradouroTomador = enderecoLogradouroTomador;
        return this;
    }

    public String getEnderecoNumeroTomador() {
        return enderecoNumeroTomador;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setEnderecoNumeroTomador(String enderecoNumeroTomador) {
        this.enderecoNumeroTomador = enderecoNumeroTomador;
        return this;
    }

    public String getEnderecoComplementoTomador() {
        return enderecoComplementoTomador;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setEnderecoComplementoTomador(String enderecoComplementoTomador) {
        this.enderecoComplementoTomador = enderecoComplementoTomador;
        return this;
    }

    public String getEnderecoBairroTomador() {
        return enderecoBairroTomador;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setEnderecoBairroTomador(String enderecoBairroTomador) {
        this.enderecoBairroTomador = enderecoBairroTomador;
        return this;
    }

    public String getEnderecoCidadeTomador() {
        return enderecoCidadeTomador;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setEnderecoCidadeTomador(String enderecoCidadeTomador) {
        this.enderecoCidadeTomador = enderecoCidadeTomador;
        return this;
    }

    public String getEnderecoUFTomador() {
        return enderecoUFTomador;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setEnderecoUFTomador(String enderecoUFTomador) {
        this.enderecoUFTomador = enderecoUFTomador;
        return this;
    }

    public String getEnderecoCEPTomador() {
        return enderecoCEPTomador;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setEnderecoCEPTomador(String enderecoCEPTomador) {
        this.enderecoCEPTomador = enderecoCEPTomador;
        return this;
    }

    public String getEmailTomador() {
        return emailTomador;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setEmailTomador(String emailTomador) {
        this.emailTomador = emailTomador;
        return this;
    }

    public String getNumeroFatura() {
        return numeroFatura;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setNumeroFatura(String numeroFatura) {
        this.numeroFatura = numeroFatura;
        return this;
    }

    public BigDecimal getValorFatura() {
        return valorFatura;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setValorFatura(BigDecimal valorFatura) {
        this.valorFatura = valorFatura;
        return this;
    }

    public String getFormaPagamentoFatura() {
        return formaPagamentoFatura;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setFormaPagamentoFatura(String formaPagamentoFatura) {
        this.formaPagamentoFatura = formaPagamentoFatura;
        return this;
    }

    public String getDiscriminacaoServico() {
        return discriminacaoServico;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 setDiscriminacaoServico(String discriminacaoServico) {
        this.discriminacaoServico = discriminacaoServico;
        return this;
    }

    @Override
    public String getTipoRegistro() {
        return TIPO_REGISTRO;
    }

    @Override
    public NFSeBarueriRPSArquivoEnvioRegistroTipo2 fromLinha(String linha) {
        return new NFSeBarueriRPSArquivoEnvioRegistroTipo2()
                .setTipoRPS(StringUtils.trimToEmpty(linha.substring(1, 6)))
                .setSerieRPS(StringUtils.trimToEmpty(linha.substring(6, 10)))
                .setSerieNFe(StringUtils.trimToEmpty(linha.substring(10, 15)))
                .setNumeroRPS(Long.parseLong(linha.substring(15, 25)))
                .setDataRPS(LocalDate.from(WSBarueri.FORMATO_DATA.parse(linha.substring(25, 33))))
                .setHoraRPS(LocalTime.from(WSBarueri.FORMATO_HORA.parse(linha.substring(33, 39))))
                .setSituacaoRPS(NFSeBarueriSituacao.valueOfCodigo(linha.substring(39, 40)))
                .setMotivoCancelamento(NFSeBarueriMotivoCancelamento.valueOfCodigo(linha.substring(40, 42)))
                .setNumeroNfeASerCanceladaOuSubstituida(linha.substring(42, 49))
                .setSerieNfeASerCanceladaOuSubstituida(linha.substring(49, 54))
                .setDataEmissaoNFeASerCanceladaOuSubstituida(StringUtils.isNotBlank(StringUtils.stripStart(linha.substring(54, 62).trim(), "0")) ? LocalDate.from(WSBarueri.FORMATO_DATA.parse(linha.substring(54, 62))) : null)
                .setDescricaoCancelamento(linha.substring(62, 242))
                .setCodigoServicoPrestado(linha.substring(242, 251))
                .setLocalPrestacaoServico(NFSeBarueriLocalPrestacaoServico.valueOfCodigo(linha.substring(251, 252)))
                .setServicoPrestadoEmViaPublica("1".equals(linha.substring(252, 253)))
                .setEnderecoLogradouroLocalServicoPrestado(linha.substring(253, 328))
                .setEnderecoNumeroLocalServicoPrestado(linha.substring(328, 337))
                .setEnderecoComplementoLocalServicoPrestado(linha.substring(337, 367))
                .setEnderecoBairroLocalServicoPrestado(linha.substring(367, 407))
                .setEnderecoCidadeLocalServicoPrestado(linha.substring(407, 447))
                .setEnderecoUFLocalServicoPrestado(linha.substring(447, 449))
                .setEnderecoCEPLocalServicoPrestado(linha.substring(449, 457))
                .setQuantidadeServicoPrestado(Integer.parseInt(linha.substring(457, 463).trim()))
                .setValorServicoPrestado(new BigDecimal(linha.substring(463, 478)).movePointLeft(2))
                .setReservado(linha.substring(478, 483))
                .setValorRetencoes(new BigDecimal(linha.substring(483, 498)).movePointLeft(2))
                .setTomadorEstrangeiro("1".equals(linha.substring(498, 499)))
                .setPaisTomadorEstrangeiro(NFSeBarueriPais.valueOfCodigo(linha.substring(499, 502)))
                .setServicoExportacao("1".equals(linha.substring(502, 503)))
                .setIndicadorCpfCnpjTomador(NFSeBarueriPessoaTipo.valueOfCodigo(linha.substring(503, 504)))
                .setCpfCnpjTomador(linha.substring(504, 518))
                .setRazaoSocialTomador(linha.substring(518, 578))
                .setEnderecoLogradouroTomador(linha.substring(578, 653))
                .setEnderecoNumeroTomador(linha.substring(653, 662))
                .setEnderecoComplementoTomador(linha.substring(662, 692))
                .setEnderecoBairroTomador(linha.substring(692, 732))
                .setEnderecoCidadeTomador(linha.substring(732, 772))
                .setEnderecoUFTomador(linha.substring(772, 774))
                .setEnderecoCEPTomador(linha.substring(774, 782))
                .setEmailTomador(linha.substring(782, 934))
                .setNumeroFatura(linha.substring(934, 940))
                .setValorFatura(StringUtils.isNotBlank(linha.substring(940, 955)) ? new BigDecimal(linha.substring(940, 955)).movePointLeft(2) : null)
                .setFormaPagamentoFatura(linha.substring(955, 970))
                .setDiscriminacaoServico(linha.substring(970, 1970))
                .setErros(parseErros(linha));
    }

    @Override
    public String toLinha() {
        return String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s",
                getTipoRegistro(),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.tipoRPS), 5),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.serieRPS), 4),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.serieNFe), 5),
                StringUtils.leftPad(String.valueOf(this.numeroRPS), 10, '0'),
                dataRPS.format(WSBarueri.FORMATO_DATA),
                horaRPS.format(WSBarueri.FORMATO_HORA),
                this.situacaoRPS.getCodigo(),
                StringUtils.leftPad(this.motivoCancelamento != null ? this.motivoCancelamento.getCodigo() : "", 2),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.numeroNfeASerCanceladaOuSubstituida), 7),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.serieNfeASerCanceladaOuSubstituida), 5),
                dataEmissaoNFeASerCanceladaOuSubstituida != null ? dataEmissaoNFeASerCanceladaOuSubstituida.format(WSBarueri.FORMATO_DATA) : StringUtils.rightPad("", 8),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.descricaoCancelamento), 180),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.codigoServicoPrestado), 9, '0'),
                this.localPrestacaoServico.getCodigo(),
                this.servicoPrestadoEmViaPublica ? "1" : "2",
                StringUtils.rightPad(StringUtils.trimToEmpty(this.enderecoLogradouroLocalServicoPrestado), 75),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.enderecoNumeroLocalServicoPrestado), 9),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.enderecoComplementoLocalServicoPrestado), 30),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.enderecoBairroLocalServicoPrestado), 40),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.enderecoCidadeLocalServicoPrestado), 40),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.enderecoUFLocalServicoPrestado), 2),
                StringUtils.leftPad(StringUtils.trimToEmpty(this.enderecoCEPLocalServicoPrestado), 8, '0'),
                StringUtils.leftPad(String.valueOf(this.quantidadeServicoPrestado), 6, '0'),
                StringUtils.leftPad(this.valorServicoPrestado != null ? this.valorServicoPrestado.setScale(2, RoundingMode.HALF_UP).toPlainString().replaceAll("[^0-9]", "") : "", 15, '0'),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.reservado), 5),
                StringUtils.leftPad(this.valorRetencoes != null ? this.valorRetencoes.setScale(2, RoundingMode.HALF_UP).toPlainString().replaceAll("[^0-9]", "") : "", 15, '0'),
                this.tomadorEstrangeiro ? "1" : "2",
                StringUtils.leftPad(this.paisTomadorEstrangeiro != null ? this.paisTomadorEstrangeiro.getCodigo() : "", 3, '0'),
                this.servicoExportacao ? "1" : "2",
                this.indicadorCpfCnpjTomador != null ? this.indicadorCpfCnpjTomador.getCodigo() : NFSeBarueriPessoaTipo.ESTRANGEIRA.getCodigo(),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.cpfCnpjTomador), 14, '0'),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.razaoSocialTomador), 60),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.enderecoLogradouroTomador), 75),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.enderecoNumeroTomador), 9),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.enderecoComplementoTomador), 30),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.enderecoBairroTomador), 40),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.enderecoCidadeTomador), 40),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.enderecoUFTomador), 2),
                StringUtils.leftPad(StringUtils.trimToEmpty(this.enderecoCEPTomador), 8, '0'),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.emailTomador), 152),
                StringUtils.leftPad(StringUtils.isNotBlank(this.numeroFatura) ? StringUtils.leftPad(this.numeroFatura, 6, '0') : "", 6),
                StringUtils.leftPad(this.valorFatura != null ? StringUtils.leftPad(this.valorFatura.setScale(2, RoundingMode.HALF_UP).toPlainString().replaceAll("[^0-9]", ""), 15, '0') : "", 15),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.formaPagamentoFatura), 15),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.discriminacaoServico), 1000));
    }
}
