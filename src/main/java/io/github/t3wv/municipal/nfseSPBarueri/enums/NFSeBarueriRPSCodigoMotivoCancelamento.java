package io.github.t3wv.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriRPSCodigoMotivoCancelamento {
    CANCELAMENTO ("01"),
    DADOS_INCORRETOS("02"),
    SUBSTITUICAO("03");

    private final String codigo;

    NFSeBarueriRPSCodigoMotivoCancelamento(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
