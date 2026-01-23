package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NFSeBarueriRPSArquivoEnvioRegistroTipo3Test {
    @Test
    void testFromLinhaAndToLinha() {
        final var linha = "304000000000000018";
        assertEquals(linha, new NFSeBarueriRPSArquivoEnvioRegistroTipo3().fromLinha(linha).toLinha());
    }
}