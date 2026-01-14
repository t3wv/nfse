package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriRPSArquivoRetornoSituacaoNFe {
    ATIVA("A", "Ativa"),
    CANCELADA("C", "Cancelada");

    private final String codigo;
    private final String descricao;

    NFSeBarueriRPSArquivoRetornoSituacaoNFe(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeBarueriRPSArquivoRetornoSituacaoNFe valueOfCodigo(String codigo) {
        for (NFSeBarueriRPSArquivoRetornoSituacaoNFe tipo : NFSeBarueriRPSArquivoRetornoSituacaoNFe.values()) {
            if (tipo.getCodigo().equalsIgnoreCase(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
