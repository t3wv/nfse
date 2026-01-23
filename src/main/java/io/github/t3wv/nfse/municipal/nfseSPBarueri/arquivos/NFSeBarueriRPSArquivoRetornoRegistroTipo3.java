package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import java.math.BigDecimal;

public class NFSeBarueriRPSArquivoRetornoRegistroTipo3 extends NFSeBarueriRPSArquivoRetornoRegistro<NFSeBarueriRPSArquivoRetornoRegistroTipo3> {

    static final String TIPO_REGISTRO = "3";
    private int tipoRegistro;
    private int quantidade;
    private String descricao;
    private long codigo;
    private BigDecimal valorUnitario;
    private BigDecimal aliquota;

    public NFSeBarueriRPSArquivoRetornoRegistroTipo3() {
//        this.tipoRegistro = Integer.parseInt(linha.substring(0, 1).trim());
//        this.quantidade = Integer.parseInt(linha.substring(1, 7).trim());
//        this.descricao = linha.substring(7, 67).trim();
//        this.codigo = Long.parseLong(linha.substring(67, 76).trim());
//        this.valorUnitario = StringUtils.stripStart(linha.substring(76, 91).trim(), "0").isEmpty() ? BigDecimal.ZERO : new BigDecimal(linha.substring(76, 91).trim()).movePointLeft(2);
//        this.aliquota = StringUtils.stripStart(linha.substring(91, 95).trim(), "0").isEmpty() ? BigDecimal.ZERO : new BigDecimal(linha.substring(91, 95).trim()).movePointLeft(2);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public long getCodigo() {
        return codigo;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }

    @Override
    public String getTipoRegistro() {
        return TIPO_REGISTRO;
    }

    @Override
    public NFSeBarueriRPSArquivoRetornoRegistroTipo3 fromLinha(String linha) {
        return null;
    }

    @Override
    public String toLinha() {
        return "";
    }
}
