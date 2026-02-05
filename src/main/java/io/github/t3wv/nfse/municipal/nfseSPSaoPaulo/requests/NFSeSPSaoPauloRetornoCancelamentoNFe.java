package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.requests;// java

import io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos.TpEvento;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@Namespace(reference = "http://www.prefeitura.sp.gov.br/nfe")
public class NFSeSPSaoPauloRetornoCancelamentoNFe {

    @Element(name = "Cabecalho", required = false)
    protected NFSeSPSaoPauloRetornoCabecalho cabecalho;

    @ElementList(entry = "Alerta", inline = true, required = false)
    protected List<TpEvento> alertas;

    @ElementList(entry = "Erro", inline = true, required = false)
    protected List<TpEvento> erros;

    public NFSeSPSaoPauloRetornoCabecalho getCabecalho() {
        return cabecalho;
    }

    public NFSeSPSaoPauloRetornoCancelamentoNFe setCabecalho(NFSeSPSaoPauloRetornoCabecalho cabecalho) {
        this.cabecalho = cabecalho;
        return this;
    }

    public List<TpEvento> getAlertas() {
        return alertas;
    }

    public NFSeSPSaoPauloRetornoCancelamentoNFe setAlertas(List<TpEvento> alertas) {
        this.alertas = alertas;
        return this;
    }

    public NFSeSPSaoPauloRetornoCancelamentoNFe addAlerta(TpEvento alertaItem) {
        if (this.alertas == null) {
            this.alertas = new ArrayList<>();
        }
        this.alertas.add(alertaItem);
        return this;
    }

    public List<TpEvento> getErros() {
        return erros;
    }

    public NFSeSPSaoPauloRetornoCancelamentoNFe setErros(List<TpEvento> erros) {
        this.erros = erros;
        return this;
    }

    public NFSeSPSaoPauloRetornoCancelamentoNFe addErro(TpEvento erroItem) {
        if (this.erros == null) {
            this.erros = new ArrayList<>();
        }
        this.erros.add(erroItem);
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
