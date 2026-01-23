package io.github.t3wv.nfse.municipal;

import io.github.t3wv.nfse.NFSeConfig;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.WSBarueri;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos.*;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriLocalPrestacaoServico;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriPessoaTipo;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriSituacao;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.services.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class NFSeSPBarueriTest {

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
    public void testeEmiteCancela() throws Exception {
        final var arquivo = new NFSeBarueriRPSArquivoEnvio()
                .addLinha(new NFSeBarueriRPSArquivoEnvioRegistroTipo1()
                        .setInscricaoContribuinte("4458481")
                        .setVersaoLayout("PMB004")
                        .setIdentificacaoRemessaContribuinte(String.valueOf(System.nanoTime()).substring(0, 11)))
                .addLinha(new NFSeBarueriRPSArquivoEnvioRegistroTipo2()
                        .setTipoRPS("RPS")
                        //.setSerieRPS(StringUtils.trimToEmpty(linha.substring(6, 10)))
                        //.setSerieNFe(StringUtils.trimToEmpty(linha.substring(10, 15)))
                        .setNumeroRPS(1L)
                        .setDataRPS(LocalDate.now())
                        .setHoraRPS(LocalTime.now())
                        .setSituacaoRPS(NFSeBarueriSituacao.ENVIADO)
                        //.setMotivoCancelamento(NFSeBarueriMotivoCancelamento.valueOfCodigo(linha.substring(40, 42)))
                        //.setNumeroNfeASerCanceladaOuSubstituida(linha.substring(42, 49))
                        //.setSerieNfeASerCanceladaOuSubstituida(linha.substring(49, 54))
                        //.setDataEmissaoNFeASerCanceladaOuSubstituida(StringUtils.isNotBlank(StringUtils.stripStart(linha.substring(54, 62).trim(), "0")) ? LocalDate.from(WSBarueri.FORMATO_DATA.parse(linha.substring(54, 62))) : null)
                        //.setDescricaoCancelamento(linha.substring(62, 242))
                        .setCodigoServicoPrestado("990101200")
                        .setLocalPrestacaoServico(NFSeBarueriLocalPrestacaoServico.OUTROS)
                        .setServicoPrestadoEmViaPublica(false)
                        .setEnderecoLogradouroLocalServicoPrestado("AV PRESIDENTE KENNEDY")
                        .setEnderecoNumeroLocalServicoPrestado("568")
                        .setEnderecoComplementoLocalServicoPrestado("SALA 902")
                        .setEnderecoBairroLocalServicoPrestado("CAMPINAS")
                        .setEnderecoCidadeLocalServicoPrestado("SAO JOSE")
                        .setEnderecoUFLocalServicoPrestado("SC")
                        .setEnderecoCEPLocalServicoPrestado("88101050")
                        .setQuantidadeServicoPrestado(1)
                        .setValorServicoPrestado(BigDecimal.TEN)
                        //.setReservado(linha.substring(478, 483))
                        .setValorRetencoes(BigDecimal.ZERO)
                        .setTomadorEstrangeiro(false)
                        //.setPaisTomadorEstrangeiro(NFSeBarueriPais.valueOfCodigo(linha.substring(499, 502)))
                        .setServicoExportacao(false)
                        .setIndicadorCpfCnpjTomador(NFSeBarueriPessoaTipo.JURIDICA)
                        .setCpfCnpjTomador("52398509000138")
                        .setRazaoSocialTomador("T3W TECNOLOGIA LTDA")
                        .setEnderecoLogradouroTomador("RUA")
                        .setEnderecoNumeroTomador("NUMERO")
                        .setEnderecoComplementoTomador("COMPLEMENTO")
                        .setEnderecoBairroTomador("BAIRRO")
                        .setEnderecoCidadeTomador("SAO JOSE")
                        .setEnderecoUFTomador("SC")
                        .setEnderecoCEPTomador("88101050")
                        .setEmailTomador("DIEGO@T3W.IO")
                        //.setNumeroFatura(linha.substring(934, 940))
                        //.setValorFatura(StringUtils.isNotBlank(linha.substring(940, 955)) ? new BigDecimal(linha.substring(940, 955)).movePointLeft(2) : null)
                        //.setFormaPagamentoFatura(linha.substring(955, 970))
                        .setDiscriminacaoServico("TESTE DE EMISSAO E CANCELAMENTO"))
                .addLinha(new NFSeBarueriRPSArquivoEnvioRegistroTipo9()
                        .setQuantidadeLinhas(2)
                        .setValorTotalServicos(BigDecimal.TEN)
                        .setValorTotalServicosContidosRegistro3(BigDecimal.ZERO));

        final var arquivoRequest = new NFSeBarueriLoteEnviarArquivoRequest()
                .setApenasValidaArq(true)
                .setCpfCnpjContrib("03918609000647")
                .setInscricaoMunicipal("4458481")
                .setNomeArquivoRPS("RPS_%s.rem".formatted(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))))
                .setArquivoRPSBase64(arquivo.toBase64());
        Files.write(Path.of("/tmp/%s.txt".formatted(arquivoRequest.getNomeArquivoRPS())), arquivo.toByteArray());

        final var wsBarueri = new WSBarueri(config);

        // Envio o lote para emissão
        final NFSeBarueriLoteEnviarArquivoResponse responseEnvioEmissao = wsBarueri.loteEnviarArquivo(arquivoRequest);
        final var responseEnvioEmissaoErros = responseEnvioEmissao.getResultado().getListaMensagemRetorno();
        if (responseEnvioEmissaoErros != null) {
            throw new IllegalStateException("%s - %s - %s".formatted(responseEnvioEmissaoErros.getCodigo(), responseEnvioEmissaoErros.getMensagem(), responseEnvioEmissaoErros.getCorrecao()));
        }
        Thread.sleep(5000);

        // Consulto o status do arquivo enviado
        final NFSeBarueriLoteStatusArquivoResponse responseStatusEmissao = wsBarueri
                .loteStatusArquivo(new NFSeBarueriLoteStatusArquivoRequest("4458481", "03918609000647", responseEnvioEmissao.getResultado().getProtocoloRemessa()));
        Files.writeString(Path.of("/tmp/%s_%s.rem".formatted(arquivoRequest.getNomeArquivoRPS(), responseEnvioEmissao.getResultado().getProtocoloRemessa())), responseStatusEmissao.toXml());
        Thread.sleep(5000);

        // Baixo o arquivo de retorno da emissão
        final NFSeBarueriLoteBaixarArquivoResponse responseBaixarEmissao = wsBarueri
                .loteBaixarArquivo(new NFSeBarueriLoteBaixarArquivoRequest("4458481", "03918609000647", responseStatusEmissao.getResultado().getListaNfeArquivosRPS().getNomeArqRetorno()));
        Files.writeString(Path.of("/tmp/%s_%s.xml".formatted(arquivoRequest.getNomeArquivoRPS(), responseEnvioEmissao.getResultado().getProtocoloRemessa())), responseBaixarEmissao.toXml());

        final NFSeBarueriLoteBaixarArquivoResult resultadoEmissao = responseBaixarEmissao.getResultado();
        final byte[] arquivoB64 = Base64.getDecoder().decode(resultadoEmissao.getArquivoRPSBase64());
        Files.write(Path.of("/tmp/%s_%s.ret".formatted(arquivoRequest.getNomeArquivoRPS(), responseEnvioEmissao.getResultado().getProtocoloRemessa())), arquivoB64);
        final var arquivoRetorno = resultadoEmissao.getArquivoRetorno();

