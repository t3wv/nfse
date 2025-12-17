package io.github.t3wv.municipal;

import io.github.t3wv.NFSeConfig;
import io.github.t3wv.NFSeLogger;
import io.github.t3wv.municipal.nfseSCSaoJose.*;
import io.github.t3wv.nacional.classes.nfsenacional.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Base64;

/**
 * Teste de emissao de NFSe para o municipio de Sao Jose SC
 */
class NFSeSCSaoJoseTest implements NFSeLogger {

    private static NFSeConfig config;

    @Disabled
    @BeforeAll
    static void prepara() {
        config = new NFSeConfig(
                System.getenv("CERTIFICADO_PATH"),
                System.getenv("CERTIFICADO_SENHA"),
                System.getenv("CADEIA_CERTIFICADOS_PATH"),
                System.getenv("CADEIA_CERTIFICADOS_SENHA"), true);
    }

    @Disabled
    @Test
    void testeEmissaoSJ() throws Exception {
        final var dps = new NFSeSefinNacionalInfDPS()
                .setTipoAmbiente(NFSeSefinNacionalTipoAmbiente.HOMOLOGACAO)
                .setDataHoraEmissao(ZonedDateTime.of(2025, 10, 23, 10, 33, 19, 0, ZoneId.of("-03:00")))
                .setVersaoApp("Teste")
                .setSerie("0")
                .setNumeroDPS(0)
                .setDataInicioPrestacaoServico(LocalDate.of(2025, 10, 23))
                .setTipoEmitente(NFSeSefinNacionalInfDPSTipoEmitente.PRESTADOR)
                .setCodigoMunicipioEmissao("")
                .setPrestador(new NFSeSefinNacionalInfoPrestador().setCNPJ("").setRegimeTributario(new NFSeSefinNacionalRegTrib().setOpSimplesNacional(NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional.NAO_OPTANTE).setRegimeEspecialTributacao(NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao.NENHUM)))
                .setTomador(new NFSeSefinNacionalInfoPessoa().setCPF("").setNome("").setEmail(""))
                .setServicoPrestado(new NFSeSefinNacionalServ().setLocalPrestacao(new NFSeSefinNacionalLocPrest().setCodigoMunicipio("4205407")).setCServ(new NFSeSefinNacionalCServ().setCodigoNacionalTributacaoISSQN("010101").setDescricaoServico("Teste").setCodigoNBS("114061100")))
                .setValores(new NFSeSefinNacionalInfoValores().setValoresServicoPrestado(new NFSeSefinNacionalVServPrest().setValorServicos(BigDecimal.valueOf(0.01))).setTributos(new NFSeSefinNacionalInfoTributacao().setTributosMunicipais(new NFSeSefinNacionalTribMunicipal().setTributacaoISSQN(NFSeSefinNacionalTribMunicipalTributacaoISSQN.OPERACAO_TRIBUTAVEL).setTipoRetencaoISSQN(NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN.NAO_RETIDO)).setTributosNacionais(new NFSeSefinNacionalTribFederal().setPiscofins(new NFSeSefinNacionalTribOutrosPisCofins().setCST(NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria.CONTRIBUICAO_SEM_INCIDENCIA))).setTotalTributos(new NFSeSefinNacionalTribTotal().setIndicadorValorTotalTributos("0"))));

        String credentials = "login_xpto:senha_xpto";
        String headerValue = "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());

        this.getLogger().info(testeConverteNacionalParaLocal(dps).toXml());

        final var response = this.postFileAsFormData(new URI("https://saojose.atende.net/atende.php?pg=rest&service=WNERestServiceNFSe&cidade=padrao"), testeConverteNacionalParaLocal(dps).toXml(), "teste.xml", headerValue);
        this.getLogger().info(response.body());
    }

