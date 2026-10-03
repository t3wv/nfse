package io.github.t3wv.nfse.nacional.classes.nfsenacional;


import org.simpleframework.xml.Root;

/**
 * Ambiente gerador da NFS-e (campo {@code ambGer}, tipo {@code TSAmbGeradorNFSe} do XSD da NFS-e Nacional).
 *
 * @author Marcos Lombardi de Andrade
 */
@Root(name = "ambGer")
public enum NFSeSefinNacionalInfNFSeAmbienteGeracao {

    PREFEITURA("1", "Prefeitura"),
    SISTEMA_NACIONAL("2", "Sistema Nacional da NFS-e");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalInfNFSeAmbienteGeracao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalInfNFSeAmbienteGeracao valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalInfNFSeAmbienteGeracao tipo : NFSeSefinNacionalInfNFSeAmbienteGeracao.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
