package io.github.t3wv.nfse.nacional.danfse;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalTribTotalPercent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * Testes das informações complementares e dos totais aproximados dos tributos (item 2.4.5 da NT 008, notas 7 a 10).
 */
class DanfseRodapeTest {

    @Test
    void deveJuntarAsInformacoesNaOrdemDaNtSeparadasPorPipes() {
        final var informacoes = DanfseRodape.informacoes(DanfseFixtures.nota(DanfseFixtures.COMPLETA));
        Assertions.assertTrue(informacoes.startsWith("Inf. Cont.: Pagamento em 30 dias. | NFS-e Subst.: "));
        Assertions.assertTrue(informacoes.endsWith(" | Inf. A. T. Mun.: Informação de uso da administração tributária municipal."));
        Assertions.assertTrue(informacoes.indexOf("Cod. Obra:") < informacoes.indexOf("Insc. Imob.:"));
        Assertions.assertTrue(informacoes.indexOf("Núm. Ped.:") < informacoes.indexOf("Item Ped.: 10, 20"));
    }

    @Test
    void deveInformarOCodigoDaAtividadeDeEventoDepoisDaInscricaoImobiliaria() throws Exception {
        final var xml = DanfseFixtures.xml(DanfseFixtures.COMPLETA).replace("</obra>",
                "</obra><atvEvento><xNome>Show de rock</xNome><dtIni>2026-09-10</dtIni><dtFim>2026-09-12</dtFim><idAtvEvt>EVT-2026-001</idAtvEvt></atvEvento>");
        final var nfse = new io.github.t3wv.nfse.utils.NFSePersister().read(io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalNFSe.class, xml);
        final var informacoes = DanfseRodape.informacoes(new DanfseNota(nfse));
        Assertions.assertTrue(informacoes.contains("Insc. Imob.: 000.111.222-3 | Cod. Evt.: EVT-2026-001 | Doc. Tec.: ART-2026-0001"), informacoes);
    }

    @Test
    void deveDeixarAsInformacoesVaziasQuandoANotaNaoTemNenhuma() {
        Assertions.assertEquals("", DanfseRodape.informacoes(DanfseFixtures.nota(DanfseFixtures.MINIMA)));
    }

    @Test
    void deveLimitarAsInformacoesA2000Caracteres() {
        final var nota = DanfseFixtures.nota(DanfseFixtures.COMPLETA);
        nota.dps().getServicoPrestado().getInformacoesComplementares().setInformacoesComplementares("x".repeat(3000));
        final var informacoes = DanfseRodape.informacoes(nota);
        Assertions.assertEquals(2000, informacoes.length());
        Assertions.assertTrue(informacoes.endsWith("..."));
    }

    @Test
    void deveInformarOsTotaisAproximadosEmValoresOuPercentuais() {
        final var prefixo = "Totais Aproximados dos Tributos cfe. Lei nº 12.741/2012: ";
        final var nota = DanfseFixtures.nota(DanfseFixtures.COMPLETA);
        Assertions.assertEquals(prefixo + "Federais: R$ 1.234,56; Estaduais: R$ 0,00; Municipais: R$ 175,00", DanfseRodape.totaisAproximados(nota));

        nota.totTrib().setValorTotalTributos(null).setPercentualTotalTributos(new NFSeSefinNacionalTribTotalPercent()
                .setPercentualTributosFederais(new BigDecimal("11.33")).setPercentualTributosEstaduais(BigDecimal.ZERO)
                .setPercentualTributosMunicipais(new BigDecimal("5")));
        Assertions.assertEquals(prefixo + "Federais: 11,33 %; Estaduais: 0,00 %; Municipais: 5,00 %", DanfseRodape.totaisAproximados(nota));

        nota.totTrib().setPercentualTotalTributos(null).setPercentualTotalSimplesNacional(new BigDecimal("6.00"));
        Assertions.assertEquals(prefixo + "Simples Nacional: 6,00 %", DanfseRodape.totaisAproximados(nota));

        Assertions.assertEquals(prefixo + "Federais: -; Estaduais: -; Municipais: -", DanfseRodape.totaisAproximados(DanfseFixtures.nota(DanfseFixtures.MINIMA)));
    }
}
