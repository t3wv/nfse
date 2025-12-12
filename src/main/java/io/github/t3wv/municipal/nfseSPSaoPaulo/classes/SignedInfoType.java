package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

import io.github.t3wv.nacional.classes.nfsenacional.SignatureReferenceType;
import io.github.t3wv.nacional.classes.nfsenacional.SignatureSignedInfoType;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "SignedInfoType")
public class SignedInfoType {

    @Element(name = "CanonicalizationMethod", required = true)
    protected SignatureSignedInfoType.CanonicalizationMethod canonicalizationMethod;
    @Element(name = "SignatureMethod", required = true)
    protected SignatureSignedInfoType.SignatureMethod signatureMethod;
    @Element(name = "Reference", required = true)
    protected SignatureReferenceType reference;
    @Attribute(name = "ID", required = false)
    protected String id;

    /**
     * Gets the value of the canonicalizationMethod property.
     *
     * @return possible object is
     * {@link SignatureSignedInfoType.CanonicalizationMethod }
     *
     */
    public SignatureSignedInfoType.CanonicalizationMethod getCanonicalizationMethod() {
        return canonicalizationMethod;
    }

    /**
     * Sets the value of the canonicalizationMethod property.
     *
     * @param value allowed object is
     *              {@link SignatureSignedInfoType.CanonicalizationMethod }
     *
     */
    public void setCanonicalizationMethod(SignatureSignedInfoType.CanonicalizationMethod value) {
        this.canonicalizationMethod = value;
    }

    /**
     * Gets the value of the signatureMethod property.
     *
     * @return possible object is
     * {@link SignatureSignedInfoType.SignatureMethod }
     *
     */
    public SignatureSignedInfoType.SignatureMethod getSignatureMethod() {
        return signatureMethod;
    }

    /**
     * Sets the value of the signatureMethod property.
     *
     * @param value allowed object is
     *              {@link SignatureSignedInfoType.SignatureMethod }
     *
     */
    public void setSignatureMethod(SignatureSignedInfoType.SignatureMethod value) {
        this.signatureMethod = value;
    }

    /**
     * Gets the value of the reference property.
     *
     * @return possible object is
     * {@link SignatureReferenceType }
     *
     */
    public SignatureReferenceType getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     *
     * @param value allowed object is
     *              {@link SignatureReferenceType }
     *
     */
    public void setReference(SignatureReferenceType value) {
        this.reference = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" fixed="http://www.w3.org/TR/2001/REC-xml-c14n-20010315" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */

    public static class CanonicalizationMethod {

        @Attribute(name = "Algorithm")
        protected String algorithm;

        /**
         * Gets the value of the algorithm property.
         *
         * @return possible object is
         * {@link String }
         *
         */
        public String getAlgorithm() {
            if (algorithm == null) {
                return "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";
            } else {
                return algorithm;
            }
        }

        /**
         * Sets the value of the algorithm property.
         *
         * @param value allowed object is
         *              {@link String }
         *
         */
        public void setAlgorithm(String value) {
            this.algorithm = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" fixed="http://www.w3.org/2000/09/xmldsig#rsa-sha1" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    public static class SignatureMethod {

        @Attribute(name = "Algorithm")
        protected String algorithm;

        /**
         * Gets the value of the algorithm property.
         *
         * @return possible object is
         * {@link String }
         *
         */
        public String getAlgorithm() {
            if (algorithm == null) {
                return "http://www.w3.org/2000/09/xmldsig#rsa-sha1";
            } else {
                return algorithm;
            }
        }

        /**
         * Sets the value of the algorithm property.
         *
         * @param value allowed object is
         *              {@link String }
         *
         */
        public void setAlgorithm(String value) {
            this.algorithm = value;
        }

    }

}