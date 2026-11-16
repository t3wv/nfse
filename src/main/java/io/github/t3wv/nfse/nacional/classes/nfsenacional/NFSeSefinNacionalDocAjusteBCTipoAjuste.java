package io.github.t3wv.nfse.nacional.classes.nfsenacional;

/**
 * Tipo de ajuste da base de cálculo por documento (TSRTCTpAjusteBC, NT SE/CGNFS-e 009).
 * Os códigos 1, 3 e 4 estão na NT mas não no XSD de produção restrita de 20/10/2026: a SEFIN ainda
 * os recusa numa DPS, mas ficam aqui para que uma NFS-e que os traga possa ser lida.
 */
public enum NFSeSefinNacionalDocAjusteBCTipoAjuste {
    ALIMENTACAO_BEBIDAS_FRIGOBAR("1", "Alimentação e bebidas/frigobar"),
    MATERIAIS("2", "Materiais"),
    PRODUCAO_EXTERNA("3", "Produção externa"),
    REEMBOLSO_DESPESAS("4", "Reembolso de despesas"),
    REPASSE_CONSORCIADO("5", "Repasse consorciado"),
    REPASSE_PLANO_SAUDE("6", "Repasse plano de saúde"),
    SERVICOS("7", "Serviços"),
    SUBEMPREITADA_MAO_OBRA("8", "Subempreitada de mão de obra"),
    PROFISSIONAL_PARCEIRO("9", "Profissional parceiro"),
    OUTRAS_DEDUCOES_ISSQN("99", "Outras deduções exclusivas do ISSQN"),
    INTERMEDIACAO_IMOVEIS("101", "Repasse de remuneração por intermediação de imóveis a demais corretores envolvidos na operação"),
    AGENCIA_TURISMO("102", "Repasse de valores a fornecedor relativo a fornecimento intermediado por agência de turismo"),
    PUBLICIDADE_PRODUCAO_EXTERNA("103", "Reembolso ou ressarcimento recebido por agência de propaganda e publicidade por valores pagos relativos a serviços de produção externa por conta e ordem de terceiro"),
    PUBLICIDADE_SERVICO_MIDIA("104", "Reembolso ou ressarcimento recebido por agência de propaganda e publicidade por valores pagos relativos a serviços de mídia por conta e ordem de terceiro"),
    GLOSA_SERVICOS_SAUDE("105", "Glosa de Serviços de Saúde"),
    OUTROS_REEMBOLSOS("199", "Outros reembolsos ou ressarcimentos recebidos por valores pagos relativos a operações por conta e ordem de terceiro");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalDocAjusteBCTipoAjuste(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalDocAjusteBCTipoAjuste valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalDocAjusteBCTipoAjuste tipo : NFSeSefinNacionalDocAjusteBCTipoAjuste.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
