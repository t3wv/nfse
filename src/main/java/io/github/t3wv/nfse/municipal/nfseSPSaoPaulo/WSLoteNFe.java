package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo;

import io.github.t3wv.nfse.NFSeConfig;
import io.github.t3wv.nfse.NFSeLogger;
import io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.requests.*;
import io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.utils.NFSeSPSaoPauloUtils;
import io.github.t3wv.nfse.utils.NFSeAssinaturaDigital;
import io.github.t3wv.nfse.utils.NFSeHttpClient;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.apache.commons.lang3.StringUtils;

import java.net.URI;
import java.util.Map;

public class WSLoteNFe implements NFSeLogger {

    public static final String URL_BASE = "https://nfews.prefeitura.sp.gov.br/lotenfe.asmx";

    private final NFSeConfig config;

    public WSLoteNFe(NFSeConfig config) {
        this.config = config;
    }

    public NFSeSPSaoPauloRetornoEnvioLoteRPS enviarTesteLoteRPS(NFSeSPSaoPauloRequestEnvioRPS pedidoEnvioRPS) throws Exception {
        final var body = String.format("<?xml version=\"1.0\" encoding=\"utf-8\"?><soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\"><soap12:Body><TesteEnvioLoteRPSRequest xmlns=\"http://www.prefeitura.sp.gov.br/nfe\"><VersaoSchema>%s</VersaoSchema><MensagemXML><![CDATA[%s]]></MensagemXML></TesteEnvioLoteRPSRequest></soap12:Body></soap12:Envelope>", pedidoEnvioRPS.getCabecalho().getVersao(), new NFSeAssinaturaDigital(this.config).setOmitirDeclaracaoXML(true).setUsarIdComoReferencia(false).assinarDocumento(NFSeSPSaoPauloUtils.assinarRPSs(config, pedidoEnvioRPS).toXml()));
        this.getLogger().debug("Enviando RPS de teste para o município de São Paulo com xml: {}", body);

        final var response = new NFSeHttpClient(this.config).sendPostRequest(new URI(URL_BASE), Map.of("Content-Type", "application/soap+xml; charset=utf-8"), body);
        final var responseBody = StringUtils.trimToEmpty(response.body()); // Trim no body porque o webservice retorna espaços em branco antes do XML
        final var responseCode = response.statusCode();

        if (responseCode != 200) {
            throw new Exception("Request de RPS de teste retornou erro '%d'!".formatted(responseCode));
        } else {
            this.getLogger().debug("RPS de teste enviado com sucesso: {}", responseBody);
            return (NFSeSPSaoPauloRetornoEnvioLoteRPS) new NFSePersister().read(NFSeSPSaoPauloSoapEnvelope.class, response.body()).getResponse();
        }
    }

    public NFSeSPSaoPauloRetornoEnvioLoteRPS enviarRPS(NFSeSPSaoPauloRequestEnvioRPS pedidoEnvioRPS) throws Exception {
        final var body = String.format("<?xml version=\"1.0\" encoding=\"utf-8\"?><soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\"><soap12:Body><EnvioRPSRequest xmlns=\"http://www.prefeitura.sp.gov.br/nfe\"><VersaoSchema>%s</VersaoSchema><MensagemXML><![CDATA[%s]]></MensagemXML></EnvioRPSRequest></soap12:Body></soap12:Envelope>", pedidoEnvioRPS.getCabecalho().getVersao(), new NFSeAssinaturaDigital(this.config).setOmitirDeclaracaoXML(true).setUsarIdComoReferencia(false).assinarDocumento(NFSeSPSaoPauloUtils.assinarRPSs(config, pedidoEnvioRPS).toXml()));
        this.getLogger().debug("Enviando RPS para o município de São Paulo com xml: {}", body);

        final var response = new NFSeHttpClient(this.config).sendPostRequest(new URI(URL_BASE), Map.of("Content-Type", "application/soap+xml; charset=utf-8"), body);
        final var responseBody = StringUtils.trimToEmpty(response.body()); // Trim no body porque o webservice retorna espaços em branco antes do XML
        final var responseCode = response.statusCode();

        if (responseCode != 200) {
            throw new Exception("Request de envio de RPS retornou erro '%d'!".formatted(responseCode));
        } else {
            this.getLogger().debug("RPS enviado com sucesso: {}", responseBody);
            return (NFSeSPSaoPauloRetornoEnvioLoteRPS) new NFSePersister().read(NFSeSPSaoPauloSoapEnvelope.class, response.body()).getResponse();
        }
    }

