package io.github.t3wv.nfse.nacional.danfse;

/**
 * Opções de impressão do DANFSe. Por padrão o DANFSe sai com o canhoto e sem marca d'água.
 */
public class DanfseOpcoes {

    private boolean canhoto = true;
    private DanfseSituacao situacao = DanfseSituacao.NORMAL;
    private float margemSegurancaCm = 0f;

    /** Margem de segurança sugerida para impressoras que cortam o texto, parecida com a da DANFE. */
    public static final float MARGEM_SEGURANCA_SUGERIDA_CM = 0.70f;

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

    /**
     * @return distância, em cm, entre a borda do DANFSe e a beira do papel
     */
    public float getMargemSegurancaCm() {
        return margemSegurancaCm;
    }

    /**
     * Define a margem de segurança de impressão: a distância entre a borda do DANFSe e a beira do papel, para que a impressora
     * não corte o texto. O DANFSe é reduzido proporcionalmente para caber. O padrão é zero, que mantém o leiaute exato da NT 008
     * (borda a 0,18 cm do papel); {@value #MARGEM_SEGURANCA_SUGERIDA_CM} cm costuma evitar cortes na impressão.
     *
     * @param margemSegurancaCm margem em cm, de zero a 3
     * @return as próprias opções
     * @throws IllegalArgumentException se a margem for negativa ou maior que 3 cm
     */
    public DanfseOpcoes setMargemSegurancaCm(final float margemSegurancaCm) {
        if (!(margemSegurancaCm >= 0f && margemSegurancaCm <= 3f)) {
            throw new IllegalArgumentException("A margem de segurança deve estar entre 0 e 3 cm");
        }
        this.margemSegurancaCm = margemSegurancaCm;
        return this;
    }
}
