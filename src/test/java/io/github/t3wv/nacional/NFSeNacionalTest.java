package io.github.t3wv.nacional;


import io.github.t3wv.NFSeConfig;
import io.github.t3wv.NFSeLogger;
import io.github.t3wv.nacional.classes.nfsenacional.*;
import io.github.t3wv.nacional.webservices.WSDANFSe;
import io.github.t3wv.nacional.webservices.WSParametrosMunicipais;
import io.github.t3wv.nacional.webservices.WSSefinNFSe;
import io.github.t3wv.utils.NFSeCadeiaCertificadosTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.zip.GZIPInputStream;


/**
 * Classe que realiza os testes das NFSe.
 * Serve como uma documentação de como utilizar a biblioteca para NFSe.
 * Para gerar a cadeia de certificados, use o metodo {@link NFSeCadeiaCertificadosTest#geraCadeiaCertificadoHomologacao()}
 */
public class NFSeNacionalTest implements NFSeLogger {

    private static NFSeConfig config;

    @Disabled
    @BeforeAll
    public static void prepara() {
        config = new NFSeConfig(
                System.getenv("CERTIFICADO_PATH"),
                System.getenv("CERTIFICADO_SENHA"),
                System.getenv("CADEIA_CERTIFICADOS_PATH"),
                System.getenv("CADEIA_CERTIFICADOS_SENHA"), false);
    }

    @Disabled
    @Test
    public void consultaConvenioMunicipioTest() throws Exception {
        getLogger().info("Teste de consulta de convênio do município na API de Parâmetros Municipais do Governo Federal");
        final var codigoDoMunicipio = "3505708"; // SC - São José
        final var consulta = new WSParametrosMunicipais(config).consultaConvenioMunicipio(codigoDoMunicipio);
        Assertions.assertNotNull(consulta);
        Assertions.assertEquals("Parâmetros do convênio recuperados com sucesso.", consulta.getMensagem());
        Assertions.assertTrue(consulta.getParametrosConvenio().isAderenteAmbienteNacional());
        Assertions.assertFalse(consulta.getParametrosConvenio().isAderenteEmissorNacional());
        Assertions.assertFalse(consulta.getParametrosConvenio().isAderenteMAN());
        Assertions.assertTrue(consulta.getParametrosConvenio().isPermiteAproveitametoDeCreditos());
        Assertions.assertEquals(1, consulta.getParametrosConvenio().getSituacaoEmissaoPadraoContribuintesRFB());
        getLogger().info(consulta.toString());
    }

    @Disabled
    @Test
    public void consultaAliquotaMunicipioServicoCompetenciaTest() throws Exception {
        getLogger().info("Teste de consulta de alíquota do município para um serviço e competência na API de Parâmetros Municipais do Governo Federal");
        final var codigoDoMunicipio = "4216602"; // SC - São José
        final var codigoDoServico = "31.01.04.000"; // Serviços técnicos em telecomunicações e congêneres
        final var dataCompetencia = LocalDate.now();
        final var consulta = new WSParametrosMunicipais(config).consultaAliquotaMunicipioServicoCompetencia(codigoDoMunicipio, codigoDoServico, dataCompetencia);
        Assertions.assertNotNull(consulta);
        Assertions.assertEquals("Alíquotas recuperadas com sucesso.", consulta.getMensagem());
        Assertions.assertNotNull(consulta.getAliquotas());
        Assertions.assertEquals(1, consulta.getAliquotas().size());
        Assertions.assertNotNull(consulta.getAliquotas().get(codigoDoServico));
        Assertions.assertNotNull(consulta.getAliquotas().get(codigoDoServico).get(0));
        Assertions.assertEquals(new BigDecimal("3"), consulta.getAliquotas().get(codigoDoServico).get(0).getAliq());
        Assertions.assertEquals(LocalDateTime.of(2024, 5, 2, 0, 0, 0), consulta.getAliquotas().get(codigoDoServico).get(0).getDtIni());
        Assertions.assertNull(consulta.getAliquotas().get(codigoDoServico).get(0).getDtFim());
        getLogger().info(consulta.toString());
    }

    @Disabled
    @Test
    public void consultaHistoricoAliquotaMunicipioServicoTest() throws Exception {
        final var codigoDoMunicipio = "4216602";
        final var codigoDoServico = "01.01.01.000";
        final var consulta = new WSParametrosMunicipais(config).consultaHistoricoAliquotaMunicipioServico(codigoDoMunicipio, codigoDoServico);
        System.out.println(consulta);
    }

    @Disabled
    @Test
    public void consultaBeneficioMunicipioBeneficioCompetencia() {
        // Esse método está desativado por enquanto, pois não foi possível localizar o formato de código de benefício aceito pela API.
        // Assim que essa informação estiver disponível, o teste poderá ser reativado e ajustado
        //final var codigoDoMunicipio = "4216602";
        //final var codigoDoBeneficio = "00.00.00.000";
        //final var consulta = new WSParametrosMunicipais(config).consultaBeneficioMunicipioBeneficioCompetencia(codigoDoMunicipio, codigoDoBeneficio, LocalDate.now());;
        //System.out.println(consulta);
    }

    @Disabled
    @Test
    public void consultaRegimesEspeciaisMunicipioServicoCompetenciaTest() throws Exception {
        final var codigoDoMunicipio = "4205407";
        final var codigoDoServico = "10.01.01.000";
        final var consulta = new WSParametrosMunicipais(config).consultaRegimesEspeciaisMunicipioServicoCompetencia(codigoDoMunicipio, codigoDoServico, LocalDate.now());
        getLogger().info(consulta.toString());
    }

