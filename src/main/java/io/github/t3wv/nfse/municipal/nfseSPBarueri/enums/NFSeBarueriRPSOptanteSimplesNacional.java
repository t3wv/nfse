package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriRPSOptanteSimplesNacional {
    NAO_OPTANTE("1"),
    MEI("2"),
    ME_EPP("3");

    private final String codigo;

    NFSeBarueriRPSOptanteSimplesNacional(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static NFSeBarueriRPSOptanteSimplesNacional valueOfCodigo(String codigo) {
        for (NFSeBarueriRPSOptanteSimplesNacional optante : NFSeBarueriRPSOptanteSimplesNacional.values()) {
            if (optante.getCodigo().equals(codigo)) {
                return optante;
            }
        }
        return null;
    }
}