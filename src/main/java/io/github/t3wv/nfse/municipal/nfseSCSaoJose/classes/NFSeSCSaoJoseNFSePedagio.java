package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;

public class NFSeSCSaoJoseNFSePedagio {

    @Element(name = "cod_equipamento_automatico", required = false)
    private String codigoEquipamentoAutomatico;

    public String getCodigoEquipamentoAutomatico() {
        return codigoEquipamentoAutomatico;
    }

    public NFSeSCSaoJoseNFSePedagio setCodigoEquipamentoAutomatico(String codigoEquipamentoAutomatico) {
        this.codigoEquipamentoAutomatico = codigoEquipamentoAutomatico;
        return this;
    }

    public String toXml() throws Exception {
        StringWriter writer = new StringWriter();
        new NFSePersister(true, new NFSeRegistryMatcher()).write(this, writer);
        return writer.toString();
    }
}
