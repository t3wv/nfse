package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriVinculoEntrePartes {

    SEM_VINCULO("0"),
    CONTROLADA("1"),
    CONTROLADORA("2"),
    COLIGADA("3"),
    MATRIZ("4"),
    FILIAL_SUCURSAL("5"),
    OUTRO("6");


    private final String codigo;

    NFSeBarueriVinculoEntrePartes(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static NFSeBarueriVinculoEntrePartes valueOfCodigo(String codigo) {
        for (NFSeBarueriVinculoEntrePartes vinculo : NFSeBarueriVinculoEntrePartes.values()) {
            if (vinculo.getCodigo().equals(codigo)) {
                return vinculo;
            }
        }
        return null;
    }
}