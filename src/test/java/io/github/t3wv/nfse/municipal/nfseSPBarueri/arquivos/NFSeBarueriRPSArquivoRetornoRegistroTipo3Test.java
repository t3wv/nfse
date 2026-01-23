package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NFSeBarueriRPSArquivoRetornoRegistroTipo3Test {

    @Test
    void testFromLinhaAndToLinha() {
        final var linha = "3000001Análise e desenvolvimento de sistemas.                      0101012200000000000117520200";
        assertEquals(linha, new NFSeBarueriRPSArquivoRetornoRegistroTipo3().fromLinha(linha).toLinha());
    }
}