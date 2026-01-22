package io.github.t3wv.nfse.utils;

import io.github.t3wv.nfse.NFSeConfig;
import io.github.t3wv.nfse.NFSeLogger;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.WSBarueri;
import io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.WSLoteNFe;
import io.github.t3wv.nfse.nacional.WSDANFSe;
import io.github.t3wv.nfse.nacional.WSParametrosMunicipais;
import io.github.t3wv.nfse.nacional.WSSefinNFSe;
import org.apache.commons.lang3.StringUtils;

import javax.net.ssl.*;
import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Classe utilitaria para gerar a cadeia de certificados (cacerts) necessaria para comunicacao com os webservices de NFSe.
 */
public abstract class NFSeCadeiaCertificados implements NFSeLogger {

    private static final int PORT = 443;

    public static byte[] geraCadeiaCertificados(final NFSeConfig config) throws Exception {
        final var cadeiaCertificadosSenha = config.getCadeiaCertificadosSenha();
        final KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, cadeiaCertificadosSenha.toCharArray());
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            NFSeCadeiaCertificados.get(keyStore, WSSefinNFSe.URL_BASE_PRODUCAO);
            NFSeCadeiaCertificados.get(keyStore, WSSefinNFSe.URL_BASE_HOMOLOGACAO);
            NFSeCadeiaCertificados.get(keyStore, WSDANFSe.URL_BASE_PRODUCAO);
            NFSeCadeiaCertificados.get(keyStore, WSDANFSe.URL_BASE_HOMOLOGACAO);
            NFSeCadeiaCertificados.get(keyStore, WSParametrosMunicipais.URL_BASE_PRODUCAO);
            NFSeCadeiaCertificados.get(keyStore, WSParametrosMunicipais.URL_BASE_HOMOLOGACAO);
            NFSeCadeiaCertificados.get(keyStore, WSBarueri.URL_BASE_PRODUCAO);
            NFSeCadeiaCertificados.get(keyStore, WSBarueri.URL_BASE_HOMOLOGACAO);
            NFSeCadeiaCertificados.get(keyStore, WSLoteNFe.URL_BASE);

            // grava o keystore em um array de bytes
            keyStore.store(out, cadeiaCertificadosSenha.toCharArray());
            return out.toByteArray();
        }
    }

    private static void get(final KeyStore keyStore, final String url) throws Exception {
        NFSeLogger.getLogger(NFSeCadeiaCertificados.class).debug("Obtendo cadeia de certificados para a URL: {}", url);
        if (StringUtils.isNotBlank(url)) {
            // obtém o host a partir da URL fornecida - necessário para abrir a conexão SSL
            final var host = new URI(url).getHost();

            final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);

            final X509TrustManager defaultTrustManager = (X509TrustManager) trustManagerFactory.getTrustManagers()[0];
            final SavingTrustManager savingTrustManager = new SavingTrustManager(defaultTrustManager);

            final SSLContext sslContext = SSLContext.getInstance(NFSeHttpClient.PROTOCOL);
            sslContext.init(null, new TrustManager[]{savingTrustManager}, null);

            NFSeLogger.getLogger(NFSeCadeiaCertificados.class).debug("Abrindo conexao para o servidor: {}:{}", host, NFSeCadeiaCertificados.PORT);
            try (SSLSocket sslSocket = (SSLSocket) sslContext.getSocketFactory().createSocket(host, NFSeCadeiaCertificados.PORT)) {
                sslSocket.setSoTimeout(10000);
                sslSocket.startHandshake();
            } catch (final Exception e) {
                NFSeLogger.getLogger(NFSeCadeiaCertificados.class).error("[{}] {}", host, e.toString());
            }

            // se conseguir obter a cadeia de certificados, adiciona no keystore
            if (savingTrustManager.chain != null) {
                NFSeLogger.getLogger(NFSeCadeiaCertificados.class).debug("Certificados enviados pelo servidor: {}", savingTrustManager.chain.length);
                final MessageDigest sha1 = MessageDigest.getInstance("SHA1");
                final MessageDigest md5 = MessageDigest.getInstance("MD5");
                for (int i = 0; i < savingTrustManager.chain.length; i++) {
                    final X509Certificate certificate = savingTrustManager.chain[i];
                    sha1.update(certificate.getEncoded());
                    md5.update(certificate.getEncoded());

                    final String alias = String.format("%s.%s", host, i + 1);
                    keyStore.setCertificateEntry(alias, certificate);
                    NFSeLogger.getLogger(NFSeCadeiaCertificados.class).debug("Adicionado certificado no keystore com o alias: {}", alias);
                }
            }
        }
    }

    private static class SavingTrustManager implements X509TrustManager {
        private final X509TrustManager trustManager;
        private X509Certificate[] chain;

        SavingTrustManager(final X509TrustManager trustManager) {
            this.trustManager = trustManager;
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return this.trustManager.getAcceptedIssuers();
        }

        @Override
        public void checkClientTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
            this.trustManager.checkClientTrusted(chain, authType);
        }

        @Override
        public void checkServerTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
            this.chain = chain;
            this.trustManager.checkServerTrusted(chain, authType);
        }
    }
}
