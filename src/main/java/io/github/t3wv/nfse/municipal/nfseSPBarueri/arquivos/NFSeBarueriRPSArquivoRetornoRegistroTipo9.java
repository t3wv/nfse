package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import java.math.BigDecimal;

public class NFSeBarueriRPSArquivoRetornoRegistroTipo9 extends NFSeBarueriRPSArquivoRetornoRegistro<NFSeBarueriRPSArquivoRetornoRegistroTipo9> {

    public static final String TIPO_REGISTRO = "9";

    private Integer numeroTotalLinhasArquivo;
    private BigDecimal valorTotalServicosArquivo;
    private BigDecimal valorTotalRetencoesContidosNoRegistro4;

    public Integer getNumeroTotalLinhasArquivo() {
        return numeroTotalLinhasArquivo;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo9 setNumeroTotalLinhasArquivo(Integer numeroTotalLinhasArquivo) {
        this.numeroTotalLinhasArquivo = numeroTotalLinhasArquivo;
        return this;
    }

    public BigDecimal getValorTotalServicosArquivo() {
        return valorTotalServicosArquivo;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo9 setValorTotalServicosArquivo(BigDecimal valorTotalServicosArquivo) {
        this.valorTotalServicosArquivo = valorTotalServicosArquivo;
        return this;
    }

    public BigDecimal getValorTotalRetencoesContidosNoRegistro4() {
        return valorTotalRetencoesContidosNoRegistro4;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo9 setValorTotalRetencoesContidosNoRegistro4(BigDecimal valorTotalRetencoesContidosNoRegistro4) {
        this.valorTotalRetencoesContidosNoRegistro4 = valorTotalRetencoesContidosNoRegistro4;
        return this;
    }

    @Override
    public String getTipoRegistro() {
        return TIPO_REGISTRO;
    }

    @Override
    public NFSeBarueriRPSArquivoRetornoRegistroTipo9 fromLinha(String linha) {
        return new NFSeBarueriRPSArquivoRetornoRegistroTipo9()
                .setNumeroTotalLinhasArquivo(Integer.parseInt(linha.substring(1, 8)))
                .setValorTotalServicosArquivo(new BigDecimal(linha.substring(8, 23)).movePointLeft(2))
                .setValorTotalRetencoesContidosNoRegistro4(new BigDecimal(linha.substring(23, 38)).movePointLeft(2));
    }

    @Override
    public String toLinha() {
        return "%s%s%s%s".formatted(
                TIPO_REGISTRO,
                String.format("%07d", numeroTotalLinhasArquivo),
                String.format("%015d", valorTotalServicosArquivo.movePointRight(2).longValue()),
                String.format("%015d", valorTotalRetencoesContidosNoRegistro4.movePointRight(2).longValue())
        );
    }
}
