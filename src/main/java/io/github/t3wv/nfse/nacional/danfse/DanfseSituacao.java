package io.github.t3wv.nfse.nacional.danfse;

/**
 * Situação da NFS-e no momento da impressão do DANFSe. O XML da NFS-e não traz o cancelamento nem a substituição, que são
 * eventos: quem gera o DANFSe informa a situação, e as NFS-e canceladas ou substituídas saem com a marca d'água dos itens
 * 2.5.1 e 2.5.2 da NT 008.
 */
public enum DanfseSituacao {

    NORMAL(null),
    CANCELADA("CANCELADA"),
    SUBSTITUIDA("SUBSTITUÍDA");

    private final String marcaDagua;

    DanfseSituacao(final String marcaDagua) {
        this.marcaDagua = marcaDagua;
    }

    /**
     * @return texto da marca d'água, ou null quando a NFS-e não leva marca d'água
     */
    public String getMarcaDagua() {
        return marcaDagua;
    }
}
