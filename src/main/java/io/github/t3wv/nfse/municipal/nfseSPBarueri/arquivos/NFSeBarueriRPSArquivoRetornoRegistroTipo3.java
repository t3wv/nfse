package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public class NFSeBarueriRPSArquivoRetornoRegistroTipo3 extends NFSeBarueriRPSArquivoRetornoRegistro<NFSeBarueriRPSArquivoRetornoRegistroTipo3> {

    public static final String TIPO_REGISTRO = "3";

    private Integer quantidade;
    private String descricao;
    private Long codigo;
    private BigDecimal valorUnitario;
    private BigDecimal aliquota;

    public Integer getQuantidade() {
        return quantidade;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo3 setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo3 setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Long getCodigo() {
        return codigo;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo3 setCodigo(Long codigo) {
        this.codigo = codigo;
        return this;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo3 setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
        return this;
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo3 setAliquota(BigDecimal aliquota) {
        this.aliquota = aliquota;
        return this;
    }

    @Override
    public String getTipoRegistro() {
        return TIPO_REGISTRO;
    }

    @Override
    public NFSeBarueriRPSArquivoRetornoRegistroTipo3 fromLinha(String linha) {
        return new NFSeBarueriRPSArquivoRetornoRegistroTipo3()
                .setQuantidade(Integer.parseInt(linha.substring(1, 7).trim()))
                .setDescricao(StringUtils.trimToEmpty(linha.substring(7, 67)))
                .setCodigo(Long.parseLong(StringUtils.trimToEmpty(linha.substring(67, 76))))
                .setValorUnitario(new BigDecimal(StringUtils.trimToEmpty(linha.substring(76, 91))).movePointLeft(2))
                .setAliquota(new BigDecimal(StringUtils.trimToEmpty(linha.substring(91, 95))).movePointLeft(2));
    }

    @Override
    public String toLinha() {
        return String.format("%s%s%s%s%s%s",
                getTipoRegistro(),
                StringUtils.leftPad(String.valueOf(getQuantidade()), 6, '0'),
                StringUtils.rightPad(getDescricao(), 60),
                StringUtils.leftPad(String.valueOf(getCodigo()), 9, '0'),
                StringUtils.leftPad(getValorUnitario().movePointRight(2).toPlainString(), 15, '0'),
                StringUtils.leftPad(getAliquota().movePointRight(2).toPlainString(), 4, '0'));
    }
}
