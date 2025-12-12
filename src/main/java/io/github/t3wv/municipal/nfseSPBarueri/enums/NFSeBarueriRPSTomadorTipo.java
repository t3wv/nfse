package io.github.t3wv.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriRPSTomadorTipo {
    ESTRANGEIRO("1"),
    BRASILEIRO("2");

    private final String codigo;

    NFSeBarueriRPSTomadorTipo(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
