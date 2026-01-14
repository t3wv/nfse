package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class NFSeBarueriRPSArquivoRetorno {
    private NFSeBarueriRPSArquivoRetornoRegistroTipo1 header;
    private NFSeBarueriRPSArquivoRetornoRegistroTipo9 footer;
    private List<NFSeBarueriRPSArquivoRetornoRegistroTipo2> notas;

    public NFSeBarueriRPSArquivoRetorno addNota(NFSeBarueriRPSArquivoRetornoRegistroTipo2 nfSeBarueriRPSArquivoRetornoRegistroTipo2) {
        if (this.notas == null) {
            this.notas = new ArrayList<>();
        }
        this.notas.add(nfSeBarueriRPSArquivoRetornoRegistroTipo2);
        return this;
    }

    public List<NFSeBarueriRPSArquivoRetornoRegistroTipo2> getNotas() {
        return this.notas;
    }

    private List<String> geraArquivo() {
        final List<String> linhasArquivo = new ArrayList<>();
        return linhasArquivo;
    }

    public ByteArrayOutputStream geraConteudoArquivo() throws Exception {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (Writer writer = new OutputStreamWriter(baos, StandardCharsets.ISO_8859_1)) {
                for (final String linha : this.geraArquivo()) {
                    writer.write(linha);
                    writer.write((char) 13);
                    writer.write((char) 10);
                }
                writer.flush();
            }
            return baos;
        }
    }

    public String getArquivoBase64() throws Exception {
        return Base64.getEncoder().encodeToString(this.geraConteudoArquivo().toByteArray());
    }

    public NFSeBarueriRPSArquivoRetorno setHeader(NFSeBarueriRPSArquivoRetornoRegistroTipo1 nfSeBarueriRPSArquivoRetornoRegistroTipo1) {
        this.header = nfSeBarueriRPSArquivoRetornoRegistroTipo1;
        return this;
    }

    public NFSeBarueriRPSArquivoRetorno setFooter(NFSeBarueriRPSArquivoRetornoRegistroTipo9 nfSeBarueriRPSArquivoRetornoRegistroTipo9) {
        this.footer = nfSeBarueriRPSArquivoRetornoRegistroTipo9;
        return this;
    }
}
