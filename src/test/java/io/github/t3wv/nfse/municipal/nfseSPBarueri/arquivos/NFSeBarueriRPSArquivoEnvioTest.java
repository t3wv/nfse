package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class NFSeBarueriRPSArquivoEnvioTest {

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
        final var expected = List.of("11234567PMB00412345678901", "92      000000000000000000000000000000");
        Assertions.assertEquals(
                expected,
                envio.toLinhas());
    }
}