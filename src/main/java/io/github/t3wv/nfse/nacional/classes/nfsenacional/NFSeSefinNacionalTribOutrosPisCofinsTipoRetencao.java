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

    /**
     * @return true se o PIS é retido neste tipo de retenção (códigos 1, 3, 4, 5 e 9).
     */
    public boolean isPisRetido() {
        return switch (this) {
            case PIS_COFINS_RETIDOS, RETIDOS, PIS_COFINS_RETIDOS_CSLL_NAO_RETIDO, PIS_RETIDO_COFINS_CSLL_NAO_RETIDOS, COFINS_NAO_RETIDO_PIS_CSLL_RETIDOS -> true;
            default -> false;
        };
    }

    /**
     * @return true se a COFINS é retida neste tipo de retenção (códigos 1, 3, 4, 6 e 7).
     */
    public boolean isCofinsRetido() {
        return switch (this) {
            case PIS_COFINS_RETIDOS, RETIDOS, PIS_COFINS_RETIDOS_CSLL_NAO_RETIDO, COFINS_RETIDO_PIS_CSLL_NAO_RETIDO, PIS_NAO_RETIDO_COFINS_CSLL_NAO_RETIDOS -> true;
            default -> false;
        };
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