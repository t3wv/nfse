package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.core.Persister;

import java.io.StringWriter;

/**
 * Grupo de valores do IBS e da CBS (TCRTCInfoValoresIBSCBS). Pela NT SE/CGNFS-e 009 o gReeRepRes
 * saiu daqui: os ajustes por documento foram unificados no vAjusteBC de infDPS/valores.
 */
public class NFSeSefinNacionalInfoIBSCBSInfoValoresIBSCBS {

    @Element(name = "trib")
    protected NFSeSefinNacionalInfoIBSCBSInfoTributos trib;

    public NFSeSefinNacionalInfoIBSCBSInfoTributos getTrib() {
        return trib;
    }

    public NFSeSefinNacionalInfoIBSCBSInfoValoresIBSCBS setTrib(NFSeSefinNacionalInfoIBSCBSInfoTributos trib) {
        this.trib = trib;
        return this;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalInfoIBSCBSInfoValoresIBSCBS{" +
                "trib=" + trib +
                '}';
    }

    public String toXml() throws Exception {
        Persister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
