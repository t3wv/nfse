package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.WSBarueri;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriArquivoRetornoSituacaoNFe;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriArquivoRetornoTipoTributacao;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalTime;


public class NFSeBarueriRPSArquivoRetornoRegistroTipo2 extends NFSeBarueriRPSArquivoRetornoRegistro<NFSeBarueriRPSArquivoRetornoRegistroTipo2> {

    public static final String TIPO_REGISTRO = "2";

    private String serieNFe;
    private Long numeroNFe;
    private LocalDate dataNFe;
    private LocalTime horaNFe;
    private String codigoAutenticidade;
    private String serieRPS, numeroRPS;
    private NFSeBarueriArquivoRetornoTipoTributacao tributacao;
    private Boolean issRetido;
    private NFSeBarueriArquivoRetornoSituacaoNFe situacaoNfe;
    private LocalDate dataCancelamento;
    private Long numeroGuia;
    private LocalDate dataPagamentoGuia;
    private String tomadorDocumento;
    private String tomadorRazaoSocial;
    private String tomadorEnderecoLogradouro;
    private String tomadorEnderecoNumero;
    private String tomadorEnderecoComplemento;
    private String tomadorEnderecoBairro;
    private String tomadorEnderecoCidade;
    private String tomadorEnderecoUF;
    private String tomadorEnderecoCEP;
    private String tomadorEnderecoPais;
    private String tomadorEmails;
    private String discriminacaoServico;
    private String chaveAcessoNFSeNacional;

