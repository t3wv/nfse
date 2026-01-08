package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriRPSSituacao {
    ENVIADO("E"),
    CANCELADO("C"),
    REENVIO("R");

    private final String codigo;

    NFSeBarueriRPSSituacao(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static NFSeBarueriRPSSituacao valueOfCodigo(String codigo) {
        for (NFSeBarueriRPSSituacao situacao : NFSeBarueriRPSSituacao.values()) {
            if (situacao.getCodigo().equals(codigo)) {
                return situacao;
            }
        }
        return null;
    }
}