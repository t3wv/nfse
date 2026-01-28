package io.github.t3wv.nfse.municipal;


import io.github.t3wv.nfse.NFSeConfig;
import io.github.t3wv.nfse.NFSeConfigTest;
import io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.WSFacade;
import io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.classes.*;
import io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.requests.*;
import io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.utils.NFSeSPSaoPauloUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NFSeSPSaoPauloTest {

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
        rps.setChaveRPS(new TpChaveRPS().setInscricaoPrestador("").setNumeroRPS(""));
        rps.setTipoRPS(TpTipoRPS.RPS);
        rps.setDataEmissao(LocalDate.now());
        rps.setStatusRPS(TpStatusNFe.N);
        rps.setTributacaoRPS("X");
        rps.setValorServicos(BigDecimal.valueOf(0.01));
        rps.setValorDeducoes(BigDecimal.ZERO);
        rps.setValorPIS(BigDecimal.ZERO);
        rps.setValorCOFINS(BigDecimal.ZERO);
        rps.setValorINSS(BigDecimal.ZERO);
        rps.setValorIR(BigDecimal.ZERO);
        rps.setValorCSLL(BigDecimal.ZERO);
        rps.setCodigoServico("02496");
        rps.setAliquotaServicos(BigDecimal.ZERO);
        rps.setISSRetido(false);
        rps.setCPFCNPJTomador(new TpCPFCNPJNIF().setCNPJ(""));
        rps.setEnderecoTomador(new TpEndereco().setLogradouro("").setBairro("").setCidade(4216602).setUF("SC").setCEP(""));
        rps.setDiscriminacao("Teste emissao NFSe");
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

        final var rps = new TpRPS();
        rps.setChaveRPS(new TpChaveRPS().setInscricaoPrestador("").setNumeroRPS(""));
        rps.setTipoRPS(TpTipoRPS.RPS);
        rps.setDataEmissao(LocalDate.now());
        rps.setStatusRPS(TpStatusNFe.N);
        rps.setTributacaoRPS("X");
        rps.setValorDeducoes(BigDecimal.ZERO);
        rps.setValorPIS(BigDecimal.ZERO);
        rps.setValorCOFINS(BigDecimal.ZERO);
        rps.setValorINSS(BigDecimal.ZERO);
        rps.setValorIR(BigDecimal.ZERO);
        rps.setValorCSLL(BigDecimal.ZERO);
        rps.setCodigoServico("02496");
        rps.setAliquotaServicos(BigDecimal.ZERO);
        rps.setISSRetido(false);
        rps.setCPFCNPJTomador(new TpCPFCNPJNIF().setCNPJ(""));
        rps.setEnderecoTomador(new TpEndereco().setLogradouro("").setBairro("").setCidade(4216602).setUF("SC").setCEP(""));
        rps.setDiscriminacao("Teste emissao NFSe");
        rps.setValorInicialCobrado(BigDecimal.valueOf(0.01));
        rps.setValorIPI(BigDecimal.ZERO);
        rps.setExigibilidadeSuspensa(1);
        rps.setPagamentoParceladoAntecipado(0);
        rps.setNBS("");
        rps.setCLocPrestacao("");
        rps.setIBSCBS(new TpIBSCBS().setFinNFSe(0).setIndFinal(0).setCIndOp("").setIndDest(0).setValores(new TpValores().setTrib(new TpTrib().setGIBSCBS(new TpGIBSCBS().setCClassTrib("200001")))));
        pedidoEnvioRPS.addRps(rps);

        // Gero e assino a assinatura digital de cada rps
        final var response = new WSFacade(config).enviarTesteLoteRPS(NFSeSPSaoPauloUtils.assinarRPSs(config, pedidoEnvioRPS));
        System.out.println(response.toXml());
    }

    @Disabled
    @Test
    public void envioSimplesRPSCUIDADO() throws Exception {
        final var pedidoEnvioRPS = new NFSeSPSaoPauloRequestEnvioRPSUnico();
        pedidoEnvioRPS.setCabecalho(new NFSeSPSaoPauloRequestEnvioRPSCabecalho()
                .setVersao("1")
                .setCPFCNPJRemetente(new TpCPFCNPJ().setCNPJ("")));

        final var rps = new TpRPS();
        rps.setChaveRPS(new TpChaveRPS().setInscricaoPrestador("").setNumeroRPS(""));
        rps.setTipoRPS(TpTipoRPS.RPS);
        rps.setDataEmissao(LocalDate.now());
        rps.setStatusRPS(TpStatusNFe.N);
        rps.setTributacaoRPS("X");
        rps.setValorServicos(BigDecimal.valueOf(0.01));
        rps.setValorDeducoes(BigDecimal.ZERO);
        rps.setValorPIS(BigDecimal.ZERO);
        rps.setValorCOFINS(BigDecimal.ZERO);
        rps.setValorINSS(BigDecimal.ZERO);
        rps.setValorIR(BigDecimal.ZERO);
        rps.setValorCSLL(BigDecimal.ZERO);
        rps.setCodigoServico("");
        rps.setAliquotaServicos(BigDecimal.ZERO);
        rps.setISSRetido(false);
        rps.setCPFCNPJTomador(new TpCPFCNPJNIF().setCNPJ(""));
        rps.setEnderecoTomador(new TpEndereco().setLogradouro("").setBairro("").setCidade(4216602).setUF("SC").setCEP(""));
        rps.setDiscriminacao("Teste emissao NFSe");
        pedidoEnvioRPS.addRps(rps);

        final var response = new WSFacade(config).enviarRPS(pedidoEnvioRPS);
        System.out.println(response);
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
        detalheItem.setAssinaturaCancelamento(NFSeSPSaoPauloUtils.gerarAssinaturaDigital(config, detalheItem.getAssinaturaString()));
        pedidoCancelamentoNFe.addDetalhe(detalheItem);

        final var response = new WSFacade(config).enviarPedidoCancelamentoNFe(pedidoCancelamentoNFe);
        System.out.println(response.toXml());
    }
}
