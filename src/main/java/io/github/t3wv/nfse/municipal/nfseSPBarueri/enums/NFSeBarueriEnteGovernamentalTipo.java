package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriEnteGovernamentalTipo {
    UNIAO("1"),
    ESTADO("2"),
    DISTRITO_FEDERAL("3"),
    MUNICIPIO("4");

    private final String codigo;

    NFSeBarueriEnteGovernamentalTipo(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static NFSeBarueriEnteGovernamentalTipo valueOfCodigo(String codigo) {
        for (NFSeBarueriEnteGovernamentalTipo tipo : NFSeBarueriEnteGovernamentalTipo.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
