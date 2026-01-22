package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriArquivoRetornoSituacaoNFe {
    ATIVA("A", "Ativa"),
    CANCELADA("C", "Cancelada");

    private final String codigo;
    private final String descricao;

    NFSeBarueriArquivoRetornoSituacaoNFe(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeBarueriArquivoRetornoSituacaoNFe valueOfCodigo(String codigo) {
        for (NFSeBarueriArquivoRetornoSituacaoNFe tipo : NFSeBarueriArquivoRetornoSituacaoNFe.values()) {
            if (tipo.getCodigo().equalsIgnoreCase(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
