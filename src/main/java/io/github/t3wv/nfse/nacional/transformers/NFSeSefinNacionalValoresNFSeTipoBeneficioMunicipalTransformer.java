package io.github.t3wv.nfse.nacional.transformers;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalValoresNFSeTipoBeneficioMunicipal;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalValoresNFSeTipoBeneficioMunicipalTransformer implements Transform<NFSeSefinNacionalValoresNFSeTipoBeneficioMunicipal>{
    @Override
    public NFSeSefinNacionalValoresNFSeTipoBeneficioMunicipal read(String value) {
        return NFSeSefinNacionalValoresNFSeTipoBeneficioMunicipal.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalValoresNFSeTipoBeneficioMunicipal value) {
        return value.getCodigo();
    }
}
