package io.github.t3wv.nfse.municipal;

import io.github.t3wv.nfse.NFSeConfig;
import io.github.t3wv.nfse.NFSeConfigTest;
import io.github.t3wv.nfse.NFSeLogger;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.WSBarueri;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos.*;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.*;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.services.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

@Disabled
public class NFSeSPBarueriTest implements NFSeLogger {

    private static NFSeConfig config;

    @BeforeAll
    static void prepara() {
        config = new NFSeConfigTest();
    }

    @Test
    public void testeEmiteCancela() throws Exception {
        NFSeBarueriRPSArquivoEnvioRegistroTipo1 linha1 = new NFSeBarueriRPSArquivoEnvioRegistroTipo1().fromLinha("");
        NFSeBarueriRPSArquivoEnvioRegistroTipo2 linha2 = new NFSeBarueriRPSArquivoEnvioRegistroTipo2().fromLinha("");
        NFSeBarueriRPSArquivoEnvioRegistroTipo4 linha4 = new NFSeBarueriRPSArquivoEnvioRegistroTipo4().fromLinha("");
        NFSeBarueriRPSArquivoEnvioRegistroTipo9 linha9 = new NFSeBarueriRPSArquivoEnvioRegistroTipo9().fromLinha("");

        linha1.setIdentificacaoRemessaContribuinte("");

        linha2.setLocalPrestacaoServico(NFSeBarueriLocalPrestacaoServico.OUTROS);

        linha4.setCodigoCidadeLocalServicoPrestado(null);
        linha4.setCodigoPostalLocalServicoPrestadoExterior("666");
        linha4.setEstadoProvinciaRegiaoLocalServicoPrestadoExterior("sldfk");
        linha4.setPaisLocalServicoPrestado(NFSeBarueriPais.US);

        final var arquivo = new NFSeBarueriRPSArquivoEnvio()
            .addRegistro(linha1)
            .addRegistro(linha2)
            .addRegistro(linha4)
            .addRegistro(linha9);

        final var wsBarueri = new WSBarueri(config);

        final var arquivoRequest = new NFSeBarueriLoteEnviarArquivoRequest()
                .setCpfCnpjContribuinte("")
                .setInscricaoMunicipal("")
                .setApenasValidaArquivo(false)
                .setNomeArquivoRPS("RPS_%s.rem".formatted(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))))
                .setArquivoRPSBase64(arquivo.toBase64());
        Files.write(Path.of("/tmp/%s.txt".formatted(arquivoRequest.getNomeArquivoRPS())), arquivo.toByteArray());

        // Envio o lote para emissão
        final NFSeBarueriLoteEnviarArquivoResponse responseEnvioEmissao = wsBarueri.loteEnviarArquivo(arquivoRequest);
        final var responseEnvioEmissaoProtocoloRemessa = responseEnvioEmissao.getResultado().getProtocoloRemessa();
        this.getLogger().info("Protocolo de remessa da emissão: %s".formatted(responseEnvioEmissaoProtocoloRemessa));
        Thread.sleep(1000);

        // Consulto o status do arquivo enviado
        final NFSeBarueriLoteStatusArquivoResponse responseStatusEmissao = wsBarueri
                .loteStatusArquivo(new NFSeBarueriLoteStatusArquivoRequest("", "", responseEnvioEmissao.getResultado().getProtocoloRemessa()));
        Files.writeString(Path.of("/tmp/%s".formatted(arquivoRequest.getNomeArquivoRPS().replaceAll(".rem", "_response_%s.xml".formatted(responseEnvioEmissao.getResultado().getProtocoloRemessa())))), responseStatusEmissao.toXml());
        this.getLogger().info("Arquivo enviado {}, com nome de retorno {}, com situacao {}: {}",
                responseStatusEmissao.getResult().getListaNfeArquivosRPS().getNomeArquivoOriginal(),
                responseStatusEmissao.getResult().getListaNfeArquivosRPS().getNomeArquivoRetorno(),
                responseStatusEmissao.getResult().getListaNfeArquivosRPS().getSituacaoArquivo().getCodigo(),
                responseStatusEmissao.getResult().getListaNfeArquivosRPS().getSituacaoArquivo().getDescricao());
        Thread.sleep(1000);

        // Baixo o arquivo de retorno da emissão
        final NFSeBarueriLoteBaixarArquivoResponse responseBaixarEmissao = wsBarueri
                .loteBaixarArquivo(new NFSeBarueriLoteBaixarArquivoRequest(
                        "",
                        "",
                        responseStatusEmissao.getResult().getListaNfeArquivosRPS().getNomeArquivoRetorno()));
        Files.writeString(Path.of("/tmp/%s".formatted(arquivoRequest.getNomeArquivoRPS().replaceAll(".rem", "_download_%s.xml".formatted(responseEnvioEmissao.getResultado().getProtocoloRemessa())))), responseBaixarEmissao.toXml());

        if (!"OK200".equals(responseBaixarEmissao.getResultado().getListaMensagemRetorno().getCodigo())) {
            throw new IllegalStateException("%s - %s - %s".formatted(
                    responseBaixarEmissao.getResultado().getListaMensagemRetorno().getCodigo(),
                    responseBaixarEmissao.getResultado().getListaMensagemRetorno().getMensagem(),
                    responseBaixarEmissao.getResultado().getListaMensagemRetorno().getCorrecao()));
        }

        final NFSeBarueriLoteBaixarArquivoResult resultadoEmissao = responseBaixarEmissao.getResultado();
        Files.write(Path.of("/tmp/%s".formatted(arquivoRequest.getNomeArquivoRPS().replaceAll(".rem", "_resultado_%s.txt".formatted(responseEnvioEmissao.getResultado().getProtocoloRemessa())))), Base64.getDecoder().decode(resultadoEmissao.getArquivoRPSBase64()));
        if (!"OK200".equals(resultadoEmissao.getListaMensagemRetorno().getCodigo())) {
            throw new IllegalStateException("%s - %s - %s".formatted(
                    resultadoEmissao.getListaMensagemRetorno().getCodigo(),
                    resultadoEmissao.getListaMensagemRetorno().getMensagem(),
                    resultadoEmissao.getListaMensagemRetorno().getCorrecao()));
        }

        if (NFSeBarueriArquivoRetornoSituacaoArquivo.ARQUIVO_COM_ERROS.equals(responseStatusEmissao.getResult().getListaNfeArquivosRPS().getSituacaoArquivo())) {
            final var arquivoRemessaComErros = resultadoEmissao.getArquivoEnvioComErros();
            for (final var erro : arquivoRemessaComErros.getErros()) {
                this.getLogger().error("Erro no arquivo de remessa - Código: {}, Descrição: {}, Solução: {}",
                        erro.getCodigo(),
                        erro.getDescricao(),
                        erro.getSolucao());
            }
        } else {
            final var arquivoRetorno = resultadoEmissao.getArquivoRetorno();
            for (NFSeBarueriRPSArquivoRetornoRegistro registro : arquivoRetorno.getRegistros()) {
                if (NFSeBarueriRPSArquivoRetornoRegistroTipo2.TIPO_REGISTRO.equals(registro.getTipoRegistro())) {
                    final var registroTipo2 = (NFSeBarueriRPSArquivoRetornoRegistroTipo2) registro;
                    final var serie = registroTipo2.getSerieNFe();
                    final var numero = registroTipo2.getNumeroNFe();
                    final var emissao = registroTipo2.getDataNFe();
                    final var rps = registroTipo2.getNumeroRPS();
                    final var tomadorDocumento = registroTipo2.getTomadorDocumento();
                    final var codigoAtenticidade = registroTipo2.getCodigoAutenticidade();
                    //final var chaveNFSeNacional = registroTipo2.getChaveAcessoNFSeNacional();

                    //salva o pdf da emissao
                    try (final InputStream in = new URI(String.format("http://testeeiss.barueri.sp.gov.br/nfe/wfimagemnota.aspx?codigoautenticidade=%s&numdoc=%s", codigoAtenticidade, tomadorDocumento)).toURL().openStream()) {
                        this.getLogger().debug("Download PDF nota servico Barueri: {} {}", codigoAtenticidade, tomadorDocumento);
                        Files.write(Path.of("/tmp/%s_%s_emitida.pdf".formatted(rps, numero)), in.readAllBytes());
                    }

                    //inicia o cancelamento
                    for (NFSeBarueriRPSArquivoEnvioRegistro arquivoRegistro : arquivo.getRegistros()) {
                        if (NFSeBarueriRPSArquivoEnvioRegistroTipo1.TIPO_REGISTRO.equals(arquivoRegistro.getTipoRegistro())) {
                            final var rpsParaCancelamento = (NFSeBarueriRPSArquivoEnvioRegistroTipo1) arquivoRegistro;
                            rpsParaCancelamento.setIdentificacaoRemessaContribuinte("%s%s".formatted(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMdd")), LocalTime.now().toSecondOfDay()));
                        }
                        if (NFSeBarueriRPSArquivoEnvioRegistroTipo2.TIPO_REGISTRO.equals(arquivoRegistro.getTipoRegistro())) {
                            final var rpsParaCancelamento = (NFSeBarueriRPSArquivoEnvioRegistroTipo2) arquivoRegistro;
                            rpsParaCancelamento
                                    .setNumeroRPS(0L)
                                    .setSituacaoRPS(NFSeBarueriSituacao.CANCELADO)
                                    .setMotivoCancelamento(NFSeBarueriMotivoCancelamento.CANCELAMENTO)
                                    .setNumeroNfeASerCanceladaOuSubstituida(String.valueOf(numero))
                                    .setSerieNfeASerCanceladaOuSubstituida(serie)
                                    .setDataEmissaoNFeASerCanceladaOuSubstituida(emissao)
                                    .setDescricaoCancelamento("Teste de cancelamento");
                        }
                    }

                    //refaz a request
                    final var cancelamentoRequest = new NFSeBarueriLoteEnviarArquivoRequest()
                            .setCpfCnpjContribuinte("03918609000647")
                            .setInscricaoMunicipal("4458481")
                            .setApenasValidaArquivo(false)
                            .setNomeArquivoRPS("RPS_%s_cancelamento.rem".formatted(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))))
                            .setArquivoRPSBase64(arquivo.toBase64());
                    Files.write(Path.of("/tmp/%s.txt".formatted(cancelamentoRequest.getNomeArquivoRPS())), arquivo.toByteArray());

                    // Envio o lote para emissão
                    final var cancelamentoEnvioResponse = wsBarueri.loteEnviarArquivo(cancelamentoRequest);
                    final var cancelamentoEnvioResponseProtocoloRemessa = cancelamentoEnvioResponse.getResultado().getProtocoloRemessa();
                    this.getLogger().info("Protocolo de remessa do cancelamento: %s".formatted(cancelamentoEnvioResponseProtocoloRemessa));
                    Thread.sleep(1000);

                    // Consulto o status do arquivo enviado
                    final var cancelamentoStatusResponse = wsBarueri.loteStatusArquivo(new NFSeBarueriLoteStatusArquivoRequest("4458481", "03918609000647", cancelamentoEnvioResponse.getResultado().getProtocoloRemessa()));
                    Files.writeString(Path.of("/tmp/%s".formatted(cancelamentoRequest.getNomeArquivoRPS().replaceAll(".rem", "_response_%s.xml".formatted(cancelamentoEnvioResponse.getResultado().getProtocoloRemessa())))), cancelamentoStatusResponse.toXml());
                    this.getLogger().info("Arquivo enviado {}, com nome de retorno {}, com situacao {}: {}",
                            cancelamentoStatusResponse.getResult().getListaNfeArquivosRPS().getNomeArquivoOriginal(),
                            cancelamentoStatusResponse.getResult().getListaNfeArquivosRPS().getNomeArquivoRetorno(),
                            cancelamentoStatusResponse.getResult().getListaNfeArquivosRPS().getSituacaoArquivo().getCodigo(),
                            cancelamentoStatusResponse.getResult().getListaNfeArquivosRPS().getSituacaoArquivo().getDescricao());
                    Thread.sleep(1000);

                    // Baixo o arquivo de retorno da emissão
                    final var responseBaixarCancelamento = wsBarueri
                            .loteBaixarArquivo(new NFSeBarueriLoteBaixarArquivoRequest(
                                    "4458481",
                                    "03918609000647",
                                    cancelamentoStatusResponse.getResult().getListaNfeArquivosRPS().getNomeArquivoRetorno()));
                    Files.writeString(Path.of("/tmp/%s".formatted(cancelamentoRequest.getNomeArquivoRPS().replaceAll(".rem", "_download_%s.xml".formatted(cancelamentoEnvioResponse.getResultado().getProtocoloRemessa())))), responseBaixarCancelamento.toXml());
                    if (!"OK200".equals(responseBaixarCancelamento.getResultado().getListaMensagemRetorno().getCodigo())) {
                        throw new IllegalStateException("%s - %s - %s".formatted(
                                responseBaixarCancelamento.getResultado().getListaMensagemRetorno().getCodigo(),
                                responseBaixarCancelamento.getResultado().getListaMensagemRetorno().getMensagem(),
                                responseBaixarCancelamento.getResultado().getListaMensagemRetorno().getCorrecao()));
                    }

                    final var resultadoCancelamento = responseBaixarCancelamento.getResultado();
                    Files.write(Path.of("/tmp/%s".formatted(cancelamentoRequest.getNomeArquivoRPS().replaceAll(".rem", "_resultado_%s.txt".formatted(cancelamentoEnvioResponse.getResultado().getProtocoloRemessa())))), Base64.getDecoder().decode(resultadoCancelamento.getArquivoRPSBase64()));
                    if (!"OK200".equals(resultadoCancelamento.getListaMensagemRetorno().getCodigo())) {
                        throw new IllegalStateException("%s - %s - %s".formatted(
                                resultadoCancelamento.getListaMensagemRetorno().getCodigo(),
                                resultadoCancelamento.getListaMensagemRetorno().getMensagem(),
                                resultadoCancelamento.getListaMensagemRetorno().getCorrecao()));
                    }

                    if (NFSeBarueriArquivoRetornoSituacaoArquivo.ARQUIVO_COM_ERROS.equals(cancelamentoStatusResponse.getResult().getListaNfeArquivosRPS().getSituacaoArquivo())) {
                        final var arquivoRemessaComErros = resultadoCancelamento.getArquivoEnvioComErros();
                        for (final var erro : arquivoRemessaComErros.getErros()) {
                            this.getLogger().error("Erro no arquivo de remessa - Código: {}, Descrição: {}, Solução: {}",
                                    erro.getCodigo(),
                                    erro.getDescricao(),
                                    erro.getSolucao());
                        }
                    } else {
                        //salva o pdf do cancelamento
                        try (final InputStream in = new URI(String.format("http://testeeiss.barueri.sp.gov.br/nfe/wfimagemnota.aspx?codigoautenticidade=%s&numdoc=%s", codigoAtenticidade, tomadorDocumento)).toURL().openStream()) {
                            this.getLogger().debug("Download PDF nota servico Barueri: {} {}", codigoAtenticidade, tomadorDocumento);
                            Files.write(Path.of("/tmp/%s_%s_cancelada.pdf".formatted(rps, numero)), in.readAllBytes());
                        }
                    }
                }
            }
        }
    }
}
