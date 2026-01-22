package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriIndicadorDestinatarioServico {

    TOMADOR("0"),
    TERCEIRO("1");

    private final String codigo;

    NFSeBarueriIndicadorDestinatarioServico(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static NFSeBarueriIndicadorDestinatarioServico valueOfCodigo(String codigo) {
        for (NFSeBarueriIndicadorDestinatarioServico indicador : NFSeBarueriIndicadorDestinatarioServico.values()) {
            if (indicador.getCodigo().equals(codigo)) {
                return indicador;
            }
        }
        return null;
    }
}
