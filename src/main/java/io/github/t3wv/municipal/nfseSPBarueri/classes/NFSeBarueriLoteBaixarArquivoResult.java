package io.github.t3wv.municipal.nfseSPBarueri.classes;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Base64;

public class NFSeBarueriLoteBaixarArquivoResult {

    @Element(name = "ListaMensagemRetorno")
    private NFSeBarueriLoteBaixarArquivoResultMensagemRetorno listaMensagemRetorno;

    @Element(name = "ArquivoRPSBase64")
    private String arquivoRPSBase64;

    public NFSeBarueriLoteBaixarArquivoResultMensagemRetorno getListaMensagemRetorno() {
        return listaMensagemRetorno;
    }

    public void setListaMensagemRetorno(NFSeBarueriLoteBaixarArquivoResultMensagemRetorno listaMensagemRetorno) {
        this.listaMensagemRetorno = listaMensagemRetorno;
    }

    public String getArquivoRPSBase64() {
        return arquivoRPSBase64;
    }

    public void setArquivoRPSBase64(String arquivoRPSBase64) {
        this.arquivoRPSBase64 = arquivoRPSBase64;
    }

    public String[] getLinhas() {
        final byte[] resultadoEmissaoB64 = Base64.getDecoder().decode(this.getArquivoRPSBase64());
        return new String(resultadoEmissaoB64).split("\r\n");
    }

    public static ArrayList<String> parseErros(String[] linhas) {
        final var erros = new ArrayList<String>();

        for (int indice = 0; indice < linhas.length; indice++) {
            String linha = linhas[indice];
            if (linha.length() > 1971) {
                final var errosApi = linha.substring(1970).split(";");
                for (var erroApi : errosApi) {
                    final var erro = NFSeBarueriRetornoErros.valueOfCodigo(erroApi);
                    erros.add("Linha %s - Código %s: %s -  %s".formatted(indice+1, erro.getCodigo(), erro.getDescricao(), erro.getSolucao()));
                }
            }
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
