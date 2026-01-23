package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NFSeBarueriRPSArquivoEnvioRegistroTipo4Test {

    @Test
    void testFromLinhaAndToLinha() {
        final var linha = "41    35294013529401                                        000000000                                                                                                                                                                                                                                                                                                                                                                                                                                                             00000000000000000";
        assertEquals(linha, new NFSeBarueriRPSArquivoEnvioRegistroTipo4().fromLinha(linha).toLinha());
    }
}