package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriSituacao {
    ENVIADO("E"),
    CANCELADO("C"),
    REENVIO("R");

    private final String codigo;

    NFSeBarueriSituacao(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static NFSeBarueriSituacao valueOfCodigo(String codigo) {
        for (NFSeBarueriSituacao situacao : NFSeBarueriSituacao.values()) {
            if (situacao.getCodigo().equals(codigo)) {
                return situacao;
            }
        }
        return null;
    }
}