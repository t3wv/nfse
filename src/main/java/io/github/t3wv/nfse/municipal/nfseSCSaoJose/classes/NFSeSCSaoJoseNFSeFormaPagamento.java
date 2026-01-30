package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.municipal.nfseSCSaoJose.enums.NFSeSCSaoJoseTipoPagamento;
import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.List;

public class NFSeSCSaoJoseNFSeFormaPagamento {
    @Element(name = "tipo_pagamento")
    private NFSeSCSaoJoseTipoPagamento tipo_pagamento;

    @Path(value = "parcelas")
    @ElementList(inline = true, entry = "parcela", required = false)
    private List<NFSeSCSaoJoseNFSeFormaPagamentoParcela> parcelas;

    public NFSeSCSaoJoseTipoPagamento getTipo_pagamento() {
        return tipo_pagamento;
    }

    public NFSeSCSaoJoseNFSeFormaPagamento setTipo_pagamento(NFSeSCSaoJoseTipoPagamento tipo_pagamento) {
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
        final var registryMatcher = new NFSeRegistryMatcher();
        registryMatcher.bind(boolean.class, new NFSeBooleanTransformer());
        registryMatcher.bind(Boolean.class, new NFSeBooleanTransformer());
        registryMatcher.bind(BigDecimal.class, new NFSeBigDecimalTransformer());

        NFSePersister serializer = new NFSePersister(true, registryMatcher);
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