    @Disabled
    @Test
    public void consultaRetencoesMunicipioCompetenciaTest() throws Exception {
        final var codigoDoMunicipio = "4205407";
        final var consulta = new WSParametrosMunicipais(config).consultaRetencoesMunicipioCompetencia(codigoDoMunicipio, LocalDate.now().minusMonths(12));
        System.out.println(consulta);
    }

    @Disabled
    @Test
    public void downloadDANFSePdfChaveAcessoTest() throws Exception {
        System.out.println("Teste de download do DANFSe em PDF utilizando a chave de acesso da NFSe");
        final var nfseChaveAcesso = "";
        final var pathToSave = "";
        final var danfsePDF = new WSDANFSe(config).downloadDANFSePdfByChaveAcesso(nfseChaveAcesso);
        Files.write(Paths.get("%s/%s.pdf".formatted(pathToSave, nfseChaveAcesso)), danfsePDF);
    }

    @Disabled
    @Test
    public void downloadXmlNFSeViaChaveAcessoTest() throws Exception {
        System.out.println("Teste de download do xml da NFSe");
        final var nfseChaveAcesso = "";
        final var pathToSave = "";
        final var responseXml = new WSSefinNFSe(config).getNFSeByChaveAcesso(nfseChaveAcesso);

        final byte[] conteudo = Base64.getDecoder().decode(responseXml.getNfseXmlGZipB64());//java 8
        try (GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(conteudo))) {
            try (BufferedReader bf = new BufferedReader(new InputStreamReader(gis, StandardCharsets.UTF_8))) {
                StringBuilder outStr = new StringBuilder();
                String line;
                while ((line = bf.readLine()) != null) {
                    outStr.append(line);
                }
                Files.writeString(Paths.get("%s/%s.xml".formatted(pathToSave, nfseChaveAcesso)), config.getPersister().read(NFSeSefinNacionalNFSe.class, outStr.toString()).toXml());
            }
        }
    }

    @Test
    @Disabled
    public void testeEmitirNFSe() throws Exception {
        final var dps = new NFSeSefinNacionalDPS().setInfDPS(new NFSeSefinNacionalInfDPS()
                .setTipoAmbiente(NFSeSefinNacionalTipoAmbiente.HOMOLOGACAO)
                .setDataHoraEmissao(ZonedDateTime.of(2025, 10, 23, 10, 33, 19, 0, ZoneId.of("-03:00")))
                .setVersaoApp("NFSe Fake Teste 1.0")
                .setSerie("901")
                .setNumeroDPS("6")
                .setDataInicioPrestacaoServico(LocalDate.of(2025, 10, 23))
                .setTipoEmitente(NFSeSefinNacionalInfDPSTipoEmitente.PRESTADOR)
                .setCodigoMunicipioEmissao("4205407")
                .setPrestador(new NFSeSefinNacionalInfoPrestador().setCPF("").setRegimeTributario(new NFSeSefinNacionalRegTrib().setOpSimplesNacional(NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional.NAO_OPTANTE).setRegimeEspecialTributacao(NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao.NENHUM)))
                .setTomador(new NFSeSefinNacionalInfoPessoa().setCPF("").setNome(""))
                .setServicoPrestado(new NFSeSefinNacionalServ().setLocalPrestacao(new NFSeSefinNacionalLocPrest().setCodigoMunicipio("4205407")).setCServ(new NFSeSefinNacionalCServ().setCodigoNacionalTributacaoISSQN("170601").setDescricaoServico("Teste").setCodigoNBS("114061100")))
                .setValores(new NFSeSefinNacionalInfoValores().setValoresServicoPrestado(new NFSeSefinNacionalVServPrest().setValorServicos(BigDecimal.valueOf(0.01))).setTributos(new NFSeSefinNacionalInfoTributacao().setTributosMunicipais(new NFSeSefinNacionalTribMunicipal().setTributacaoISSQN(NFSeSefinNacionalTribMunicipalTributacaoISSQN.OPERACAO_TRIBUTAVEL).setTipoRetencaoISSQN(NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN.NAO_RETIDO)).setTributosNacionais(new NFSeSefinNacionalTribFederal().setPiscofins(new NFSeSefinNacionalTribOutrosPisCofins().setCST(NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria.CONTRIBUICAO_SEM_INCIDENCIA))).setTotalTributos(new NFSeSefinNacionalTribTotal().setIndicadorValorTotalTributos("0")))));

        new WSSefinNFSe(config).emitirNFSeByDPS(dps);
    }

    @Disabled
    @Test
    public void testeCancelamentoNFSeByChaveAcesso() throws Exception {
        final var evento = new NFSeSefinNacionalPedRegEvt().setInfPedReg(
                new NFSeSefinNacionalInfPedReg()
                        .setTpAmb(NFSeSefinNacionalTipoAmbiente.HOMOLOGACAO)
                        .setVerAplic("")
                        .setDhEvento(ZonedDateTime.of(2025, 10, 30, 15, 59, 19, 0, ZoneId.of("-03:00")))
                        .setCNPJAutor("")
                        .setChaveAcessoNFSE("")
                        .setNPedRegEvento("1")
                        .setEvento(new NFSeSefinNacionalInfPedRegTE101101()
                                .setcMotivo(NFSeSefinNacionalTSCodJustCanc.OUTROS)
                                .setxMotivo("Cancelamento de NFSe para testes"))
        );

        new WSSefinNFSe(config).enviarPedidoRegistroEvento(evento);
    }
}
