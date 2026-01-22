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

    public byte[] geraConteudoArquivo() throws Exception {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (Writer writer = new OutputStreamWriter(baos, StandardCharsets.ISO_8859_1)) {
                writer.write(header.toString());
                writer.write((char) 13);
                writer.write((char) 10);
                for (NFSeBarueriRPSArquivoRetornoRegistroTipo2 nota : this.notas) {
                    writer.write(nota.toString());
                    writer.write((char) 13);
                    writer.write((char) 10);
                    for (NFSeBarueriRPSArquivoRetornoRegistroTipo3 notaItem : nota.getItens()) {
                        writer.write(notaItem.toString());
                        writer.write((char) 13);
                        writer.write((char) 10);
                    }
                }
                writer.write(footer.toString());
                writer.write((char) 13);
                writer.write((char) 10);
                writer.flush();
            }
            return baos.toByteArray();
        }
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
