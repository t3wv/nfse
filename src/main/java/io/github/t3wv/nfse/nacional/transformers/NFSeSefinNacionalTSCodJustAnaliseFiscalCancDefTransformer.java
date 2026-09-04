package io.github.t3wv.nfse.nacional.transformers;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalTSCodJustAnaliseFiscalCancDef;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalTSCodJustAnaliseFiscalCancDefTransformer implements Transform<NFSeSefinNacionalTSCodJustAnaliseFiscalCancDef>{
    @Override
    public NFSeSefinNacionalTSCodJustAnaliseFiscalCancDef read(String value) {
        return NFSeSefinNacionalTSCodJustAnaliseFiscalCancDef.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalTSCodJustAnaliseFiscalCancDef value) {
        return value.getCodigo();
    }
}
