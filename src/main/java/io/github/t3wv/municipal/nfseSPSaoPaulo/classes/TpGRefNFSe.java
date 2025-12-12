package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

import org.simpleframework.xml.Element;

import java.util.ArrayList;
import java.util.List;

public class TpGRefNFSe {

    @Element(name = "refNFSe", required = true)
    protected List<String> refNFSe;

    public List<String> getRefNFSe() {
        if (refNFSe == null) {
            refNFSe = new ArrayList<String>();
        }
        return this.refNFSe;
    }

}
