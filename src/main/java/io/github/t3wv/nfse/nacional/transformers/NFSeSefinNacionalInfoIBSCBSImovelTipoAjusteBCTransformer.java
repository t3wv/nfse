package io.github.t3wv.nfse.nacional.transformers;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalInfoIBSCBSImovelTipoAjusteBC;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalInfoIBSCBSImovelTipoAjusteBCTransformer implements Transform<NFSeSefinNacionalInfoIBSCBSImovelTipoAjusteBC> {

    @Override
    public NFSeSefinNacionalInfoIBSCBSImovelTipoAjusteBC read(String value) {
        return NFSeSefinNacionalInfoIBSCBSImovelTipoAjusteBC.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalInfoIBSCBSImovelTipoAjusteBC value) {
        return value.getCodigo();
    }
}
