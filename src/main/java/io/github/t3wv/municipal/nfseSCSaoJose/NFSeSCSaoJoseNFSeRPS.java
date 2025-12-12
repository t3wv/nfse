package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class NFSeSCSaoJoseNFSeRPS {
    @Element(name = "nro_recibo_provisorio", required = false)
    private String nroReciboProvisorio;

    @Element(name = "serie_recibo_provisorio", required = false)
    private String serieReciboProvisorio;

    @Element(name = "data_emissao_recibo_provisorio", required = false)
    private LocalDate dataEmissaoReciboProvisorio;

    @Element(name = "hora_emissao_recibo_provisorio", required = false)
    private LocalTime horaEmissaoReciboProvisorio;

    public String getNroReciboProvisorio() {
        return nroReciboProvisorio;
    }

    public NFSeSCSaoJoseNFSeRPS setNroReciboProvisorio(String nroReciboProvisorio) {
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
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
