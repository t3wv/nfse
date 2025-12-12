package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;


import io.github.t3wv.nacional.classes.nfsenacional.SignatureKeyInfoType;
import io.github.t3wv.nacional.classes.nfsenacional.SignatureSignedInfoType;
import io.github.t3wv.nacional.classes.nfsenacional.SignatureValueType;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(name = "SignatureType")
public class SignatureType {

    @Element(name = "SignedInfo", required = true)
    protected SignatureSignedInfoType signedInfo;
    @Element(name = "SignatureValue", required = true)
    protected SignatureValueType signatureValue;
    @Element(name = "KeyInfo", required = true)
    protected SignatureKeyInfoType keyInfo;
    @Element(name = "ID", required = false)
    protected String id;

    /**
     * Gets the value of the signedInfo property.
     *
     * @return
     *     possible object is
     *     {@link SignatureSignedInfoType }
     *
     */
    public SignatureSignedInfoType getSignedInfo() {
        return signedInfo;
    }

    /**
     * Sets the value of the signedInfo property.
     *
     * @param value
     *     allowed object is
     *     {@link SignatureSignedInfoType }
     *
     */
    public void setSignedInfo(SignatureSignedInfoType value) {
        this.signedInfo = value;
    }

    /**
     * Gets the value of the signatureValue property.
     *
     * @return
     *     possible object is
     *     {@link SignatureValueType }
     *
     */
    public SignatureValueType getSignatureValue() {
        return signatureValue;
    }

    /**
     * Sets the value of the signatureValue property.
     *
     * @param value
     *     allowed object is
     *     {@link SignatureValueType }
     *
     */
    public void setSignatureValue(SignatureValueType value) {
        this.signatureValue = value;
    }

    /**
     * Gets the value of the keyInfo property.
     *
     * @return
     *     possible object is
     *     {@link SignatureKeyInfoType }
     *
     */
    public SignatureKeyInfoType getKeyInfo() {
        return keyInfo;
    }

    /**
     * Sets the value of the keyInfo property.
     *
     * @param value
     *     allowed object is
     *     {@link SignatureKeyInfoType }
     *
     */
    public void setKeyInfo(SignatureKeyInfoType value) {
        this.keyInfo = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

}
