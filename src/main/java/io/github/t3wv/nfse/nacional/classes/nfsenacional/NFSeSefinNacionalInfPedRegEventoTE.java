package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class NFSeSefinNacionalInfPedRegEventoTE {

    public final static List<String> EVENTOS_CANCELAMENTO = List.of("101101", "105102", "101103", "105104", "105105", "305101");
    final static List<String> EVENTOS_OUTROS = List.of("202201", "203202", "204203", "205204", "202205", "203206", "204207", "205208", "305102", "305103");
    final static List<String> TODOS_EVENTOS = Stream.concat(EVENTOS_CANCELAMENTO.stream(), EVENTOS_OUTROS.stream()).collect(Collectors.toList());


    @Element(name = "xDesc")
    private String xDesc;

    private String codigoEvento;

    public NFSeSefinNacionalInfPedRegEventoTE(String xDesc, String codigoEvento) {
        this.xDesc = xDesc;
        this.codigoEvento = codigoEvento;
    }

    public String getxDesc(){
        return this.xDesc;
    };

    public NFSeSefinNacionalInfPedRegEventoTE setxDesc(String xDesc){
        this.xDesc = xDesc;
        return this;
    }

    public String getCodigoEvento() {
        return codigoEvento;
    }

    public NFSeSefinNacionalInfPedRegEventoTE setCodigoEvento(String codigoEvento) {
        this.codigoEvento = codigoEvento;
        return this;
    }
}
