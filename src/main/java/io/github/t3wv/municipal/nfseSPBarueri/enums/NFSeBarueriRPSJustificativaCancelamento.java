package io.github.t3wv.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriRPSJustificativaCancelamento {
    DESENQUADRAMENTO_SIMPLES_NACIONAL("1"),
    ENQUADRAMENTO_SIMPLES_NACIONAL("2"),
    INCLUSAO_RETROATIVA_IMUNIDADE("3"),
    EXCLUSAO_RETROATIVA_IMUNIDADE("4"),
    REJEICAO("5"),
    OUTROS("9");

    private final String codigo;

    NFSeBarueriRPSJustificativaCancelamento(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
