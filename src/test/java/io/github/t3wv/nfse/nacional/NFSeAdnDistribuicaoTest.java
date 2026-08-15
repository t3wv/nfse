package io.github.t3wv.nfse.nacional;

import io.github.t3wv.nfse.NFSeConfig;
import io.github.t3wv.nfse.nacional.classes.adn.NFSeAdnDocumentoDistribuido;
import io.github.t3wv.nfse.nacional.classes.adn.NFSeAdnLoteDistribuicaoResponse;
import io.github.t3wv.nfse.nacional.classes.adn.NFSeAdnStatusProcessamento;
import io.github.t3wv.nfse.nacional.classes.adn.NFSeAdnTipoDocumento;
import io.github.t3wv.nfse.utils.NFSeObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;

/**
 * Testes da distribuição de DF-e do ADN que não dependem de rede nem de certificado: a
 * desserialização da resposta e o desempacotamento do conteúdo dos documentos.
 */
public class NFSeAdnDistribuicaoTest {

    private static final NFSeObjectMapper MAPPER = new NFSeObjectMapper();

    private static final String XML_DOCUMENTO = "<NFSe xmlns=\"http://www.sped.fazenda.gov.br/nfse\"><infNFSe><nNFSe>1</nNFSe></infNFSe></NFSe>";

    private static String gzipBase64(final String conteudo) throws Exception {
        try (final var baos = new ByteArrayOutputStream(); final var gzip = new GZIPOutputStream(baos)) {
            gzip.write(conteudo.getBytes(StandardCharsets.UTF_8));
            gzip.finish();
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        }
    }

    private static NFSeAdnLoteDistribuicaoResponse desserializar(final String json) throws Exception {
        return MAPPER.convertValue(MAPPER.readTree(json), NFSeAdnLoteDistribuicaoResponse.class);
    }

    @Test
    public void desserializaLoteComDocumentos() throws Exception {
        final var json = """
            {
              "StatusProcessamento": "DOCUMENTOS_LOCALIZADOS",
              "LoteDFe": [
                {
                  "NSU": 1,
                  "ChaveAcesso": "26125051226063877000115250000000685425085159913279",
                  "TipoDocumento": "NFSE",
                  "TipoEvento": null,
                  "ArquivoXml": "%s",
                  "DataHoraGeracao": "2025-08-30T00:04:36.633"
                },
                {
                  "NSU": 7,
                  "ChaveAcesso": "26125051226063877000115250000000685425085159913279",
                  "TipoDocumento": "EVENTO",
                  "TipoEvento": "101101",
                  "ArquivoXml": "%s",
                  "DataHoraGeracao": "2025-08-31T10:12:00.000"
                }
              ],
              "Alertas": [],
              "Erros": [],
              "TipoAmbiente": "HOMOLOGACAO",
              "VersaoAplicativo": "1.0.0.0",
              "DataHoraProcessamento": "2026-08-13T20:37:43-03:00"
            }
            """.formatted(gzipBase64(XML_DOCUMENTO), gzipBase64(XML_DOCUMENTO));

        final var response = desserializar(json);

        Assertions.assertEquals(NFSeAdnStatusProcessamento.DOCUMENTOS_LOCALIZADOS, response.getStatusProcessamento());
        Assertions.assertTrue(response.temDocumentos());
        Assertions.assertFalse(response.vazio());
        Assertions.assertEquals(2, response.getLoteDFe().size());
        Assertions.assertEquals("1.0.0.0", response.getVersaoAplicativo());
        Assertions.assertTrue(response.getErros().isEmpty());

        final NFSeAdnDocumentoDistribuido nota = response.getLoteDFe().get(0);
        Assertions.assertEquals(1L, nota.getNsu());
        Assertions.assertEquals(NFSeAdnTipoDocumento.NFSE, nota.getTipoDocumento());
        Assertions.assertEquals(50, nota.getChaveAcesso().length(), "a chave da NFSe tem 50 dígitos, não 44");
        Assertions.assertNull(nota.getTipoEvento());
        Assertions.assertEquals(2025, nota.getDataHoraGeracao().getYear());

        final NFSeAdnDocumentoDistribuido evento = response.getLoteDFe().get(1);
        Assertions.assertEquals(NFSeAdnTipoDocumento.EVENTO, evento.getTipoDocumento());
        Assertions.assertEquals("101101", evento.getTipoEvento());

        //o NSU de partida da próxima chamada sai do maior NSU do lote, já que o ADN não devolve teto
        Assertions.assertTrue(response.getMaiorNsu().isPresent());
        Assertions.assertEquals(7L, response.getMaiorNsu().getAsLong());
    }

