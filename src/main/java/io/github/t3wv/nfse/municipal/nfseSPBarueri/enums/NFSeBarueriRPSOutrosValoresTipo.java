package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriRPSOutrosValoresTipo {
    IRRF("01"),
    PIS_PASEP("02"),
    COFINS("03"),
    CSLL("04"),
    CONTRIBUICAO_PREVIDENCIARIA("05"),
    VALOR_NAO_INCLUSO("VN");

    private final String codigo;

    NFSeBarueriRPSOutrosValoresTipo(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static NFSeBarueriRPSOutrosValoresTipo valueOfCodigo(String codigo) {
        for (NFSeBarueriRPSOutrosValoresTipo tipo : NFSeBarueriRPSOutrosValoresTipo.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}