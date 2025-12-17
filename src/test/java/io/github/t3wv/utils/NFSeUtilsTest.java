package io.github.t3wv.utils;

import io.github.t3wv.nacional.classes.nfsenacional.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class NFSeUtilsTest {

    @Disabled
    @Test
    public void testeFormatoDPSId() {
        final var dps = new NFSeSefinNacionalDPS().setInfDPS(new NFSeSefinNacionalInfDPS());
        dps.getInfDPS()
                .setCodigoMunicipioEmissao("1234567")
                .setSerie("7")
                .setNumeroDPS(123)
                .setPrestador(new NFSeSefinNacionalInfoPrestador().setCPF("00998264024"))
                .setTomador(new NFSeSefinNacionalInfoPessoa().setCPF("27415855043"))
                .setIntermediario(new NFSeSefinNacionalInfoPessoa().setCPF("60071397000"));

        // Testa os três tipos de emitente com cpf
        for (final var tipoEmitente : NFSeSefinNacionalInfDPSTipoEmitente.values()) {
            dps.getInfDPS().setTipoEmitente(tipoEmitente);
            final var idGerado = NFSeUtils.gerarDPSId(dps);
            dps.getInfDPS().setId(idGerado);
            switch (tipoEmitente) {
                case PRESTADOR:
                    Assertions.assertNotEquals("DPS123456720000099826402400007000000000000123", dps.getInfDPS().getId());
                    Assertions.assertEquals("DPS123456710000099826402400007000000000000123", dps.getInfDPS().getId());
                    break;
                case TOMADOR:
                    Assertions.assertNotEquals("DPS123456720002741585504300007000000000000123", dps.getInfDPS().getId());
                    Assertions.assertEquals("DPS123456710002741585504300007000000000000123", dps.getInfDPS().getId());
                    break;
                case INTERMEDIARIO:
                    Assertions.assertNotEquals("DPS123456720006007139700000007000000000000123", dps.getInfDPS().getId());
                    Assertions.assertEquals("DPS123456710006007139700000007000000000000123", dps.getInfDPS().getId());
                    break;
            }
        }

        dps.getInfDPS().getPrestador().setCNPJ("59179556000130");
        dps.getInfDPS().getTomador().setCNPJ("83041294000127");
        dps.getInfDPS().getIntermediario().setCNPJ("48177960000158");
        // Testa os três tipos de emitente com cnpj
        for (final var tipoEmitente : NFSeSefinNacionalInfDPSTipoEmitente.values()) {
            dps.getInfDPS().setTipoEmitente(tipoEmitente);
            final var idGerado = NFSeUtils.gerarDPSId(dps);
            dps.getInfDPS().setId(idGerado);
            switch (tipoEmitente) {
                case PRESTADOR:
                    Assertions.assertNotEquals("DPS123456715917955600013000007000000000000123", dps.getInfDPS().getId());
                    Assertions.assertEquals("DPS123456725917955600013000007000000000000123", dps.getInfDPS().getId());
                    break;
                case TOMADOR:
                    Assertions.assertNotEquals("DPS123456718304129400012700007000000000000123", dps.getInfDPS().getId());
                    Assertions.assertEquals("DPS123456728304129400012700007000000000000123", dps.getInfDPS().getId());
                    break;
                case INTERMEDIARIO:
                    Assertions.assertNotEquals("DPS123456714817796000015800007000000000000123", dps.getInfDPS().getId());
                    Assertions.assertEquals("DPS123456724817796000015800007000000000000123", dps.getInfDPS().getId());
                    break;
            }

        }
    }

    /**
     * Testa geração do ID de eventos de NFSe nacional.
     * Padrão do ID:
     * "PRE" + Chave de Acesso da NFSe (44) + Código do Evento (6) + Número do Pedido de Registro do Evento (3)
     */
    @Disabled
    @Test
    public void testeFormatoPedidoRegistroEventoId() {
        final var evento = new NFSeSefinNacionalPedRegEvt();
        Assertions.assertThrows(AssertionError.class, () -> NFSeUtils.gerarEventoId(evento));

        evento.setInfPedReg(new NFSeSefinNacionalInfPedReg().setChaveAcessoNFSE("12345123451234512134512345123451234512345123451234"));
        Assertions.assertThrows(AssertionError.class, () -> NFSeUtils.gerarEventoId(evento));

        evento.getInfPedReg().setNPedRegEvento("1");
        Assertions.assertThrows(AssertionError.class, () -> NFSeUtils.gerarEventoId(evento));

        evento.getInfPedReg().setEvento(new NFSeSefinNacionalInfPedRegTE101101());
        Assertions.assertEquals("PRE12345123451234512134512345123451234512345123451234101101001", NFSeUtils.gerarEventoId(evento));
    }
}
