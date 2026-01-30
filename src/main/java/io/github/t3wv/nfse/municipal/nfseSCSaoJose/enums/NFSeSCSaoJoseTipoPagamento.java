package io.github.t3wv.nfse.municipal.nfseSCSaoJose.enums;

public enum NFSeSCSaoJoseTipoPagamento {

    A_VISTA("1", "À Vista"),
    A_PRAZO("2", "À Prazo"),
    DEPOSITO("3", "Depósito"),
    APRESENTACAO("4", "Na apresentação"),
    CARTAO_DEBITO("5", "Cartão de débito"),
    CARTAO_CREDITO("6", "Cartão de crédito"),
    CHEQUE("7", "Cheque"),
    PIX("8", "PIX");

    private final String codigo;
    private final String descricao;

    NFSeSCSaoJoseTipoPagamento(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSCSaoJoseTipoPagamento valueOfCodigo(String codigo) {
        for (NFSeSCSaoJoseTipoPagamento tipo : NFSeSCSaoJoseTipoPagamento.values()) {
            if (tipo.getCodigo().equalsIgnoreCase(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
