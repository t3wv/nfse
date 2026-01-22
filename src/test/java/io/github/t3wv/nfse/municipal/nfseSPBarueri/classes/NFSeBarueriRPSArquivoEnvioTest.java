package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.WSBarueri;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class NFSeBarueriRPSArquivoEnvioTest {

    @Test
    void testMontaArquivo() {
        final var envio = new NFSeBarueriRPSArquivoEnvio()
                .addLinha(new NFSeBarueriRPSArquivoEnvioRegistroTipo1()
                        .setInscricaoContribuinte("12345678909")
                        .setVersaoLayout("PMB004")
                        .setIdentificacaoRemessaContribuinte("12345678901"))
                .addLinha(new NFSeBarueriRPSArquivoEnvioRegistroTipo9()
                        .setQuantidadeLinhas(2)
                        .setValorTotalServicos(BigDecimal.ZERO)
                        .setValorTotalServicsContidosRegistro3(BigDecimal.ZERO))
                .toString();
        Assertions.assertEquals(
                "112345678909PMB00412345678901" + WSBarueri.CHR13 + WSBarueri.CHR10 +
                "92      000000000000000000000000000000" + WSBarueri.CHR13 + WSBarueri.CHR10,
                envio);
    }
}