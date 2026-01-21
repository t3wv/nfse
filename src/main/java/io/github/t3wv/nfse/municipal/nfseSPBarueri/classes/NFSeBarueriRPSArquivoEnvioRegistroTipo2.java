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
        return StringUtils.rightPad(this.rps.getRpsSerie(), 4);
    }

    private String getNFSerie() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getNotaSerie()), 5);
    }

    private String getRPSNumero() {
        return StringUtils.leftPad(this.rps.getRpsNumero(), 10, "0");
    }

    private String getRPSDataEmissao() {
        return this.rps.getRpsDataEmissao() != null ?
                this.rps.getRpsDataEmissao().format(DateTimeFormatter.ofPattern("yyyyMMdd")) :
                "";
    }

    private String getRPSHoraEmissao() {
        return this.rps.getRpsHoraEmissao() != null ?
                new DateTimeFormatterBuilder().appendPattern("HHmmss").toFormatter().format(this.rps.getRpsHoraEmissao()) :
                "";
    }

    private String getRPSSituacao() {
        return this.rps.getRpsSituacao().getCodigo();
    }

    private String getRPSMotivoCancelamento() {
        return StringUtils.rightPad(this.rps.getMotivoCancelamento() != null ? this.rps.getMotivoCancelamento().getCodigo() : "", 2);
    }

    private String getNFSubstituidaNumero() {
        return StringUtils.leftPad(StringUtils.trimToEmpty(this.rps.getNotaSubstituidaNumero()), 7, "0");
    }

    private String getNFSubstituidaSerie() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getNotaSubstituidaSerie()), 5);
    }

    private String getNFSubstituidaDataEmissao() {
        return StringUtils.rightPad(this.rps.getNotaSubstituidaDataEmissao() != null ? this.rps.getNotaSubstituidaDataEmissao().format(DateTimeFormatter.ofPattern("yyyyMMdd")) : "", 8);
    }

    private String getNFSubstituidaDescricaoCancelamento() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getNotaSubstituidaDescricaoCancelamento()), 180);
    }

    private String getRPSCodigoServicoPrestado() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getCodigoServicoPrestado()), 9);
    }

    private String getRPSLocalPrestacaoServico() {
        return this.rps.getLocalPrestacaoServico() != null ? this.rps.getLocalPrestacaoServico().getCodigo() : "";
    }

    private String getRPSServicoPrestadoEmViaPublica() {
        return this.rps.getServicoPrestadoEmViasPublicas() != null ? this.rps.getServicoPrestadoEmViasPublicas().getCodigo() : "";
    }

    private String getRPSEnderecoServicoPrestado() {
        return StringUtils.rightPad(this.rps.getEnderecoServicoPrestado(), 75);
    }

    private String getRPSEnderecoServicoPrestadoNumero() {
        return StringUtils.rightPad(this.rps.getEnderecoServicoPrestadoNumero(), 9);
    }

    private String getRPSEnderecoServicoPrestadoComplemento() {
        return StringUtils.rightPad(this.rps.getEnderecoServicoPrestadoComplemento(), 30);
    }

    private String getRPSEnderecoServicoPrestadoBairro() {
        return StringUtils.rightPad(this.rps.getEnderecoServicoPrestadoBairro(), 40);
    }

    private String getRPSEnderecoServicoPrestadoCidade() {
        return StringUtils.rightPad(this.rps.getEnderecoServicoPrestadoCidade(), 40);
    }

    private String getRPSEnderecoServicoPrestadoUF() {
        return StringUtils.rightPad(this.rps.getEnderecoServicoPrestadoUF(), 2);
    }

    private String getRPSEnderecoServicoPrestadoCEP() {
        return StringUtils.rightPad(this.rps.getEnderecoServicoPrestadoCodigoPostal(), 8);
    }

    private String getRPSQuantidadeServicoPrestado() {
        return StringUtils.leftPad(this.rps.getQuantidadeServicoPrestado(), 6, "0");
    }

    private String getRPSValorServico() {
        return StringUtils.leftPad(this.rps.getValorServico() != null ? this.rps.getValorServico().toPlainString().replaceAll("[^0-9]", "") : "", 15, "0");
    }

    private String getCampoReservado() {
        return StringUtils.rightPad("", 5);
    }

    private String getRPSValorRetencoes() {
        return StringUtils.leftPad(this.rps.getValorRetencoes() != null ? this.rps.getValorRetencoes().toPlainString().replaceAll("[^0-9]", "") : "", 15, "0");
    }

    private String getRPSTomadorTipo() {
        return this.rps.getTomadorTipo() != null ? this.rps.getTomadorTipo().getCodigo() : "";
    }

    private String getRPSTomadorEstrangeiroCodigoPais() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getPaisTomadorEstrangeiro() != null ? this.rps.getPaisTomadorEstrangeiro().getCodigo() : ""), 3, "0");
    }

    private String getRPSServicoExportacao() {
        return this.rps.getServicoExportacao() != null ? this.rps.getServicoExportacao().getCodigo() : "";
    }

    private String getRPSTomadorDocumentoTipo() {
        return NFSeUtils.isCpfValido(this.rps.getTomadorDocumento()) ? "1" : NFSeUtils.isCnpjValido(this.rps.getTomadorDocumento()) ? "2" : " ";
    }

    private String getRPSTomadorDocumento() {
        return StringUtils.leftPad(StringUtils.trimToEmpty(this.rps.getTomadorDocumento()), 14, "0");
    }

    private String getRPSTomadorRazaoSocial() {
        return StringUtils.rightPad(this.rps.getTomadorRazaoSocial(), 60);
    }

    private String getRPSTomadorEndereco() {
        return StringUtils.rightPad(this.rps.getTomadorEndereco(), 75);
    }

    private String getRPSTomadorEnderecoNumero() {
        return StringUtils.rightPad(this.rps.getTomadorEnderecoNumero(), 9);
    }

    private String getRPSTomadorEnderecoComplemento() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getTomadorEnderecoComplemento()), 30);
    }

    private String getRPSTomadorEnderecoBairro() {
        return StringUtils.rightPad(this.rps.getTomadorEnderecoBairro(), 40);
    }

    private String getRPSTomadorEnderecoCidade() {
        return StringUtils.rightPad(this.rps.getTomadorEnderecoCidade(), 40);
    }

    private String getRPSTomadorEnderecoUF() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getTomadorEnderecoUF()), 2);
    }

    private String getRPSTomadorEnderecoCep() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getTomadorEnderecoCodigoPostal()), 8);
    }

    private String getRPSTomadorEmail() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getTomadorEmail()), 152);
    }

    private String getRPSFaturaNumero() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getFaturaNumero()), 6);
    }

    private String getRPSFaturaValor() {
        if (StringUtils.isNotBlank(this.rps.getFaturaNumero())) {
            return StringUtils.leftPad(this.rps.getFaturaValor().setScale(2, RoundingMode.HALF_UP).toPlainString().replaceAll("[^0-9]", ""), 15, "0");
        } else {
            return StringUtils.rightPad("", 15);
        }
    }

    private String getRPSFaturaFormaPagamento() {
        return StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getFaturaFormaPagamento()), 15);
    }

    private String getRPSDiscriminacaoServicos() {
        return StringUtils.rightPad(this.rps.getDiscriminacaoServicos(), 1000);
    }

}
