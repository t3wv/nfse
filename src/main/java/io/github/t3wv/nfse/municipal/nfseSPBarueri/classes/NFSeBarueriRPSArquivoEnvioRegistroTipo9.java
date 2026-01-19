package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NFSeBarueriRPSArquivoEnvioRegistroTipo9 {
    static final String TIPO_REGISTRO = "9";

    private final int quantidadeLinhas;
    private final BigDecimal valorTotalServico;
    private final BigDecimal valorTotalNaoIncluidoBasecalculoISS;

    NFSeBarueriRPSArquivoEnvioRegistroTipo9(final int quantidadeLinhas, final BigDecimal valorTotalServico, final BigDecimal valorTotalNaoIncluidoBasecalculoISS) {
        this.quantidadeLinhas = quantidadeLinhas;
        this.valorTotalServico = valorTotalServico;
        this.valorTotalNaoIncluidoBasecalculoISS = valorTotalNaoIncluidoBasecalculoISS;
    }

    public String getLinha() {
        return String.format("%s%s%s%s", TIPO_REGISTRO, StringUtils.rightPad(String.valueOf(this.quantidadeLinhas), 7), StringUtils.leftPad(this.valorTotalServico.setScale(2, RoundingMode.HALF_UP).toPlainString().replaceAll("[^0-9]", ""), 15, "0"), StringUtils.leftPad(this.valorTotalNaoIncluidoBasecalculoISS.setScale(2, RoundingMode.HALF_UP).toPlainString().replaceAll("[^0-9]", ""), 15, "0"));
    }
}
