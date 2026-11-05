package io.github.t3wv.nfse.nacional.danfse;

import java.util.Base64;

/**
 * Logomarca da NFS-e impressa no canto esquerdo do cabeçalho do DANFSe (item 2.4.3 da NT 008): PNG com transparência, de
 * 540 x 107 pixels, embutido em base64 para não depender de arquivos de recurso.
 */
final class DanfseLogomarca {

    /** Bytes do PNG da logomarca. */
    static final byte[] PNG = Base64.getMimeDecoder().decode("""
            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""");

    /**
     * Classe utilitária, não deve ser instanciada.
     */
    private DanfseLogomarca() {
    }
}
