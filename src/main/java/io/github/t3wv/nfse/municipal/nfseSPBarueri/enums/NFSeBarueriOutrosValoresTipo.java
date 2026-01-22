package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriOutrosValoresTipo {
    IRRF("01", "IRRF"),
    PIS_PASEP("02", "PIS/PASEP"),
    COFINS("03", "COFINS"),
    CSLL("04", "CSLL"),
    CONTRIBUICAO_PREVIDENCIARIA("05", "Contribuição Previdenciária"),
    VALOR_NAO_INCLUSO("VN", "Valor Não Incluso na base de cálculo (Exceto tributos federais)");

    private final String codigo;
    private final String descricao;

    NFSeBarueriOutrosValoresTipo(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeBarueriOutrosValoresTipo valueOfCodigo(String codigo) {
        for (NFSeBarueriOutrosValoresTipo tipo : NFSeBarueriOutrosValoresTipo.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}