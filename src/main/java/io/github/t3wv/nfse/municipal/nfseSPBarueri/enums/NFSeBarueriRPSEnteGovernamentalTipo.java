package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

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

    public static NFSeBarueriRPSEnteGovernamentalTipo valueOfCodigo(String codigo) {
        for (NFSeBarueriRPSEnteGovernamentalTipo tipo : NFSeBarueriRPSEnteGovernamentalTipo.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
