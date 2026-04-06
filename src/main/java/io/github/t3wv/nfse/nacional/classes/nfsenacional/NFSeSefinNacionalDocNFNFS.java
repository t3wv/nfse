
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "DocNFNFS")
public class NFSeSefinNacionalDocNFNFS {

    @Element(name = "nNFS")
    protected String numero;
    @Element(name = "modNFS")
    protected String modelo;
    @Element(name = "serieNFS")
    protected String serie;

    /**
     * @return Número da Nota Fiscal NF ou NFS
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero Número da Nota Fiscal NF ou NFS
     */
    public NFSeSefinNacionalDocNFNFS setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    /**
     * @return Modelo da Nota Fiscal NF ou NFS
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo Modelo da Nota Fiscal NF ou NFS
     */
    public NFSeSefinNacionalDocNFNFS setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    /**
     * @return Série Nota Fiscal NF ou NFS
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie Série Nota Fiscal NF ou NFS
     */
    public NFSeSefinNacionalDocNFNFS setSerie(String serie) {
        this.serie = serie;
        return this;
    }

}
