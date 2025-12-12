package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
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
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
