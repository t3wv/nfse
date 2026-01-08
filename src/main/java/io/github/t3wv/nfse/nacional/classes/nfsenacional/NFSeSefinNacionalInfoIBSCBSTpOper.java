package io.github.t3wv.nfse.nacional.classes.nfsenacional;

/**
 *  Tipo de Operação com Entes Governamentais ou outros serviços sobre bens imóveis
 */
public enum NFSeSefinNacionalInfoIBSCBSTpOper {
    PAGAMENTO_POSTERIOR("1", "Fornecimento com pagamento posterior"),
    PAGAMENTO_FORNECIMENTO_PREVIO("2", "Recebimento do pagamento com fornecimento já realizado"),
    FORNECIMENTO_PAGAMENTO_PREVIO("3", "Fornecimento com pagamento já realizado"),
    RECEBIMENTO_PAGAMENTO_FORNECIMENTO_POSTERIOR("4", "Recebimento do pagamento com fornecimento posterior"),
    FORNECIMENTO_RECEBIMENTO_PAGAMENTO_CONCOMITANTES("5", "Fornecimento e recebimento do pagamento concomitantes");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalInfoIBSCBSTpOper(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalInfoIBSCBSTpOper valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalInfoIBSCBSTpOper tipo : NFSeSefinNacionalInfoIBSCBSTpOper.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}