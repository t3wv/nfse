package io.github.t3wv.municipal.nfseSPSaoPaulo.utils;

import io.github.t3wv.NFSeConfig;
import io.github.t3wv.municipal.nfseSPSaoPaulo.classes.TpRPS;
import io.github.t3wv.municipal.nfseSPSaoPaulo.requests.NFSeSPSaoPauloRequestEnvioRPS;
import io.github.t3wv.utils.NFSeUtils;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public abstract class NFSeSPSaoPauloUtils {
    /**
     * ️  Gera a string de assinatura digital dos RPS conforme o layout definido pela Prefeitura de São Paulo ️
     * <a href="https://notadomilhao.sf.prefeitura.sp.gov.br/wp-content/uploads/2025/11/NFe_Web_Service-4.pdf"> Página 47</a>
     */
    public static NFSeSPSaoPauloRequestEnvioRPS assinarRPSs(NFSeConfig config, NFSeSPSaoPauloRequestEnvioRPS pedido) {
        final var versaoSchemas = pedido.getCabecalho().getVersao();
        for (TpRPS rps : pedido.getRps()) {
            try {
                final var assinaturaDigitalString = new StringBuilder();
                final var chaveRps = rps.getChaveRPS();
                final var tomador = rps.getCPFCNPJTomador();

                assinaturaDigitalString.append(StringUtils.leftPad(chaveRps.getInscricaoPrestador(), versaoSchemas.equals("2") ? 12 : 8, "0"));
                assinaturaDigitalString.append(StringUtils.rightPad(StringUtils.trimToEmpty(chaveRps.getSerieRPS()), 5));
                assinaturaDigitalString.append(StringUtils.leftPad(chaveRps.getNumeroRPS(), 12, "0"));
                assinaturaDigitalString.append(rps.getDataEmissao().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
                assinaturaDigitalString.append(rps.getTributacaoRPS());
                assinaturaDigitalString.append(rps.getStatusRPS());
                assinaturaDigitalString.append(rps.isISSRetido() ? "S" : "N");
                assinaturaDigitalString.append(StringUtils.leftPad(String.valueOf(versaoSchemas.equals("2") ? rps.getValorInicialCobrado() : rps.getValorServicos()).replaceAll("\\D", ""), 15, "0"));
                assinaturaDigitalString.append(StringUtils.leftPad(String.valueOf(rps.getValorDeducoes()).replaceAll("\\D", ""), 15, "0"));
                assinaturaDigitalString.append(StringUtils.leftPad(rps.getCodigoServico(), 5, "0"));
                assinaturaDigitalString.append(NFSeUtils.isCpfValido(tomador.getCPF()) ? "1" : NFSeUtils.isCnpjValido(tomador.getCNPJ()) ? "2" : versaoSchemas.equals("2") && StringUtils.isNotBlank(tomador.getNIF()) ? "4" : "3");
                assinaturaDigitalString.append(StringUtils.leftPad(StringUtils.firstNonBlank(tomador.getCPF(), tomador.getCNPJ()), 14, "0"));

                if (rps.getCPFCNPJIntermediario() != null) {
                    final var intermediario = rps.getCPFCNPJIntermediario();
                    assinaturaDigitalString.append(NFSeUtils.isCpfValido(intermediario.getCPF()) ? "1" : NFSeUtils.isCnpjValido(intermediario.getCNPJ()) ? "2" : "3");
                    assinaturaDigitalString.append(StringUtils.leftPad(StringUtils.firstNonBlank(intermediario.getCPF(), intermediario.getCNPJ()), 14, "0"));
                    assinaturaDigitalString.append(StringUtils.trimToEmpty(rps.getISSRetidoIntermediario()));
                    assinaturaDigitalString.append(versaoSchemas.equals("2") ? (tomador.getNaoNIF() != null ? String.valueOf(tomador.getNaoNIF()) : StringUtils.trim(tomador.getNIF())) : "");
                }

                System.out.println(assinaturaDigitalString.toString());
                final var assinaturaDigital = NFSeSPSaoPauloUtils.gerarAssinaturaDigital(config, assinaturaDigitalString.toString());
                rps.setAssinatura(assinaturaDigital);
            } catch (Exception e) {
                throw new RuntimeException("Erro ao gerar assinatura digital do RPS: " + e.getMessage(), e);
            }
        }

        return pedido;
    }

    public static String gerarAssinaturaDigital(NFSeConfig config, String assinaturaString) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, InvalidKeyException, SignatureException {

        // 1º - Converte a string para bytes ASCII
        final byte[] dadosBytes = assinaturaString.getBytes(StandardCharsets.US_ASCII);

        // 2º - Gera o hash SHA-1 dos dados
        String alias = config.getKeyStoreCertificado().aliases().nextElement();
        PrivateKey privateKey = (PrivateKey) config.getKeyStoreCertificado().getKey(alias, config.getCertificadoSenha().toCharArray());
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(privateKey);
        signature.update(dadosBytes);
        return Base64.getEncoder().encodeToString(signature.sign());
    }
}
