package io.github.t3wv.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriRPSVinculoEntrePartes {

    SEM_VINCULO("0"),
    CONTROLADA("1"),
    CONTROLADORA("2"),
    COLIGADA("3"),
    MATRIZ("4"),
    FILIAL_SUCURSAL("5"),
    OUTRO("6");


    private final String codigo;

    NFSeBarueriRPSVinculoEntrePartes(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
