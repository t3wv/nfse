package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.WSBarueri;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class NFSeBarueriRPSArquivoRetorno {

    private final List<NFSeBarueriRPSArquivoRetornoRegistro> registros = new ArrayList<>();

    public NFSeBarueriRPSArquivoRetorno addRegistro(NFSeBarueriRPSArquivoRetornoRegistro linha) {
        this.registros.add(linha);
        return this;
    }

    public NFSeBarueriRPSArquivoRetorno addRegistro(final String linha) {
        final var tipoRegistro = linha.substring(0, 1);
        switch (tipoRegistro) {
            case NFSeBarueriRPSArquivoRetornoRegistroTipo1.TIPO_REGISTRO ->
                    this.registros.add(new NFSeBarueriRPSArquivoRetornoRegistroTipo1().fromLinha(linha));
            case NFSeBarueriRPSArquivoRetornoRegistroTipo2.TIPO_REGISTRO ->
                    this.registros.add(new NFSeBarueriRPSArquivoRetornoRegistroTipo2().fromLinha(linha));
            case NFSeBarueriRPSArquivoRetornoRegistroTipo3.TIPO_REGISTRO ->
                    this.registros.add(new NFSeBarueriRPSArquivoRetornoRegistroTipo3().fromLinha(linha));
            case NFSeBarueriRPSArquivoRetornoRegistroTipo4.TIPO_REGISTRO ->
                    this.registros.add(new NFSeBarueriRPSArquivoRetornoRegistroTipo4().fromLinha(linha));
            case NFSeBarueriRPSArquivoRetornoRegistroTipo9.TIPO_REGISTRO ->
                    this.registros.add(new NFSeBarueriRPSArquivoRetornoRegistroTipo9().fromLinha(linha));
            default -> throw new IllegalStateException("Tipo de registro desconhecido: " + tipoRegistro);
        }
        return this;
    }

    public List<NFSeBarueriRPSArquivoRetornoRegistro> getRegistros() {
        return registros;
    }

    public List<String> toLinhas() {
        final var linhas = new ArrayList<String>(this.registros.size());
        for (final var registro : this.registros) {
            linhas.add(registro.toLinha());
        }
        return linhas;
    }

    public byte[] toByteArray() throws Exception {
        try (var baos = new ByteArrayOutputStream()) {
            try (var writer = new OutputStreamWriter(baos, StandardCharsets.ISO_8859_1)) {
                for (final var registro : this.registros) {
                    writer.write(registro.toLinha());
                    writer.write(WSBarueri.CHR13);
                    writer.write(WSBarueri.CHR10);
                }
                writer.flush();
            }
            return baos.toByteArray();
        }
    }

    public String toBase64() throws Exception {
        return Base64.getEncoder().encodeToString(this.toByteArray());
    }

    public static NFSeBarueriRPSArquivoRetorno fromBase64(String arquivoRPSBase64) {
        final var arquivoBytes = Base64.getDecoder().decode(arquivoRPSBase64);
        final var arquivoString = new String(arquivoBytes, StandardCharsets.ISO_8859_1);
        final var arquivoLinhas = arquivoString.split("\r\n");
        final var retorno = new NFSeBarueriRPSArquivoRetorno();
        Arrays.stream(arquivoLinhas).forEach(retorno::addRegistro);
        return retorno;
    }
}
