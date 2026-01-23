package io.github.t3wv.nfse.municipal.nfseSPBarueri.services;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriArquivoRetornoSituacaoArquivo;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;

import java.io.StringWriter;

@Root(name = "NFeLoteStatusArquivoResponse")
@Namespace(reference = "http://www.barueri.sp.gov.br/nfe")
public class NFSeBarueriLoteStatusArquivoResponse {

    @Element(name = "NFeLoteStatusArquivoResult", required = false)
    private NFeLoteStatusArquivoResult result;

    public NFeLoteStatusArquivoResult getResult() {
        return result;
    }

    public NFSeBarueriLoteStatusArquivoResponse setResult(NFeLoteStatusArquivoResult result) {
        this.result = result;
        return this;
    }

    public String toXml() throws Exception {
        final var writer = new StringWriter();
        new NFSePersister().write(this, writer);
        return writer.toString();
    }

    public static class NFeLoteStatusArquivoResult {

        @Element(name = "ListaMensagemRetorno", required = false)
        private ListaMensagemRetorno listaMensagemRetorno;

        @Element(name = "ListaNfeArquivosRPS", required = false)
        private ListaNfeArquivosRPS listaNfeArquivosRPS;

        public ListaMensagemRetorno getListaMensagemRetorno() {
            return listaMensagemRetorno;
        }

        public void setListaMensagemRetorno(ListaMensagemRetorno listaMensagemRetorno) {
            this.listaMensagemRetorno = listaMensagemRetorno;
        }

        public ListaNfeArquivosRPS getListaNfeArquivosRPS() {
            return listaNfeArquivosRPS;
        }

        public void setListaNfeArquivosRPS(ListaNfeArquivosRPS listaNfeArquivosRPS) {
            this.listaNfeArquivosRPS = listaNfeArquivosRPS;
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
    }

    public static class ListaNfeArquivosRPS {

        @Element(name = "NomeArquivoOrginal", required = false)
        private String nomeArquivoOriginal;

        @Element(name = "DataEnvioArq", required = false)
        private String dataEnvioArq;

        @Element(name = "CodigoRemessa", required = false)
        private String codigoRemessa;

        @Element(name = "ApenasValidaArq", required = false)
        private boolean apenasValidaArq;

        @Element(name = "SituacaoArq", required = false)
        private NFSeBarueriArquivoRetornoSituacaoArquivo situacaoArquivo;

        @Element(name = "NomeArqRetorno", required = false)
        private String nomeArqRetorno;

        public String getNomeArquivoOriginal() {
            return nomeArquivoOriginal;
        }

        public void setNomeArquivoOriginal(String nomeArquivoOriginal) {
            this.nomeArquivoOriginal = nomeArquivoOriginal;
        }

        public String getDataEnvioArq() {
            return dataEnvioArq;
        }

        public void setDataEnvioArq(String dataEnvioArq) {
            this.dataEnvioArq = dataEnvioArq;
        }

        public String getCodigoRemessa() {
            return codigoRemessa;
        }

        public void setCodigoRemessa(String codigoRemessa) {
            this.codigoRemessa = codigoRemessa;
        }

        public boolean isApenasValidaArq() {
            return apenasValidaArq;
        }

        public void setApenasValidaArq(boolean apenasValidaArq) {
            this.apenasValidaArq = apenasValidaArq;
        }

        public NFSeBarueriArquivoRetornoSituacaoArquivo getSituacaoArquivo() {
            return situacaoArquivo;
        }

        public void setSituacaoArquivo(NFSeBarueriArquivoRetornoSituacaoArquivo situacaoArquivo) {
            this.situacaoArquivo = situacaoArquivo;
        }

        public String getNomeArquivoRetorno() {
            return nomeArqRetorno;
        }

        public void setNomeArqRetorno(String nomeArqRetorno) {
            this.nomeArqRetorno = nomeArqRetorno;
        }

        public String toXml() throws Exception {
            final var writer = new StringWriter();
            new NFSePersister().write(this, writer);
            return writer.toString();
        }
    }
}
