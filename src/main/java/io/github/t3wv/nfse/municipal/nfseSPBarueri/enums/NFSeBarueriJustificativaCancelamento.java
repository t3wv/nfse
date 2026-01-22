package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriJustificativaCancelamento {
    DESENQUADRAMENTO_SIMPLES_NACIONAL("1"),
    ENQUADRAMENTO_SIMPLES_NACIONAL("2"),
    INCLUSAO_RETROATIVA_IMUNIDADE("3"),
    EXCLUSAO_RETROATIVA_IMUNIDADE("4"),
    REJEICAO("5"),
    OUTROS("9");

    private final String codigo;

    NFSeBarueriJustificativaCancelamento(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static NFSeBarueriJustificativaCancelamento valueOfCodigo(String codigo) {
        for (NFSeBarueriJustificativaCancelamento justificativa : NFSeBarueriJustificativaCancelamento.values()) {
            if (justificativa.getCodigo().equals(codigo)) {
                return justificativa;
            }
        }
        return null;
    }
}
