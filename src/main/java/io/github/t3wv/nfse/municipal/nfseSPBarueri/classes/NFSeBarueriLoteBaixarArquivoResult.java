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
    private Map<Integer, NFSeBarueriRetornoErros> erros;

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
                }
            }
        }
        return arquivoRetorno;
    }

    public Map<Integer, NFSeBarueriRetornoErros> getErros() {
        if (this.erros == null) {
            this.erros = new TreeMap<>();
            for (int indice = 0; indice < this.linhas.length; indice++) {
                String linha = linhas[indice];
                if (linha.length() > 1971) {
                    final var errosApi = linha.substring(1970).split(";");
                    for (var erroApi : errosApi) {
                        erros.put(indice + 1, NFSeBarueriRetornoErros.valueOfCodigo(erroApi));
                    }
                }
            }
            return erros;
        }
        return erros;
    }


    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
