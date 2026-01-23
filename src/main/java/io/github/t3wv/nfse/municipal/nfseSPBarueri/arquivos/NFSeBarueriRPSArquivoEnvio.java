package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.WSBarueri;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class NFSeBarueriRPSArquivoEnvio {

    private final List<NFSeBarueriRPSArquivoEnvioRegistro> linhas = new ArrayList<>();

    public NFSeBarueriRPSArquivoEnvio addLinha(NFSeBarueriRPSArquivoEnvioRegistro linha) {
        this.linhas.add(linha);
        return this;
    }

    public NFSeBarueriRPSArquivoEnvio addLinha(final String linha) {
        final var tipoRegistro = linha.substring(0, 1);
        switch (tipoRegistro) {
            case NFSeBarueriRPSArquivoEnvioRegistroTipo1.TIPO_REGISTRO ->
                    this.linhas.add(new NFSeBarueriRPSArquivoEnvioRegistroTipo1().fromLinha(linha));
            case NFSeBarueriRPSArquivoEnvioRegistroTipo2.TIPO_REGISTRO ->
                    this.linhas.add(new NFSeBarueriRPSArquivoEnvioRegistroTipo2().fromLinha(linha));
            case NFSeBarueriRPSArquivoEnvioRegistroTipo3.TIPO_REGISTRO ->
                    this.linhas.add(new NFSeBarueriRPSArquivoEnvioRegistroTipo3().fromLinha(linha));
            case NFSeBarueriRPSArquivoEnvioRegistroTipo4.TIPO_REGISTRO ->
                    this.linhas.add(new NFSeBarueriRPSArquivoEnvioRegistroTipo4().fromLinha(linha));
            case NFSeBarueriRPSArquivoEnvioRegistroTipo5.TIPO_REGISTRO ->
                    this.linhas.add(new NFSeBarueriRPSArquivoEnvioRegistroTipo5().fromLinha(linha));
            case NFSeBarueriRPSArquivoEnvioRegistroTipo9.TIPO_REGISTRO ->
                    this.linhas.add(new NFSeBarueriRPSArquivoEnvioRegistroTipo9().fromLinha(linha));
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
