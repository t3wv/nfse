package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

import java.math.BigDecimal;

public class NFSeBarueriRPSArquivoRetornoRegistroTipo9 {
    private final int tipoRegistro;
    private final int numeroLinhas;
    private final BigDecimal valorTotalServicos;
    private final BigDecimal valorTotalRetencoes;

    public NFSeBarueriRPSArquivoRetornoRegistroTipo9(String linha) {
        this.tipoRegistro = Integer.parseInt(linha.substring(0, 1).trim());
        this.numeroLinhas = Integer.parseInt(linha.substring(1, 8).trim());
        this.valorTotalServicos = linha.substring(8, 23).trim().isEmpty() ? BigDecimal.ZERO : new BigDecimal(linha.substring(8, 23).trim()).movePointLeft(2);
        this.valorTotalRetencoes = linha.substring(23, 38).trim().isEmpty() ? BigDecimal.ZERO : new BigDecimal(linha.substring(23, 38).trim()).movePointLeft(2);
    }
}
