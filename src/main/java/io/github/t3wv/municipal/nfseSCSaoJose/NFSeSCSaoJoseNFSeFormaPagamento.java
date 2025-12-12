package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.io.StringWriter;
import java.util.List;

public class NFSeSCSaoJoseNFSeFormaPagamento {
    @Element(name = "tipo_pagamento")
    private String tipo_pagamento;

    @ElementList(name = "parcelas", inline = true, required = false)
    private List<NFSeSCSaoJoseNFSeFormaPagamentoParcela> parcelas;

    public String getTipo_pagamento() {
        return tipo_pagamento;
    }

    public NFSeSCSaoJoseNFSeFormaPagamento setTipo_pagamento(String tipo_pagamento) {
        this.tipo_pagamento = tipo_pagamento;
        return this;
    }

    public List<NFSeSCSaoJoseNFSeFormaPagamentoParcela> getParcelas() {
        return parcelas;
    }

    public NFSeSCSaoJoseNFSeFormaPagamento setParcelas(List<NFSeSCSaoJoseNFSeFormaPagamentoParcela> parcelas) {
        this.parcelas = parcelas;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
