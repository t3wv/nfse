package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriArquivoRetornoSituacaoNFe;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriArquivoRetornoTipoTributacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public class NFSeBarueriRPSArquivoRetornoRegistroTipo2 extends NFSeBarueriRPSArquivoRetornoRegistro<NFSeBarueriRPSArquivoRetornoRegistroTipo2> {

    static final String TIPO_REGISTRO = "2";
    private int tipoRegistro;
    private String serieNFe;
    private long numeroNFe;
    private LocalDateTime dataHoraNFe;
    private String codigoAutenticidade;
    private String serieRPS;
    private NFSeBarueriArquivoRetornoTipoTributacao tributacao;
    private boolean issRetido;
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
    private List<String> tomadorEmails;
    private String discriminacaoServico;
    private String chaveAcessoNFSeNacional;

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2() {
//        this.serieNFe = linha.substring(1, 5).trim();
//        this.numeroNFe = Long.parseLong(linha.substring(5, 12).trim());
//        this.dataHoraNFe = LocalDateTime.parse(linha.substring(12, 26).trim(), FORMATO_DATA_HORA);
//        this.codigoAutenticidade = linha.substring(26, 50).trim();
//        this.serieRPS = linha.substring(50, 54).trim();
//        this.tributacao = NFSeBarueriArquivoRetornoTipoTributacao.valueOfCodigo(Integer.parseInt(linha.substring(64, 65).trim()));
//        this.issRetido = linha.substring(65, 66).trim().equalsIgnoreCase("S");
//        this.situacaoNfe = NFSeBarueriArquivoRetornoSituacaoNFe.valueOfCodigo(linha.substring(66, 67).trim());
//        this.dataCancelamento = StringUtils.isNotBlank(linha.substring(67, 75).trim()) ? LocalDate.parse(linha.substring(67, 75), FORMATO_DATA) : null;
//        this.numeroGuia = StringUtils.isNotBlank(linha.substring(75, 85).trim()) ? Long.parseLong(linha.substring(75, 85).trim()) : null;
//        this.dataPagamentoGuia = StringUtils.isNotBlank(linha.substring(85, 93).trim()) ? LocalDate.parse(linha.substring(85, 93), FORMATO_DATA) : null;
//        this.tomadorDocumento = linha.substring(93, 107).trim();
//        this.tomadorRazaoSocial = linha.substring(107, 207).trim();
//        this.tomadorEnderecoLogradouro = linha.substring(207, 307).trim();
//        this.tomadorEnderecoNumero = linha.substring(307, 316).trim();
//        this.tomadorEnderecoComplemento = linha.substring(316, 336).trim();
//        this.tomadorEnderecoBairro = linha.substring(336, 376).trim();
//        this.tomadorEnderecoCidade = linha.substring(376, 416).trim();
//        this.tomadorEnderecoUF = linha.substring(416, 418).trim();
//        this.tomadorEnderecoCEP = linha.substring(418, 426).trim();
//        this.tomadorEnderecoPais = linha.substring(426, 476).trim();
//        this.tomadorEmails = StringUtils.isNotBlank(linha.substring(476, 628).trim()) ? List.of(linha.substring(476, 628).trim().split("\\|")) : null;
//        this.discriminacaoServico = StringUtils.isNotBlank(linha.substring(628, 1628).trim()) ? linha.substring(628, 1628).trim().replaceAll("\\|", "") : null;
//        this.chaveAcessoNFSeNacional = linha.substring(1628, 1678).trim();
    }

    public String getSerieNFe() {
        return serieNFe;
    }

    public long getNumeroNFe() {
        return numeroNFe;
    }

    public LocalDateTime getDataHoraNFe() {
        return dataHoraNFe;
    }

    public String getSerieRPS() {
        return serieRPS;
    }

    public String getCodigoAutenticidade() {
        return codigoAutenticidade;
    }

    public NFSeBarueriArquivoRetornoTipoTributacao getTributacao() {
        return tributacao;
    }

    public boolean isIssRetido() {
        return issRetido;
    }

    public NFSeBarueriArquivoRetornoSituacaoNFe getSituacaoNfe() {
        return situacaoNfe;
    }

    public LocalDate getDataCancelamento() {
        return dataCancelamento;
    }

    public Long getNumeroGuia() {
        return numeroGuia;
    }

    public LocalDate getDataPagamentoGuia() {
        return dataPagamentoGuia;
    }

    public String getTomadorDocumento() {
        return tomadorDocumento;
    }

    public String getTomadorRazaoSocial() {
        return tomadorRazaoSocial;
    }

    public String getTomadorEnderecoLogradouro() {
        return tomadorEnderecoLogradouro;
    }

    public String getTomadorEnderecoNumero() {
        return tomadorEnderecoNumero;
    }

    public String getTomadorEnderecoComplemento() {
        return tomadorEnderecoComplemento;
    }

    public String getTomadorEnderecoBairro() {
        return tomadorEnderecoBairro;
    }

    public String getTomadorEnderecoCidade() {
        return tomadorEnderecoCidade;
    }

    public String getTomadorEnderecoUF() {
        return tomadorEnderecoUF;
    }

    public String getTomadorEnderecoCEP() {
        return tomadorEnderecoCEP;
    }

    public String getTomadorEnderecoPais() {
        return tomadorEnderecoPais;
    }

    public List<String> getTomadorEmails() {
        return tomadorEmails;
    }

    public String getDiscriminacaoServico() {
        return discriminacaoServico;
    }

    public String getChaveAcessoNFSeNacional() {
        return chaveAcessoNFSeNacional;
    }


    @Override
    public String getTipoRegistro() {
        return TIPO_REGISTRO;
    }

    @Override
    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 fromLinha(String linha) {
        return null;
    }

    @Override
    public String toLinha() {
        return "";
    }
}
