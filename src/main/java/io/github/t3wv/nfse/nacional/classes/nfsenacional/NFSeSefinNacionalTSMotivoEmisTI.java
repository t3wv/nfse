package io.github.t3wv.nfse.nacional.classes.nfsenacional;

public enum NFSeSefinNacionalTSMotivoEmisTI {

    IMPORTACAO_SERVICO("1", "Importação de Serviço"),
    OBRIGADO_LEGISLACAO_MUNICIPAL("2", "Tomador/Intermediário obrigado a emitir NFS-e por legislação municipal"),
    RECUSA_EMISSAO_PRESTADOR("3", "Tomador/Intermediário emitindo NFS-e por recusa de emissão pelo prestador"),
    REJEICAO_NFSE_PRESTADOR("4", "Tomador/Intermediário emitindo por rejeitar a NFS-e emitida pelo prestador");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalTSMotivoEmisTI(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalTSMotivoEmisTI valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalTSMotivoEmisTI tipo : NFSeSefinNacionalTSMotivoEmisTI.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