//        arquivoRetorno.getNotas()
//        final var errosEmissao = resultadoEmissao.getErros();
//
//        // Se houverem erros, lanço exceção
//        Assertions.assertTrue(errosEmissao.isEmpty(), String.format("Foram encontrados erros no retorno da emissao da NFS-e: %s", errosEmissao.entrySet().stream().map((entry) -> "Linha %s - Código %s: %s -  %s".formatted(entry.getKey(), entry.getValue().getCodigo(), entry.getValue().getDescricao(), entry.getValue().getSolucao())).collect(Collectors.joining("; "))));
//
//        // Caso não haja erros, extraio os dados relevantes da nota e prossigo com o cancelamento
//        final var serieNf = arquivoRetorno.getNotas().getFirst().getSerieNFe();
//        final var numeroNf = arquivoRetorno.getNotas().getFirst().getNumeroNFe();
//        final var chaveNFSeNacional = arquivoRetorno.getNotas().getFirst().getChaveAcessoNFSeNacional();
//
//        // Realizo o cancelamento da nota através do mesmo objeto RPS, alterando os campos necessários para o cancelamento
//        rps.setRpsSituacao(NFSeBarueriRPSSituacao.CANCELADO)
//                .setMotivoCancelamento(NFSeBarueriRPSCodigoMotivoCancelamento.CANCELAMENTO)
//                .setNotaSubstituidaDescricaoCancelamento("Teste de cancelamento")
//                .setNotaSubstituidaNumero(String.valueOf(numeroNf))
//                .setNotaSerie(serieNf)
//                .setNotaSubstituidaDataEmissao(rps.getRpsDataEmissao())//
//                .setCodigoServicoPrestado("101001220")
//                .setChaveNFSeReferenciada(chaveNFSeNacional);
//
//        // Gero o arquivo no formato que deve ser enviado dentro do SOAP para o cancelamento
//        final var arquivoRpsCancelamento = new NFSeBarueriRPSArquivoEnvio("", "", "PMB003", LocalDateTime.now(), List.of(rps));
//
//        // Envio o lote para cancelamento
//        final NFSeBarueriLoteEnviarArquivoResponse responseEnvioCancelamento = new WSRPS(config).loteEnviarArquivo(new NFSeBarueriLoteEnviarArquivoRequest(arquivoRpsCancelamento));
//        Thread.sleep(5000);
//
//        // Consulto o status do arquivo de cancelamento enviado
//        final NFSeBarueriLoteStatusArquivoResponse responseStatusCancelamento = new WSRPS(config).loteStatusArquivo(new NFSeBarueriLoteStatusArquivoRequest("", "", responseEnvioCancelamento.getResultado().getProtocoloRemessa()));
//        Thread.sleep(5000);
//
//        // Baixo o arquivo de retorno do cancelamento
//        final NFSeBarueriLoteBaixarArquivoResponse responseBaixarCancelamento = new WSRPS(config).loteBaixarArquivo(new NFSeBarueriLoteBaixarArquivoRequest("", "", responseStatusCancelamento.getResultado().getListaNfeArquivosRPS().getNomeArqRetorno()));
//        final NFSeBarueriLoteBaixarArquivoResult resultadoCancelamento = responseBaixarCancelamento.getResultado();
//        final byte[] arquivoCancelamentoB64 = Base64.getDecoder().decode(resultadoCancelamento.getArquivoRPSBase64());
//        Files.write(Paths.get(String.format("", arquivoRequest.getNomeArquivo())), arquivoCancelamentoB64);
//        final var errosCancelamento = resultadoCancelamento.getErros();
//
//        // Se houverem erros, lanço exceção
//        Assertions.assertTrue(errosCancelamento.isEmpty(), String.format("Foram encontrados erros no retorno do cancelmaneto da NFS-e: %s", errosCancelamento.entrySet().stream().map((entry) -> "Linha %s - Código %s: %s -  %s".formatted(entry.getKey(), entry.getValue().getCodigo(), entry.getValue().getDescricao(), entry.getValue().getSolucao())).collect(Collectors.joining("; "))));
    }

