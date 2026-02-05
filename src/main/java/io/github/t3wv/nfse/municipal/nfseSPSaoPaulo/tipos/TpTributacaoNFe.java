package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

public enum TpTributacaoNFe {
    TRIBUTADO_SAO_PAULO("T", "Tributado em São Paulo"),
    TRIBUTADO_OUTRO_MUNICIPIO("F", "Tributado Fora de São Paulo"),
    TRIBUTADO_SAO_PAULO_ISENTO("A", "Tributado em São Paulo, porém Isento"),
    TRIBUTADO_OUTRO_MUNICIPIO_ISENTO("B", "Tributado Fora de São Paulo,porém Isento"),
    TRIBUTADO_SAO_PAULO_ISENCAO_PARCIAL("D", "Tributado em São Paulo com isenção parcial"),
    TRIBUTADO_SAO_PAULO_INDICACAO_IMUNIDADE_SUBJETIVA("M", "Tributado em São Paulo, porém com indicação de imunidade subjetiva"),
    TRIBUTADO_OUTRO_MUNICIPIO_INDICACAO_IMUNIDADE_SUBJETIVA("N", "Tributado Fora de São Paulo,porém com indicação de imunidade subjetiva"),
    TRIBUTADO_SAO_PAULO_INDICACAO_IMUNIDADE_OBJETIVA("R", "Tributado em São Paulo, porém com indicação de imunidade objetiva"),
    TRIBUTADO_OUTRO_MUNICIPIO_INDICACAO_IMUNIDADE_OBJETIVA("S", "Tributado fora de São Paulo,porém com indicação de imunidade objetiva"),
    TRIBUTADO_SAO_PAULO_EXIGIBILIDADE_SUSPENSA("X", "Tributado em São Paulo, porém Exigibilidade Suspensa"),
    TRIBUTADO_OUTRO_MUNICIPIO_EXIGIBILIDADE_SUSPENSA("V", "Tributado Fora de São Paulo, porém Exigibilidade Suspensa"),
    EXPORTACAO("P", "Exportação de Serviços");

    private final String codigo;
    private final String descricao;

    TpTributacaoNFe(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TpTributacaoNFe valueOfCodigo(String codigo) {
        for (TpTributacaoNFe tipo : TpTributacaoNFe.values()) {
            if (tipo.getCodigo().equalsIgnoreCase(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
