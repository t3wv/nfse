package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class NFSeBarueriRPSArquivoEnvioTest {

//    @Test
//    void testMontaArquivoDasLinhas() {
//        final var envio = new NFSeBarueriRPSArquivoEnvio()
//                .addLinha("14458481PMB00302602139135")
//                .addLinha("2RPS  A        000081665520260121104757E  0000000                                                                                                                                                                                                 99010120022Av. Presidente Kennedy                                                     568                                    CAMPINAS                                SAO JOSE                                SC88101000000001000000000010000     00000000000000020002203608600001369MSA EMPRESA CINEMATOGRAFICA LTDA                            AV ANTONIA ROSA FIORAVANTE                                                 3270     LOJA 127                      V FAUSTO N MORELLI                      Mau�                                    SP09390120teste@t3w.io                                                                                                                                                                                TRAI��O ENTRE AMIGAS: R$ 100,00||Teste Manual                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ")
//                .addLinha("41    35294013529401                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             0 ")
//                .addLinha("94      000000000010000000000000000000");
//        Assertions.assertEquals(
//                "14458481PMB00302602139135" + WSBarueri.CHR13 + WSBarueri.CHR10 +
//                "2RPS  A        000081665520260121104757E  0000000                                                                                                                                                                                                 99010120022Av. Presidente Kennedy                                                     568                                    CAMPINAS                                SAO JOSE                                SC88101000000001000000000010000     00000000000000020002203608600001369MSA EMPRESA CINEMATOGRAFICA LTDA                            AV ANTONIA ROSA FIORAVANTE                                                 3270     LOJA 127                      V FAUSTO N MORELLI                      Mau�                                    SP09390120teste@t3w.io                                                                                                                                                                                TRAI��O ENTRE AMIGAS: R$ 100,00||Teste Manual                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           " + WSBarueri.CHR13 + WSBarueri.CHR10 +
//                "41    35294013529401                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             0 " + WSBarueri.CHR13 + WSBarueri.CHR10 +
//                "94      000000000010000000000000000000" + WSBarueri.CHR13 + WSBarueri.CHR10,
//                envio.toString());
//    }

    @Test
    void testMontaArquivo() {
        final var envio = new NFSeBarueriRPSArquivoEnvio()
                .addRegistro(new NFSeBarueriRPSArquivoEnvioRegistroTipo1()
                        .setInscricaoContribuinte("12345678909")
                        .setVersaoLayout("PMB004")
                        .setIdentificacaoRemessaContribuinte("12345678901"))
                .addRegistro(new NFSeBarueriRPSArquivoEnvioRegistroTipo9()
                        .setQuantidadeLinhas(2)
                        .setValorTotalServicos(BigDecimal.ZERO)
                        .setValorTotalServicosContidosRegistro3(BigDecimal.ZERO));
        final var expected = List.of("112345678909PMB00412345678901", "92      000000000000000000000000000000");
        Assertions.assertEquals(
                expected,
                envio.toLinhas());
    }
}