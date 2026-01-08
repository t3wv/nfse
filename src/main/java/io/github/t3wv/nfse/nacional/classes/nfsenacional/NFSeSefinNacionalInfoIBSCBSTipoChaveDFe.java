package io.github.t3wv.nfse.nacional.classes.nfsenacional;

public enum NFSeSefinNacionalInfoIBSCBSTipoChaveDFe {
    NFSE("1", "NFS-e"),
    NFE("2", "NF-e"),
    CTE("3", "CT-e"),
    OUTRO("9", "Outro");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalInfoIBSCBSTipoChaveDFe(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalInfoIBSCBSTipoChaveDFe valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalInfoIBSCBSTipoChaveDFe tipo : NFSeSefinNacionalInfoIBSCBSTipoChaveDFe.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}