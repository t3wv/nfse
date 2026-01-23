package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriRetornoErros;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NFSeBarueriRPSArquivoEnvioRegistroTipo9Test {
    @Test
    void testFromLinhaAndToLinha() {
        final var linha = "94      000000000010000000000000000000";
        final var registro = new NFSeBarueriRPSArquivoEnvioRegistroTipo9().fromLinha(linha);
        assertEquals(NFSeBarueriRPSArquivoEnvioRegistroTipo9.TIPO_REGISTRO, registro.getTipoRegistro());
        assertEquals(4, registro.getQuantidadeLinhas());
        assertEquals(new BigDecimal("100.00"), registro.getValorTotalServicos());
        assertEquals(new BigDecimal("0.00"), registro.getValorTotalServicosContidosRegistro3());
        assertEquals(linha, registro.toLinha());
    }

    @Test
    void testFromLinhaComErros() {
        final var linha = "92      000000000001000000000000000000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            800;601;";
        assertEquals(List.of(NFSeBarueriRetornoErros.ERRO_800,NFSeBarueriRetornoErros.ERRO_601), new NFSeBarueriRPSArquivoEnvioRegistroTipo9().fromLinha(linha).getErros());
    }
}