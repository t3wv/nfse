package io.github.t3wv.nfse.nacional.danfse;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import io.github.t3wv.nfse.nacional.WSFacade;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalInfoIBSCBSIndDest;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalNFSe;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.CM;

/**
 * Testes de {@link NFSeGeraDanfse}: entrada, página única, conteúdo dos blocos, supressões, canhoto, marca d'água e QR Code.
 */
class NFSeGeraDanfseTest {

    private static final String CHAVE = "35503082211222333000181000000000123426091234567895";

    private final NFSeGeraDanfse gerador = new NFSeGeraDanfse();

    @Test
    void deveLancarExcecaoParaXmlNuloOuVazio() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar((String) null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar("   "));
    }

    @Test
    void deveRejeitarXmlQueNaoEDeNfse() {
        final var e = Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar("<DPS xmlns=\"http://www.sped.fazenda.gov.br/nfse\"/>"));
        Assertions.assertTrue(e.getMessage().contains("NFSe"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar("<nfeProc versao=\"4.00\"/>"));
    }

    @Test
    void deveRejeitarXmlMalformado() {
        final var e = Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar("<NFSe><infNFSe>"));
        Assertions.assertEquals("XML da NFS-e inválido", e.getMessage());
    }

    @Test
    void deveRejeitarNfseNulaOuSemGruposObrigatorios() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar((NFSeSefinNacionalNFSe) null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar(new NFSeSefinNacionalNFSe()));
        final var semDps = DanfseFixtures.nfse(DanfseFixtures.COMPLETA);
        semDps.getInfNFSe().setDPS(null);
        Assertions.assertThrows(IllegalArgumentException.class, () -> gerador.gerar(semDps));
    }

    @Test
    void deveGerarUmaUnicaPaginaA4EmQualquerCombinacaoDeOpcoes() throws Exception {
        for (final var nome : new String[]{DanfseFixtures.COMPLETA, DanfseFixtures.MINIMA}) {
            for (final var situacao : DanfseSituacao.values()) {
                for (final var canhoto : new boolean[]{true, false}) {
                    final var pdf = gerador.gerar(DanfseFixtures.xml(nome), new DanfseOpcoes().setSituacao(situacao).setCanhoto(canhoto));
                    Assertions.assertEquals("%PDF", new String(pdf, 0, 4, StandardCharsets.US_ASCII));
                    try (final var documento = Loader.loadPDF(pdf)) {
                        Assertions.assertEquals(1, documento.getNumberOfPages(), nome + " " + situacao + " " + canhoto);
                        Assertions.assertEquals(PDRectangle.A4.getWidth(), documento.getPage(0).getMediaBox().getWidth(), 0.01);
                        Assertions.assertEquals(PDRectangle.A4.getHeight(), documento.getPage(0).getMediaBox().getHeight(), 0.01);
                    }
                }
            }
        }
    }

    @Test
    void deveImprimirOCabecalhoEAIdentificacaoDaNfse() {
        final var texto = DanfseFixtures.texto(gerador.gerar(DanfseFixtures.xml(DanfseFixtures.COMPLETA)));
        Assertions.assertTrue(texto.contains("DANFSe v2.0"));
        Assertions.assertTrue(texto.contains("Documento Auxiliar da NFS-e"));
        Assertions.assertTrue(texto.contains("NFS-e SEM VALIDADE JURÍDICA"));
        Assertions.assertTrue(texto.contains("Município: São Paulo / SP"));
        Assertions.assertTrue(texto.contains("Ambiente Gerador: 2"));
        Assertions.assertTrue(texto.contains("Tipo de Ambiente: 2"));
        Assertions.assertTrue(texto.contains(CHAVE));
        Assertions.assertTrue(texto.contains("15/09/2026 10:20:30"));
        Assertions.assertTrue(texto.contains("15/09/2026 10:15:00"));
        Assertions.assertTrue(texto.contains("NFS-e Gerada"));
        Assertions.assertTrue(texto.contains("NFS-e Regular"));
        Assertions.assertTrue(texto.contains("A autenticidade desta NFS-e pode ser verificada"));
    }

    @Test
    void deveImprimirOsParticipantes() {
        final var texto = DanfseFixtures.texto(gerador.gerar(DanfseFixtures.xml(DanfseFixtures.COMPLETA)));
        // prestador: nome e endereco vem do grupo do emitente, porque a DPS do prestador emitente nao os traz
        Assertions.assertTrue(texto.contains("11.222.333/0001-81"));
        Assertions.assertTrue(texto.contains("EMPRESA PRESTADORA EXEMPLO LTDA"));
        Assertions.assertTrue(texto.contains("AVENIDA PAULISTA, 1000, CONJUNTO 101, BELA VISTA"));
        Assertions.assertTrue(texto.contains("3550308 / 01.310-100"));
        Assertions.assertTrue(texto.contains("(11) 98765-4321"));
        Assertions.assertTrue(texto.contains("Regime de Apuração Tributária pelo SN"));
        // tomador: o nome do municipio vem da localidade de incidencia do IBS/CBS, que tem o mesmo codigo
        Assertions.assertTrue(texto.contains("11.444.777/0001-61"));
        Assertions.assertTrue(texto.contains("Campinas / SP"));
        Assertions.assertTrue(texto.contains("(19) 3234-5678"));
        // destinatario no exterior, com telefone estrangeiro sem mascara
        Assertions.assertTrue(texto.contains("12.345.678/0001-95"));
        Assertions.assertTrue(texto.contains("Miami / Florida"));
        Assertions.assertTrue(texto.contains("13055550100"));
        // intermediario: sem o nome do municipio no XML, sai o codigo e a UF
        Assertions.assertTrue(texto.contains("529.982.247-25"));
        Assertions.assertTrue(texto.contains("3304557 / RJ"));
    }

    @Test
    void deveImprimirServicoETributacao() {
        final var texto = DanfseFixtures.texto(gerador.gerar(DanfseFixtures.xml(DanfseFixtures.COMPLETA)));
        Assertions.assertTrue(texto.contains("01.01.01 / 001"));
        Assertions.assertTrue(texto.contains("1.1502.10.00"));
        Assertions.assertTrue(texto.contains("São Paulo / SP / -"));
        Assertions.assertTrue(texto.contains("Desenvolvimento de programas de computador sob encomenda."));
        Assertions.assertTrue(texto.contains("Desenvolvimento de módulo de faturamento conforme proposta comercial 2026/042. Inclui levantamento"));
        Assertions.assertTrue(texto.contains("Estimativa"));
        Assertions.assertTrue(texto.contains("123456789012345678901234567890"));
        Assertions.assertTrue(texto.contains("Redução da BC em percentual"));
        Assertions.assertTrue(texto.contains("R$ 600,00"), "deduções: vCalcDR + vCalcReeRepRes");
        Assertions.assertTrue(texto.contains("2,00 %"));
        Assertions.assertTrue(texto.contains("Retido pelo Tomador"));
        Assertions.assertTrue(texto.contains("R$ 465,00"), "contribuições retidas: vRetCSLL + vPis + vCofins");
        Assertions.assertTrue(texto.contains("PIS/COFINS Retidos"));
        Assertions.assertTrue(texto.contains("200 / 200001"));
        Assertions.assertTrue(texto.contains("100301 / 3509502 / Campinas / SP"));
        Assertions.assertTrue(texto.contains("R$ 1.390,00"), "exclusões: vDescIncond + vCalcReeRepRes + vISSQN + vPis + vCofins");
        Assertions.assertTrue(texto.contains("10,00 % / 20,00 % / 30,00 %"));
        Assertions.assertTrue(texto.contains("0,10 % / 0,05 %"));
        Assertions.assertTrue(texto.contains("R$ 10.000,00"));
        Assertions.assertTrue(texto.contains("R$ 55,20"), "total do IBS/CBS: vIBSTot + vCBS");
        Assertions.assertTrue(texto.contains("R$ 8.530,20"));
    }

    @Test
    void deveImprimirAsInformacoesComplementaresNaOrdemDaNt() {
        final var texto = DanfseFixtures.texto(gerador.gerar(DanfseFixtures.xml(DanfseFixtures.COMPLETA))).replaceAll("\\s+", " ");
        final var esperado = "Inf. Cont.: Pagamento em 30 dias. | NFS-e Subst.: 35503082211222333000181000000000123326091234567891 | Doc. Ref.: CONTRATO 2026/042 | "
                + "Cod. Obra: 123456789012 | Insc. Imob.: 000.111.222-3 | Doc. Tec.: ART-2026-0001 | Núm. Ped.: PED-4500012345 | Item Ped.: 10, 20 | "
                + "Inf. A. T. Mun.: Informação de uso da administração tributária municipal.";
        Assertions.assertTrue(texto.contains(esperado), texto);
        Assertions.assertTrue(texto.contains("Totais Aproximados dos Tributos cfe. Lei nº 12.741/2012: Federais: R$ 1.234,56; Estaduais: R$ 0,00; Municipais: R$ 175,00"));
    }

    @Test
    void deveSuprimirBlocosELinhasSemDados() {
        final var texto = DanfseFixtures.texto(gerador.gerar(DanfseFixtures.xml(DanfseFixtures.MINIMA)));
        Assertions.assertTrue(texto.contains(DanfseParticipantes.TOMADOR_NAO_IDENTIFICADO));
        Assertions.assertTrue(texto.contains(DanfseParticipantes.DESTINATARIO_NAO_IDENTIFICADO));
        Assertions.assertTrue(texto.contains(DanfseParticipantes.INTERMEDIARIO_NAO_IDENTIFICADO));
        Assertions.assertTrue(texto.contains(DanfseTributos.NAO_SUJEITA_AO_ISSQN));
        Assertions.assertFalse(texto.contains("Tipo de Tributação do ISSQN"));
        // item 99 do codigo de tributacao nacional: o municipio nao sai no cabecalho
        Assertions.assertFalse(texto.contains("Município:"));
        // competencia em 2027: sem a linha do PIS/COFINS de apuracao propria (nota 6)
        Assertions.assertFalse(texto.contains("PIS - Débito Apuração Própria"));
        Assertions.assertFalse(texto.contains(DanfseCabecalho.SEM_VALIDADE_JURIDICA));
        Assertions.assertTrue(texto.contains("Barueri / SP"));
        Assertions.assertTrue(texto.contains("Federais: -; Estaduais: -; Municipais: -"));
    }

    @Test
    void deveSuprimirAsLinhasDoIssqnSemDadosEManterAsComDados() {
        final var completa = DanfseFixtures.texto(gerador.gerar(DanfseFixtures.xml(DanfseFixtures.COMPLETA)));
        Assertions.assertTrue(completa.contains("Regime Especial de Tributação do ISSQN"));
        Assertions.assertTrue(completa.contains("Benefício Municipal"));

        final var nfse = DanfseFixtures.nfse(DanfseFixtures.COMPLETA);
        final var tribMun = nfse.getInfNFSe().getDPS().getInfDPS().getValores().getTributos().getTributosMunicipais();
        tribMun.setExigibilidadeSuspensa(null);
        tribMun.setBeneficioMunicipal(null);
        nfse.getInfNFSe().getDPS().getInfDPS().getPrestador().getRegimeTributario()
                .setRegimeEspecialTributacao(io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao.NENHUM);
        nfse.getInfNFSe().getValores().setTpBM(null).setVCalcBM(null).setVCalcDR(null);
        nfse.getInfNFSe().getDPS().getInfDPS().getValores().setValoresDeducaoBaseCalculo(null).setValoresDescontosCondicionadosEIncondicionados(null);
        // o vCalcReeRepRes zerado, sempre informado pelo Sistema Nacional, nao conta como dado da linha
        nfse.getInfNFSe().getIbsCbs().getValores().setvCalcReeRepRes(java.math.BigDecimal.ZERO);
        final var texto = DanfseFixtures.texto(gerador.gerar(nfse));
        Assertions.assertFalse(texto.contains("Regime Especial de Tributação do ISSQN"));
        Assertions.assertFalse(texto.contains("Benefício Municipal"));
        Assertions.assertTrue(texto.contains("BC ISSQN"));
    }

    @Test
    void deveInformarQueODestinatarioEOProprioTomador() {
        final var nfse = DanfseFixtures.nfse(DanfseFixtures.COMPLETA);
        nfse.getInfNFSe().getDPS().getInfDPS().getInfoIBSCBS().setIndDest(NFSeSefinNacionalInfoIBSCBSIndDest.TOMADOR).setDest(null);
        final var texto = DanfseFixtures.texto(gerador.gerar(nfse));
        Assertions.assertTrue(texto.contains(DanfseParticipantes.DESTINATARIO_E_O_TOMADOR));
        Assertions.assertFalse(texto.contains("DESTINATÁRIO DA OPERAÇÃO\n"));
        Assertions.assertFalse(texto.contains("Miami"));
    }

    @Test
    void deveImprimirOCanhotoSoQuandoPedido() {
        final var xml = DanfseFixtures.xml(DanfseFixtures.COMPLETA);
        final var comCanhoto = DanfseFixtures.texto(gerador.gerar(xml));
        Assertions.assertTrue(comCanhoto.contains("DATA CIENTIFICAÇÃO:"));
        Assertions.assertTrue(comCanhoto.contains("IDENTIFICAÇÃO E ASSINATURA"));
        Assertions.assertTrue(comCanhoto.contains("1234 / " + CHAVE));
        final var semCanhoto = DanfseFixtures.texto(gerador.gerar(xml, new DanfseOpcoes().setCanhoto(false)));
        Assertions.assertFalse(semCanhoto.contains("DATA CIENTIFICAÇÃO:"));
        Assertions.assertFalse(semCanhoto.contains("1234 / " + CHAVE));
    }

    @Test
    void deveAplicarAMarcaDaguaDaSituacao() throws Exception {
        final var xml = DanfseFixtures.xml(DanfseFixtures.MINIMA);
        Assertions.assertEquals(1, fluxosDeConteudo(gerador.gerar(xml)));
        Assertions.assertEquals(1, fluxosDeConteudo(gerador.gerar(xml, new DanfseOpcoes().setSituacao(null))));
        for (final var situacao : new DanfseSituacao[]{DanfseSituacao.CANCELADA, DanfseSituacao.SUBSTITUIDA}) {
            final var pdf = gerador.gerar(xml, new DanfseOpcoes().setSituacao(situacao));
            Assertions.assertTrue(fluxosDeConteudo(pdf) > 1, situacao.name());
            // a marca d'agua e o ultimo fluxo desenhado: as letras giradas saem por ultimo, uma por linha
            Assertions.assertTrue(DanfseFixtures.texto(pdf).replaceAll("\\s", "").endsWith(situacao.getMarcaDagua()), situacao.name());
        }
    }

    @Test
    void deveGerarQrCodeComOEnderecoDeConsultaEAChave() throws Exception {
        try (final var documento = Loader.loadPDF(gerador.gerar(DanfseFixtures.xml(DanfseFixtures.COMPLETA)))) {
            final var escala = 300f / 72f;
            final var imagem = new PDFRenderer(documento).renderImageWithDPI(0, 300);
            // quadro do QR Code: 1,52 cm em X 17,48 cm e Y 1,67 cm (item 2.4.3), com folga em volta
            final var quadro = imagem.getSubimage((int) (17.2f * CM * escala), (int) (1.4f * CM * escala), (int) (2.1f * CM * escala), (int) (2.1f * CM * escala));
            final var pixels = quadro.getRGB(0, 0, quadro.getWidth(), quadro.getHeight(), null, 0, quadro.getWidth());
            final var fonte = new RGBLuminanceSource(quadro.getWidth(), quadro.getHeight(), pixels);
            final var resultado = new QRCodeReader().decode(new BinaryBitmap(new HybridBinarizer(fonte)));
            Assertions.assertEquals("https://www.nfse.gov.br/ConsultaPublica/?tpc=1&chave=" + CHAVE, resultado.getText());
        }
    }

    @Test
    void deveCortarDescricaoEInformacoesLongasSemInvadirOCanhoto() {
        final var nfse = DanfseFixtures.nfse(DanfseFixtures.COMPLETA);
        final var infDps = nfse.getInfNFSe().getDPS().getInfDPS();
        infDps.getServicoPrestado().getCServ().setDescricaoServico("Descrição muito longa do serviço prestado. ".repeat(80));
        infDps.getServicoPrestado().getInformacoesComplementares().setInformacoesComplementares("Informação complementar extensa. ".repeat(80));
        final var limiteCanhoto = DanfseRodape.TOPO_CANHOTO;

        final var pdf = gerador.gerar(nfse);
        final var texto = DanfseFixtures.texto(pdf);
        Assertions.assertTrue(texto.contains("..."));
        Assertions.assertTrue(texto.contains("Totais Aproximados dos Tributos"), "a linha dos totais aproximados é fixa");
        // abaixo do topo do canhoto so pode haver o texto do proprio canhoto
        final var abaixoDoCanhoto = new StringBuilder();
        DanfseFixtures.glifos(pdf).stream().filter(glifo -> glifo.y > limiteCanhoto).forEach(glifo -> abaixoDoCanhoto.append(glifo.texto));
        Assertions.assertEquals("DATA CIENTIFICAÇÃO:IDENTIFICAÇÃO E ASSINATURANº NFS-e / CHAVE NFS-e1234 / " + CHAVE, abaixoDoCanhoto.toString());

        // sem o canhoto, o texto vai ate o fim do corpo e nao passa dele
        final var semCanhoto = gerador.gerar(nfse, new DanfseOpcoes().setCanhoto(false));
        Assertions.assertTrue(DanfseFixtures.glifos(semCanhoto).stream().allMatch(glifo -> glifo.y <= DanfseRodape.FIM_DO_CORPO));
        Assertions.assertTrue(DanfseFixtures.texto(semCanhoto).contains("Totais Aproximados dos Tributos"));
    }

    @Test
    void deveDesenharOCanhotoRenteAoFimDoCorpo() {
        // o corpo termina a 0,30 cm da beira do papel, como comeca a 0,30 cm do topo: a folga ate a borda e a mesma nos dois lados
        Assertions.assertEquals(PDRectangle.A4.getHeight() - 0.30f * CM, DanfseRodape.FIM_DO_CORPO, 0.01f);
        Assertions.assertEquals(DanfseRodape.FIM_DO_CORPO - 0.67f * CM, DanfseRodape.TOPO_CANHOTO, 0.01f);
        final var glifos = DanfseFixtures.glifos(gerador.gerar(DanfseFixtures.xml(DanfseFixtures.COMPLETA)));
        final var canhoto = glifos.stream().filter(glifo -> glifo.y > DanfseRodape.TOPO_CANHOTO).toList();
        Assertions.assertFalse(canhoto.isEmpty());
        // a linha "numero / chave", a ultima do canhoto, fica no ultimo terco do quadro, junto do fim do corpo
        Assertions.assertTrue(canhoto.stream().allMatch(glifo -> glifo.y < DanfseRodape.FIM_DO_CORPO));
        Assertions.assertTrue(canhoto.stream().anyMatch(glifo -> glifo.y > DanfseRodape.FIM_DO_CORPO - 0.30f * CM));
    }

    @Test
    void deveGerarPeloWSFacade() throws Exception {
        final var facade = new WSFacade(null);
        final var xml = DanfseFixtures.xml(DanfseFixtures.MINIMA);
        for (final var pdf : new byte[][]{facade.geraDanfse(xml), facade.geraDanfse(xml, new DanfseOpcoes().setCanhoto(false)),
                facade.geraDanfse(DanfseFixtures.nfse(DanfseFixtures.MINIMA)),
                facade.geraDanfse(DanfseFixtures.nfse(DanfseFixtures.MINIMA), new DanfseOpcoes().setSituacao(DanfseSituacao.CANCELADA))}) {
            try (final var documento = Loader.loadPDF(pdf)) {
                Assertions.assertEquals(1, documento.getNumberOfPages());
            }
        }
    }

    /**
     * A marca d'água é acrescentada à página como um fluxo de conteúdo à parte.
     */
    private static int fluxosDeConteudo(final byte[] pdf) throws Exception {
        try (final var documento = Loader.loadPDF(pdf)) {
            int total = 0;
            for (final var it = documento.getPage(0).getContentStreams(); it.hasNext(); it.next()) {
                total++;
            }
            return total;
        }
    }
}
