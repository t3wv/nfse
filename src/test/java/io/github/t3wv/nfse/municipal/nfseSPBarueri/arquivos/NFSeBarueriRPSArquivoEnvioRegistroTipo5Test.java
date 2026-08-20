package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NFSeBarueriRPSArquivoEnvioRegistroTipo5Test {

    @Test
    @Disabled
    void testFromLinhaAndToLinha() {
        final var linha = "5    00000000000000000000000000000000000000000000000000                                                                                                                                                              000 252398509000138T3w Tecnologia                                              R ELIZEU DI BERNARDI                                                       34       Sala 102                      Campinas                                Sao Jose                                3505708SC   88101050                                                                                                                                                                                               ";
        assertEquals(linha, new NFSeBarueriRPSArquivoEnvioRegistroTipo5().fromLinha(linha).toLinha());
    }
}
