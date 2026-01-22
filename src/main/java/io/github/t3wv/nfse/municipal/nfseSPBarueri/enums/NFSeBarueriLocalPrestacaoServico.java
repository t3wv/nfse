package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriLocalPrestacaoServico {

    BARUERI("1"),
    OUTROS("2");

    private final String codigo;

    NFSeBarueriLocalPrestacaoServico(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static NFSeBarueriLocalPrestacaoServico valueOfCodigo(String codigo) {
        for (NFSeBarueriLocalPrestacaoServico local : NFSeBarueriLocalPrestacaoServico.values()) {
            if (local.getCodigo().equals(codigo)) {
                return local;
            }
        }
        return null;
    }
}