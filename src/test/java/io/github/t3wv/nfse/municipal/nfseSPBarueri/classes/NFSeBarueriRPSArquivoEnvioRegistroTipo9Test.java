package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class NFSeBarueriRPSArquivoEnvioRegistroTipo9Test {
    @Test
    void testFromLinhaAndToLinha() {
        final var linha = "94      000000000010000000000000000000";
        final var registro = new NFSeBarueriRPSArquivoEnvioRegistroTipo9().fromLinha(linha);
        assertEquals(NFSeBarueriRPSArquivoEnvioRegistroTipo9.TIPO_REGISTRO, registro.getTipoRegistro());
        assertEquals(4, registro.getQuantidadeLinhas());
        assertEquals(new BigDecimal("100.00"), registro.getValorTotalServicos());
        assertEquals(new BigDecimal("0.00"), registro.getValorTotalServicsContidosRegistro3());
        assertEquals(linha, registro.toLinha());
    }
}