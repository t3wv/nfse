package io.github.t3wv.nacional.webservices;

import io.github.t3wv.*;
import io.github.t3wv.nacional.classes.nfsenacional.*;
import io.github.t3wv.utils.NFSeAssinaturaDigital;
import io.github.t3wv.utils.NFSeUtils;

import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class WSSefinNFSe implements NFSeLogger {

    public static final String URL_BASE_PRODUCAO = "https://sefin.nfse.gov.br/sefinnacional";
    public static final String URL_BASE_HOMOLOGACAO = "https://sefin.producaorestrita.nfse.gov.br/sefinnacional";
    private static final String URL_PRODUCAO_NFSE = URL_BASE_PRODUCAO + "/nfse";
    private static final String URL_HOMOLOGACAO_NFSE = URL_BASE_HOMOLOGACAO + "/nfse";

    private final NFSeObjectMapper objectMapper = new NFSeObjectMapper();
    private final NFSeConfig config;


    public WSSefinNFSe(final NFSeConfig config) {
        this.config = config;
//        this.client = ;
    }

    /**
     * Consulta NFSe pela chave de acesso
     * @param nfseChaveAcesso chave de acesso da nfse
     * @return objeto de resposta da consulta
     * @throws Exception
     */
    public NFSeSefinNacionalGetResponse getNFSeByChaveAcesso(final String nfseChaveAcesso) throws Exception {
        final var url = new URI(String.format("%s/%s", config.isTeste() ? URL_HOMOLOGACAO_NFSE : URL_PRODUCAO_NFSE, nfseChaveAcesso));
        final var response = new NFSeHttpClient(config).sendGetRequest(url);
        this.getLogger().info(response.body());
        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalGetResponse.class);
    }

    /**
     * Emite NFSe a partir do DPS
     */
    public NFSeSefinNacionalPostResponseSucesso emitirNFSeByDPS(final NFSeSefinNacionalDPS dps) throws Exception {
        // Gera o id e seta no objeto para preenchimento no xml
        dps.getInfDPS().setId(NFSeUtils.gerarDPSId(dps));

        byte[] gzipped;
        try (var baos = new ByteArrayOutputStream(); var gos = new java.util.zip.GZIPOutputStream(baos)) {
            gos.write(new NFSeAssinaturaDigital(this.config).setOmitirDeclaracaoXML(false).setUsarIdComoReferencia(false).assinarDocumento(dps.toXml()).getBytes(StandardCharsets.UTF_8));
            gos.finish();
            gzipped = baos.toByteArray();
        };

        final var uri = new URI(String.format("%s", config.isTeste() ? URL_HOMOLOGACAO_NFSE : URL_PRODUCAO_NFSE));
        final var body = String.format("{dpsXmlGZipB64:\"%s\"}", Base64.getEncoder().encodeToString(gzipped));
        final var response = new NFSeHttpClient(config).sendPostRequest(uri, body);
        if (response.statusCode() != 201) {
            final var responseError = this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalPostResponseErro.class);
            throw new IllegalStateException(String.format("Erro ao enviar DPS. Erros: %s", responseError.getErros()));
        }

        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalPostResponseSucesso.class);
    }

    /**
     * Emite um evento de cancelamento para uma NFSe
     */
    public NFSeSefinNacionalPostResponseSucesso enviarPedidoRegistroEvento(final NFSeSefinNacionalPedRegEvt pedidoRegistroEvento) throws Exception {
        // Gera o id e seta no objeto para preenchimento no xml
        pedidoRegistroEvento.getInfPedReg().setId(NFSeUtils.gerarEventoId(pedidoRegistroEvento));

        byte[] gzipped;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             java.util.zip.GZIPOutputStream gos = new java.util.zip.GZIPOutputStream(baos)) {
            gos.write(new NFSeAssinaturaDigital(this.config).setOmitirDeclaracaoXML(false).setUsarIdComoReferencia(false).assinarDocumento(pedidoRegistroEvento.toXml(), "infPedReg").getBytes(StandardCharsets.UTF_8));
            gos.finish();
            gzipped = baos.toByteArray();
        }

        final var uri = new URI(String.format("%s/%s/eventos", config.isTeste() ? URL_HOMOLOGACAO_NFSE : URL_PRODUCAO_NFSE, pedidoRegistroEvento.getInfPedReg().getChaveAcessoNFSE()));
        final var body = String.format("{pedidoRegistroEventoXmlGZipB64:\"%s\"}", Base64.getEncoder().encodeToString(gzipped));
        final var response = new NFSeHttpClient(config).sendPostRequest(uri, body);

        if (response.statusCode() != 201) {
            final var responseError = this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalPostResponseErro.class);
            throw new IllegalStateException(String.format("Erro ao enviar pedido de registro de evento. Erros: %s", responseError.getErros()));
        }

        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalPostResponseSucesso.class);
    }
}
