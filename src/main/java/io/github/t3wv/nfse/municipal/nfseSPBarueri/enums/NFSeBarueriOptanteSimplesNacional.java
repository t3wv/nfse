package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriOptanteSimplesNacional {
    NAO_OPTANTE("1"),
    MEI("2"),
    ME_EPP("3");

    private final String codigo;

    NFSeBarueriOptanteSimplesNacional(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static NFSeBarueriOptanteSimplesNacional valueOfCodigo(String codigo) {
        for (NFSeBarueriOptanteSimplesNacional optante : NFSeBarueriOptanteSimplesNacional.values()) {
            if (optante.getCodigo().equals(codigo)) {
                return optante;
            }
        }
        return null;
    }
}