    HttpResponse<String> postFileAsFormData(URI uri, String xmlContent, String filename, String authHeader) throws Exception {
        String boundary = "----Boundary" + System.currentTimeMillis();
        String CRLF = "\r\n";

        // Cabeçalho da parte do arquivo
        StringBuilder part = new StringBuilder();
        part.append("--").append(boundary).append(CRLF);
        part.append("Content-Disposition: form-data; name=\"file\"; filename=\"").append(filename).append("\"").append(CRLF);
        part.append("Content-Type: text/xml; charset=UTF-8").append(CRLF).append(CRLF);

        byte[] partHeader = part.toString().getBytes(StandardCharsets.UTF_8);
        byte[] xmlBytes = xmlContent.getBytes(StandardCharsets.UTF_8);
        byte[] closing = (CRLF + "--" + boundary + "--" + CRLF).getBytes(StandardCharsets.UTF_8);

        // Monta o corpo multipart
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(partHeader);
        baos.write(xmlBytes);
        baos.write(closing);
        byte[] multipartBody = baos.toByteArray();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "multipart/form-data; boundary=" + boundary)
                .header("Authorization", authHeader) // se necessário
                .POST(HttpRequest.BodyPublishers.ofByteArray(multipartBody))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    NFSeSCSaoJoseNFSe testeConverteNacionalParaLocal(NFSeSefinNacionalInfDPS nfseSefinNacionalInfDPS) throws Exception {
        final var nfseSCSaoJose = new NFSeSCSaoJoseNFSe();
        nfseSCSaoJose
                .setTeste(true)
                .setNf(
                        new NFSeSCSaoJoseNFSeNF()
                                .setValorTotal(nfseSefinNacionalInfDPS.getValores().getValoresServicoPrestado().getValorServicos()))
                .setPrestador(
                        new NFSeSCSaoJoseNFSePrestador()
                                .setCidade(nfseSefinNacionalInfDPS.getCodigoMunicipioEmissao())
                                .setCpfCnpj(nfseSefinNacionalInfDPS.getPrestador().getCNPJ()))
                .setTomador(
                        new NFSeSCSaoJoseNFSeTomador()
                                .setTipoPessoa("F")
                                .setCpfcnpj(nfseSefinNacionalInfDPS.getTomador().getCPF())
                                .setNomeRazaoSocial(nfseSefinNacionalInfDPS.getTomador().getNome())
                                .setEmail(nfseSefinNacionalInfDPS.getTomador().getEmail()))
                .setItens(
                        new NFSeSCSaoJoseNFSeItens().setLista(
                                new NFSeSCSaoJoseNFSeItensLista()
                                        .setCodigoLocalPrestacaoServico(nfseSefinNacionalInfDPS.getServicoPrestado().getLocalPrestacao().getCodigoMunicipio())
                                        .setCodigoItemListaServico(nfseSefinNacionalInfDPS.getServicoPrestado().getCServ().getCodigoNacionalTributacaoISSQN())
                                        .setDescritivo(nfseSefinNacionalInfDPS.getServicoPrestado().getCServ().getDescricaoServico())
                                        .setValorTributavel(nfseSefinNacionalInfDPS.getValores().getValoresServicoPrestado().getValorServicos())
                                        .setValorISSRF(BigDecimal.ZERO)
                                        .setAliquotaItemListaServico(BigDecimal.ZERO)
                                        .setSituacaoTributaria("06")));
        return nfseSCSaoJose;
    }

    // Desescape básico de HTML para XML pra tirar a desgraça do cdata da maneira mais estupida possível
    private static String unescapeBasicHtml(String str) {
        return str
                .replace("&lt;", "<")
                .replace("&gt;", ">")
                .replace("&amp;", "&")
                .replace("&quot;", "\"")
                .replace("&apos;", "'")
                .replaceAll("<\\?xml[^>]+\\?>", "");
    }

    private static String prettyPrintXml(String inputRaw) throws Exception {
        final var input = unescapeBasicHtml(inputRaw);

        // Parse String XML to DOM
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = db.parse(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));

        // Pretty print with Transformer
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        StringWriter sw = new StringWriter();
        tf.transform(new DOMSource(doc), new StreamResult(sw));
        return sw.toString();
    }
}
