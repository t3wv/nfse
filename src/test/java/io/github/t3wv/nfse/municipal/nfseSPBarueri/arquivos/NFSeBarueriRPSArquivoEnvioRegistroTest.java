package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class NFSeBarueriRPSArquivoEnvioRegistroTest {

    @Test
    void testTrataString() {
        assertEquals("Teste      ", NFSeBarueriRPSArquivoEnvioRegistro.trataString("Teste", 11));
        assertEquals("Teste", NFSeBarueriRPSArquivoEnvioRegistro.trataString("TesteExcedente", 5));
        assertEquals("          ", NFSeBarueriRPSArquivoEnvioRegistro.trataString(null, 10));
    }

    @Test
    void testTrataNumerico() {
        assertEquals("0000000123", NFSeBarueriRPSArquivoEnvioRegistro.trataNumerico(123, 10));
        assertEquals("0000100100", NFSeBarueriRPSArquivoEnvioRegistro.trataNumerico(new BigDecimal("1001"), 10));
        assertEquals("1000", NFSeBarueriRPSArquivoEnvioRegistro.trataNumerico(BigDecimal.TEN, 4));
        assertEquals("100", NFSeBarueriRPSArquivoEnvioRegistro.trataNumerico(BigDecimal.ONE, 3));
        assertEquals("0000100", NFSeBarueriRPSArquivoEnvioRegistro.trataNumerico(BigDecimal.ONE, 7));
        assertEquals("000123445", NFSeBarueriRPSArquivoEnvioRegistro.trataNumerico(new BigDecimal("1234.44678032"), 9));
        assertEquals("0000000123456", NFSeBarueriRPSArquivoEnvioRegistro.trataNumerico(123456, 13));
        assertEquals("00000001000000023456", NFSeBarueriRPSArquivoEnvioRegistro.trataNumerico(1000000023456L, 20));
        assertEquals("00000000000000000000", NFSeBarueriRPSArquivoEnvioRegistro.trataNumerico("1000000023456L", 20));
    }

    @Test
    void testToLinhaRegistrosAlterados() {
        final var registroUm = new NFSeBarueriRPSArquivoEnvioRegistroTipo1().fromLinha("14458481PMB00302602175865");
        assertEquals("10099000PMB00302602175865", registroUm.setInscricaoContribuinte("00990001000000023456000000010000000234560000000100000002345600000001000000023456000000010000000234560000000100000002345600000001000000023456000000010000000234560000000100000002345600000001000000023456").toLinha());
        final var registroDois = new NFSeBarueriRPSArquivoEnvioRegistroTipo2().fromLinha("2RPS           000006224120260123171721E                                                                                                                                                                                                          99010120022AV PRESIDENTE KENNEDY                                                      568      SALA 902                      CAMPINAS                                SAO JOSE                                SC88101050000001000000000001000     00000000000000020002252398509000138T3W TECNOLOGIA LTDA                                         RUA                                                                        NUMERO   COMPLEMENTO                   BAIRRO                                  SAO JOSE                                SC88101050DIEGO@T3W.IO                                                                                                                                                                                TESTE DE EMISSAO E CANCELAMENTO                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         ");
        registroDois.setEnderecoComplementoTomador("009900010000000234560000000100000002345600000001000000023456000000010000000234560000000100000002345600000001000000023456000000010000000234560000000100000002345600000001000000023456000000010000000234560099000100000002345600000001000000023456000000010000000234560000000100000002345600000001000000023456000000010000000234560000000100000002345600000001000000023456000000010000000234560000000100000002345600990001000000023456000000010000000234560000000100000002345600000001000000023456000000010000000234560000000100000002345600000001000000023456000000010000000234560000000100000002345600000001000000023456");
        registroDois.setDescricaoCancelamento("Teste teste teste AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA BBBBBBBBBBBBBBBBBBBBBBBBBBBB CCCCCCCCCCCCCCCCCCCCCCCC009900010000000234560000000100000002345600000001000000023456000000010000000234560000000100000002345600000001000000023456000000010000000234560000000100000002345600000001000000023456000000010000000234560099000100000002345600000001000000023456000000010000000234560000000100000002345600000001000000023456000000010000000234560000000100000002345600000001000000023456000000010000000234560000000100000002345600990001000000023456000000010000000234560000000100000002345600000001000000023456000000010000000234560000000100000002345600000001000000023456000000010000000234560000000100000002345600000001000000023456");
        assertEquals("2RPS           000006224120260123171721E                      Teste teste teste AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA BBBBBBBBBBBBBBBBBBBBBBBBBBBB CCCCCCCCCCCCCCCCCCCCCCCC0099000100000002345600000001000000023456000000010000000234560000000100000002399010120022AV PRESIDENTE KENNEDY                                                      568      SALA 902                      CAMPINAS                                SAO JOSE                                SC88101050000001000000000001000     00000000000000020002252398509000138T3W TECNOLOGIA LTDA                                         RUA                                                                        NUMERO   009900010000000234560000000100BAIRRO                                  SAO JOSE                                SC88101050DIEGO@T3W.IO                                                                                                                                                                                TESTE DE EMISSAO E CANCELAMENTO                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         ", registroDois.toLinha());
        assertEquals(NFSeBarueriRPSArquivoEnvioRegistro.ULTIMO_CARACTERE_VALIDO_LINHA_ANTES_ERROS, registroDois.toLinha().length());
    }
}