package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

class NFSeSCSaoJoseNFSeItensListaProfissional {
    @Element(name = "cnpj")
    private String cnpj;
    @Element(name = "razao_social")
    private String razaoSocial;
    @Element(name = "valor_servico")
    private BigDecimal valorServico;

    public String getCnpj() {
        return cnpj;
    }

    public NFSeSCSaoJoseNFSeItensListaProfissional setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public NFSeSCSaoJoseNFSeItensListaProfissional setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
        return this;
    }

    public BigDecimal getValorServico() {
        return valorServico;
    }

    public NFSeSCSaoJoseNFSeItensListaProfissional setValorServico(BigDecimal valorServico) {
        this.valorServico = valorServico;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
