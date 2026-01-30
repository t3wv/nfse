package io.github.t3wv.nfse.municipal.nfseSCSaoJose.enums;

public enum NFSeSCSaoJosePessoaTipo {

    FISICA("F", "Pessoa física"),
    JURIDICA("J", "Pessoa jurídica"),
    ESTRANGEIRA("E", "Pessoa estrangeira");

    private final String codigo;
    private final String descricao;

    NFSeSCSaoJosePessoaTipo(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSCSaoJosePessoaTipo valueOfCodigo(String codigo) {
        for (NFSeSCSaoJosePessoaTipo tipo : NFSeSCSaoJosePessoaTipo.values()) {
            if (tipo.getCodigo().equalsIgnoreCase(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
