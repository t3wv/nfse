package io.github.t3wv.nfse.nacional.classes.nfsenacional;

public enum NFSeSefinNacionalValoresNFSeTipoBeneficioMunicipal {

    ISENCAO("1", "Isenção"),
    REDUCAO_BC_PERCENTUAL("2", "Redução da BC em percentual"),
    REDUCAO_BC_MONETARIO("3", "Redução da BC em R$"),
    ALIQUOTA_DIFERENCIADA("4", "Alíquota Diferenciada");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalValoresNFSeTipoBeneficioMunicipal(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalValoresNFSeTipoBeneficioMunicipal valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalValoresNFSeTipoBeneficioMunicipal tipo : NFSeSefinNacionalValoresNFSeTipoBeneficioMunicipal.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
