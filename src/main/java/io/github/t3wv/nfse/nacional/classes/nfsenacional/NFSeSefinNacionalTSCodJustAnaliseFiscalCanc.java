package io.github.t3wv.nfse.nacional.classes.nfsenacional;


import org.simpleframework.xml.Root;

/**
 * Motivo da solicitação de análise fiscal para cancelamento de NFS-e (tipo {@code TSCodJustAnaliseFiscalCanc} do XSD da NFS-e Nacional).
 *
 * @author Marcos Lombardi de Andrade
 */
@Root(name = "cMotivo")
public enum NFSeSefinNacionalTSCodJustAnaliseFiscalCanc {

    ERRO_EMISSAO("1", "Erro na Emissão"),
    SERVICO_NAO_PRESTADO("2", "Serviço não Prestado"),
    OUTROS("9", "Outros");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalTSCodJustAnaliseFiscalCanc(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalTSCodJustAnaliseFiscalCanc valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalTSCodJustAnaliseFiscalCanc tipo : NFSeSefinNacionalTSCodJustAnaliseFiscalCanc.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
