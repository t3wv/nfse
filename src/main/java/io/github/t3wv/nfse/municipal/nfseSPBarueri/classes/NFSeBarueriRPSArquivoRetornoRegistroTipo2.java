package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriRPSArquivoRetornoSituacaoNFe;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriRPSArquivoRetornoTipoTributacao;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static io.github.t3wv.nfse.municipal.nfseSPBarueri.classes.NFSeBarueriLoteBaixarArquivoResult.FORMATO_DATA;
import static io.github.t3wv.nfse.municipal.nfseSPBarueri.classes.NFSeBarueriLoteBaixarArquivoResult.FORMATO_DATA_HORA;


public class NFSeBarueriRPSArquivoRetornoRegistroTipo2 {

    private final int tipoRegistro;
    private final String serieNFe;
    private final long numeroNFe;
    private final LocalDateTime dataHoraNFe;
    private final String codigoAutenticidade;
    private final String serieRPS;
    private final NFSeBarueriRPSArquivoRetornoTipoTributacao tributacao;
    private final boolean issRetido;
    private final NFSeBarueriRPSArquivoRetornoSituacaoNFe situacaoNfe;
    private final LocalDate dataCancelamento;
    private final Long numeroGuia;
    private final LocalDate dataPagamentoGuia;
    private final String tomadorDocumento;
    private final String tomadorRazaoSocial;
    private final String tomadorEnderecoLogradouro;
    private final String tomadorEnderecoNumero;
    private final String tomadorEnderecoComplemento;
    private final String tomadorEnderecoBairro;
    private final String tomadorEnderecoCidade;
    private final String tomadorEnderecoUF;
    private final String tomadorEnderecoCEP;
    private final String tomadorEnderecoPais;
    private final List<String> tomadorEmails;
    private final String discriminacaoServico;
    private final String chaveAcessoNFSeNacional;
    private List<NFSeBarueriRPSArquivoRetornoRegistroTipo3> itens;

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2(String linha) {
        this.tipoRegistro = Integer.parseInt(linha.substring(0, 1).trim());
        this.serieNFe = linha.substring(1, 5).trim();
        this.numeroNFe = Long.parseLong(linha.substring(5, 12).trim());
        this.dataHoraNFe = LocalDateTime.parse(linha.substring(12, 26).trim(), FORMATO_DATA_HORA);
        this.codigoAutenticidade = linha.substring(26, 50).trim();
        this.serieRPS = linha.substring(50, 54).trim();
        this.tributacao = NFSeBarueriRPSArquivoRetornoTipoTributacao.valueOfCodigo(Integer.parseInt(linha.substring(64, 65).trim()));
        this.issRetido = linha.substring(65, 66).trim().equalsIgnoreCase("S");
        this.situacaoNfe = NFSeBarueriRPSArquivoRetornoSituacaoNFe.valueOfCodigo(linha.substring(66, 67).trim());
        this.dataCancelamento = StringUtils.isNotBlank(linha.substring(67, 75).trim()) ? LocalDate.parse(linha.substring(67, 75), FORMATO_DATA) : null;
        this.numeroGuia = StringUtils.isNotBlank(linha.substring(75, 85).trim()) ? Long.parseLong(linha.substring(75, 85).trim()) : null;
        this.dataPagamentoGuia = StringUtils.isNotBlank(linha.substring(85, 93).trim()) ? LocalDate.parse(linha.substring(85, 93), FORMATO_DATA) : null;
        this.tomadorDocumento = linha.substring(93, 107).trim();
        this.tomadorRazaoSocial = linha.substring(107, 207).trim();
        this.tomadorEnderecoLogradouro = linha.substring(207, 307).trim();
        this.tomadorEnderecoNumero = linha.substring(307, 316).trim();
        this.tomadorEnderecoComplemento = linha.substring(316, 336).trim();
        this.tomadorEnderecoBairro = linha.substring(336, 376).trim();
        this.tomadorEnderecoCidade = linha.substring(376, 416).trim();
        this.tomadorEnderecoUF = linha.substring(416, 418).trim();
        this.tomadorEnderecoCEP = linha.substring(418, 426).trim();
        this.tomadorEnderecoPais = linha.substring(426, 476).trim();
        this.tomadorEmails = StringUtils.isNotBlank(linha.substring(476, 628).trim()) ? List.of(linha.substring(476, 628).trim().split("\\|")) : null;
        this.discriminacaoServico = StringUtils.isNotBlank(linha.substring(628, 1628).trim()) ? linha.substring(628, 1628).trim().replaceAll("\\|", "") : null;
        this.chaveAcessoNFSeNacional = linha.substring(1628, 1678).trim();
    }

    public int getTipoRegistro() {
        return tipoRegistro;
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

    public NFSeBarueriRPSArquivoRetornoTipoTributacao getTributacao() {
        return tributacao;
    }

    public boolean isIssRetido() {
        return issRetido;
    }

    public NFSeBarueriRPSArquivoRetornoSituacaoNFe getSituacaoNfe() {
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

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 setItens(List<NFSeBarueriRPSArquivoRetornoRegistroTipo3> itens) {
        this.itens = itens;
        return this;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo2 addItem(NFSeBarueriRPSArquivoRetornoRegistroTipo3 nfSeBarueriRPSArquivoRetornoRegistroTipo3) {
        if(this.itens == null) {
            this.itens = new java.util.ArrayList<>();
        }
        this.itens.add(nfSeBarueriRPSArquivoRetornoRegistroTipo3);
        return this;
    }

    public List<NFSeBarueriRPSArquivoRetornoRegistroTipo3> getItens() {
        return this.itens;
    }
}
