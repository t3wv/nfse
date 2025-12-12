package io.github.t3wv.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriRPSEnteGovernamentalTipo {
    UNIAO("1"),
    ESTADO("2"),
    DISTRITO_FEDERAL("3"),
    MUNICIPIO("4");

    private final String codigo;

    NFSeBarueriRPSEnteGovernamentalTipo(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
