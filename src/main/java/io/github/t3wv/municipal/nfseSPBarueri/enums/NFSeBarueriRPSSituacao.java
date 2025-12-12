package io.github.t3wv.municipal.nfseSPBarueri.enums;

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
}
