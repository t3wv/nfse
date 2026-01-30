package io.github.t3wv.nfse.municipal;

import io.github.t3wv.nfse.NFSeLogger;
import io.github.t3wv.nfse.municipal.nfseSCSaoJose.WSSaoJose;
import io.github.t3wv.nfse.municipal.nfseSCSaoJose.arquivos.NFSeSCSaoJoseCancelamentoEnvio;
import io.github.t3wv.nfse.municipal.nfseSCSaoJose.arquivos.NFSeSCSaoJoseCancelamentoSolicitacaoEnvio;
import io.github.t3wv.nfse.municipal.nfseSCSaoJose.arquivos.NFSeSCSaoJoseEmissaoEnvio;
import io.github.t3wv.nfse.municipal.nfseSCSaoJose.arquivos.NFSeSCSaoJosePesquisaCodigoAutenticidadeEnvio;
import io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes.*;
import io.github.t3wv.nfse.municipal.nfseSCSaoJose.enums.NFSeSCSaoJosePessoaTipo;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalInfDPS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * Teste de emissao de NFSe para o municipio de Sao Jose SC
 */
class NFSeSCSaoJoseTest implements NFSeLogger {

    private static WSSaoJose ws;

    @BeforeAll
    static void setup() {
        ws = new WSSaoJose("", "");
    }

    @Disabled
    @Test
    void testeEmissaoSJ() throws Exception {
        final var arquivo = new NFSeSCSaoJoseEmissaoEnvio()
            .setTeste(true)
            .setNf(
                new NFSeSCSaoJoseNFSeEmissao()
                    .setValorTotal(new BigDecimal("")))
            .setPrestador(
                new NFSeSCSaoJoseNFSePrestador()
                    .setCidade("")
                    .setCpfCnpj(""))
            .setTomador(
                new NFSeSCSaoJoseNFSeTomador()
                    .setTipoPessoa(NFSeSCSaoJosePessoaTipo.FISICA)
                    .setCpfcnpj("")
                    .setNomeRazaoSocial("")
                    .setEmail(""))
            .addItem(
                new NFSeSCSaoJoseNFSeListaItem()
                    .setCodigoLocalPrestacaoServico("")
                    .setCodigoItemListaServico("")
                    .setDescritivo("")
                    .setAliquotaItemListaServico(new BigDecimal(""))
                    .setTributaMunicipioPrestador(true)
                    .setSituacaoTributaria("")
                    .setValorTributavel(new BigDecimal(""))
                    .setValorDeducao(BigDecimal.ZERO)
                    .setValorISSRF(BigDecimal.ZERO)
                    .setUnidadeCodigo("")
                    .setUnidadeQuantidade(BigDecimal.ONE)
                    .setUnidadeValorUnitario(new BigDecimal(""))
            );

        final var retorno = ws.enviarEmissaoNFSe(arquivo, "arquivo.xml");
        this.getLogger().info("NFSe emitida com sucesso: {}", retorno.toXml());
    }

    @Disabled
    @Test
    void testePesquisaCodigoAutenticidade() throws Exception {
        final var pesquisa = new NFSeSCSaoJosePesquisaCodigoAutenticidadeEnvio().setCodigoAutenticidade("");
        final var retorno = ws.consultaNFSeCodigoAutenticidade(pesquisa, "pesquisa.xml");
        this.getLogger().info(retorno.toXml());
    }

    @Disabled
    @Test
    void testeCancelamento() throws Exception {
        final var prestador = new NFSeSCSaoJoseNFSePrestador().setCidade("").setCpfCnpj("");
        final var nf = new NFSeSCSaoJoseNFSeCancelamento().setNumero("").setSerieNFSe("").setSituacao("C").setObservacao("");
        final var cancelamento = new NFSeSCSaoJoseCancelamentoEnvio().setNf(nf).setPrestador(prestador);
        final var retorno = ws.enviarCancelamentoNFSe(cancelamento, "cancelamento.xml");
        this.getLogger().info(retorno.toXml());
    }

    @Disabled
    @Test
    void testeArquivoCancelamentoXMLExemplo() throws Exception {
        // XML exemplo retirado do site da IPM Fiscal https://www.nfs-e.net/fiscalweb.php
        final var exemploCancelamento = "<nfse><nf><numero>20190013</numero><situacao>C</situacao><observacao>Cancelando uma NFS-e</observacao></nf><prestador><cpfcnpj>11252365444435</cpfcnpj><cidade>8291</cidade></prestador></nfse>";
        final var prestador = new NFSeSCSaoJoseNFSePrestador().setCidade("8291").setCpfCnpj("11252365444435");
        final var nf = new NFSeSCSaoJoseNFSeCancelamento().setNumero("20190013").setSituacao("C").setObservacao("Cancelando uma NFS-e");
        final var cancelamento = new NFSeSCSaoJoseCancelamentoEnvio().setNf(nf).setPrestador(prestador);
        Assertions.assertEquals(exemploCancelamento, cancelamento.toXml());
    }

