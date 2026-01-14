package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

import static io.github.t3wv.nfse.municipal.nfseSPBarueri.classes.NFSeBarueriLoteBaixarArquivoResult.FORMATO_DATA;

public class NFSeBarueriRPSArquivoRetornoRegistroTipo1 {

    private final int tipoRegistro;
    private final String inscricaoContribuinte;
    private final LocalDate inicioTransferencia;
    private final LocalDate terminoTransferencia;
    private final String versaoLayout;
    private final long identificacaoRemessa;

    public NFSeBarueriRPSArquivoRetornoRegistroTipo1(String linha) {
        this.tipoRegistro = Integer.parseInt(linha.substring(0, 1).trim());
        this.inscricaoContribuinte = linha.substring(1, 8).trim();
        this.inicioTransferencia = StringUtils.isNotBlank(StringUtils.stripStart(linha.substring(8, 16).trim(), "0")) ? LocalDate.parse(linha.substring(8, 16).trim(), FORMATO_DATA) : null;
        this.terminoTransferencia = StringUtils.isNotBlank(StringUtils.stripStart(linha.substring(16, 24).trim(), "0")) ? LocalDate.parse(linha.substring(16, 24).trim(), FORMATO_DATA) : null;
        this.versaoLayout = linha.substring(24, 29).trim();
        this.identificacaoRemessa = Long.parseLong(linha.substring(30, 40).trim());
    }

    public int getTipoRegistro() {
        return tipoRegistro;
    }

    public String getInscricaoContribuinte() {
        return inscricaoContribuinte;
    }

    public LocalDate getInicioTransferencia() {
        return inicioTransferencia;
    }

    public LocalDate getTerminoTransferencia() {
        return terminoTransferencia;
    }

    public String getVersaoLayout() {
        return versaoLayout;
    }

    public long getIdentificacaoRemessa() {
        return identificacaoRemessa;
    }
}
