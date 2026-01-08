package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriRPSEnteGovernamentalOperacaoTipo {
     FORNECIMENTO_PAGAMENTO_POSTERIOR("1"),
     RECEBIMENTO_PAGAMENTO_FORNECIMENTO_REALIZADO("2"),
     FORNECIMENTO_PAGAMENTO_REALIZADO("3"),
     RECEBIMENTO_PAGAMENTO_FORNECIMENTO_POSTERIOR("4");

    private final String codigo;

    NFSeBarueriRPSEnteGovernamentalOperacaoTipo(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static NFSeBarueriRPSEnteGovernamentalOperacaoTipo valueOfCodigo(String codigo) {
        for (NFSeBarueriRPSEnteGovernamentalOperacaoTipo tipo : NFSeBarueriRPSEnteGovernamentalOperacaoTipo.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
