package io.github.t3wv.nfse.nacional.classes.nfsenacional;

/**
 * Tipo de Ente Governamental
 */
public enum NFSeSefinNacionalInfoIBSCBSTpEnteGov {
    UNIAO("1", "União"),
    ESTADO("2", "Estado"),
    DISTRITO("3", "Distrito Federal"),
    MUNICIPIO("4", "Município");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalInfoIBSCBSTpEnteGov(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalInfoIBSCBSTpEnteGov valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalInfoIBSCBSTpEnteGov tipo : NFSeSefinNacionalInfoIBSCBSTpEnteGov.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}