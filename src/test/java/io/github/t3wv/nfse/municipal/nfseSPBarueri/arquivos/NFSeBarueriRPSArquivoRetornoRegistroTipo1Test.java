package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NFSeBarueriRPSArquivoRetornoRegistroTipo1Test {

    @Test
    void testFromLinhaAndToLinha() {
        final var linha = "144584810000000000000000PMB00302601562144";
        assertEquals(linha, new NFSeBarueriRPSArquivoRetornoRegistroTipo1().fromLinha(linha).toLinha());
    }
}