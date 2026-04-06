
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.util.ArrayList;
import java.util.List;

@Root(name = "ListaEventos")
public class NFSeSefinNacionalListaEventos {

    @Element(required = true)
    protected List<NFSeSefinNacionalCodigoEventoNFSe> codEvento;

    public List<NFSeSefinNacionalCodigoEventoNFSe> getCodEvento() {
        if (codEvento == null) {
            codEvento = new ArrayList<NFSeSefinNacionalCodigoEventoNFSe>();
        }
        return this.codEvento;
    }

}
