package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;

import java.io.StringWriter;

@Namespace(reference = "http://www.prefeitura.sp.gov.br/nfe")
public class TpEvento {

    @Element(name = "Codigo", required = false)
    private String codigo;

    @Element(name = "Descricao", required = false)
    private String descricao;

    @Element(name = "Campo", required = false)
    private String campo;

    @Element(name = "Valor", required = false)
    private String valor;

    @Element(name = "ChaveRPS", required = false)
    private TpChaveRPS chaveRps;

    @Element(name = "ChaveNFe", required = false)
    private TpChaveNFe chaveNFe;

    public String getCodigo() {
        return codigo;
    }

    public TpEvento setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public TpEvento setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getCampo() {
        return campo;
    }

    public TpEvento setCampo(String campo) {
        this.campo = campo;
        return this;
    }

    public String getValor() {
        return valor;
    }

    public TpEvento setValor(String valor) {
        this.valor = valor;
        return this;
    }

    public TpChaveRPS getChaveRps() {
        return chaveRps;
    }

    public TpEvento setChaveRps(TpChaveRPS chaveRps) {
        this.chaveRps = chaveRps;
        return this;
    }

    public TpChaveNFe getChaveNFe() {
        return chaveNFe;
    }

    public TpEvento setChaveNFe(TpChaveNFe chaveNFe) {
        this.chaveNFe = chaveNFe;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
