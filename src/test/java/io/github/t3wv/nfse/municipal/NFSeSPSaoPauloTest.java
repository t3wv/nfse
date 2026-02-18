package io.github.t3wv.nfse.municipal;


import io.github.t3wv.nfse.NFSeConfig;
import io.github.t3wv.nfse.NFSeConfigTest;
import io.github.t3wv.nfse.NFSeLogger;
import io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.WSFacade;
import io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.requests.*;
import io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos.*;
import io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.utils.NFSeSPSaoPauloUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

@Disabled
public class NFSeSPSaoPauloTest implements NFSeLogger {

    private static NFSeConfig config;

    @Disabled
    @BeforeAll
    static void prepara() {
        config = new NFSeConfigTest();
    }

    @Disabled
    @Test
    public void testeEmissaoSchemasV1() throws Exception {
        final var pedidoEnvioRPS = new NFSeSPSaoPauloRequestEnvioRPSLote();
        pedidoEnvioRPS.setCabecalho(new NFSeSPSaoPauloRequestEnvioRPSCabecalho()
            .setVersao("1")
            .setCPFCNPJRemetente(new TpCPFCNPJ().setCNPJ(""))
            .setTransacao(false)
            .setDtInicio(LocalDate.now())
            .setDtFim(LocalDate.now())
            .setValorTotalServicos(BigDecimal.valueOf(0.01))
            .setQtdRPS(1));

        final var rps = new TpRPS();
        rps.setChaveRPS(new TpChaveRPS().setInscricaoPrestador("").setNumeroRPS(""))
            .setTipoRPS(TpTipoRPS.RPS)
            .setDataEmissao(LocalDate.now())
            .setStatusRPS(TpStatusNFe.NORMAL)
            .setValorServicos(BigDecimal.valueOf(0.01))
            .setValorDeducoes(BigDecimal.ZERO)
            .setValorPIS(BigDecimal.ZERO)
            .setValorCOFINS(BigDecimal.ZERO)
            .setValorINSS(BigDecimal.ZERO)
            .setValorIR(BigDecimal.ZERO)
            .setValorCSLL(BigDecimal.ZERO)
            .setCodigoServico("02496")
            .setAliquotaServicos(BigDecimal.ZERO)
            .setISSRetido(false)
            .setCPFCNPJTomador(new TpCPFCNPJNIF().setCNPJ(""))
            .setEnderecoTomador(new TpEndereco().setLogradouro("").setBairro("").setCidade(4216602).setUF("SC").setCEP(""))
            .setDiscriminacao("Teste emissao NFSe");
        pedidoEnvioRPS.addRps(rps);

        // Gero e assino a assinatura digital de cada rps
        final var response = new WSFacade(config).enviarTesteLoteRPS(NFSeSPSaoPauloUtils.assinarRPSs(config, pedidoEnvioRPS));
        System.out.println(response.toXml());
    }

    @Disabled
    @Test
    public void testeEmissaoSchemasV2() throws Exception {
        final var pedidoEnvioRPS = new NFSeSPSaoPauloRequestEnvioRPSLote();
        pedidoEnvioRPS.setCabecalho(new NFSeSPSaoPauloRequestEnvioRPSCabecalho()
            .setVersao("2")
            .setCPFCNPJRemetente(new TpCPFCNPJ().setCNPJ(""))
            .setTransacao(false)
            .setDtInicio(LocalDate.now())
            .setDtFim(LocalDate.now())
            .setQtdRPS(1));

        final var rps = new TpRPS()
            .setChaveRPS(new TpChaveRPS().setInscricaoPrestador("").setNumeroRPS(""))
            .setTipoRPS(TpTipoRPS.RPS)
            .setDataEmissao(LocalDate.now())
            .setStatusRPS(TpStatusNFe.NORMAL)
            .setTributacaoRPS(TpTributacaoNFe.TRIBUTADO_SAO_PAULO_EXIGIBILIDADE_SUSPENSA)
            .setValorDeducoes(BigDecimal.ZERO)
            .setValorPIS(BigDecimal.ZERO)
            .setValorCOFINS(BigDecimal.ZERO)
            .setValorINSS(BigDecimal.ZERO)
            .setValorIR(BigDecimal.ZERO)
            .setValorCSLL(BigDecimal.ZERO)
            .setCodigoServico("02496")
            .setAliquotaServicos(BigDecimal.ZERO)
            .setCPFCNPJTomador(new TpCPFCNPJNIF().setCNPJ("52398509000138"))
            .setEnderecoTomador(new TpEndereco()
                .setLogradouro("Avenida Presidente Kennedy 1234")
                .setCidade(4216602)
                .setUF("SC")
                .setCEP("88101050"))
            .setDiscriminacao("Teste emissao NFSe")
            .setValorFinalCobrado(BigDecimal.valueOf(0.01))
            .setValorIPI(BigDecimal.ZERO)
            .setExigibilidadeSuspensa(true)
            .setPagamentoParceladoAntecipado(false)
            .setNBS("101210000")
            .setCLocPrestacao("3550308")
            .setIBSCBS(
                new TpIBSCBS()
                    .setFinNFSe(0)
                    .setIndFinal(false)
                    .setCIndOp("100301")
                    .setIndDest(TpIndDest.TOMADOR)
                    .setValores(
                        new TpValores().setTrib(
                            new TpTrib().setGIBSCBS(
                                new TpGIBSCBS().setCClassTrib("000001")
                            )
                        )
                    )
            );
        pedidoEnvioRPS.addRps(rps);
        final var response = new WSFacade(config).enviarTesteLoteRPS(pedidoEnvioRPS);
        System.out.println(response.toXml());
    }

