package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriRPSServicoPrestadoViasPublicas {
    SIM("1"),
    NAO("2");

    private final String codigo;

    NFSeBarueriRPSServicoPrestadoViasPublicas(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static NFSeBarueriRPSServicoPrestadoViasPublicas valueOfCodigo(String codigo) {
        for (NFSeBarueriRPSServicoPrestadoViasPublicas servico : NFSeBarueriRPSServicoPrestadoViasPublicas.values()) {
            if (servico.getCodigo().equals(codigo)) {
                return servico;
            }
        }
        return null;
    }
}