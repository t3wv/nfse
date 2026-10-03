package io.github.t3wv.nfse.nacional.classes.nfsenacional;


import org.simpleframework.xml.Root;

/**
 * Situação da NFS-e (campo {@code cStat}, tipo {@code TStat} do XSD da NFS-e Nacional).
 *
 * @author Marcos Lombardi de Andrade
 */
@Root(name = "cStat")
public enum NFSeSefinNacionalInfNFSeSituacao {

    GERADA("100", "NFS-e Gerada"),
    DECISAO_JUDICIAL("102", "NFS-e de Decisão Judicial"),
    AVULSA("103", "NFS-e Avulsa"),
    MEI("107", "NFS-e MEI");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalInfNFSeSituacao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalInfNFSeSituacao valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalInfNFSeSituacao situacao : NFSeSefinNacionalInfNFSeSituacao.values()) {
            if (situacao.getCodigo().equals(codigo)) {
                return situacao;
            }
        }
        return null;
    }
}
