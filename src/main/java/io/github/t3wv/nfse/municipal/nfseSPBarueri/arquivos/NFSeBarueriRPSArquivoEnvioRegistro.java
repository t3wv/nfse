package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriRetornoErros;

import java.util.Arrays;
import java.util.List;

/**
 * Classe abstrata que representa um registro de arquivo de envio de RPS para o município de Barueri - SP.
 */
public abstract class NFSeBarueriRPSArquivoEnvioRegistro<T> {

    private static final int ULTIMO_CARACTERE_VALIDO_LINHA_ANTES_ERROS = 1970;
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
