package io.github.t3wv.nfse.nacional.classes.nfsenacional;

public enum NFSeSefinNacionalTribMunicipalTributacaoISSQN {

    OPERACAO_TRIBUTAVEL("1", "Operação tributável"),
    IMUNIDADE("2", "Imunidade"),
    EXPORTACAO_SERVICO("3", "Exportação de serviço"),
    NAO_INCIDENCIA("4", "Não Incidência");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalTribMunicipalTributacaoISSQN(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalTribMunicipalTributacaoISSQN valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalTribMunicipalTributacaoISSQN tipo : NFSeSefinNacionalTribMunicipalTributacaoISSQN.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}