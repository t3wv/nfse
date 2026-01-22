package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NFSeBarueriRPSArquivoEnvioRegistroTipo2Test {

    @Test
    void testFromLinhaAndToLinha() {
        final var linha = "2RPS  A        000081665520260121104757E  0000000                                                                                                                                                                                                 99010120022Av. Presidente Kennedy                                                     568                                    CAMPINAS                                SAO JOSE                                SC88101000000001000000000010000     00000000000000020002203608600001369MSA EMPRESA CINEMATOGRAFICA LTDA                            AV ANTONIA ROSA FIORAVANTE                                                 3270     LOJA 127                      V FAUSTO N MORELLI                      Mau�                                    SP09390120teste@t3w.io                                                                                                                                                                                TRAI��O ENTRE AMIGAS: R$ 100,00||Teste Manual                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ";
        final var registro = new NFSeBarueriRPSArquivoEnvioRegistroTipo2().fromLinha(linha);
        assertEquals(NFSeBarueriRPSArquivoEnvioRegistroTipo2.TIPO_REGISTRO, registro.getTipoRegistro());
        //assertEquals("X", registro.get());
        assertEquals(linha, registro.toLinha());
    }
}