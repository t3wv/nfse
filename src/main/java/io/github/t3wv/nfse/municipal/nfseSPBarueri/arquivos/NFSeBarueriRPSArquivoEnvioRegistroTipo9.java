package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import java.math.BigDecimal;

public class NFSeBarueriRPSArquivoEnvioRegistroTipo9 extends NFSeBarueriRPSArquivoEnvioRegistro<NFSeBarueriRPSArquivoEnvioRegistroTipo9> {

    public static final String TIPO_REGISTRO = "9";

    private int quantidadeLinhas;
    private BigDecimal valorTotalServicos;
    private BigDecimal valorTotalServicosContidosRegistro3;

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

    public BigDecimal getValorTotalServicosContidosRegistro3() {
        return valorTotalServicosContidosRegistro3;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo9 setValorTotalServicosContidosRegistro3(BigDecimal valorTotalServicosContidosRegistro3) {
        this.valorTotalServicosContidosRegistro3 = valorTotalServicosContidosRegistro3;
        return this;
    }

    @Override
    public NFSeBarueriRPSArquivoEnvioRegistroTipo9 fromLinha(String linha) {
        return new NFSeBarueriRPSArquivoEnvioRegistroTipo9()
                .setQuantidadeLinhas(Integer.parseInt(linha.substring(1, 8).trim()))
                .setValorTotalServicos(new BigDecimal(linha.substring(8, 23)).movePointLeft(2))
                .setValorTotalServicosContidosRegistro3(new BigDecimal(linha.substring(23, 38)).movePointLeft(2))
                .setErros(parseErros(linha));
    }

    @Override
    public String toLinha() {
        return String.format("%s%s%s%s",
                getTipoRegistro(),
                trataString(this.quantidadeLinhas, 7),
                trataNumerico(this.valorTotalServicos, 15),
                trataNumerico(this.valorTotalServicosContidosRegistro3,15));
    }
}
