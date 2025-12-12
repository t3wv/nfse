package io.github.t3wv.municipal.nfseSPBarueri.classes;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public class NFSeBarueriRPSArquivoRegistroTipo9 {
    static final String TIPO_REGISTRO = "9";

    private final int quantidadeLinhas;
    private final BigDecimal valorTotalServico;
    private final BigDecimal valorTotalNaoIncluidoBasecalculoISS;

    NFSeBarueriRPSArquivoRegistroTipo9(final int quantidadeLinhas, final BigDecimal valorTotalServico, final BigDecimal valorTotalNaoIncluidoBasecalculoISS) {
        this.quantidadeLinhas = quantidadeLinhas;
        this.valorTotalServico = valorTotalServico;
        this.valorTotalNaoIncluidoBasecalculoISS = valorTotalNaoIncluidoBasecalculoISS;
    }

    public String getLinha() {
        return String.format("%s%s%s%s", TIPO_REGISTRO, StringUtils.rightPad(String.valueOf(this.quantidadeLinhas), 7), StringUtils.leftPad(this.valorTotalServico.toPlainString().replaceAll("[^0-9]", ""), 15, "0"), StringUtils.leftPad(this.valorTotalNaoIncluidoBasecalculoISS.toPlainString().replaceAll("[^0-9]", ""), 15, "0"));
    }
}
