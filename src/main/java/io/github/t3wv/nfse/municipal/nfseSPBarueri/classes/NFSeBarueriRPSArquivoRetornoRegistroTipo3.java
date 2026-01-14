package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.List;

public class NFSeBarueriRPSArquivoRetornoRegistroTipo3 {

    private final int tipoRegistro;
    private final int quantidade;
    private final String descricao;
    private final long codigo;
    private final BigDecimal valorUnitario;
    private final BigDecimal aliquota;
    private List<NFSeBarueriRPSArquivoRetornoRegistroTipo4> retencoes;

    public NFSeBarueriRPSArquivoRetornoRegistroTipo3(String linha) {
        this.tipoRegistro = Integer.parseInt(linha.substring(0, 1).trim());
        this.quantidade = Integer.parseInt(linha.substring(1, 7).trim());
        this.descricao = linha.substring(7, 67).trim();
        this.codigo = Long.parseLong(linha.substring(67, 76).trim());
        this.valorUnitario = StringUtils.stripStart(linha.substring(76, 91).trim(), "0").isEmpty() ? BigDecimal.ZERO : new BigDecimal(linha.substring(76, 91).trim()).movePointLeft(2);
        this.aliquota = StringUtils.stripStart(linha.substring(91, 95).trim(), "0").isEmpty() ? BigDecimal.ZERO : new BigDecimal(linha.substring(91, 95).trim()).movePointLeft(2);
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo3 addRetencao(NFSeBarueriRPSArquivoRetornoRegistroTipo4 item) {
        if(this.retencoes == null) {
            this.retencoes = new java.util.ArrayList<>();
        }
        this.retencoes.add(item);
        return this;
    }
}
