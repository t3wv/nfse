package io.github.t3wv.nfse.nacional.danfse;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * Testes das regras de valores da tributação federal e do IBS/CBS (item 2.4.5 da NT 008, versão 1.02).
 */
class DanfseTributosTest {

    private static DanfseNota nota(final NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao retencao) {
        final var nota = DanfseFixtures.nota(DanfseFixtures.COMPLETA);
        // vRetCSLL 100,00, vPis 65,00 e vCofins 300,00
        nota.pisCofins().setTipoRetencao(retencao);
        return nota;
    }

    @Test
    void deveSomarPisECofinsRetidosNasContribuicoesEZerarOsDebitosProprios() {
        final var nota = nota(NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao.PIS_COFINS_RETIDOS);
        Assertions.assertEquals(new BigDecimal("465.00"), DanfseTributos.contribuicoesSociaisRetidas(nota));
        Assertions.assertEquals(BigDecimal.ZERO, DanfseTributos.pisApuracaoPropria(nota));
        Assertions.assertEquals(BigDecimal.ZERO, DanfseTributos.cofinsApuracaoPropria(nota));
    }

    @Test
    void deveManterOsDebitosPropriosQuandoPisECofinsNaoSaoRetidos() {
        for (final var retencao : new NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao[]{NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao.NAO_RETIDOS,
                NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao.PIS_COFINS_NAO_RETIDOS, NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao.PIS_COFINS_NAO_RETIDOS_CSLL_RETIDO, null}) {
            final var nota = nota(retencao);
            Assertions.assertEquals(new BigDecimal("100.00"), DanfseTributos.contribuicoesSociaisRetidas(nota), String.valueOf(retencao));
            Assertions.assertEquals(new BigDecimal("65.00"), DanfseTributos.pisApuracaoPropria(nota), String.valueOf(retencao));
            Assertions.assertEquals(new BigDecimal("300.00"), DanfseTributos.cofinsApuracaoPropria(nota), String.valueOf(retencao));
        }
    }

    @Test
    void deveAplicarARetencaoTributoATributo() {
        final var soPis = nota(NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao.PIS_RETIDO_COFINS_CSLL_NAO_RETIDOS);
        Assertions.assertEquals(new BigDecimal("165.00"), DanfseTributos.contribuicoesSociaisRetidas(soPis));
        Assertions.assertEquals(BigDecimal.ZERO, DanfseTributos.pisApuracaoPropria(soPis));
        Assertions.assertEquals(new BigDecimal("300.00"), DanfseTributos.cofinsApuracaoPropria(soPis));

        final var soCofins = nota(NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao.PIS_NAO_RETIDO_COFINS_CSLL_NAO_RETIDOS);
        Assertions.assertEquals(new BigDecimal("400.00"), DanfseTributos.contribuicoesSociaisRetidas(soCofins));
        Assertions.assertEquals(new BigDecimal("65.00"), DanfseTributos.pisApuracaoPropria(soCofins));
        Assertions.assertEquals(BigDecimal.ZERO, DanfseTributos.cofinsApuracaoPropria(soCofins));

        final var todos = nota(NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao.RETIDOS);
        Assertions.assertEquals(new BigDecimal("465.00"), DanfseTributos.contribuicoesSociaisRetidas(todos));
    }

    @Test
    void deveIndicarOsTributosRetidosDeCadaTipoDeRetencao() {
        final var pisRetido = "13459";
        final var cofinsRetida = "13467";
        for (final var retencao : NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao.values()) {
            Assertions.assertEquals(pisRetido.contains(retencao.getCodigo()), retencao.isPisRetido(), retencao.getDescricao());
            Assertions.assertEquals(cofinsRetida.contains(retencao.getCodigo()), retencao.isCofinsRetido(), retencao.getDescricao());
        }
    }

    @Test
    void deveSemInformacaoQuandoNaoHaGrupoPisCofins() {
        final var nota = DanfseFixtures.nota(DanfseFixtures.MINIMA);
        Assertions.assertNull(DanfseTributos.contribuicoesSociaisRetidas(nota));
        Assertions.assertNull(DanfseTributos.pisApuracaoPropria(nota));
        Assertions.assertNull(DanfseTributos.cofinsApuracaoPropria(nota));
    }

    @Test
    void deveSomarAsExclusoesEReducoesDaBaseDoIbsCbs() {
        // vDescIncond 750,00 + vCalcAjusteBCIBSCBS 100,00 + vISSQN 175,00 + vPis 65,00 + vCofins 300,00
        Assertions.assertEquals(new BigDecimal("1390.00"), DanfseTributos.exclusoesEReducoes(DanfseFixtures.nota(DanfseFixtures.COMPLETA)));
    }

    @Test
    void deveUsarOAjusteDaLocacaoDeImoveisQuandoNaoHaAjusteDoIbsCbs() {
        // o vBC do IBS/CBS usa vCalcAjusteBCIBSCBS ou vCalcAjusteBCLocImoveis (subitem 99.03), nunca os dois
        final var nota = DanfseFixtures.nota(DanfseFixtures.COMPLETA);
        nota.ibsCbsNota().getValores().setvCalcAjusteBCIBSCBS(null).setvCalcAjusteBCLocImoveis(new BigDecimal("40.00"));
        Assertions.assertEquals(new BigDecimal("1330.00"), DanfseTributos.exclusoesEReducoes(nota));
    }

    @Test
    void deveIdentificarOperacaoNaoSujeitaAoIssqn() {
        Assertions.assertFalse(DanfseTributos.naoSujeitaAoIssqn(DanfseFixtures.nota(DanfseFixtures.COMPLETA)));
        Assertions.assertTrue(DanfseTributos.naoSujeitaAoIssqn(DanfseFixtures.nota(DanfseFixtures.MINIMA)));
    }
}
