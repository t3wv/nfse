package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

import io.github.t3wv.nfse.utils.NFSeUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class NFSeBarueriRPSArquivoEnvioRegistroTipo2 {
    static final String TIPO_REGISTRO_BODY = "2";
    static final String TIPO_RPS = "RPS  ";
    private final NFSeBarueriRPS rps;

    public NFSeBarueriRPSArquivoEnvioRegistroTipo2(NFSeBarueriRPS rps) {
        this.rps = rps;
    }

    public String getLinha() {
        final StringBuilder linha = new StringBuilder();
        linha.append(TIPO_REGISTRO_BODY);
        linha.append(TIPO_RPS);
        linha.append(this.getRPSSerie());
        linha.append(this.getNFSerie());
        linha.append(this.getRPSNumero());
        linha.append(this.getRPSDataEmissao());
        linha.append(this.getRPSHoraEmissao());
        linha.append(this.getRPSSituacao());
        linha.append(this.getRPSMotivoCancelamento());
        linha.append(this.getNFSubstituidaNumero());
        linha.append(this.getNFSubstituidaSerie());
        linha.append(this.getNFSubstituidaDataEmissao());
        linha.append(this.getNFSubstituidaDescricaoCancelamento());
        linha.append(this.getRPSCodigoServicoPrestado());
        linha.append(this.getRPSLocalPrestacaoServico());
        linha.append(this.getRPSServicoPrestadoEmViaPublica());
        linha.append(this.getRPSEnderecoServicoPrestado());
        linha.append(this.getRPSEnderecoServicoPrestadoNumero());
        linha.append(this.getRPSEnderecoServicoPrestadoComplemento());
        linha.append(this.getRPSEnderecoServicoPrestadoBairro());
        linha.append(this.getRPSEnderecoServicoPrestadoCidade());
        linha.append(this.getRPSEnderecoServicoPrestadoUF());
        linha.append(this.getRPSEnderecoServicoPrestadoCEP());
        linha.append(this.getRPSQuantidadeServicoPrestado());
        linha.append(this.getRPSValorServico());
        linha.append(this.getCampoReservado());
        linha.append(this.getRPSValorRetencoes());
        linha.append(this.getRPSTomadorTipo());
        linha.append(this.getRPSTomadorEstrangeiroCodigoPais());
        linha.append(this.getRPSServicoExportacao());
        linha.append(this.getRPSTomadorDocumentoTipo());
        linha.append(this.getRPSTomadorDocumento());
        linha.append(this.getRPSTomadorRazaoSocial());
        linha.append(this.getRPSTomadorEndereco());
        linha.append(this.getRPSTomadorEnderecoNumero());
        linha.append(this.getRPSTomadorEnderecoComplemento());
        linha.append(this.getRPSTomadorEnderecoBairro());
        linha.append(this.getRPSTomadorEnderecoCidade());
        linha.append(this.getRPSTomadorEnderecoUF());
        linha.append(this.getRPSTomadorEnderecoCep());
        linha.append(this.getRPSTomadorEmail());
        linha.append(this.getRPSFaturaNumero());
        linha.append(this.getRPSFaturaValor());
        linha.append(this.getRPSFaturaFormaPagamento());
        linha.append(this.getRPSDiscriminacaoServicos());
        return linha.toString();
    }

    private String getRPSSerie() {
        return StringUtils.rightPad(this.rps.getRPSSerie(), 4);
    }

    private String getNFSerie() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getNFSerie()), 5);
    }

    private String getRPSNumero() {
        return StringUtils.leftPad(this.rps.getRPSNumero(), 10, "0");
    }

    private String getRPSDataEmissao() {
        return this.rps.getRPSDataEmissao() != null ?
                this.rps.getRPSDataEmissao().format(DateTimeFormatter.ofPattern("yyyyMMdd")) :
                "";
    }

    private String getRPSHoraEmissao() {
        return this.rps.getRPSHoraEmissao() != null ?
                new DateTimeFormatterBuilder().appendPattern("HHmmss").toFormatter().format(this.rps.getRPSHoraEmissao()) :
                "";
    }

    private String getRPSSituacao() {
        return this.rps.getRPSSituacao().getCodigo();
    }

    private String getRPSMotivoCancelamento() {
        return StringUtils.rightPad(this.rps.getRPSMotivoCancelamento() != null ? this.rps.getRPSMotivoCancelamento().getCodigo() : "", 2);
    }

    private String getNFSubstituidaNumero() {
        return StringUtils.leftPad(StringUtils.trimToEmpty(this.rps.getNFSubstituidaNumero()), 7, "0");
    }

    private String getNFSubstituidaSerie() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getNFSubstituidaSerie()), 5);
    }

    private String getNFSubstituidaDataEmissao() {
        return StringUtils.rightPad(this.rps.getNFSubstituidaDataEmissao() != null ? this.rps.getNFSubstituidaDataEmissao().format(DateTimeFormatter.ofPattern("yyyyMMdd")) : "", 8);
    }

    private String getNFSubstituidaDescricaoCancelamento() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getNFSubstituidaDescricaoCancelamento()), 180);
    }

    private String getRPSCodigoServicoPrestado() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getRPSCodigoServicoPrestado()), 9);
    }

    private String getRPSLocalPrestacaoServico() {
        return this.rps.getRPSLocalPrestacaoServico() != null ? this.rps.getRPSLocalPrestacaoServico().getCodigo() : "";
    }

    private String getRPSServicoPrestadoEmViaPublica() {
        return this.rps.getRPSServicoPrestadoEmViasPublicas() != null ? this.rps.getRPSServicoPrestadoEmViasPublicas().getCodigo() : "";
    }

    private String getRPSEnderecoServicoPrestado() {
        return StringUtils.rightPad(this.rps.getRPSEnderecoServicoPrestado(), 75);
    }

    private String getRPSEnderecoServicoPrestadoNumero() {
        return StringUtils.rightPad(this.rps.getRPSEnderecoServicoPrestadoNumero(), 9);
    }

    private String getRPSEnderecoServicoPrestadoComplemento() {
        return StringUtils.rightPad(this.rps.getRPSEnderecoServicoPrestadoComplemento(), 30);
    }

    private String getRPSEnderecoServicoPrestadoBairro() {
        return StringUtils.rightPad(this.rps.getRPSEnderecoServicoPrestadoBairro(), 40);
    }

    private String getRPSEnderecoServicoPrestadoCidade() {
        return StringUtils.rightPad(this.rps.getRPSEnderecoServicoPrestadoCidade(), 40);
    }

    private String getRPSEnderecoServicoPrestadoUF() {
        return StringUtils.rightPad(this.rps.getRPSEnderecoServicoPrestadoUF(), 2);
    }

    private String getRPSEnderecoServicoPrestadoCEP() {
        return StringUtils.rightPad(this.rps.getRPSEnderecoServicoPrestadoCodigoPostal(), 8);
    }

    private String getRPSQuantidadeServicoPrestado() {
        return StringUtils.leftPad(this.rps.getRPSQuantidadeServicoPrestado(), 6, "0");
    }

    private String getRPSValorServico() {
        return StringUtils.leftPad(this.rps.getRPSValorServico() != null ? this.rps.getRPSValorServico().toPlainString().replaceAll("[^0-9]", "") : "", 15, "0");
    }

    private String getCampoReservado() {
        return StringUtils.rightPad("", 5);
    }

    private String getRPSValorRetencoes() {
        return StringUtils.leftPad(this.rps.getRPSValorRetencoes() != null ? this.rps.getRPSValorRetencoes().toPlainString().replaceAll("[^0-9]", "") : "", 15, "0");
    }

    private String getRPSTomadorTipo() {
        return this.rps.getRPSTomadorTipo() != null ? this.rps.getRPSTomadorTipo().getCodigo() : "";
    }

    private String getRPSTomadorEstrangeiroCodigoPais() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getRPSCodigoPaisTomadorEstrangeiro()), 3, "0");
    }

    private String getRPSServicoExportacao() {
        return this.rps.getRPSServicoExportacao() != null ? this.rps.getRPSServicoExportacao().getCodigo() : "";
    }

    private String getRPSTomadorDocumentoTipo() {
        return NFSeUtils.isCpfValido(this.rps.getRPSTomadorDocumento()) ? "1" : NFSeUtils.isCnpjValido(this.rps.getRPSTomadorDocumento()) ? "2" : " ";
    }

    private String getRPSTomadorDocumento() {
        return StringUtils.leftPad(StringUtils.trimToEmpty(this.rps.getRPSTomadorDocumento()), 14, "0");
    }

    private String getRPSTomadorRazaoSocial() {
        return StringUtils.rightPad(this.rps.getRPSTomadorRazaoSocial(), 60);
    }

    private String getRPSTomadorEndereco() {
        return StringUtils.rightPad(this.rps.getRPSTomadorEndereco(), 75);
    }

    private String getRPSTomadorEnderecoNumero() {
        return StringUtils.rightPad(this.rps.getRPSTomadorEnderecoNumero(), 9);
    }

    private String getRPSTomadorEnderecoComplemento() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getRPSTomadorEnderecoComplemento()), 30);
    }

    private String getRPSTomadorEnderecoBairro() {
        return StringUtils.rightPad(this.rps.getRPSTomadorEnderecoBairro(), 40);
    }

    private String getRPSTomadorEnderecoCidade() {
        return StringUtils.rightPad(this.rps.getRPSTomadorEnderecoCidade(), 40);
    }

    private String getRPSTomadorEnderecoUF() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getRPSTomadorEnderecoUF()), 2);
    }

    private String getRPSTomadorEnderecoCep() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getRPSTomadorEnderecoCodigoPostal()), 8);
    }

    private String getRPSTomadorEmail() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getRPSTomadorEmail()), 152);
    }

    private String getRPSFaturaNumero() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getRPSFaturaNumero()), 6);
    }

    private String getRPSFaturaValor() {
        if (StringUtils.isNotBlank(this.rps.getRPSFaturaNumero())) {
            return StringUtils.leftPad(this.rps.getRPSFaturaValor().setScale(2, RoundingMode.HALF_UP).toPlainString().replaceAll("[^0-9]", ""), 15, "0");
        } else {
            return StringUtils.rightPad("", 15);
        }
    }

    private String getRPSFaturaFormaPagamento() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getRPSFaturaFormaPagamento()), 15);
    }

    private String getRPSDiscriminacaoServicos() {
        return StringUtils.rightPad(this.rps.getRPSDiscriminacaoServicos(), 1000);
    }

}
