package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

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

    public static NFSeBarueriRPSIndicadorDestinatarioServico valueOfCodigo(String codigo) {
        for (NFSeBarueriRPSIndicadorDestinatarioServico indicador : NFSeBarueriRPSIndicadorDestinatarioServico.values()) {
            if (indicador.getCodigo().equals(codigo)) {
                return indicador;
            }
        }
        return null;
    }
}
