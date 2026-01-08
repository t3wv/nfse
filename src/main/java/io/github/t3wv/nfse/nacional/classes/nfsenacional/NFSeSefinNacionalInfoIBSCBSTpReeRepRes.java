package io.github.t3wv.nfse.nacional.classes.nfsenacional;

public enum NFSeSefinNacionalInfoIBSCBSTpReeRepRes {
    INTERMEDIACAO("01", "Repasse de remuneração por intermediação de imóveis a demais corretores envolvidos na operação"),
    AGENCIA_TURISMO("02", "Repasse de valores a fornecedor relativo a fornecimento intermediado por agência de turismo"),
    PUBLICIDADE_PRODUCAO_EXTERNA("03", "Reembolso ou ressarcimento recebido por agência de propaganda e publicidade por valores pagos relativos a serviços de produção externa por conta e ordem de terceiro"),
    PUBLICIDADE_SERVICO_MIDIA("04", "Reembolso ou ressarcimento recebido por agência de propaganda e publicidade por valores pagos relativos a serviços de mídia por conta e ordem de terceiro"),
    OUTROS("99", "Outros reembolsos ou ressarcimentos recebidos por valores pagos relativos a operações por conta e ordem de terceiro");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalInfoIBSCBSTpReeRepRes(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalInfoIBSCBSTpReeRepRes valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalInfoIBSCBSTpReeRepRes tipo : NFSeSefinNacionalInfoIBSCBSTpReeRepRes.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}