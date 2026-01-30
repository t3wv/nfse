package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class NFSeSCSaoJoseNFSeRPS {
    @Element(name = "nro_recibo_provisorio", required = false)
    private Long nroReciboProvisorio;

    @Element(name = "serie_recibo_provisorio", required = false)
    private String serieReciboProvisorio;

    @Element(name = "data_emissao_recibo_provisorio", required = false)
    private LocalDate dataEmissaoReciboProvisorio;

    @Element(name = "hora_emissao_recibo_provisorio", required = false)
    private LocalTime horaEmissaoReciboProvisorio;

    public Long getNroReciboProvisorio() {
        return nroReciboProvisorio;
    }

    public NFSeSCSaoJoseNFSeRPS setNroReciboProvisorio(Long nroReciboProvisorio) {
        this.nroReciboProvisorio = nroReciboProvisorio;
        return this;
    }

    public String getSerieReciboProvisorio() {
        return serieReciboProvisorio;
    }

    public NFSeSCSaoJoseNFSeRPS setSerieReciboProvisorio(String serieReciboProvisorio) {
        this.serieReciboProvisorio = serieReciboProvisorio;
        return this;
    }

    public LocalDate getDataEmissaoReciboProvisorio() {
        return dataEmissaoReciboProvisorio;
    }

    public NFSeSCSaoJoseNFSeRPS setDataEmissaoReciboProvisorio(LocalDate dataEmissaoReciboProvisorio) {
        this.dataEmissaoReciboProvisorio = dataEmissaoReciboProvisorio;
        return this;
    }

    public LocalTime getHoraEmissaoReciboProvisorio() {
        return horaEmissaoReciboProvisorio;
    }

    public NFSeSCSaoJoseNFSeRPS setHoraEmissaoReciboProvisorio(LocalTime horaEmissaoReciboProvisorio) {
        this.horaEmissaoReciboProvisorio = horaEmissaoReciboProvisorio;
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