    public NFSeSPSaoPauloRetornoConsultaNFe enviarPedidoConsultaNFe(NFSeSPSaoPauloRequestConsultaNFe pedidoConsultaNFe) throws Exception {
        final var body = String.format("<?xml version=\"1.0\" encoding=\"utf-8\"?><soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\"><soap12:Body><ConsultaNFeRequest xmlns=\"http://www.prefeitura.sp.gov.br/nfe\"><VersaoSchema>1</VersaoSchema><MensagemXML><![CDATA[%s]]></MensagemXML></ConsultaNFeRequest></soap12:Body></soap12:Envelope>", new NFSeAssinaturaDigital(this.config).setOmitirDeclaracaoXML(true).setUsarIdComoReferencia(false).assinarDocumento(pedidoConsultaNFe.toXml()));
        this.getLogger().debug("Enviando consulta de NFe para o município de São Paulo com xml: {}", body);

        final var response = new NFSeHttpClient(this.config).sendPostRequest(new URI(URL_BASE), Map.of("Content-Type", "application/soap+xml; charset=utf-8"), body);
        final var responseBody = StringUtils.trimToEmpty(response.body()); // Trim no body porque o webservice retorna espaços em branco antes do XML
        final var responseCode = response.statusCode();

        if (responseCode != 200) {
            throw new Exception("Request de consulta de NFe retornou erro '%d'!".formatted(responseCode));
        } else {
            this.getLogger().debug("Consulta de NFe realizada com sucesso: {}", responseBody);
            return (NFSeSPSaoPauloRetornoConsultaNFe) new NFSePersister().read(NFSeSPSaoPauloSoapEnvelope.class, response.body()).getResponse();
        }
    }

    public NFSeSPSaoPauloRetornoCancelamentoNFe enviarPedidoCancelamentoNFe(NFSeSPSaoPauloRequestCancelamentoNFe pedidoCancelamentoNFe) throws Exception {
        // assinatura extra cancelamentos
        for (final var detalheItem : pedidoCancelamentoNFe.getDetalhe()) {
            detalheItem.setAssinaturaCancelamento(NFSeSPSaoPauloUtils.gerarAssinaturaDigital(config, detalheItem.getAssinaturaString()));
        }

        final var body = String.format("<?xml version=\"1.0\" encoding=\"utf-8\"?><soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\"><soap12:Body><CancelamentoNFeRequest xmlns=\"http://www.prefeitura.sp.gov.br/nfe\"><VersaoSchema>%s</VersaoSchema><MensagemXML><![CDATA[%s]]></MensagemXML></CancelamentoNFeRequest></soap12:Body></soap12:Envelope>", pedidoCancelamentoNFe.getCabecalho().getVersao(), new NFSeAssinaturaDigital(this.config).setOmitirDeclaracaoXML(true).setUsarIdComoReferencia(false).assinarDocumento(pedidoCancelamentoNFe.toXml()));
        this.getLogger().debug("Enviando pedido de cancelamento de NFe para o município de São Paulo com xml: {}", body);

        final var response = new NFSeHttpClient(this.config).sendPostRequest(new URI(URL_BASE), Map.of("Content-Type", "application/soap+xml; charset=utf-8"), body);
        final var responseBody = StringUtils.trimToEmpty(response.body()); // Trim no body porque o webservice retorna espaços em branco antes do XML
        final var responseCode = response.statusCode();

        if (responseCode != 200) {
            throw new Exception("Request de consulta de NFe retornou erro '%d'!".formatted(responseCode));
        } else {
            this.getLogger().debug("Pedido de cancelamento de NFe enviado com sucesso: {}", responseBody);
            return (NFSeSPSaoPauloRetornoCancelamentoNFe) new NFSePersister().read(NFSeSPSaoPauloSoapEnvelope.class, response.body()).getResponse();
        }
    }
}
