package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.WSBarueri;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class NFSeBarueriRPSArquivoRetorno {

    private final List<NFSeBarueriRPSArquivoRetornoRegistro> linhas = new ArrayList<>();

    public NFSeBarueriRPSArquivoRetorno addLinha(NFSeBarueriRPSArquivoRetornoRegistro linha) {
        this.linhas.add(linha);
        return this;
    }

    public NFSeBarueriRPSArquivoRetorno addLinha(final String linha) {
        final var tipoRegistro = linha.substring(0, 1);
        switch (tipoRegistro) {
            case NFSeBarueriRPSArquivoRetornoRegistroTipo1.TIPO_REGISTRO ->
                    this.linhas.add(new NFSeBarueriRPSArquivoRetornoRegistroTipo1().fromLinha(linha));
            case NFSeBarueriRPSArquivoRetornoRegistroTipo2.TIPO_REGISTRO ->
                    this.linhas.add(new NFSeBarueriRPSArquivoRetornoRegistroTipo2().fromLinha(linha));
            case NFSeBarueriRPSArquivoRetornoRegistroTipo3.TIPO_REGISTRO ->
                    this.linhas.add(new NFSeBarueriRPSArquivoRetornoRegistroTipo3().fromLinha(linha));
            case NFSeBarueriRPSArquivoRetornoRegistroTipo4.TIPO_REGISTRO ->
                    this.linhas.add(new NFSeBarueriRPSArquivoRetornoRegistroTipo4().fromLinha(linha));
            case NFSeBarueriRPSArquivoRetornoRegistroTipo9.TIPO_REGISTRO ->
                    this.linhas.add(new NFSeBarueriRPSArquivoRetornoRegistroTipo9().fromLinha(linha));
            default -> throw new IllegalStateException("Tipo de registro desconhecido: " + tipoRegistro);
        }
        return this;
    }

    public List<String> toLinhas() {
        final var linhas = new ArrayList<String>(this.linhas.size());
        for (final var registro : this.linhas) {
            linhas.add(registro.toLinha());
        }
        return linhas;
    }

    public byte[] toByteArray() throws Exception {
        try (var baos = new ByteArrayOutputStream()) {
            try (var writer = new OutputStreamWriter(baos, StandardCharsets.ISO_8859_1)) {
                for (final var registro : this.linhas) {
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
}
