package io.github.t3wv.nfse.nacional.classes.nfsenacional;


public enum NFSeSefinNacionalTSCodJustAnaliseFiscalCancDef {

    EXTEMPORANEO_DEFERIDO("1", "Cancelamento Extemporâneo Deferido");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalTSCodJustAnaliseFiscalCancDef(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalTSCodJustAnaliseFiscalCancDef valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalTSCodJustAnaliseFiscalCancDef tipo : NFSeSefinNacionalTSCodJustAnaliseFiscalCancDef.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
