package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriArquivoRetornoSituacaoArquivo {

    AGUARDANDO_PROCESSAMENTO("-2", "Aguardando processamento"),
    EM_PROCESSAMENTO("-1", "Em processamento"),
    ARQUIVO_VALIDADO("0", "Arquivo validado"),
    ARQUIVO_IMPORTADO("1", "Arquivo importado"),
    ARQUIVO_COM_ERROS("2", "Arquivo com erros");

    private final String codigo;
    private final String descricao;

    NFSeBarueriArquivoRetornoSituacaoArquivo(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeBarueriArquivoRetornoSituacaoArquivo valueOfCodigo(String codigo) {
        for (NFSeBarueriArquivoRetornoSituacaoArquivo tipo : NFSeBarueriArquivoRetornoSituacaoArquivo.values()) {
            if (tipo.getCodigo().equalsIgnoreCase(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
