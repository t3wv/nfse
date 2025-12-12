package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NFSeSCSaoJoseNFSeFormaPagamentoParcela {
    @Element(name = "numero")
    private String numero;

    @Element(name = "valor")
    private BigDecimal valor;

    @Element(name = "data_vencimento")
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
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
