package io.github.t3wv.nfse.nacional.transformers;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalTSMotivoEmisTI;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalTSMotivoEmisTITransformer implements Transform<NFSeSefinNacionalTSMotivoEmisTI>{
    @Override
    public NFSeSefinNacionalTSMotivoEmisTI read(String value) {
        return NFSeSefinNacionalTSMotivoEmisTI.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalTSMotivoEmisTI value) {
        return value.getCodigo();
    }
}
