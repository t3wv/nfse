package io.github.t3wv.nfse.nacional.transformers;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalTSCodJustAnaliseFiscalCanc;
import org.simpleframework.xml.transform.Transform;

/**
 * Converte o código do XML para {@link NFSeSefinNacionalTSCodJustAnaliseFiscalCanc} e vice-versa.
 *
 * @author Marcos Lombardi de Andrade
 */
public class NFSeSefinNacionalTSCodJustAnaliseFiscalCancTransformer implements Transform<NFSeSefinNacionalTSCodJustAnaliseFiscalCanc> {

	@Override
    public NFSeSefinNacionalTSCodJustAnaliseFiscalCanc read(String value) {
        return NFSeSefinNacionalTSCodJustAnaliseFiscalCanc.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalTSCodJustAnaliseFiscalCanc value) {
        return value.getCodigo();
    }
}
