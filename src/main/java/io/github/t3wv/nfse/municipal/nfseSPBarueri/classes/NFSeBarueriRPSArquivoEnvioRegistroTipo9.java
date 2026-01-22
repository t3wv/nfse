package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NFSeBarueriRPSArquivoEnvioRegistroTipo9 extends NFSeBarueriRPSArquivoEnvioRegistro<NFSeBarueriRPSArquivoEnvioRegistroTipo9> {

    static final String TIPO_REGISTRO = "9";
    private int quantidadeLinhas;
    private BigDecimal valorTotalServicos;
    private BigDecimal valorTotalServicsContidosRegistro3;

    @Override
    public String getTipoRegistro() {
        return TIPO_REGISTRO;
    }

    public int getQuantidadeLinhas() {
        return quantidadeLinhas;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo9 setQuantidadeLinhas(int quantidadeLinhas) {
        this.quantidadeLinhas = quantidadeLinhas;
        return this;
    }

    public BigDecimal getValorTotalServicos() {
        return valorTotalServicos;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo9 setValorTotalServicos(BigDecimal valorTotalServicos) {
        this.valorTotalServicos = valorTotalServicos;
        return this;
    }

    public BigDecimal getValorTotalServicsContidosRegistro3() {
        return valorTotalServicsContidosRegistro3;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo9 setValorTotalServicsContidosRegistro3(BigDecimal valorTotalServicsContidosRegistro3) {
        this.valorTotalServicsContidosRegistro3 = valorTotalServicsContidosRegistro3;
        return this;
    }

    @Override
    public String toLinha() {
        return String.format("%s%s%s%s",
                getTipoRegistro(),
                StringUtils.rightPad(String.valueOf(this.quantidadeLinhas), 7),
                StringUtils.leftPad(this.valorTotalServicos.setScale(2, RoundingMode.HALF_UP).toPlainString().replaceAll("[^0-9]", ""), 15, "0"),
                StringUtils.leftPad(this.valorTotalServicsContidosRegistro3.setScale(2, RoundingMode.HALF_UP).toPlainString().replaceAll("[^0-9]", ""), 15, "0"));
    }

    @Override
    public NFSeBarueriRPSArquivoEnvioRegistroTipo9 fromLinha(String linha) {
        return new NFSeBarueriRPSArquivoEnvioRegistroTipo9()
                .setQuantidadeLinhas(Integer.parseInt(linha.substring(1,8).trim()))
                .setValorTotalServicos(new BigDecimal(linha.substring(8,23)).movePointLeft(2))
                .setValorTotalServicsContidosRegistro3(new BigDecimal(linha.substring(23,38)).movePointLeft(2));
    }
}
