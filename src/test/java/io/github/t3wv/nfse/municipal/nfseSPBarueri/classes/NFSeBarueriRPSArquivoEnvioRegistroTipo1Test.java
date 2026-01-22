package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NFSeBarueriRPSArquivoEnvioRegistroTipo1Test {

    @Test
    void testFromLinhaAndToLinha() {
        final var linha = "14458481PMB00302602175865";
        final var registro = new NFSeBarueriRPSArquivoEnvioRegistroTipo1().fromLinha(linha);
        assertEquals(NFSeBarueriRPSArquivoEnvioRegistroTipo1.TIPO_REGISTRO, registro.getTipoRegistro());
        assertEquals("4458481", registro.getInscricaoContribuinte());
        assertEquals("PMB003", registro.getVersaoLayout());
        assertEquals("02602175865", registro.getIdentificacaoRemessaContribuinte());
        assertEquals(linha, registro.toLinha());
    }
}