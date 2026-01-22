package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Map;
import java.util.TreeMap;

public class NFSeBarueriLoteBaixarArquivoResult {

    static DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("yyyyMMdd");
    static DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    @Element(name = "ListaMensagemRetorno")
    private NFSeBarueriLoteBaixarArquivoResultMensagemRetorno listaMensagemRetorno;

    @Element(name = "ArquivoRPSBase64")
    private String arquivoRPSBase64;

    private String[] linhas;

    private NFSeBarueriRPSArquivoRetorno arquivoRetorno;

    public String getArquivoRPSBase64() {
        return arquivoRPSBase64;
    }

    public String[] getLinhas() {
        if (this.linhas == null) {
            final byte[] resultadoEmissaoB64 = Base64.getDecoder().decode(this.getArquivoRPSBase64());
            this.linhas = new String(resultadoEmissaoB64).split("\r\n");
        }
        return linhas;
    }

    public NFSeBarueriLoteBaixarArquivoResult setLinhas(String[] linhas) {
        this.linhas = linhas;
        return this;
    }

    public NFSeBarueriRPSArquivoRetorno getArquivoRetorno() {
        if (this.arquivoRetorno == null) {
            this.arquivoRetorno = new NFSeBarueriRPSArquivoRetorno();
            for (String linha : getLinhas()) {
                switch (linha.charAt(0)) {
                    case '1' -> {
                        arquivoRetorno.setHeader(new NFSeBarueriRPSArquivoRetornoRegistroTipo1(linha));
                    }
                    case '2' -> {
                        arquivoRetorno.addNota(new NFSeBarueriRPSArquivoRetornoRegistroTipo2(linha));
                    }
                    case '3' -> {
                        arquivoRetorno.getNotas().getLast().addItem(new NFSeBarueriRPSArquivoRetornoRegistroTipo3(linha));
                    }
                    case '4' -> {
                        arquivoRetorno.getNotas().getLast().getItens().getLast().addRetencao(new NFSeBarueriRPSArquivoRetornoRegistroTipo4(linha));
                    }
                    case '9' -> {
                        arquivoRetorno.setFooter(new NFSeBarueriRPSArquivoRetornoRegistroTipo9(linha));
                    }
                    default -> throw new IllegalArgumentException("Tipo de registro desconhecido: " + linha.charAt(0));
                }
            }
        }
        return arquivoRetorno;
    }

    public String toXml() throws Exception {
        final StringWriter writer = new StringWriter();
        new NFSePersister().write(this, writer);
        return writer.toString();
    }
}
