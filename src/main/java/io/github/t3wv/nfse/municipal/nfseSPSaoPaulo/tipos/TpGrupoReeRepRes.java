package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

import org.simpleframework.xml.Element;

import java.util.ArrayList;
import java.util.List;

public class TpGrupoReeRepRes {

    @Element(name = "documentos", required = true)
    protected List<TpDocumento> documentos;

    public List<TpDocumento> getDocumentos() {
        if (documentos == null) {
            documentos = new ArrayList<TpDocumento>();
        }
        return this.documentos;
    }

}
