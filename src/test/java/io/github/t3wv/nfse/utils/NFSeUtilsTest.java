package io.github.t3wv.nfse.utils;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class NFSeUtilsTest {

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

        evento.getInfPedReg().setEvento(new NFSeSefinNacionalInfPedRegTE101101());
        Assertions.assertEquals("PRE12345123451234512134512345123451234512345123451234101101001", NFSeUtils.gerarEventoId(evento));
    }

    @Test
    public void deveRejeitarCnpjNulo() {
        Assertions.assertFalse(NFSeUtils.isCnpjValido(null));
    }

    @Test
    public void deveRejeitarCnpjVazio() {
        Assertions.assertFalse(NFSeUtils.isCnpjValido(""));
    }

    @Test
    public void deveRejeitarCnpjComTodosDigitosIguais() {
        Assertions.assertFalse(NFSeUtils.isCnpjValido("00000000000000"));
        Assertions.assertFalse(NFSeUtils.isCnpjValido("11111111111111"));
    }

    @Test
    public void deveValidarCnpjNumericoTradicional() {
        Assertions.assertTrue(NFSeUtils.isCnpjValido("03918609000132"));
        Assertions.assertTrue(NFSeUtils.isCnpjValido("11222333000181"));
    }

    @Test
    public void deveRejeitarCnpjNumericoComDigitoInvalido() {
        Assertions.assertFalse(NFSeUtils.isCnpjValido("03918609000199"));
        Assertions.assertFalse(NFSeUtils.isCnpjValido("11222333000100"));
    }

    @Test
    public void deveRejeitarCnpjComTamanhoInvalido() {
        Assertions.assertFalse(NFSeUtils.isCnpjValido("0391860900013"));
        Assertions.assertFalse(NFSeUtils.isCnpjValido("039186090001322"));
    }

    @Test
    public void deveRejeitarCnpjComCaracteresEspeciais() {
        Assertions.assertFalse(NFSeUtils.isCnpjValido("03.918.609/0001-32"));
    }

    @Test
    public void deveValidarCnpjAlfanumerico() {
        Assertions.assertTrue(NFSeUtils.isCnpjValido("12ABC34501DE35"));
        Assertions.assertTrue(NFSeUtils.isCnpjValido("12abc34501de35"));
    }

    @Test
    public void deveValidarCnpjAlfanumericoCaseInsensitive() {
        Assertions.assertTrue(NFSeUtils.isCnpjValido("12abc34501de35"));
    }

    @Test
    public void deveRejeitarCnpjAlfanumericoComDigitoInvalido() {
        Assertions.assertFalse(NFSeUtils.isCnpjValido("12ABC34501DE99"));
    }

    @Test
    public void deveRejeitarCnpjComLetraNosDigitosVerificadores() {
        Assertions.assertFalse(NFSeUtils.isCnpjValido("12ABC34501DEAB"));
    }

    @Test
    public void deveValidarCnpjNumericoCompleto() {
        // Testa CNPJs numéricos válidos tradicionais
        Assertions.assertTrue(NFSeUtils.isCnpjValido("11222333000181"));
        Assertions.assertTrue(NFSeUtils.isCnpjValido("03918609000132"));
        Assertions.assertTrue(NFSeUtils.isCnpjValido("00000000000191"));
    }

    @Test
    public void deveValidarFormatoCnpjMixtoAlfanumerico() {
        // Testa CNPJs alfanuméricos válidos (incluindo cálculo de dígitos verificadores)
        Assertions.assertTrue(NFSeUtils.isCnpjValido("A1B2C3D4E5F668"));
        Assertions.assertTrue(NFSeUtils.isCnpjValido("123456ABCDEF66"));
    }

    @Test
    public void deveRejeitarCnpjAlfanumericoComCaracteresInvalidos() {
        // Testa rejeição de caracteres especiais
        Assertions.assertFalse(NFSeUtils.isCnpjValido("0JRXDN7G0001@5"));
        Assertions.assertFalse(NFSeUtils.isCnpjValido("0JRXDN7G-00175"));
        Assertions.assertFalse(NFSeUtils.isCnpjValido("0JRXDN7G 00175"));
    }

    @Test
    public void deveRejeitarCnpjComLetraMinusculaNosDigitosVerificadores() {
        // Os últimos 2 caracteres devem ser sempre numéricos
        Assertions.assertFalse(NFSeUtils.isCnpjValido("0JRXDN7G0001a5"));
        Assertions.assertFalse(NFSeUtils.isCnpjValido("0JRXDN7G00017b"));
    }

    @Test
    public void isCPFValido() {
        Assertions.assertFalse(NFSeUtils.isCpfValido(null));
        Assertions.assertFalse(NFSeUtils.isCpfValido(""));
        Assertions.assertFalse(NFSeUtils.isCpfValido("00000000000"));
        Assertions.assertFalse(NFSeUtils.isCpfValido("11111111111"));
        Assertions.assertFalse(NFSeUtils.isCpfValido("12345678909"));
        Assertions.assertTrue(NFSeUtils.isCpfValido("38883975022"));
    }
}
