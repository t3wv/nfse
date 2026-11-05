package io.github.t3wv.nfse.nacional.danfse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Formatações de texto do DANFSe (documentos, CEP, telefone, códigos, valores e datas), conforme a tabela do item 2.4.5 da
 * NT 008. Os métodos aceitam null; os campos sem informação no XML saem com um traço (nota 12).
 */
final class DanfseFormatador {

    /** Conteúdo dos campos sem informação no XML (item 2.4.5, nota 12). */
    static final String SEM_INFORMACAO = "-";

    private static final DateTimeFormatter DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final Locale PT_BR = Locale.forLanguageTag("pt-BR");
    /**
     * DDD seguido de telefone de 8 dígitos começando de 2 a 9 (fixo, ou celular no formato antigo, sem o nono dígito) ou de
     * celular com 9 dígitos começando com 9.
     */
    private static final String TELEFONE_BRASILEIRO = "[1-9]{2}([2-9]\\d{7}|9\\d{8})";

    /** Sigla da UF pelos dois primeiros dígitos do código de município do IBGE. */
    private static final Map<String, String> UF_POR_CODIGO_IBGE = Map.ofEntries(
            Map.entry("11", "RO"), Map.entry("12", "AC"), Map.entry("13", "AM"), Map.entry("14", "RR"), Map.entry("15", "PA"),
            Map.entry("16", "AP"), Map.entry("17", "TO"), Map.entry("21", "MA"), Map.entry("22", "PI"), Map.entry("23", "CE"),
            Map.entry("24", "RN"), Map.entry("25", "PB"), Map.entry("26", "PE"), Map.entry("27", "AL"), Map.entry("28", "SE"),
            Map.entry("29", "BA"), Map.entry("31", "MG"), Map.entry("32", "ES"), Map.entry("33", "RJ"), Map.entry("35", "SP"),
            Map.entry("41", "PR"), Map.entry("42", "SC"), Map.entry("43", "RS"), Map.entry("50", "MS"), Map.entry("51", "MT"),
            Map.entry("52", "GO"), Map.entry("53", "DF"));

    /**
     * Classe utilitária, não deve ser instanciada.
     */
    private DanfseFormatador() {
    }

    /**
     * Normaliza o texto do XML: troca caracteres de controle e sequências de espaços (inclusive as quebras de linha da
     * indentação do XML) por um único espaço, como faz o DANFSe gerado pelo Sistema Nacional.
     *
     * @param texto texto do XML, ou null
     * @return texto normalizado, ou string vazia
     */
    static String texto(final String texto) {
        if (texto == null) {
            return "";
        }
        final var resultado = new StringBuilder();
        texto.codePoints().forEach(codigo -> resultado.appendCodePoint(Character.isISOControl(codigo) || Character.isWhitespace(codigo) ? ' ' : codigo));
        return resultado.toString().replaceAll(" {2,}", " ").trim();
    }

    /**
     * @param texto texto já formatado, ou null
     * @return o texto, ou um traço quando vazio (nota 12)
     */
    static String ouTraco(final String texto) {
        final var normalizado = texto(texto);
        return normalizado.isEmpty() ? SEM_INFORMACAO : normalizado;
    }

    /**
     * Limita o texto à quantidade de caracteres do campo, terminando com reticências quando passar (item 2.4.5).
     *
     * @param texto texto a limitar, ou null
     * @param maximo quantidade máxima de caracteres, já contando as reticências
     * @return o texto inteiro, se couber, ou os primeiros {@code maximo - 3} caracteres seguidos de reticências
     */
    static String limitar(final String texto, final int maximo) {
        final var normalizado = texto(texto);
        if (normalizado.length() <= maximo) {
            return normalizado;
        }
        return semSeparadorNoFim(normalizado.substring(0, maximo - DanfseCanvas.RETICENCIAS.length())) + DanfseCanvas.RETICENCIAS;
    }

    /**
     * @param texto texto cortado
     * @return o texto sem espaços, pontuação e pipes no fim, para as reticências não virem depois de um separador
     */
    static String semSeparadorNoFim(final String texto) {
        return texto.replaceAll("[\\s,;:.|]+$", "");
    }

    /**
     * Junta as partes não vazias com o separador.
     *
     * @param separador separador entre as partes
     * @param partes textos, que podem ser null ou vazios
     * @return texto unido, ou string vazia se nenhuma parte tiver conteúdo
     */
    static String juntar(final String separador, final String... partes) {
        return Arrays.stream(partes).map(DanfseFormatador::texto).filter(parte -> !parte.isEmpty()).collect(Collectors.joining(separador));
    }

    /**
     * Formata CNPJ (nn.nnn.nnn/nnnn-nn, inclusive o alfanumérico) ou CPF (nnn.nnn.nnn-nn); outro valor é devolvido como está.
     *
     * @param valor somente dígitos (ou letras e dígitos no CNPJ alfanumérico)
     * @return documento formatado
     */
    static String cnpjOuCpf(final String valor) {
        final var documento = texto(valor);
        if (documento.matches("[0-9A-Z]{12}\\d{2}")) {
            return documento.replaceAll("(.{2})(.{3})(.{3})(.{4})(.{2})", "$1.$2.$3/$4-$5");
        }
        if (documento.matches("\\d{11}")) {
            return documento.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        }
        return documento;
    }

