package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

public enum TpOpcaoSimplesNFe {
    NAO_OPTANTE("0", "Não-optante pelo Simples Federal nem Municipal."),
    OPTANTE_UM_PORCENTO("1", "Optante pelo Simples Federal (Alíquota de 1,0%)."),
    OPTANTE_MEIO_PORCENTO("2", "Optante pelo Simples Federal (Alíquota de 0,5%)."),
    OPTANTE_SIMPLES_MUNICIPAL("3", "Optante pelo Simples Municipal."),
    OPTANTE_DAS("4", "Optante pelo Simples Nacional - DAS."),
    OPTANTE_DAMSP("6", "Optante pelo Simples Nacional - DAMSP.");

    private final String codigo;
    private final String descricao;

    TpOpcaoSimplesNFe(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TpOpcaoSimplesNFe valueOfCodigo(final String codigo) {
        for (final TpOpcaoSimplesNFe tpOpcaoSimplesNFe : TpOpcaoSimplesNFe.values()) {
            if (tpOpcaoSimplesNFe.getCodigo().equals(codigo)) {
                return tpOpcaoSimplesNFe;
            }
        }
        return null;
    }
}
