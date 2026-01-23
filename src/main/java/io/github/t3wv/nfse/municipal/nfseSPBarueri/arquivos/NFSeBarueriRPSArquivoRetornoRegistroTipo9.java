package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import java.math.BigDecimal;

public class NFSeBarueriRPSArquivoRetornoRegistroTipo9 extends NFSeBarueriRPSArquivoRetornoRegistro<NFSeBarueriRPSArquivoRetornoRegistroTipo9> {

    static final String TIPO_REGISTRO = "9";
    private int numeroLinhas;
    private BigDecimal valorTotalServicos;
    private BigDecimal valorTotalRetencoes;

    public NFSeBarueriRPSArquivoRetornoRegistroTipo9() {
//        this.numeroLinhas = Integer.parseInt(linha.substring(1, 8).trim());
//        this.valorTotalServicos = linha.substring(8, 23).trim().isEmpty() ? BigDecimal.ZERO : new BigDecimal(linha.substring(8, 23).trim()).movePointLeft(2);
//        this.valorTotalRetencoes = linha.substring(23, 38).trim().isEmpty() ? BigDecimal.ZERO : new BigDecimal(linha.substring(23, 38).trim()).movePointLeft(2);
    }

    @Override
    public String getTipoRegistro() {
        return TIPO_REGISTRO;
    }

    @Override
    public NFSeBarueriRPSArquivoRetornoRegistroTipo9 fromLinha(String linha) {
        return null;
    }

    @Override
    public String toLinha() {
        return "";
    }
}