//    @Disabled
//    @Test
//    public void testeCancelamentoBarueri() throws Exception {
//        final var rps = new NFSeBarueriRPS()
//                .setRpsSerie("")
//                .setRpsNumero("")
//                .setRpsDataEmissao(LocalDate.now())
//                .setRpsHoraEmissao(LocalTime.now())
//                .setRpsSituacao(NFSeBarueriRPSSituacao.CANCELADO)
//                .setMotivoCancelamento(NFSeBarueriRPSCodigoMotivoCancelamento.CANCELAMENTO)
//                .setNotaSubstituidaNumero("")
//                .setNotaSubstituidaDataEmissao(LocalDate.of(2025, 12, 3))//
//                .setNotaSubstituidaDescricaoCancelamento("")
//                .setCodigoServicoPrestado("")
//                .setLocalPrestacaoServico(NFSeBarueriRPSLocalPrestacaoServico.OUTROS)
//                .setServicoPrestadoEmViasPublicas(NFSeBarueriRPSServicoPrestadoViasPublicas.SIM)
//                .setEnderecoServicoPrestado("")
//                .setEnderecoServicoPrestadoNumero("")
//                .setEnderecoServicoPrestadoComplemento("")
//                .setEnderecoServicoPrestadoBairro("")
//                .setEnderecoServicoPrestadoCidade("")
//                .setEnderecoServicoPrestadoUF("")
//                .setEnderecoServicoPrestadoCodigoPostal("")
//                .setQuantidadeServicoPrestado("")
//                .setValorServico(BigDecimal.valueOf(2.99))
//                .setTomadorTipo(NFSeBarueriRPSTomadorTipo.BRASILEIRO)
//                .setServicoExportacao(NFSeBarueriRPSServicoExportacao.NAO)
//                .setTomadorDocumento("")
//                .setTomadorRazaoSocial("")
//                .setTomadorEndereco("")
//                .setTomadorEnderecoNumero("")
//                .setTomadorEnderecoComplemento("")
//                .setTomadorEnderecoBairro("")
//                .setTomadorEnderecoCidade("")
//                .setTomadorEnderecoUF("")
//                .setTomadorEnderecoCodigoPostal("")
//                .setTomadorEmail("")
//                .setDiscriminacaoServicos("")
//                .setOptanteSimplesNacional(NFSeBarueriRPSOptanteSimplesNacional.NAO_OPTANTE)
//                .setRegimeApuracaoTributariaSimplesNacional(NFSeBarueriRPSRegimeApuracaoTributariaSimplesNacional.LEGISLACAO_FEDERAL_E_MUNICIPAL_TRIBUTO)
//                .setServicoPrestadoCidadeCodigoIBGE("")
//                .setTomadorCidadeCodigoIBGE("")
//                .setVinculoEntrePartes(NFSeBarueriRPSVinculoEntrePartes.SEM_VINCULO);
//
//
//        final var arquivoRps = new NFSeBarueriRPSArquivoEnvio("", "", "PMB002", LocalDateTime.now(), List.of(rps));
//        Files.write(Paths.get("".formatted(arquivoRps.getNomeArquivo())), arquivoRps.geraConteudoArquivo());
//        final NFSeBarueriLoteEnviarArquivoResponse responseEnvioCancelamento = new WSRPS(config).loteEnviarArquivo(new NFSeBarueriLoteEnviarArquivoRequest(arquivoRps));
//        Files.writeString(Paths.get("".formatted(responseEnvioCancelamento.getResultado().getProtocoloRemessa())), responseEnvioCancelamento.toXml());
//        Thread.sleep(5000);
//        final NFSeBarueriLoteStatusArquivoResponse responseStatusCancelamento = new WSRPS(config).loteStatusArquivo(new NFSeBarueriLoteStatusArquivoRequest("", "", responseEnvioCancelamento.getResultado().getProtocoloRemessa()));
//        Files.writeString(Paths.get("".formatted(responseEnvioCancelamento.getResultado().getProtocoloRemessa())), responseStatusCancelamento.toXml());
//        Thread.sleep(5000);
//        final NFSeBarueriLoteBaixarArquivoResponse responseBaixarCancelamento = new WSRPS(config).loteBaixarArquivo(new NFSeBarueriLoteBaixarArquivoRequest("", "", responseStatusCancelamento.getResultado().getListaNfeArquivosRPS().getNomeArqRetorno()));
//        Files.writeString(Paths.get("".formatted(responseEnvioCancelamento.getResultado().getProtocoloRemessa())), responseBaixarCancelamento.toXml());
//    }
}
