package io.github.t3wv.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriRPSIndicadorDestinatarioServico {

    TOMADOR("0"),
    TERCEIRO("1");


    private final String codigo;

    NFSeBarueriRPSIndicadorDestinatarioServico(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
