package io.github.t3wv.nfse.nacional.transformers;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalInfNFSeAmbienteGeracao;
import org.simpleframework.xml.transform.Transform;

/**
 * Converte o código do XML para {@link NFSeSefinNacionalInfNFSeAmbienteGeracao} e vice-versa.
 *
 * @author Marcos Lombardi de Andrade
 */
public class NFSeSefinNacionalInfNFSeAmbienteGeracaoTransformer implements Transform<NFSeSefinNacionalInfNFSeAmbienteGeracao> {

	@Override
    public NFSeSefinNacionalInfNFSeAmbienteGeracao read(String value) {
        return NFSeSefinNacionalInfNFSeAmbienteGeracao.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalInfNFSeAmbienteGeracao value) {
        return value.getCodigo();
    }
}