    @Test
    public void desserializaLoteVazioComRejeicao() throws Exception {
        final var json = """
            {
              "StatusProcessamento": "NENHUM_DOCUMENTO_LOCALIZADO",
              "LoteDFe": null,
              "Alertas": [],
              "Erros": [ { "Codigo": "E2215", "Descricao": "Não existem DF-e a partir do NSU informado", "Complemento": "NSU 999" } ],
              "TipoAmbiente": "PRODUCAO",
              "VersaoAplicativo": "1.0.0.0",
              "DataHoraProcessamento": "2026-08-13T20:37:43-03:00"
            }
            """;

        final var response = desserializar(json);

        Assertions.assertTrue(response.vazio());
        Assertions.assertFalse(response.temDocumentos());
        //lote nulo não pode estourar em quem itera
        Assertions.assertNotNull(response.getLoteDFe());
        Assertions.assertTrue(response.getLoteDFe().isEmpty());
        Assertions.assertTrue(response.getMaiorNsu().isEmpty());
        Assertions.assertEquals(1, response.getErros().size());
        Assertions.assertEquals("E2215", response.getErros().get(0).getCodigo());
    }

    @Test
    public void desempacotaArquivoXmlComprimido() throws Exception {
        final var documento = new NFSeAdnDocumentoDistribuido().setArquivoXml(gzipBase64(XML_DOCUMENTO));
        Assertions.assertEquals(XML_DOCUMENTO, documento.getXml());
    }

    @Test
    public void desempacotaArquivoXmlSemCompressao() throws Exception {
        //o gzip não é declarado no contrato; se um dia deixar de vir, o conteúdo ainda deve ser lido
        final var base64Puro = Base64.getEncoder().encodeToString(XML_DOCUMENTO.getBytes(StandardCharsets.UTF_8));
        final var documento = new NFSeAdnDocumentoDistribuido().setArquivoXml(base64Puro);
        Assertions.assertEquals(XML_DOCUMENTO, documento.getXml());
    }

    @Test
    public void desempacotaArquivoXmlAusente() throws Exception {
        Assertions.assertNull(new NFSeAdnDocumentoDistribuido().getXml());
        Assertions.assertNull(new NFSeAdnDocumentoDistribuido().setArquivoXml("").getXml());
    }

    @Test
    public void rejeitaChaveAcessoInvalidaNaConsultaDeEventos() {
        final var ws = new WSDistribuicaoDFe(new NFSeConfigDistribuicaoStub());
        Assertions.assertThrows(IllegalArgumentException.class, () -> ws.consultarEventosPorChaveAcesso("123"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ws.consultarEventosPorChaveAcesso(null));
    }

    @Test
    public void rejeitaNsuNegativoECnpjInvalido() {
        final var ws = new WSDistribuicaoDFe(new NFSeConfigDistribuicaoStub());
        Assertions.assertThrows(IllegalArgumentException.class, () -> ws.distribuirDFe(-1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ws.distribuirDFe(0, "12345678000100"));
    }

    /**
     * Config mínima para exercitar as validações, que acontecem antes de qualquer acesso ao
     * certificado.
     */
    private static class NFSeConfigDistribuicaoStub implements NFSeConfig {

        @Override
        public String getCertificadoSenha() {
            return "";
        }

        @Override
        public String getCadeiaCertificadosSenha() {
            return "";
        }

        @Override
        public KeyStore getKeyStoreCertificado() {
            return null;
        }

        @Override
        public KeyStore getKeyStoreCadeia() {
            return null;
        }

        @Override
        public boolean isTeste() {
            return true;
        }
    }
}
