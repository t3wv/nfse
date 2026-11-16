package io.github.t3wv.nfse.nacional.classes.nfsenacional;

/**
 * Tipo de parcela não integrante da base de cálculo do IBS/CBS na locação de imóvel
 * (TSAjusteBCLocImoveis, NT SE/CGNFS-e 009)
 */
public enum NFSeSefinNacionalInfoIBSCBSImovelTipoAjusteBC {
    TRIBUTOS("01", "Tributos inclusos no aluguel ou equivalente (ex.: IPTU, contribuição de melhoria)"),
    EMOLUMENTOS("02", "Emolumento incluso no aluguel ou equivalente"),
    CONDOMINIO("03", "Condomínio incluso no aluguel ou equivalente"),
    REDUTOR_SOCIAL("04", "Redutor Social"),
    OUTRAS("99", "Outras parcelas inclusas no aluguel ou equivalente");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalInfoIBSCBSImovelTipoAjusteBC(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalInfoIBSCBSImovelTipoAjusteBC valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalInfoIBSCBSImovelTipoAjusteBC tipo : NFSeSefinNacionalInfoIBSCBSImovelTipoAjusteBC.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
