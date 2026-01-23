package io.github.t3wv.nfse.municipal.nfseSPBarueri.services;

import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;

import java.io.StringWriter;

@Root(name = "NFeLoteEnviarArquivoResponse")
@Namespace(reference = "http://www.barueri.sp.gov.br/nfe")
public class NFSeBarueriLoteEnviarArquivoResponse {

    @Element(name = "NFeLoteEnviarArquivoResult")
    private NFeLoteEnviarArquivoResult resultado;

    public NFeLoteEnviarArquivoResult getResultado() {
        return resultado;
    }

    public void setResultado(NFeLoteEnviarArquivoResult resultado) {
        this.resultado = resultado;
    }

    public String toXml() throws Exception {
        StringWriter writer = new StringWriter();
        new NFSePersister().write(this, writer);
        return writer.toString();
    }

    public static class NFeLoteEnviarArquivoResult {

        @Element(name = "ListaMensagemRetorno")
        private ListaMensagemRetorno listaMensagemRetorno;

        @Element(name = "ProtocoloRemessa", required = false)
        private String protocoloRemessa;

        public ListaMensagemRetorno getListaMensagemRetorno() {
            return listaMensagemRetorno;
        }

        public void setListaMensagemRetorno(ListaMensagemRetorno listaMensagemRetorno) {
            this.listaMensagemRetorno = listaMensagemRetorno;
        }

        public String getProtocoloRemessa() {
            return protocoloRemessa;
        }

        public void setProtocoloRemessa(String protocoloRemessa) {
            this.protocoloRemessa = protocoloRemessa;
        }
    }

    public static class ListaMensagemRetorno {

        @Element(name = "Codigo")
        private String codigo;

        @Element(name = "Mensagem")
        private String mensagem;

        @Element(name = "Correcao", required = false)
        private String correcao;

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getMensagem() {
            return mensagem;
        }

        public void setMensagem(String mensagem) {
            this.mensagem = mensagem;
        }

        public String getCorrecao() {
            return correcao;
        }

        public void setCorrecao(String correcao) {
            this.correcao = correcao;
        }

        public String toXml() throws Exception {
            StringWriter writer = new StringWriter();
            new NFSePersister().write(this, writer);
            return writer.toString();
        }
    }
}