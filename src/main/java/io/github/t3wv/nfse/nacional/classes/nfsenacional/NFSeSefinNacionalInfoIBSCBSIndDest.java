package io.github.t3wv.nfse.nacional.classes.nfsenacional;

/**
 * Indicador do Destinatário do Serviço
 */
public enum NFSeSefinNacionalInfoIBSCBSIndDest {
    TOMADOR("0", "Destinatário é o próprio tomador/adquirente identificado na NFS-e (tomador = adquirente = destinatário)"),
    TERCEIRO("1", "Destinatário não é o próprio adquirente, podendo ser outra pessoa, física ou jurídica (ou equiparada), ou um estabelecimento diferente do indicado como tomador (tomador = adquirente ≠ destinatário)");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalInfoIBSCBSIndDest(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalInfoIBSCBSIndDest valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalInfoIBSCBSIndDest tipo : NFSeSefinNacionalInfoIBSCBSIndDest.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}