    @Disabled
    @Test
    void testeArquivoCancelamentoSolicitacaoXMLExemplo() throws Exception {
        // XML exemplo retirado do site da IPM Fiscal https://www.nfs-e.net/fiscalweb.php
        final var exemploCancelamento = "<solicitacao_cancelamento><prestador><cpfcnpj>88888888853089</cpfcnpj><cidade>7493</cidade></prestador><documentos><nfse><numero>9</numero><serie>1</serie><observacao>Documento em Duplicidade com a nota 8</observacao><substituta><numero>8</numero><serie>1</serie></substituta></nfse><nfse><numero>11</numero><serie>1</serie><observacao>Documento em Duplicidade com a nota 10</observacao><substituta><numero>10</numero><serie>1</serie></substituta></nfse></documentos></solicitacao_cancelamento>";
        final var prestador = new NFSeSCSaoJoseNFSePrestador().setCidade("7493").setCpfCnpj("88888888853089");
        final var documentoUm = new NFSeSCSaoJoseNFSeCancelamentoSolicitacao().setNumero(9).setSerie(1).setObservacao("Documento em Duplicidade com a nota 8").setSubstituta(new NFSeSCSaoJoseNFSeCancelamentoSolicitacaoSubstituta().setNumero(8).setSerie(1));
        final var documentoDois = new NFSeSCSaoJoseNFSeCancelamentoSolicitacao().setNumero(11).setSerie(1).setObservacao("Documento em Duplicidade com a nota 10").setSubstituta(new NFSeSCSaoJoseNFSeCancelamentoSolicitacaoSubstituta().setNumero(10).setSerie(1));
        Assertions.assertEquals(exemploCancelamento, new NFSeSCSaoJoseCancelamentoSolicitacaoEnvio().setPrestador(prestador).setDocumentos(List.of(documentoUm, documentoDois)).toXml());
    }

    NFSeSCSaoJoseEmissaoEnvio testeConverteNacionalParaLocal(NFSeSefinNacionalInfDPS nfseSefinNacionalInfDPS) throws Exception {
        final var nfseSCSaoJose = new NFSeSCSaoJoseEmissaoEnvio();
        nfseSCSaoJose
            .setTeste(true)
            .setNf(
                new NFSeSCSaoJoseNFSeEmissao()
                    .setValorTotal(nfseSefinNacionalInfDPS.getValores().getValoresServicoPrestado().getValorServicos()))
            .setPrestador(
                new NFSeSCSaoJoseNFSePrestador()
                    .setCidade(nfseSefinNacionalInfDPS.getCodigoMunicipioEmissao())
                    .setCpfCnpj(nfseSefinNacionalInfDPS.getPrestador().getCNPJ()))
            .setTomador(
                new NFSeSCSaoJoseNFSeTomador()
                    .setTipoPessoa(NFSeSCSaoJosePessoaTipo.FISICA)
                    .setCpfcnpj(nfseSefinNacionalInfDPS.getTomador().getCPF())
                    .setNomeRazaoSocial(nfseSefinNacionalInfDPS.getTomador().getNome())
                    .setEmail(nfseSefinNacionalInfDPS.getTomador().getEmail()))
            .setItens(
                List.of(
                    new NFSeSCSaoJoseNFSeListaItem()
                        .setCodigoLocalPrestacaoServico(nfseSefinNacionalInfDPS.getServicoPrestado().getLocalPrestacao().getCodigoMunicipio())
                        .setCodigoItemListaServico(nfseSefinNacionalInfDPS.getServicoPrestado().getCServ().getCodigoNacionalTributacaoISSQN())
                        .setDescritivo(nfseSefinNacionalInfDPS.getServicoPrestado().getCServ().getDescricaoServico())
                        .setAliquotaItemListaServico(BigDecimal.ZERO)
                        .setTributaMunicipioPrestador(true)
                        .setSituacaoTributaria("0")
                        .setValorTributavel(nfseSefinNacionalInfDPS.getValores().getValoresServicoPrestado().getValorServicos())
                        .setValorDeducao(BigDecimal.ZERO)
                        .setValorISSRF(BigDecimal.ZERO)
                        .setUnidadeCodigo("1")
                        .setUnidadeQuantidade(BigDecimal.ONE)
                        .setUnidadeValorUnitario(nfseSefinNacionalInfDPS.getValores().getValoresServicoPrestado().getValorServicos())

                ));
        return nfseSCSaoJose;
    }
}
