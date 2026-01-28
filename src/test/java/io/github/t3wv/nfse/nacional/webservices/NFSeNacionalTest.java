package io.github.t3wv.nfse.nacional.webservices;


import io.github.t3wv.nfse.NFSeConfig;
import io.github.t3wv.nfse.NFSeConfigTest;
import io.github.t3wv.nfse.NFSeLogger;
import io.github.t3wv.nfse.nacional.WSParametrosMunicipais;
import io.github.t3wv.nfse.nacional.WSSefinNFSe;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.*;
import io.github.t3wv.nfse.utils.NFSeCadeiaCertificadosTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;


/**
 * Classe que realiza os testes das NFSe.
 * Serve como uma documentação de como utilizar a biblioteca para NFSe.
 * Para gerar a cadeia de certificados, use o metodo {@link NFSeCadeiaCertificadosTest}
 */
public class NFSeNacionalTest implements NFSeLogger {

    private static NFSeConfig config;

    @Disabled
    @BeforeAll
    public static void prepara() {
        config = new NFSeConfigTest();
    }

    @Disabled
    @Test
    public void consultaConvenioMunicipioTest() throws Exception {
        getLogger().info("Teste de consulta de convênio do município na API de Parâmetros Municipais do Governo Federal");
        final var codigoDoMunicipio = "3550308"; // SC - São José
        final var consulta = new WSParametrosMunicipais(config).consultaConvenioMunicipio(codigoDoMunicipio);
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

    @Test
    @Disabled
    public void testeEmitirNFSe() throws Exception {
        final var dps = new NFSeSefinNacionalDPS()
                .setInfDPS(new NFSeSefinNacionalInfDPS()
                        .setTipoAmbiente(NFSeSefinNacionalTipoAmbiente.HOMOLOGACAO)
                        .setDataHoraEmissao(ZonedDateTime.of(2025, 10, 23, 10, 33, 19, 0, ZoneId.of("-03:00")))
                        .setVersaoApp("NFSe Fake Teste 1.0")
                        .setSerie("901")
                        .setNumeroDPS(6)
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
                        .setCNPJAutor("")
                        .setChaveAcessoNFSE("")
                        //.setNPedRegEvento("1")
                        .setEvento(new NFSeSefinNacionalInfPedRegTE101101()
                                .setcMotivo(NFSeSefinNacionalTSCodJustCanc.OUTROS)
                                .setxMotivo("Cancelamento de NFSe para testes"))
        );

        new WSSefinNFSe(config).enviarPedidoRegistroEvento(evento);
    }
}
