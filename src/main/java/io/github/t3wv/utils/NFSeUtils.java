package io.github.t3wv.utils;

import io.github.t3wv.nacional.classes.nfsenacional.NFSeSefinNacionalDPS;
import io.github.t3wv.nacional.classes.nfsenacional.NFSeSefinNacionalInfDPS;
import io.github.t3wv.nacional.classes.nfsenacional.NFSeSefinNacionalPedRegEvt;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.zip.GZIPInputStream;

public abstract class NFSeUtils {

    private static final List<String> CPFS_INVALIDOS = Arrays.asList("00000000000", "11111111111", "22222222222",
            "33333333333", "44444444444", "55555555555", "66666666666", "77777777777", "88888888888", "99999999999",
            "12345678909");

    /**
     * Verifica se o CNPJ informado eh valido. <br>
     * Nao verifica o tamanho e presume que este seja de 14 digidos e somente numeros.
     *
     * @param cnpj CNPJ a ser validado.
     * @return Se o CNPJ informado eh valido ou nao.
     */
    public static boolean isCnpjValido(final String cnpj) {
        if (cnpj == null || !cnpj.matches("^[0-9]{14}$")) {
            return false;
        }

        // verifica por falsos positivos
        if (cnpj.equalsIgnoreCase("00000000000000")) {
            return false;
        }

        String cnpjCalculado = cnpj.substring(0, 12);
        final char[] chrCNPJ = cnpj.toCharArray();

        // primeira parte
        int soma = 0;
        for (int i = 0; i < 4; i++) {
            if (((chrCNPJ[i] - 48) >= 0) && ((chrCNPJ[i] - 48) <= 9)) {
                soma += (chrCNPJ[i] - 48) * (6 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (((chrCNPJ[i + 4] - 48) >= 0) && ((chrCNPJ[i + 4] - 48) <= 9)) {
                soma += (chrCNPJ[i + 4] - 48) * (10 - (i + 1));
            }
        }
        int dig = 11 - (soma % 11);
        cnpjCalculado += (dig == 10) || (dig == 11) ? "0" : Integer.toString(dig);

        // segunda parte
        soma = 0;
        for (int i = 0; i < 5; i++) {
            if (((chrCNPJ[i] - 48) >= 0) && ((chrCNPJ[i] - 48) <= 9)) {
                soma += (chrCNPJ[i] - 48) * (7 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (((chrCNPJ[i + 5] - 48) >= 0) && ((chrCNPJ[i + 5] - 48) <= 9)) {
                soma += (chrCNPJ[i + 5] - 48) * (10 - (i + 1));
            }
        }
        dig = 11 - (soma % 11);
        cnpjCalculado += (dig == 10) || (dig == 11) ? "0" : Integer.toString(dig);
        return cnpj.equals(cnpjCalculado);
    }

    /**
     * Verifica se o CPF informado eh valido. <br>
     * Nao verifica o tamanho e presume que este seja de 11 digidos e somente numeros.
     *
     * @param cpf CPF a ser validado.
     * @return Se o CPF informado eh valido ou nao.
     */
    public static boolean isCpfValido(final String cpf) {
        if (cpf == null || !cpf.matches("^[0-9]{11}$")) {
            return false;
        }

        // verifica por falsos positivos
        if (CPFS_INVALIDOS.contains(cpf)) {
            return false;
        }

        int d1 = 0, d2 = 0;
        for (int i = 1; i < 10; i++) {
            final int digitoCPF = Integer.parseInt(cpf.substring(i - 1, i));

            // multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante
            d1 += (11 - i) * digitoCPF;

            // para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior
            d2 += (12 - i) * digitoCPF;
        }

        // primeiro resto da divisao por 11
        int resto = d1 % 11;

        // se o resultado for 0 ou 1 o digito eh 0 caso contrario o digito eh 11 menos o resultado anterior
        final int digito1 = resto < 2 ? 0 : 11 - resto;

        // segundo resto da divisao por 11
        resto = (d2 + (2 * digito1)) % 11;
        // se o resultado for 0 ou 1 o digito eh 0 caso contrario o digito eh 11 menos o resultado anterior
        final int digito2 = resto < 2 ? 0 : 11 - resto;

        // digito verificador do CPF que estah sendo validado
        final String nDigVerific = cpf.substring(cpf.length() - 2);

        // concatenando o primeiro resto com o segundo
        final String nDigResult = String.valueOf(digito1) + digito2;

        // comparar o digito verificador do cpf com o primeiro resto + o segundo resto
        return nDigVerific.equals(nDigResult);
    }

    /**
     * Gera o ID do Pedido de Registro de Evento conforme o layout definido na especificação técnica
     * "PRE" + Chave de Acesso da NFSe (44) + Código do Evento (6) + Número do Pedido de Registro do Evento (3)
     *
     * @param evento Evento para geração do ID
     * @return ID do Pedido de Registro de Evento conforme o layout definido
     */
    public static String gerarEventoId(NFSeSefinNacionalPedRegEvt evento) {
        assert evento != null : "Evento deve estar preenchido para gerar o ID";
        final var infPedReg = evento.getInfPedReg();
        assert infPedReg != null : "InfPedReg deve estar preenchido para gerar o ID";
        final var chaveAcessoNFSE = infPedReg.getChaveAcessoNFSE();
        assert chaveAcessoNFSE != null : "Chave de Acesso da NFSe deve estar preenchida para gerar o ID";
        final var eventoInfo = infPedReg.getEvento();
        assert eventoInfo != null : "Informações do Evento devem estar preenchidas para gerar o ID";
        final var codigoEvento = eventoInfo.getCodigoEvento();
        assert codigoEvento != null : "Código do Evento deve estar preenchido para gerar o ID";
        final var numeroPedidoRegistroEvento = infPedReg.getNPedRegEvento();
        assert numeroPedidoRegistroEvento != null : "Número do Pedido de Registro do Evento deve estar preenchido para gerar o ID";

        return String.format("PRE%s%s%s",
                chaveAcessoNFSE,
                codigoEvento,
                StringUtils.leftPad(numeroPedidoRegistroEvento, 3, '0')
        );
    }

    /**
     * Gera o ID da DPS conforme o layout definido na especificação técnica
     * "DPS" + Cód.Mun (7) + Tipo de Inscrição Federal (1) + Inscrição Federal (14 - CPF completar com 000 à esquerda) + Série DPS (5)+ Núm. DPS (15)
     *
     * @param dps DPS para geração do ID
     * @return ID da DPS conforme o layout definido
     */
    public static String gerarDPSId(final NFSeSefinNacionalDPS dps) {
        // Valido as informações necessárias para montar o ID
        assert dps != null : "DPS deve estar preenchido para gerar o ID";
        final NFSeSefinNacionalInfDPS infDps = dps.getInfDPS();
        assert infDps != null : "InfDPS deve estar preenchido para gerar o ID";
        final String codigoMunicipioEmissao = infDps.getCodigoMunicipioEmissao();
        assert codigoMunicipioEmissao != null : "Código do município de emissão não pode ser nulo para geração do ID da DPS";
        final int serie = Integer.parseInt(infDps.getSerie());
        assert serie > 0 && serie <= 99999 : "Série do DPS deve estar entre 1 e 99999 para geração do ID";
        final long numeroDPS = infDps.getNumeroDPS();
        assert numeroDPS > 0 && numeroDPS <= 999999999999999L : "Numero do DPS deve estar entre 1 e 999999999999999 para geração do ID";

        // Monto a inscrição federal de acordo com o emitente
        String inscricaoFederalEmitente;
        switch (infDps.getTipoEmitente()) {
            case PRESTADOR:
                final var prestador = infDps.getPrestador();
                if (prestador == null)
                    throw new AssertionError("Prestador deve estar preenchido para obter a inscricao federal");
                inscricaoFederalEmitente = StringUtils.firstNonBlank(prestador.getCNPJ(), prestador.getCPF());
                break;
            case TOMADOR:
                final var tomador = infDps.getTomador();
                if (tomador == null)
                    throw new AssertionError("Tomador deve estar preenchido para obter a inscricao federal");
                inscricaoFederalEmitente = StringUtils.firstNonBlank(tomador.getCNPJ(), tomador.getCPF());
                break;
            case INTERMEDIARIO:
                final var intermediario = infDps.getIntermediario();
                if (intermediario == null)
                    throw new AssertionError("Intermediario deve estar preenchido para obter a inscricao federal");
                inscricaoFederalEmitente = StringUtils.firstNonBlank(intermediario.getCNPJ(), intermediario.getCPF());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + infDps.getTipoEmitente());
        }
        ;

        if (inscricaoFederalEmitente == null) {
            throw new IllegalArgumentException("Inscrição Federal do emitente não pode ser nula para geração do ID da DPS");
        }

        final var tipoInscricaoFederal = NFSeUtils.isCpfValido(inscricaoFederalEmitente) ? 1 : (NFSeUtils.isCnpjValido(inscricaoFederalEmitente) ? 2 : 0);
        assert tipoInscricaoFederal != 0 : "Inscrição Federal do emitente inválida para geração do ID da DPS";

        // Formata os campos conforme o layout do ID
        final var codigoMunicipioEmissaoFormatado = StringUtils.leftPad(codigoMunicipioEmissao, 7, '0');
        final var inscricaoFederalFormatada = StringUtils.leftPad(inscricaoFederalEmitente, 14, '0');
        final var serieFormatada = StringUtils.leftPad(String.valueOf(serie), 5, '0');
        final var numeroDPSFormatado = StringUtils.leftPad(String.valueOf(numeroDPS), 15, '0');
        return String.format("DPS%s%s%s%s%s", codigoMunicipioEmissaoFormatado, tipoInscricaoFederal, inscricaoFederalFormatada, serieFormatada, numeroDPSFormatado);
    }

    /**
     * Decodifica o XML da NFSe que esta compactado em GZip e codificado em Base64.
     *
     * @param nfseXmlGZipB64 XML da NFSe compactado em GZip e codificado em Base64.
     * @return XML da NFSe decodificado.
     * @throws IOException Se ocorrer um erro durante a decodificação.
     */
    public static String decodeXmlGZipB64(String nfseXmlGZipB64) throws IOException {
        final byte[] conteudo = Base64.getDecoder().decode(nfseXmlGZipB64);//java 8
        try (GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(conteudo))) {
            try (BufferedReader bf = new BufferedReader(new InputStreamReader(gis, StandardCharsets.UTF_8))) {
                StringBuilder outStr = new StringBuilder();
                String line;
                while ((line = bf.readLine()) != null) {
                    outStr.append(line);
                }
                return outStr.toString();
            }
        }
    }
}
