package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NFSeBarueriRPSArquivoRetornoRegistroTipo9Test {

    @Test
    void testFromLinhaAndToLinha() {
        final var linha = "90000004000000000011752000000000000000";
        assertEquals(linha, new NFSeBarueriRPSArquivoRetornoRegistroTipo9().fromLinha(linha).toLinha());
    }
}