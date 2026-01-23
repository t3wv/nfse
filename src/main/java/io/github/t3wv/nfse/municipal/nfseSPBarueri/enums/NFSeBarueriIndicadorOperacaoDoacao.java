package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriIndicadorOperacaoDoacao {

    DOACAO_COM_CONTRAPRESTACAO("1");

    private final String codigo;

    NFSeBarueriIndicadorOperacaoDoacao(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static NFSeBarueriIndicadorOperacaoDoacao valueOfCodigo(String codigo) {
        for (NFSeBarueriIndicadorOperacaoDoacao tipo : NFSeBarueriIndicadorOperacaoDoacao.values()) {
            if (tipo.getCodigo().equalsIgnoreCase(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
