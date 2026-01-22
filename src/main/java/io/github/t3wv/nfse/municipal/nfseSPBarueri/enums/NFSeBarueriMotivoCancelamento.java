package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriMotivoCancelamento {

    CANCELAMENTO("01", "Cancelamento do serviço"),
    DADOS_INCORRETOS("02", "Dados incorretos"),
    SUBSTITUICAO("03", "Substituição");

    private final String codigo, descricao;

    NFSeBarueriMotivoCancelamento(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeBarueriMotivoCancelamento valueOfCodigo(String codigo) {
        for (NFSeBarueriMotivoCancelamento motivo : NFSeBarueriMotivoCancelamento.values()) {
            if (motivo.getCodigo().equals(codigo)) {
                return motivo;
            }
        }
        return null;
    }
}
