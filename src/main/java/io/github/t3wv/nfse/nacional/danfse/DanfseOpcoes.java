package io.github.t3wv.nfse.nacional.danfse;

/**
 * Opções de impressão do DANFSe. Por padrão o DANFSe sai com o canhoto e sem marca d'água.
 */
public class DanfseOpcoes {

    private boolean canhoto = true;
    private DanfseSituacao situacao = DanfseSituacao.NORMAL;

    /**
     * @return true se o DANFSe é impresso com o canhoto (bloco opcional, item 2.1.13 da NT 008)
     */
    public boolean isCanhoto() {
        return canhoto;
    }

    /**
     * Define se o DANFSe é impresso com o canhoto. Sem ele, as informações complementares ocupam o espaço do bloco (item 2.3.3).
     *
     * @param canhoto true para imprimir o canhoto
     * @return as próprias opções
     */
    public DanfseOpcoes setCanhoto(final boolean canhoto) {
        this.canhoto = canhoto;
        return this;
    }

    /**
     * @return situação da NFS-e, que define a marca d'água
     */
    public DanfseSituacao getSituacao() {
        return situacao;
    }

    /**
     * Define a situação da NFS-e: canceladas e substituídas saem com a marca d'água "CANCELADA" ou "SUBSTITUÍDA" (itens 2.5.1 e
     * 2.5.2 da NT 008).
     *
     * @param situacao situação da NFS-e; null equivale a {@link DanfseSituacao#NORMAL}
     * @return as próprias opções
     */
    public DanfseOpcoes setSituacao(final DanfseSituacao situacao) {
        this.situacao = situacao == null ? DanfseSituacao.NORMAL : situacao;
        return this;
    }
}
