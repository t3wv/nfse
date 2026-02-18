package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

public enum TpStatusNFe {

    NORMAL("N", "Normal"),
    CANCELADA("C", "Cancelada"),
    EXTRAVIADA("E", "Extraviada");

    private final String codigo;
    private final String descricao;

    TpStatusNFe(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TpStatusNFe valueOfCodigo(String codigo) {
        for (TpStatusNFe status : TpStatusNFe.values()) {
            if (status.getCodigo().equalsIgnoreCase(codigo)) {
                return status;
            }
        }
        return null;
    }
}
