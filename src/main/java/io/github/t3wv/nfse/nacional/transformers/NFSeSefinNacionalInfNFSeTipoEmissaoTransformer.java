package io.github.t3wv.nfse.nacional.transformers;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalInfNFSeTipoEmissao;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalInfNFSeTipoEmissaoTransformer implements Transform<NFSeSefinNacionalInfNFSeTipoEmissao>{
    @Override
    public NFSeSefinNacionalInfNFSeTipoEmissao read(String value) {
        return NFSeSefinNacionalInfNFSeTipoEmissao.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalInfNFSeTipoEmissao value) {
        return value.getCodigo();
    }
}