    @Disabled
    @Test
    public void envioSimplesRPSCUIDADO() throws Exception {
        final var pedidoEnvioRPS = new NFSeSPSaoPauloRequestEnvioRPSUnico();
        pedidoEnvioRPS.setCabecalho(new NFSeSPSaoPauloRequestEnvioRPSCabecalho()
            .setVersao("1")
            .setCPFCNPJRemetente(new TpCPFCNPJ().setCNPJ("")));

        final var rps = new TpRPS()
            .setChaveRPS(new TpChaveRPS().setInscricaoPrestador("").setNumeroRPS(""))
            .setTipoRPS(TpTipoRPS.RPS)
            .setDataEmissao(LocalDate.now())
            .setStatusRPS(TpStatusNFe.NORMAL)
            .setValorServicos(BigDecimal.valueOf(0.01))
            .setValorDeducoes(BigDecimal.ZERO)
            .setValorPIS(BigDecimal.ZERO)
            .setValorCOFINS(BigDecimal.ZERO)
            .setValorINSS(BigDecimal.ZERO)
            .setValorIR(BigDecimal.ZERO)
            .setValorCSLL(BigDecimal.ZERO)
            .setCodigoServico("")
            .setAliquotaServicos(BigDecimal.ZERO)
            .setISSRetido(false)
            .setCPFCNPJTomador(new TpCPFCNPJNIF().setCNPJ(""))
            .setEnderecoTomador(new TpEndereco().setLogradouro("").setBairro("").setCidade(4216602).setUF("SC").setCEP(""))
            .setDiscriminacao("Teste emissao NFSe");
        pedidoEnvioRPS.addRps(rps);

//        final var response = new WSFacade(config).enviarRPS(pedidoEnvioRPS);
//        System.out.println(response);
    }

    @Disabled
    @Test
    public void testeConsultaNFe() throws Exception {
        final var pedidoConsultaNFe = new NFSeSPSaoPauloRequestConsultaNFe();
        pedidoConsultaNFe.setCabecalho(new NFSeSPSaoPauloRequestConsultaNFeCabecalho().setCpfCnpjRemetente(new TpCPFCNPJ().setCNPJ("")).setVersao("1"));
        pedidoConsultaNFe.addDetalhe(new NFSeSPSaoPauloRequestConsultaNFeDetalhe().setChaveNFe(new TpChaveNFe().setNumeroNFe("").setInscricaoPrestador("")));
        final var response = new WSFacade(config).enviarPedidoConsultaNFe(pedidoConsultaNFe);
        System.out.println(response.toXml());
    }

    @Disabled
    @Test
    public void testeCancelamentoNFe() throws Exception {
        final var pedidoCancelamentoNFe = new NFSeSPSaoPauloRequestCancelamentoNFe();
        pedidoCancelamentoNFe.setCabecalho(new NFSeSPSaoPauloRequestCancelamentoNFeCabecalho().setCpfCnpjRemetente(new TpCPFCNPJ().setCNPJ("")).setTransacao(false).setVersao("1"));

        NFSeSPSaoPauloRequestCancelamentoNFeDetalhe detalheItem = new NFSeSPSaoPauloRequestCancelamentoNFeDetalhe().setChaveNFe(new TpChaveNFe().setNumeroNFe("").setInscricaoPrestador(""));
        pedidoCancelamentoNFe.addDetalhe(detalheItem);

        final var response = new WSFacade(config).enviarPedidoCancelamentoNFe(pedidoCancelamentoNFe);
        System.out.println(response.toXml());
    }
}
