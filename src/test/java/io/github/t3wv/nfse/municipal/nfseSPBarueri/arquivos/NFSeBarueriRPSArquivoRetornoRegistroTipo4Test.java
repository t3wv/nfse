package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NFSeBarueriRPSArquivoRetornoRegistroTipo4Test {

    @Test
    void testFromLinhaAndToLinha() {
        final var linha = "4VN000000000001025";
        assertEquals(linha, new NFSeBarueriRPSArquivoRetornoRegistroTipo4().fromLinha(linha).toLinha());
    }
}