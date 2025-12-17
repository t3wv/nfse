package io.github.t3wv.utils;

import io.github.t3wv.NFSeConfig;
import io.github.t3wv.NFSeLogger;
import org.apache.commons.lang3.Strings;
import org.apache.jcp.xml.dsig.internal.dom.XMLDSigRI;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.naming.ldap.LdapName;
import javax.xml.crypto.*;
import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.security.*;
import java.security.cert.X509Certificate;
import java.util.*;

public class NFSeAssinaturaDigital implements NFSeLogger {

    private static final String C14N_TRANSFORM_METHOD = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";
    private static final String[] ELEMENTOS_ASSINAVEIS = new String[]{"infDPS", "infNFSe", "infPedRegEvt", "RPS", "Detalhe"};
    private boolean omitirDeclaracaoXML, usarIdComoReferencia;
    private final NFSeConfig config;

    public NFSeAssinaturaDigital(final NFSeConfig config) {
        this.config = config;
        this.omitirDeclaracaoXML = true;
        this.usarIdComoReferencia = true;
    }

    public boolean isOmitirDeclaracaoXML() {
        return omitirDeclaracaoXML;
    }

    public NFSeAssinaturaDigital setOmitirDeclaracaoXML(final boolean omitirDeclaracaoXML) {
        this.omitirDeclaracaoXML = omitirDeclaracaoXML;
        return this;
    }

    public boolean isUsarIdComoReferencia() {
        return usarIdComoReferencia;
    }

    public NFSeAssinaturaDigital setUsarIdComoReferencia(boolean usarIdComoReferencia) {
        this.usarIdComoReferencia = usarIdComoReferencia;
        return this;
    }

    public static boolean isValida(final InputStream xmlStream) throws Exception {
        final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);

        final Document document = dbf.newDocumentBuilder().parse(xmlStream);
        final NodeList nodeList = document.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");
        if (nodeList.getLength() == 0) {
            throw new IllegalStateException("Nao foi encontrada a assinatura do XML.");
        }

        final DOMValidateContext validateContext = new DOMValidateContext(new NFSeKeySelector(), nodeList.item(0));
        for (final String tag : NFSeAssinaturaDigital.ELEMENTOS_ASSINAVEIS) {
            final NodeList elements = document.getElementsByTagName(tag);
            if (elements.getLength() > 0) {
                validateContext.setIdAttributeNS((Element) elements.item(0), null, "Id");
            }
        }

        final XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM", new XMLDSigRI());
        return signatureFactory.unmarshalXMLSignature(validateContext).validate(validateContext);
    }

    public String assinarDocumento(final String conteudoXml) throws Exception {
        return this.assinarDocumento(conteudoXml, NFSeAssinaturaDigital.ELEMENTOS_ASSINAVEIS);
    }

    public String assinarDocumento(final String conteudoXml, final String... elementosAssinaveis) throws Exception {
        try (StringReader reader = new StringReader(conteudoXml)) {
            try (StringWriter writer = new StringWriter()) {
                this.assinarDocumento(reader, writer, elementosAssinaveis);
                return writer.toString();
            }
        }
    }

    public void assinarDocumento(final Reader xmlReader, final Writer xmlAssinado, final String... elementosAssinaveis) throws Exception {
        final KeyStore.PrivateKeyEntry keyEntry = getPrivateKeyEntry();

        final String dn = ((X509Certificate) keyEntry.getCertificate()).getSubjectX500Principal().getName();
        this.getLogger().debug("DN: {}", dn);

        final String cn = new LdapName(dn).getRdns().stream()
                .filter(rdn -> Strings.CI.equals(rdn.getType(), "CN"))
                .map(val -> String.valueOf(val.getValue()))
                .findFirst()
                .orElse("");
        this.getLogger().debug("CN: {}", cn);


        final XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");
        final List<Transform> transforms = new ArrayList<>(2);
        transforms.add(signatureFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null));
        transforms.add(signatureFactory.newTransform(NFSeAssinaturaDigital.C14N_TRANSFORM_METHOD, (TransformParameterSpec) null));

        final KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
        final X509Data x509Data = keyInfoFactory.newX509Data(Collections.singletonList((X509Certificate) keyEntry.getCertificate()));
        final KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(x509Data));
        final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);

        final Document document = documentBuilderFactory.newDocumentBuilder().parse(new InputSource(xmlReader));
        for (final String elementoAssinavel : elementosAssinaveis) {
            final NodeList elements = document.getElementsByTagName(elementoAssinavel);
            for (int i = 0; i < elements.getLength(); i++) {
                final Element element = (Element) elements.item(i);
                final String id = element.getAttribute("Id");

                if (this.isUsarIdComoReferencia()) {
                    element.setIdAttribute("Id", true);
                }

                final Reference reference = signatureFactory.newReference(this.isUsarIdComoReferencia() ? String.format("#%s", id) : "", signatureFactory.newDigestMethod(DigestMethod.SHA1, null), transforms, null, null);
                final SignedInfo signedInfo = signatureFactory.newSignedInfo(signatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null), signatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(reference));
                final XMLSignature signature = signatureFactory.newXMLSignature(signedInfo, keyInfo);
                signature.sign(new DOMSignContext(keyEntry.getPrivateKey(), element.getParentNode()));
            }
        }

        final Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, this.isOmitirDeclaracaoXML() ? "yes" : "no");
        transformer.transform(new DOMSource(document), new StreamResult(xmlAssinado));
    }

    private KeyStore.PrivateKeyEntry getPrivateKeyEntry() throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableEntryException {
        final KeyStore.PasswordProtection passwordProtection = new KeyStore.PasswordProtection(this.config.getCertificadoSenha().toCharArray());
        final KeyStore ks = config.getKeyStoreCertificado();
        for (Enumeration<String> e = ks.aliases(); e.hasMoreElements(); ) {
            final String alias = e.nextElement();
            if (ks.isKeyEntry(alias)) {
                this.getLogger().debug("Usando alias descoberto: '{}'", alias);
                return (KeyStore.PrivateKeyEntry) ks.getEntry(alias, passwordProtection);
            }
        }
        throw new KeyStoreException("Não foi possível encontrar a chave privada do certificado!");
    }

    private static class NFSeKeySelector extends KeySelector {
        @Override
        public KeySelectorResult select(final KeyInfo keyInfo, final KeySelector.Purpose purpose, final AlgorithmMethod method, final XMLCryptoContext context) throws KeySelectorException {
            for (final XMLStructure info : keyInfo.getContent()) {
                if (info instanceof X509Data x509Data) {
                    for (final Object certificado : x509Data.getContent()) {
                        if (certificado instanceof X509Certificate x509Certificate) {
                            if (this.algEquals(method.getAlgorithm(), x509Certificate.getPublicKey().getAlgorithm())) {
                                return x509Certificate::getPublicKey;
                            }
                        }
                    }
                }
            }
            throw new KeySelectorException("Nao foi localizada a chave do certificado.");
        }

        private boolean algEquals(final String algURI, final String algName) {
            return ((algName.equalsIgnoreCase("DSA") && algURI.equalsIgnoreCase(SignatureMethod.DSA_SHA1)) || (algName.equalsIgnoreCase("RSA") && algURI.equalsIgnoreCase(SignatureMethod.RSA_SHA1)));
        }
    }
}