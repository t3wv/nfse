package io.github.t3wv.nfse.nacional.danfse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * Testes das formatações do DANFSe (item 2.4.5 da NT 008).
 */
class DanfseFormatadorTest {

    @Test
    void deveNormalizarEspacosEQuebrasDeLinhaDoXml() {
        Assertions.assertEquals("", DanfseFormatador.texto(null));
        Assertions.assertEquals("Vingança S/A, Salic", DanfseFormatador.texto("  Vingança\n                S/A,\tSalic \r\n"));
    }

    @Test
    void deveUsarTracoNosCamposSemInformacao() {
        Assertions.assertEquals("-", DanfseFormatador.ouTraco(null));
        Assertions.assertEquals("-", DanfseFormatador.ouTraco("   "));
        Assertions.assertEquals("abc", DanfseFormatador.ouTraco(" abc "));
        Assertions.assertEquals("-", DanfseFormatador.valor(null));
        Assertions.assertEquals("-", DanfseFormatador.percentual(null));
        Assertions.assertEquals("-", DanfseFormatador.data(null));
        Assertions.assertEquals("-", DanfseFormatador.dataHora(null));
        Assertions.assertEquals("-", DanfseFormatador.documento(null));
        Assertions.assertEquals("-", DanfseFormatador.documento(" "));
    }

    @Test
    void deveLimitarAQuantidadeDeCaracteresComReticencias() {
        Assertions.assertEquals("abcde", DanfseFormatador.limitar("abcde", 5));
        Assertions.assertEquals("ab...", DanfseFormatador.limitar("abcdef", 5));
        Assertions.assertEquals(80, DanfseFormatador.limitar("x".repeat(200), 80).length());
        // as reticencias nao vem depois de um separador
        Assertions.assertEquals("RUA A...", DanfseFormatador.limitar("RUA A, 123, CENTRO", 9));
    }

    @Test
    void deveFormatarDocumentos() {
        Assertions.assertEquals("11.222.333/0001-81", DanfseFormatador.cnpjOuCpf("11222333000181"));
        Assertions.assertEquals("12.ABC.345/01DE-35", DanfseFormatador.cnpjOuCpf("12ABC34501DE35"));
        Assertions.assertEquals("529.982.247-25", DanfseFormatador.cnpjOuCpf("52998224725"));
        Assertions.assertEquals("NIF-123", DanfseFormatador.cnpjOuCpf("NIF-123"));
    }

    @Test
    void deveIdentificarODocumentoPeloDigitoVerificador() {
        Assertions.assertEquals("12.345.678/0001-95", DanfseFormatador.documento("12345678000195"));
        Assertions.assertEquals("12.ABC.345/01DE-35", DanfseFormatador.documento("12ABC34501DE35"), "CNPJ alfanumérico");
        Assertions.assertEquals("529.982.247-25", DanfseFormatador.documento("52998224725"));
        Assertions.assertEquals("NIF-123", DanfseFormatador.documento("NIF-123"));
        // NIF estrangeiro com o comprimento de CPF ou CNPJ, mas sem os digitos verificadores validos: sai como informado
        Assertions.assertEquals("12345678901", DanfseFormatador.documento("12345678901"));
        Assertions.assertEquals("12345678000199", DanfseFormatador.documento("12345678000199"));
        // sequencias repetidas fecham o modulo 11, mas nao sao documentos
        Assertions.assertEquals("00000000000", DanfseFormatador.documento("00000000000"));
        Assertions.assertEquals("00000000000000", DanfseFormatador.documento("00000000000000"));
        Assertions.assertEquals(40, DanfseFormatador.documento("N".repeat(60)).length());
    }

    @Test
    void deveFormatarCepTelefoneECodigos() {
        Assertions.assertEquals("88.015-240", DanfseFormatador.cep("88015240"));
        Assertions.assertEquals("(48) 3035-9700", DanfseFormatador.telefone("4830359700"));
        Assertions.assertEquals("(11) 98765-4321", DanfseFormatador.telefone("11987654321"));
        Assertions.assertEquals("(11) 98765-4321", DanfseFormatador.telefone("5511987654321"));
        Assertions.assertEquals("(48) 9178-3009", DanfseFormatador.telefone("4891783009"), "celular no formato antigo, sem o nono dígito");
        Assertions.assertEquals("(48) 9178-3009", DanfseFormatador.telefone("554891783009"));
        Assertions.assertEquals("13055550100", DanfseFormatador.telefone("13055550100"), "telefone do exterior fica sem máscara");
        Assertions.assertEquals("-", DanfseFormatador.telefone(null));
        Assertions.assertEquals("35.01.02", DanfseFormatador.codigoTributacaoNacional("350102"));
        Assertions.assertEquals("1.1401.31.00", DanfseFormatador.nbs("114013100"));
        Assertions.assertEquals("-", DanfseFormatador.nbs(null));
    }

    @Test
    void deveObterAUfPeloCodigoIbgeDoMunicipio() {
        Assertions.assertEquals("SC", DanfseFormatador.uf("4205407"));
        Assertions.assertEquals("TO", DanfseFormatador.uf("1721000"));
        Assertions.assertEquals("DF", DanfseFormatador.uf("5300108"));
        Assertions.assertEquals("", DanfseFormatador.uf("9999999"));
        Assertions.assertEquals("", DanfseFormatador.uf(null));
    }

    @Test
    void deveFormatarValoresEPercentuais() {
        Assertions.assertEquals("R$ 90.000,00", DanfseFormatador.valor(new BigDecimal("90000.00")));
        Assertions.assertEquals("R$ 0,00", DanfseFormatador.valor(BigDecimal.ZERO));
        Assertions.assertEquals("R$ 1.234.567,89", DanfseFormatador.valor(new BigDecimal("1234567.89")));
        Assertions.assertEquals("5,00 %", DanfseFormatador.percentual(new BigDecimal("5")));
        Assertions.assertEquals("0,10 %", DanfseFormatador.percentual(new BigDecimal("0.10")));
    }

    @Test
    void deveFormatarDatasEChave() {
        Assertions.assertEquals("15/10/2026", DanfseFormatador.data(LocalDate.of(2026, 10, 15)));
        Assertions.assertEquals("15/10/2026 08:16:21", DanfseFormatador.dataHora(ZonedDateTime.of(2026, 10, 15, 8, 16, 21, 0, ZoneOffset.ofHours(-3))));
        Assertions.assertEquals("4205407", DanfseFormatador.chaveAcesso("NFS4205407"));
        Assertions.assertEquals("Intermediário", DanfseFormatador.primeiraMaiuscula("intermediário"));
    }
}
