package io.github.t3wv.nfse.nacional.transformers;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalDocAjusteBCTipoAjuste;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalDocAjusteBCTipoAjusteTransformer implements Transform<NFSeSefinNacionalDocAjusteBCTipoAjuste> {

    @Override
    public NFSeSefinNacionalDocAjusteBCTipoAjuste read(String value) {
        return NFSeSefinNacionalDocAjusteBCTipoAjuste.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalDocAjusteBCTipoAjuste value) {
        return value.getCodigo();
    }
}
