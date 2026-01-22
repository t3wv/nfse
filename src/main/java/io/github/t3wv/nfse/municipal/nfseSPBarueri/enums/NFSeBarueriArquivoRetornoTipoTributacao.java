package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriArquivoRetornoTipoTributacao {
    MUNICIPAL(1, "Serviço prestado no município"),
    INTERMUNICIPAL(2, "Serviço prestado fora do município"),
    ISENTA(3, "Serviço isento"),
    SUSPENSAO_JUDICIAL(4, "Suspensão judicial");

    private final int codigo;
    private final String descricao;

    NFSeBarueriArquivoRetornoTipoTributacao(final int codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeBarueriArquivoRetornoTipoTributacao valueOfCodigo(int codigo) {
        for (NFSeBarueriArquivoRetornoTipoTributacao tipo : NFSeBarueriArquivoRetornoTipoTributacao.values()) {
            if (tipo.getCodigo() == codigo) {
                return tipo;
            }
        }
        return null;
    }
}