    public String getSerieNFe() {
        return serieNFe;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setSerieNFe(String serieNFe) {
        this.serieNFe = serieNFe;
        return this;
    }

    public Long getNumeroNFe() {
        return numeroNFe;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setNumeroNFe(Long numeroNFe) {
        this.numeroNFe = numeroNFe;
        return this;
    }

    public LocalDate getDataNFe() {
        return dataNFe;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setDataNFe(LocalDate dataNFe) {
        this.dataNFe = dataNFe;
        return this;
    }

    public LocalTime getHoraNFe() {
        return horaNFe;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setHoraNFe(LocalTime horaNFe) {
        this.horaNFe = horaNFe;
        return this;
    }

    public String getCodigoAutenticidade() {
        return codigoAutenticidade;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setCodigoAutenticidade(String codigoAutenticidade) {
        this.codigoAutenticidade = codigoAutenticidade;
        return this;
    }

    public String getSerieRPS() {
        return serieRPS;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setSerieRPS(String serieRPS) {
        this.serieRPS = serieRPS;
        return this;
    }

    public String getNumeroRPS() {
        return numeroRPS;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setNumeroRPS(String numeroRPS) {
        this.numeroRPS = numeroRPS;
        return this;
    }

    public NFSeBarueriArquivoRetornoTipoTributacao getTributacao() {
        return tributacao;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setTributacao(NFSeBarueriArquivoRetornoTipoTributacao tributacao) {
        this.tributacao = tributacao;
        return this;
    }

    public Boolean getIssRetido() {
        return issRetido;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setIssRetido(Boolean issRetido) {
        this.issRetido = issRetido;
        return this;
    }

    public NFSeBarueriArquivoRetornoSituacaoNFe getSituacaoNfe() {
        return situacaoNfe;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setSituacaoNfe(NFSeBarueriArquivoRetornoSituacaoNFe situacaoNfe) {
        this.situacaoNfe = situacaoNfe;
        return this;
    }

    public LocalDate getDataCancelamento() {
        return dataCancelamento;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setDataCancelamento(LocalDate dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
        return this;
    }

    public Long getNumeroGuia() {
        return numeroGuia;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setNumeroGuia(Long numeroGuia) {
        this.numeroGuia = numeroGuia;
        return this;
    }

    public LocalDate getDataPagamentoGuia() {
        return dataPagamentoGuia;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setDataPagamentoGuia(LocalDate dataPagamentoGuia) {
        this.dataPagamentoGuia = dataPagamentoGuia;
        return this;
    }

    public String getTomadorDocumento() {
        return tomadorDocumento;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setTomadorDocumento(String tomadorDocumento) {
        this.tomadorDocumento = tomadorDocumento;
        return this;
    }

    public String getTomadorRazaoSocial() {
        return tomadorRazaoSocial;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setTomadorRazaoSocial(String tomadorRazaoSocial) {
        this.tomadorRazaoSocial = tomadorRazaoSocial;
        return this;
    }

    public String getTomadorEnderecoLogradouro() {
        return tomadorEnderecoLogradouro;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setTomadorEnderecoLogradouro(String tomadorEnderecoLogradouro) {
        this.tomadorEnderecoLogradouro = tomadorEnderecoLogradouro;
        return this;
    }

    public String getTomadorEnderecoNumero() {
        return tomadorEnderecoNumero;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setTomadorEnderecoNumero(String tomadorEnderecoNumero) {
        this.tomadorEnderecoNumero = tomadorEnderecoNumero;
        return this;
    }

    public String getTomadorEnderecoComplemento() {
        return tomadorEnderecoComplemento;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setTomadorEnderecoComplemento(String tomadorEnderecoComplemento) {
        this.tomadorEnderecoComplemento = tomadorEnderecoComplemento;
        return this;
    }

    public String getTomadorEnderecoBairro() {
        return tomadorEnderecoBairro;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setTomadorEnderecoBairro(String tomadorEnderecoBairro) {
        this.tomadorEnderecoBairro = tomadorEnderecoBairro;
        return this;
    }

    public String getTomadorEnderecoCidade() {
        return tomadorEnderecoCidade;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setTomadorEnderecoCidade(String tomadorEnderecoCidade) {
        this.tomadorEnderecoCidade = tomadorEnderecoCidade;
        return this;
    }

    public String getTomadorEnderecoUF() {
        return tomadorEnderecoUF;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setTomadorEnderecoUF(String tomadorEnderecoUF) {
        this.tomadorEnderecoUF = tomadorEnderecoUF;
        return this;
    }

    public String getTomadorEnderecoCEP() {
        return tomadorEnderecoCEP;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setTomadorEnderecoCEP(String tomadorEnderecoCEP) {
        this.tomadorEnderecoCEP = tomadorEnderecoCEP;
        return this;
    }

    public String getTomadorEnderecoPais() {
        return tomadorEnderecoPais;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setTomadorEnderecoPais(String tomadorEnderecoPais) {
        this.tomadorEnderecoPais = tomadorEnderecoPais;
        return this;
    }

    public String getTomadorEmails() {
        return tomadorEmails;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setTomadorEmails(String tomadorEmails) {
        this.tomadorEmails = tomadorEmails;
        return this;
    }

    public String getDiscriminacaoServico() {
        return discriminacaoServico;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setDiscriminacaoServico(String discriminacaoServico) {
        this.discriminacaoServico = discriminacaoServico;
        return this;
    }

    public String getChaveAcessoNFSeNacional() {
        return chaveAcessoNFSeNacional;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setChaveAcessoNFSeNacional(String chaveAcessoNFSeNacional) {
        this.chaveAcessoNFSeNacional = chaveAcessoNFSeNacional;
        return this;
    }

    @Override
    public String getTipoRegistro() {
        return TIPO_REGISTRO;
    }

    @Override
    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 fromLinha(String linha) {
        return new NFSeBarueriRPSArquivoRetornoRegistroTipo2()
                .setSerieNFe(StringUtils.trimToEmpty(linha.substring(1, 5)))
                .setNumeroNFe(Long.parseLong(linha.substring(5, 12)))
                .setDataNFe(LocalDate.parse(linha.substring(12, 20), WSBarueri.FORMATO_DATA))
                .setHoraNFe(LocalTime.parse(linha.substring(20, 26), WSBarueri.FORMATO_HORA))
                .setCodigoAutenticidade(StringUtils.trimToEmpty(linha.substring(26, 50)))
                .setSerieRPS(StringUtils.trimToEmpty(linha.substring(50, 54)))
                .setNumeroRPS(StringUtils.trimToEmpty(linha.substring(54, 64)))
                .setTributacao(NFSeBarueriArquivoRetornoTipoTributacao.valueOfCodigo(Integer.parseInt(linha.substring(64, 65))))
                .setIssRetido(StringUtils.trimToEmpty(linha.substring(65, 66)).equalsIgnoreCase("S"))
                .setSituacaoNfe(NFSeBarueriArquivoRetornoSituacaoNFe.valueOfCodigo(linha.substring(66, 67)))
                .setDataCancelamento(StringUtils.isNotBlank(linha.substring(67, 75)) ? LocalDate.parse(linha.substring(67, 75), WSBarueri.FORMATO_DATA) : null)
                .setNumeroGuia(StringUtils.isNotBlank(linha.substring(75, 85)) ? Long.parseLong(linha.substring(75, 85)) : null)
                .setDataPagamentoGuia(StringUtils.isNotBlank(linha.substring(85, 93)) ? LocalDate.parse(linha.substring(85, 93), WSBarueri.FORMATO_DATA) : null)
                .setTomadorDocumento(StringUtils.trimToEmpty(linha.substring(93, 107)))
                .setTomadorRazaoSocial(StringUtils.trimToEmpty(linha.substring(107, 207)))
                .setTomadorEnderecoLogradouro(StringUtils.trimToEmpty(linha.substring(207, 307)))
                .setTomadorEnderecoNumero(StringUtils.trimToEmpty(linha.substring(307, 316)))
                .setTomadorEnderecoComplemento(StringUtils.trimToEmpty(linha.substring(316, 336)))
                .setTomadorEnderecoBairro(StringUtils.trimToEmpty(linha.substring(336, 376)))
                .setTomadorEnderecoCidade(StringUtils.trimToEmpty(linha.substring(376, 416)))
                .setTomadorEnderecoUF(StringUtils.trimToEmpty(linha.substring(416, 418)))
                .setTomadorEnderecoCEP(StringUtils.trimToEmpty(linha.substring(418, 426)))
                .setTomadorEnderecoPais(StringUtils.trimToEmpty(linha.substring(426, 476)))
                .setTomadorEmails(StringUtils.trimToEmpty(linha.substring(476, 628)))
                .setDiscriminacaoServico(StringUtils.trimToEmpty(linha.substring(628, 1628)))
                .setChaveAcessoNFSeNacional(StringUtils.trimToEmpty(linha.substring(1628, 1678)));
    }

    @Override
    public String toLinha() {
        return String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s",
                getTipoRegistro(),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.serieNFe), 4),
                StringUtils.leftPad(this.numeroNFe != null ? this.numeroNFe.toString() : "0", 7, '0'),
                this.dataNFe != null ? this.dataNFe.format(WSBarueri.FORMATO_DATA) : StringUtils.repeat(" ", 8),
                this.horaNFe != null ? this.horaNFe.format(WSBarueri.FORMATO_HORA) : StringUtils.repeat(" ", 6),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.codigoAutenticidade), 24),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.serieRPS), 4),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.numeroRPS), 10),
                StringUtils.rightPad(this.tributacao != null ? String.valueOf(this.tributacao.getCodigo()) : "0", 1),
                StringUtils.rightPad(this.issRetido != null && this.issRetido ? "S" : "N", 1),
                StringUtils.rightPad(this.situacaoNfe != null ? this.situacaoNfe.getCodigo() : "0", 1),
                this.dataCancelamento != null ? this.dataCancelamento.format(WSBarueri.FORMATO_DATA) : StringUtils.repeat(" ", 8),
                StringUtils.leftPad(this.numeroGuia != null ? this.numeroGuia.toString() : "0", 10, '0'),
                this.dataPagamentoGuia != null ? this.dataPagamentoGuia.format(WSBarueri.FORMATO_DATA) : StringUtils.repeat(" ", 8),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.tomadorDocumento), 14),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.tomadorRazaoSocial), 100),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.tomadorEnderecoLogradouro), 100),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.tomadorEnderecoNumero), 9),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.tomadorEnderecoComplemento), 20),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.tomadorEnderecoBairro), 40),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.tomadorEnderecoCidade), 40),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.tomadorEnderecoUF), 2),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.tomadorEnderecoCEP), 8),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.tomadorEnderecoPais), 50),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.tomadorEmails), 152),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.discriminacaoServico), 1000),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.chaveAcessoNFSeNacional), 50));
    }
}
