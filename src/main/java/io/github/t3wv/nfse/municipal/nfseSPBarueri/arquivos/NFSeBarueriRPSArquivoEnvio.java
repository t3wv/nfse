package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.WSBarueri;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriRetornoErros;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class NFSeBarueriRPSArquivoEnvio {

    private final List<NFSeBarueriRPSArquivoEnvioRegistro> registros = new ArrayList<>();

    public NFSeBarueriRPSArquivoEnvio addRegistro(NFSeBarueriRPSArquivoEnvioRegistro linha) {
        this.registros.add(linha);
        return this;
    }

    public NFSeBarueriRPSArquivoEnvio addRegistro(final String linha) {
        final var tipoRegistro = linha.substring(0, 1);
        switch (tipoRegistro) {
            case NFSeBarueriRPSArquivoEnvioRegistroTipo1.TIPO_REGISTRO ->
                    this.registros.add(new NFSeBarueriRPSArquivoEnvioRegistroTipo1().fromLinha(linha));
            case NFSeBarueriRPSArquivoEnvioRegistroTipo2.TIPO_REGISTRO ->
                    this.registros.add(new NFSeBarueriRPSArquivoEnvioRegistroTipo2().fromLinha(linha));
            case NFSeBarueriRPSArquivoEnvioRegistroTipo3.TIPO_REGISTRO ->
                    this.registros.add(new NFSeBarueriRPSArquivoEnvioRegistroTipo3().fromLinha(linha));
            case NFSeBarueriRPSArquivoEnvioRegistroTipo4.TIPO_REGISTRO ->
                    this.registros.add(new NFSeBarueriRPSArquivoEnvioRegistroTipo4().fromLinha(linha));
            case NFSeBarueriRPSArquivoEnvioRegistroTipo5.TIPO_REGISTRO ->
                    this.registros.add(new NFSeBarueriRPSArquivoEnvioRegistroTipo5().fromLinha(linha));
            case NFSeBarueriRPSArquivoEnvioRegistroTipo9.TIPO_REGISTRO ->
                    this.registros.add(new NFSeBarueriRPSArquivoEnvioRegistroTipo9().fromLinha(linha));
            default -> throw new IllegalStateException("Tipo de registro desconhecido: " + tipoRegistro);
        }
        return this;
    }

    public List<NFSeBarueriRPSArquivoEnvioRegistro> getRegistros() {
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

    public static NFSeBarueriRPSArquivoEnvio fromBase64(String arquivoRPSBase64) {
        final var arquivoBytes = Base64.getDecoder().decode(arquivoRPSBase64);
        final var arquivoString = new String(arquivoBytes, StandardCharsets.ISO_8859_1);
        final var arquivoLinhas = arquivoString.split("\r\n");
        final var envio = new NFSeBarueriRPSArquivoEnvio();
        Arrays.stream(arquivoLinhas).forEach(envio::addRegistro);
        return envio;
    }

    public List<NFSeBarueriRetornoErros> getErros() {
        if (!this.registros.isEmpty()) {
            final var erros = new ArrayList<NFSeBarueriRetornoErros>();
            for (final var registro : this.registros) {
                if (registro.getErros() != null && !registro.getErros().isEmpty()) {
                    erros.addAll(registro.getErros());
                }
            }
            return erros;
        }
        return List.of();

    }
}
