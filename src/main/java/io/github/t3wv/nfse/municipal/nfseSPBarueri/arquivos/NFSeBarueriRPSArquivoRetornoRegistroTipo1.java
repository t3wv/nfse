package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.WSBarueri;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;


public class NFSeBarueriRPSArquivoRetornoRegistroTipo1 extends NFSeBarueriRPSArquivoRetornoRegistro<NFSeBarueriRPSArquivoRetornoRegistroTipo1> {

    public static final String TIPO_REGISTRO = "1";

    private String inscricaoContribuinte;
    private LocalDate inicioTransferencia;
    private LocalDate terminoTransferencia;
    private String versaoLayout;
    private String identificacaoRemessa;

    public String getInscricaoContribuinte() {
        return inscricaoContribuinte;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo1 setInscricaoContribuinte(String inscricaoContribuinte) {
        this.inscricaoContribuinte = inscricaoContribuinte;
        return this;
    }

    public LocalDate getInicioTransferencia() {
        return inicioTransferencia;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo1 setInicioTransferencia(LocalDate inicioTransferencia) {
        this.inicioTransferencia = inicioTransferencia;
        return this;
    }

    public LocalDate getTerminoTransferencia() {
        return terminoTransferencia;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo1 setTerminoTransferencia(LocalDate terminoTransferencia) {
        this.terminoTransferencia = terminoTransferencia;
        return this;
    }

    public String getVersaoLayout() {
        return versaoLayout;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo1 setVersaoLayout(String versaoLayout) {
        this.versaoLayout = versaoLayout;
        return this;
    }

    public String getIdentificacaoRemessa() {
        return identificacaoRemessa;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo1 setIdentificacaoRemessa(String identificacaoRemessa) {
        this.identificacaoRemessa = identificacaoRemessa;
        return this;
    }


    @Override
    public String getTipoRegistro() {
        return TIPO_REGISTRO;
    }

    @Override
    public NFSeBarueriRPSArquivoRetornoRegistroTipo1 fromLinha(String linha) {
        return new NFSeBarueriRPSArquivoRetornoRegistroTipo1()
                .setInscricaoContribuinte(StringUtils.trimToEmpty(linha.substring(1, 8)))
                .setInicioTransferencia(StringUtils.isNotBlank(StringUtils.stripStart(linha.substring(8, 16).trim(), "0")) ? LocalDate.parse(linha.substring(8, 16).trim(), WSBarueri.FORMATO_DATA) : null)
                .setTerminoTransferencia(StringUtils.isNotBlank(StringUtils.stripStart(linha.substring(16, 24).trim(), "0")) ? LocalDate.parse(linha.substring(16, 24).trim(), WSBarueri.FORMATO_DATA) : null)
                .setVersaoLayout(StringUtils.trimToEmpty(linha.substring(24, 30)))
                .setIdentificacaoRemessa(StringUtils.trimToEmpty(linha.substring(30, 41)));
    }

    @Override
    public String toLinha() {
        return String.format("%s%s%s%s%s%s",
                getTipoRegistro(),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.inscricaoContribuinte), 7),
                this.inicioTransferencia != null ? this.inicioTransferencia.format(WSBarueri.FORMATO_DATA) : StringUtils.repeat("0", 8),
                this.terminoTransferencia != null ? this.terminoTransferencia.format(WSBarueri.FORMATO_DATA) : StringUtils.repeat("0", 8),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.versaoLayout), 6),
                StringUtils.rightPad(StringUtils.trimToEmpty(this.identificacaoRemessa), 11));
    }
}
