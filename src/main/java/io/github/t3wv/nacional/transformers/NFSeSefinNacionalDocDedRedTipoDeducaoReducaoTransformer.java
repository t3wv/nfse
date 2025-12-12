package io.github.t3wv.nacional.transformers;

import io.github.t3wv.nacional.classes.nfsenacional.NFSeSefinNacionalDocDedRedTipoDeducaoReducao;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalDocDedRedTipoDeducaoReducaoTransformer implements Transform<NFSeSefinNacionalDocDedRedTipoDeducaoReducao>{
    @Override
    public NFSeSefinNacionalDocDedRedTipoDeducaoReducao read(String value) {
        return NFSeSefinNacionalDocDedRedTipoDeducaoReducao.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalDocDedRedTipoDeducaoReducao value) {
        return value.getCodigo();
    }
}