
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BasicSignature complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BasicSignature">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EncryptionAlgoUsedToSignThisToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="KeyLengthUsedToSignThisToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DigestAlgoUsedToSignThisToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MaskGenerationFunctionUsedToSignThisToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReferenceDataFound" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ReferenceDataIntact" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SignatureIntact" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SignatureValid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BasicSignature", namespace = "http://dss.esig.europa.eu/validation/diagnostic", propOrder = {
    "encryptionAlgoUsedToSignThisToken",
    "keyLengthUsedToSignThisToken",
    "digestAlgoUsedToSignThisToken",
    "maskGenerationFunctionUsedToSignThisToken",
    "referenceDataFound",
    "referenceDataIntact",
    "signatureIntact",
    "signatureValid"
})
public class BasicSignature {

    @XmlElement(name = "EncryptionAlgoUsedToSignThisToken")
    protected String encryptionAlgoUsedToSignThisToken;
    @XmlElement(name = "KeyLengthUsedToSignThisToken")
    protected String keyLengthUsedToSignThisToken;
    @XmlElement(name = "DigestAlgoUsedToSignThisToken")
    protected String digestAlgoUsedToSignThisToken;
    @XmlElement(name = "MaskGenerationFunctionUsedToSignThisToken")
    protected String maskGenerationFunctionUsedToSignThisToken;
    @XmlElement(name = "ReferenceDataFound")
    protected boolean referenceDataFound;
    @XmlElement(name = "ReferenceDataIntact")
    protected boolean referenceDataIntact;
    @XmlElement(name = "SignatureIntact")
    protected boolean signatureIntact;
    @XmlElement(name = "SignatureValid")
    protected boolean signatureValid;

    /**
     * Gets the value of the encryptionAlgoUsedToSignThisToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncryptionAlgoUsedToSignThisToken() {
        return encryptionAlgoUsedToSignThisToken;
    }

    /**
     * Sets the value of the encryptionAlgoUsedToSignThisToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncryptionAlgoUsedToSignThisToken(String value) {
        this.encryptionAlgoUsedToSignThisToken = value;
    }

    /**
     * Gets the value of the keyLengthUsedToSignThisToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyLengthUsedToSignThisToken() {
        return keyLengthUsedToSignThisToken;
    }

    /**
     * Sets the value of the keyLengthUsedToSignThisToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyLengthUsedToSignThisToken(String value) {
        this.keyLengthUsedToSignThisToken = value;
    }

    /**
     * Gets the value of the digestAlgoUsedToSignThisToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDigestAlgoUsedToSignThisToken() {
        return digestAlgoUsedToSignThisToken;
    }

    /**
     * Sets the value of the digestAlgoUsedToSignThisToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDigestAlgoUsedToSignThisToken(String value) {
        this.digestAlgoUsedToSignThisToken = value;
    }

    /**
     * Gets the value of the maskGenerationFunctionUsedToSignThisToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaskGenerationFunctionUsedToSignThisToken() {
        return maskGenerationFunctionUsedToSignThisToken;
    }

    /**
     * Sets the value of the maskGenerationFunctionUsedToSignThisToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaskGenerationFunctionUsedToSignThisToken(String value) {
        this.maskGenerationFunctionUsedToSignThisToken = value;
    }

    /**
     * Gets the value of the referenceDataFound property.
     * 
     */
    public boolean isReferenceDataFound() {
        return referenceDataFound;
    }

    /**
     * Sets the value of the referenceDataFound property.
     * 
     */
    public void setReferenceDataFound(boolean value) {
        this.referenceDataFound = value;
    }

    /**
     * Gets the value of the referenceDataIntact property.
     * 
     */
    public boolean isReferenceDataIntact() {
        return referenceDataIntact;
    }

    /**
     * Sets the value of the referenceDataIntact property.
     * 
     */
    public void setReferenceDataIntact(boolean value) {
        this.referenceDataIntact = value;
    }

    /**
     * Gets the value of the signatureIntact property.
     * 
     */
    public boolean isSignatureIntact() {
        return signatureIntact;
    }

    /**
     * Sets the value of the signatureIntact property.
     * 
     */
    public void setSignatureIntact(boolean value) {
        this.signatureIntact = value;
    }

    /**
     * Gets the value of the signatureValid property.
     * 
     */
    public boolean isSignatureValid() {
        return signatureValid;
    }

    /**
     * Sets the value of the signatureValid property.
     * 
     */
    public void setSignatureValid(boolean value) {
        this.signatureValid = value;
    }

}
