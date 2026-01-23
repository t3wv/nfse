package io.github.t3wv.nfse.municipal.nfseSPBarueri.services;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos.*;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class NFSeBarueriLoteBaixarArquivoResult {

    @Element(name = "ListaMensagemRetorno")
    private NFSeBarueriLoteBaixarArquivoResultMensagemRetorno listaMensagemRetorno;

    @Element(name = "ArquivoRPSBase64")
    private String arquivoRPSBase64;

    public String getArquivoRPSBase64() {
        return arquivoRPSBase64;
    }

    public NFSeBarueriRPSArquivoEnvio getArquivoEnvioComErros() {
        return NFSeBarueriRPSArquivoEnvio.fromBase64(arquivoRPSBase64);
    }

    public NFSeBarueriRPSArquivoRetorno getArquivoRetorno() {
        return NFSeBarueriRPSArquivoRetorno.fromBase64(arquivoRPSBase64);
    }

    public NFSeBarueriLoteBaixarArquivoResultMensagemRetorno getListaMensagemRetorno() {
        return listaMensagemRetorno;
    }

    public String toXml() throws Exception {
        final StringWriter writer = new StringWriter();
        new NFSePersister().write(this, writer);
        return writer.toString();
    }
}
