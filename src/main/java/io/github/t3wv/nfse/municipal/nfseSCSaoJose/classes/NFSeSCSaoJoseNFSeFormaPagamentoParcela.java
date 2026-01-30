package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NFSeSCSaoJoseNFSeFormaPagamentoParcela {
    @Element(name = "numero", required = false)
    private String numero;

    @Element(name = "valor", required = false)
    private BigDecimal valor;

    @Element(name = "data_vencimento", required = false)
    private LocalDate data_vencimento;

    public String getNumero() {
        return numero;
    }

    public NFSeSCSaoJoseNFSeFormaPagamentoParcela setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public NFSeSCSaoJoseNFSeFormaPagamentoParcela setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public LocalDate getData_vencimento() {
        return data_vencimento;
    }

    public NFSeSCSaoJoseNFSeFormaPagamentoParcela setData_vencimento(LocalDate data_vencimento) {
        this.data_vencimento = data_vencimento;
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
