package io.github.t3wv.nfse.nacional.classes.nfsenacional;

public enum NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao {

//    NAO_RETIDO("0", "Teste"),
//    NENHUM("1", "Retido"),
//    BASICA("2", "Não retido");

    NAO_RETIDOS("0", "PIS/COFINS/CSLL Não Retidos"),
    PIS_COFINS_RETIDOS("1", "PIS/COFINS Retidos"),
    PIS_COFINS_NAO_RETIDOS("2", "PIS/COFINS Não Retidos"),
    RETIDOS("3", "PIS/COFINS/CSLL Retidos"),
    PIS_COFINS_RETIDOS_CSLL_NAO_RETIDO("4", "PIS/COFINS Retidos, CSLL Não Retido"),
    PIS_RETIDO_COFINS_CSLL_NAO_RETIDOS("5", "PIS Retido, COFINS/CSLL Não Retido"),
    COFINS_RETIDO_PIS_CSLL_NAO_RETIDO("6", "COFINS Retido, PIS/CSLL Não Retido"),
    PIS_NAO_RETIDO_COFINS_CSLL_NAO_RETIDOS("7", "PIS Não Retido, COFINS/CSLL Retidos"),
    PIS_COFINS_NAO_RETIDOS_CSLL_RETIDO("8", "PIS/COFINS Não Retidos, CSLL Retido"),
    COFINS_NAO_RETIDO_PIS_CSLL_RETIDOS("9", "COFINS Não Retido, PIS/CSLL Retidos");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao tipo : NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}