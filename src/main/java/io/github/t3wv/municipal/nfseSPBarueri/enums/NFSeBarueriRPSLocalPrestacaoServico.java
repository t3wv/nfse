package io.github.t3wv.municipal.nfseSPBarueri.enums;

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
}
