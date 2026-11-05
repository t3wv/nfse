package io.github.t3wv.nfse.nacional.danfse;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalUF;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Testes das primitivas de texto do DANFSe e da resolução do nome dos municípios.
 */
class DanfseCanvasTest {

    @Test
    void deveCortarComReticenciasSoOQueNaoCabe() throws Exception {
        try (final var documento = new PDDocument()) {
            final var canvas = new DanfseCanvas(documento);
            Assertions.assertEquals("curto", canvas.caber("curto", 100f, 7f, false));
            final var cortado = canvas.caber("AVENIDA PROFESSOR OTHON GAMA D'ECA, 677, CENTRO, FLORIANÓPOLIS", 60f, 7f, false);
            Assertions.assertTrue(cortado.endsWith("..."));
            Assertions.assertTrue(canvas.largura(cortado, 7f, false) <= 60f);
            Assertions.assertFalse(cortado.contains(",..."), "reticências não vêm depois da vírgula");
        }
    }

    @Test
    void deveQuebrarTextoSemPerderCaracteres() throws Exception {
        try (final var documento = new PDDocument()) {
            final var canvas = new DanfseCanvas(documento);
            final var longo = "A".repeat(2000);
            final var linhas = canvas.quebrar(longo, 100f, 7f, false);
            Assertions.assertTrue(linhas.size() > 10);
            Assertions.assertEquals(longo, String.join("", linhas));
            linhas.forEach(linha -> Assertions.assertTrue(canvas.largura(linha, 7f, false) <= 100f));
            Assertions.assertEquals(List.of("um", "dois"), canvas.quebrar("um\ndois", 200f, 7f, false));
        }
    }

    @Test
    void deveManterAsPrimeirasLinhasEFecharComReticencias() throws Exception {
        try (final var documento = new PDDocument()) {
            final var canvas = new DanfseCanvas(documento);
            final var linhas = List.of("primeira linha", "segunda linha", "terceira linha");
            Assertions.assertEquals(linhas, canvas.cortarLinhas(linhas, 5, 200f, 7f));
            Assertions.assertEquals(List.of("primeira linha", "segunda linha..."), canvas.cortarLinhas(linhas, 2, 200f, 7f));
            Assertions.assertTrue(canvas.cortarLinhas(linhas, 0, 200f, 7f).isEmpty());
        }
    }

    @Test
    void deveTrocarPorInterrogacaoOsCaracteresForaDoWinAnsi() throws Exception {
        try (final var documento = new PDDocument()) {
            final var canvas = new DanfseCanvas(documento);
            Assertions.assertEquals("a?b", canvas.caber("a中b", 100f, 7f, false));
            Assertions.assertEquals("Ação nº 1", canvas.caber("Ação nº 1", 100f, 7f, false));
        }
    }

    @Test
    void deveDecodificarALogomarcaEmbutida() throws Exception {
        final var imagem = javax.imageio.ImageIO.read(new java.io.ByteArrayInputStream(DanfseLogomarca.PNG));
        Assertions.assertNotNull(imagem, "a logomarca em base64 deve ser um PNG legível");
        Assertions.assertEquals(540, imagem.getWidth());
        Assertions.assertEquals(107, imagem.getHeight());
        Assertions.assertTrue(imagem.getColorModel().hasAlpha(), "a logomarca tem fundo transparente");
    }

    @Test
    void naoDeveMisturarOMunicipioEmissorComOEnderecoDoEmitente() {
        // municipio emissor em Sao Paulo (cLocEmi 3550308 / xLocEmi "São Paulo"), endereco do emitente no Rio de Janeiro
        final var nfse = DanfseFixtures.nfse(DanfseFixtures.COMPLETA);
        nfse.getInfNFSe().getEmitente().getEnderNac().setCMun("3304557").setUF(NFSeSefinNacionalUF.RJ);
        final var nota = new DanfseNota(nfse);
        // nome e UF do cabecalho sao do mesmo municipio, o emissor
        Assertions.assertEquals("São Paulo / SP", DanfseCabecalho.municipio(nota));
        // o nome do municipio emissor nao e atribuido ao codigo do endereco do emitente
        Assertions.assertNull(nota.nomeMunicipio("3304557"));
        Assertions.assertEquals("3304557 / RJ", nota.municipioUf("3304557"));
    }

    @Test
    void deveUsarAUfDoEnderecoDoEmitenteSoSemOCodigoDoMunicipioEmissor() {
        final var nfse = DanfseFixtures.nfse(DanfseFixtures.COMPLETA);
        nfse.getInfNFSe().getDPS().getInfDPS().setCodigoMunicipioEmissao(null);
        Assertions.assertEquals("São Paulo / SP", DanfseCabecalho.municipio(new DanfseNota(nfse)));
    }

    @Test
    void deveUsarONomeDoMunicipioSoQuandoOXmlOInforma() {
        final var nota = DanfseFixtures.nota(DanfseFixtures.COMPLETA);
        Assertions.assertEquals("São Paulo / SP", nota.municipioUf("3550308"));
        Assertions.assertEquals("Campinas / SP", nota.municipioUf("3509502"));
        Assertions.assertEquals("3304557 / RJ", nota.municipioUf("3304557"));
        Assertions.assertEquals("-", nota.municipioUf(null));
    }
}
