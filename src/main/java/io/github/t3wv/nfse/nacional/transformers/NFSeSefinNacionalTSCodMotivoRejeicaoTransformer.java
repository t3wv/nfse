package io.github.t3wv.nfse.nacional.transformers;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalTSCodMotivoRejeicao;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalTSCodMotivoRejeicaoTransformer implements Transform<NFSeSefinNacionalTSCodMotivoRejeicao>{
    @Override
    public NFSeSefinNacionalTSCodMotivoRejeicao read(String value) {
        return NFSeSefinNacionalTSCodMotivoRejeicao.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalTSCodMotivoRejeicao value) {
        return value.getCodigo();
    }
}
