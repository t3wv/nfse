package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriRetornoErros;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/**
 * Classe abstrata que representa um registro de arquivo de envio de RPS para o município de Barueri - SP.
 */
public abstract class NFSeBarueriRPSArquivoEnvioRegistro<T> {

    public static final int ULTIMO_CARACTERE_VALIDO_LINHA_ANTES_ERROS = 1970;
    private List<NFSeBarueriRetornoErros> erros;

    public T setErros(List<NFSeBarueriRetornoErros> erros) {
        this.erros = erros;
        return (T) this;
    }

    public List<NFSeBarueriRetornoErros> getErros() {
        return erros;
    }

    public abstract String getTipoRegistro();

    public abstract T fromLinha(String linha);

    public abstract String toLinha();

    /**
     * Trata uma string para garantir que ela tenha o tamanho especificado, preenchendo com espaços à direita ou truncando conforme necessário.
     * @param valor A string a ser tratada.
     * @param tamanho O tamanho desejado da string.
     * @return A string tratada com o tamanho especificado.
     */
    static String trataString(int valor, int tamanho) {
        return trataString(String.valueOf(valor), tamanho);
    }

    static String trataString(String valor, int tamanho) {
        final var stringTrim = StringUtils.trimToEmpty(valor);
        if (stringTrim.isEmpty()) {
            return StringUtils.rightPad("", tamanho);
        }
        if (stringTrim.length() > tamanho) {
            return stringTrim.substring(0, tamanho);
        }
        return StringUtils.rightPad(stringTrim, tamanho);
    }

    static String trataNumerico(Long valor, int tamanho) {
        return trataNumerico(valor != null ? String.valueOf(valor) : null, tamanho);
    }

    static String trataNumerico(Integer valor, int tamanho) {
        return trataNumerico(valor != null ? String.valueOf(valor) : null, tamanho);
    }

    static String trataNumerico(BigDecimal valor, int tamanho) {;
        return trataNumerico(valor != null ? valor.setScale(2, RoundingMode.HALF_UP).toPlainString().replaceAll("[^0-9]", "") : null, tamanho);
    }

    static String trataNumerico(String valor, int tamanho) {
        final var stringTrim = StringUtils.trimToEmpty(valor);
        if (stringTrim.isEmpty() || !NumberUtils.isDigits(valor)) {
            return StringUtils.repeat("0", tamanho);
        }
        if (stringTrim.length() > tamanho) {
            return valor.substring(0, tamanho);
        }
        return StringUtils.leftPad(stringTrim, tamanho,"0");
    }

    public static List<NFSeBarueriRetornoErros> parseErros(final String linha) {
        if (linha.length() > ULTIMO_CARACTERE_VALIDO_LINHA_ANTES_ERROS) {
            return Arrays.stream(linha.substring(ULTIMO_CARACTERE_VALIDO_LINHA_ANTES_ERROS).split(";")).map(NFSeBarueriRetornoErros::valueOfCodigo).toList();
        }
        return List.of();
    }

    @Override
    public String toString() {
        return this.toLinha();
    }
}
