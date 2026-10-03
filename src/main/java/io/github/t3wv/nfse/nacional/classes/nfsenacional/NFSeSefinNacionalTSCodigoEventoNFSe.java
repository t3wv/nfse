package io.github.t3wv.nfse.nacional.classes.nfsenacional;


import org.simpleframework.xml.Root;

/**
 * Código de evento da NFS-e (tipo {@code TSCodigoEventoNFSe} do XSD da NFS-e Nacional).
 *
 * @author Marcos Lombardi de Andrade
 */
@Root(name = "codEvento")
public enum NFSeSefinNacionalTSCodigoEventoNFSe {

    CANCELAMENTO("e101101", "Cancelamento de NFS-e"),
    CANCELAMENTO_SUBSTITUICAO("e105102", "Cancelamento de NFS-e por Substituição"),
    CANCELAMENTO_DEFERIDO_ANALISE_FISCAL("e105104", "Cancelamento de NFS-e Deferido por Análise Fiscal"),
    CANCELAMENTO_INDEFERIDO_ANALISE_FISCAL("e105105", "Cancelamento de NFS-e Indeferido por Análise Fiscal"),
    CANCELAMENTO_OFICIO("e305101", "Cancelamento de NFS-e por Ofício");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalTSCodigoEventoNFSe(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalTSCodigoEventoNFSe valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalTSCodigoEventoNFSe tipo : NFSeSefinNacionalTSCodigoEventoNFSe.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
