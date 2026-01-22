package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriPessoaTipo {

    FISICA("1", "Pessoa física"),
    JURIDICA("2", "Pessoa jurídica"),
    ESTRANGEIRA(" ", "Pessoa estrangeira");

    private final String codigo;
    private final String descricao;

    NFSeBarueriPessoaTipo(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeBarueriPessoaTipo valueOfCodigo(String codigo) {
        for (NFSeBarueriPessoaTipo tipo : NFSeBarueriPessoaTipo.values()) {
            if (tipo.getCodigo().equalsIgnoreCase(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
