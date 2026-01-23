package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriRetornoErros;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NFSeBarueriRPSArquivoEnvioRegistroTipo2Test {

    @Test
    void testFromLinhaAndToLinha() {
        final var linha = "2RPS           000006224120260123171721E                                                                                                                                                                                                          99010120022AV PRESIDENTE KENNEDY                                                      568      SALA 902                      CAMPINAS                                SAO JOSE                                SC88101050000001000000000001000     00000000000000020002252398509000138T3W TECNOLOGIA LTDA                                         RUA                                                                        NUMERO   COMPLEMENTO                   BAIRRO                                  SAO JOSE                                SC88101050DIEGO@T3W.IO                                                                                                                                                                                TESTE DE EMISSAO E CANCELAMENTO                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         ";
        assertEquals(linha, new NFSeBarueriRPSArquivoEnvioRegistroTipo2().fromLinha(linha).toLinha());
    }
}