    /**
     * @param cnpj CNPJ, ou null
     * @param cpf CPF, ou null
     * @param nif NIF, ou null
     * @return o primeiro documento informado, formatado, ou um traço
     */
    static String documento(final String cnpj, final String cpf, final String nif) {
        for (final var valor : new String[]{cnpj, cpf, nif}) {
            if (!texto(valor).isEmpty()) {
                return limitar(cnpjOuCpf(valor), 40);
            }
        }
        return SEM_INFORMACAO;
    }

    /**
     * Formata o CEP como nn.nnn-nnn, como no exemplo da tabela do item 2.4.5; outro valor é devolvido como está.
     *
     * @param cep somente dígitos
     * @return CEP formatado
     */
    static String cep(final String cep) {
        final var valor = texto(cep);
        return valor.matches("\\d{8}") ? valor.replaceAll("(\\d{2})(\\d{3})(\\d{3})", "$1.$2-$3") : valor;
    }

    /**
     * Formata o telefone brasileiro com DDD, (nn) nnnn-nnnn (fixo ou celular sem o nono dígito) ou (nn) 9nnnn-nnnn (celular),
     * sem o 55 do país quando vier junto; outro valor (como o telefone do exterior) é devolvido como está.
     *
     * @param telefone somente dígitos
     * @return telefone formatado, ou um traço
     */
    static String telefone(final String telefone) {
        final var valor = texto(telefone);
        final var numero = valor.matches("55" + TELEFONE_BRASILEIRO) ? valor.substring(2) : valor;
        return ouTraco(numero.matches(TELEFONE_BRASILEIRO) ? numero.replaceAll("(\\d{2})(\\d{4,5})(\\d{4})", "($1) $2-$3") : limitar(valor, 20));
    }

    /**
     * Formata o código de tributação nacional (item, subitem e desdobro) como nn.nn.nn.
     *
     * @param codigo código com 6 dígitos
     * @return código formatado
     */
    static String codigoTributacaoNacional(final String codigo) {
        final var valor = texto(codigo);
        return valor.matches("\\d{6}") ? valor.replaceAll("(\\d{2})(\\d{2})(\\d{2})", "$1.$2.$3") : valor;
    }

    /**
     * Formata o código da NBS como n.nnnn.nn.nn.
     *
     * @param codigo código com 9 dígitos
     * @return código formatado, ou um traço
     */
    static String nbs(final String codigo) {
        final var valor = texto(codigo);
        return ouTraco(valor.matches("\\d{9}") ? valor.replaceAll("(\\d)(\\d{4})(\\d{2})(\\d{2})", "$1.$2.$3.$4") : valor);
    }

    /**
     * @param codigoMunicipio código do município do IBGE, com 7 dígitos
     * @return sigla da UF, ou string vazia se o código não for de um município brasileiro
     */
    static String uf(final String codigoMunicipio) {
        final var codigo = texto(codigoMunicipio);
        return codigo.matches("\\d{7}") ? UF_POR_CODIGO_IBGE.getOrDefault(codigo.substring(0, 2), "") : "";
    }

    /**
     * @param id identificador da NFS-e ("NFS" seguido da chave de acesso)
     * @return chave de acesso com 50 dígitos, sem o prefixo "NFS" (item 2.4.5)
     */
    static String chaveAcesso(final String id) {
        final var valor = texto(id);
        return valor.startsWith("NFS") ? valor.substring(3) : valor;
    }

    /**
     * Formata o valor monetário como "R$ 1.234,56", como no modelo do Anexo I.
     *
     * @param valor valor, ou null
     * @return valor formatado, ou um traço
     */
    static String valor(final BigDecimal valor) {
        return valor == null ? SEM_INFORMACAO : "R$ " + numero(valor);
    }

    /**
     * Formata a alíquota como "5,00 %", como no modelo do Anexo I.
     *
     * @param percentual percentual, ou null
     * @return percentual formatado, ou um traço
     */
    static String percentual(final BigDecimal percentual) {
        return percentual == null ? SEM_INFORMACAO : numero(percentual) + " %";
    }

    private static String numero(final BigDecimal valor) {
        final var formato = new DecimalFormat("#,##0.00", DecimalFormatSymbols.getInstance(PT_BR));
        return formato.format(valor.setScale(Math.max(2, valor.scale()), RoundingMode.HALF_EVEN));
    }

    /**
     * Soma os valores informados, ignorando os nulos.
     *
     * @param valores valores, que podem ser null
     * @return a soma, ou null se nenhum valor foi informado
     */
    static BigDecimal somar(final BigDecimal... valores) {
        return Arrays.stream(valores).filter(Objects::nonNull).reduce(BigDecimal::add).orElse(null);
    }

    /**
     * @param data data, ou null
     * @return data como DD/MM/AAAA, ou um traço
     */
    static String data(final LocalDate data) {
        return data == null ? SEM_INFORMACAO : DATA.format(data);
    }

    /**
     * @param dataHora data e hora, ou null
     * @return data e hora como DD/MM/AAAA hh:mm:ss, no fuso informado no XML, ou um traço
     */
    static String dataHora(final ZonedDateTime dataHora) {
        return dataHora == null ? SEM_INFORMACAO : DATA_HORA.format(dataHora);
    }

    /**
     * @param texto texto, ou null
     * @return o texto com a primeira letra maiúscula (o leiaute descreve o emitente intermediário em minúsculas)
     */
    static String primeiraMaiuscula(final String texto) {
        final var valor = texto(texto);
        return valor.isEmpty() ? valor : valor.substring(0, 1).toUpperCase(PT_BR) + valor.substring(1);
    }
}
