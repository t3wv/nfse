package io.github.t3wv.nacional.transformers;

import io.github.t3wv.nacional.classes.nfsenacional.NFSeSefinNacionalInfoPrestadorCodigoNaoNIF;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalInfoPrestadorCodigoNaoNIFTransformer implements Transform<NFSeSefinNacionalInfoPrestadorCodigoNaoNIF>{
    @Override
    public NFSeSefinNacionalInfoPrestadorCodigoNaoNIF read(String value) {
        return NFSeSefinNacionalInfoPrestadorCodigoNaoNIF.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalInfoPrestadorCodigoNaoNIF value) {
        return value.getCodigo();
    }
}

