package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriRPSLocalPrestacaoServico {
    BARUERI("1"),
    OUTROS("2");

    private final String codigo;

    NFSeBarueriRPSLocalPrestacaoServico(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static NFSeBarueriRPSLocalPrestacaoServico valueOfCodigo(String codigo) {
        for (NFSeBarueriRPSLocalPrestacaoServico local : NFSeBarueriRPSLocalPrestacaoServico.values()) {
            if (local.getCodigo().equals(codigo)) {
                return local;
            }
        }
        return null;
    }
}