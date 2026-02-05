package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

public enum TpIndDest {

    TOMADOR("0", "O destinatário é o próprio tomador/adquirente identificado na NFS-e (tomador = adquirente = destinatário)"),
    TERCEIRO("1", "O destinatário não é o próprio adquirente, podendo ser outra pessoa, física ou jurídica (ou equiparada), ou um estabelecimento diferente do indicado como tomador (tomador = adquirente ≠ destinatário)");

    private final String codigo;
    private final String descricao;

    TpIndDest(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TpIndDest valueOfCodigo(String codigo) {
        for (TpIndDest tipo : TpIndDest.values()) {
            if (tipo.getCodigo().equalsIgnoreCase(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
