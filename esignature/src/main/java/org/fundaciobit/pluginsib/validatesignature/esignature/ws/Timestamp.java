
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Timestamp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Timestamp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProductionTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="SignedDataDigestAlgo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EncodedSignedDataDigestValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MessageImprintDataFound" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="MessageImprintDataIntact" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CanonicalizationMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BasicSignature" type="{http://dss.esig.europa.eu/validation/diagnostic}BasicSignature"/>
 *         &lt;element name="SigningCertificate" type="{http://dss.esig.europa.eu/validation/diagnostic}SigningCertificate" minOccurs="0"/>
 *         &lt;element name="CertificateChain" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ChainItem" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Source" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TimestampedObjects" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TimestampedObject" type="{http://dss.esig.europa.eu/validation/diagnostic}TimestampedObject" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Timestamp", namespace = "http://dss.esig.europa.eu/validation/diagnostic", propOrder = {
    "productionTime",
    "signedDataDigestAlgo",
    "encodedSignedDataDigestValue",
    "messageImprintDataFound",
    "messageImprintDataIntact",
    "canonicalizationMethod",
    "basicSignature",
    "signingCertificate",
    "certificateChain",
    "timestampedObjects"
})
public class Timestamp {

    @XmlElement(name = "ProductionTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar productionTime;
    @XmlElement(name = "SignedDataDigestAlgo", required = true)
    protected String signedDataDigestAlgo;
    @XmlElement(name = "EncodedSignedDataDigestValue", required = true)
    protected String encodedSignedDataDigestValue;
    @XmlElement(name = "MessageImprintDataFound")
    protected boolean messageImprintDataFound;
    @XmlElement(name = "MessageImprintDataIntact")
    protected boolean messageImprintDataIntact;
    @XmlElement(name = "CanonicalizationMethod")
    protected String canonicalizationMethod;
    @XmlElement(name = "BasicSignature", required = true)
    protected BasicSignature basicSignature;
    @XmlElement(name = "SigningCertificate")
    protected SigningCertificate signingCertificate;
    @XmlElement(name = "CertificateChain")
    protected Timestamp.CertificateChain certificateChain;
    @XmlElement(name = "TimestampedObjects")
    protected Timestamp.TimestampedObjects timestampedObjects;
    @XmlAttribute(name = "Id", required = true)
    protected String id;
    @XmlAttribute(name = "Type", required = true)
    protected String type;

    /**
     * Gets the value of the productionTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProductionTime() {
        return productionTime;
    }

    /**
     * Sets the value of the productionTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProductionTime(XMLGregorianCalendar value) {
        this.productionTime = value;
    }

    /**
     * Gets the value of the signedDataDigestAlgo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignedDataDigestAlgo() {
        return signedDataDigestAlgo;
    }

    /**
     * Sets the value of the signedDataDigestAlgo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignedDataDigestAlgo(String value) {
        this.signedDataDigestAlgo = value;
    }

    /**
     * Gets the value of the encodedSignedDataDigestValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncodedSignedDataDigestValue() {
        return encodedSignedDataDigestValue;
    }

    /**
     * Sets the value of the encodedSignedDataDigestValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncodedSignedDataDigestValue(String value) {
        this.encodedSignedDataDigestValue = value;
    }

    /**
     * Gets the value of the messageImprintDataFound property.
     * 
     */
    public boolean isMessageImprintDataFound() {
        return messageImprintDataFound;
    }

    /**
     * Sets the value of the messageImprintDataFound property.
     * 
     */
    public void setMessageImprintDataFound(boolean value) {
        this.messageImprintDataFound = value;
    }

    /**
     * Gets the value of the messageImprintDataIntact property.
     * 
     */
    public boolean isMessageImprintDataIntact() {
        return messageImprintDataIntact;
    }

    /**
     * Sets the value of the messageImprintDataIntact property.
     * 
     */
    public void setMessageImprintDataIntact(boolean value) {
        this.messageImprintDataIntact = value;
    }

    /**
     * Gets the value of the canonicalizationMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCanonicalizationMethod() {
        return canonicalizationMethod;
    }

    /**
     * Sets the value of the canonicalizationMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCanonicalizationMethod(String value) {
        this.canonicalizationMethod = value;
    }

    /**
     * Gets the value of the basicSignature property.
     * 
     * @return
     *     possible object is
     *     {@link BasicSignature }
     *     
     */
    public BasicSignature getBasicSignature() {
        return basicSignature;
    }

    /**
     * Sets the value of the basicSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link BasicSignature }
     *     
     */
    public void setBasicSignature(BasicSignature value) {
        this.basicSignature = value;
    }

    /**
     * Gets the value of the signingCertificate property.
     * 
     * @return
     *     possible object is
     *     {@link SigningCertificate }
     *     
     */
    public SigningCertificate getSigningCertificate() {
        return signingCertificate;
    }

    /**
     * Sets the value of the signingCertificate property.
     * 
     * @param value
     *     allowed object is
     *     {@link SigningCertificate }
     *     
     */
    public void setSigningCertificate(SigningCertificate value) {
        this.signingCertificate = value;
    }

    /**
     * Gets the value of the certificateChain property.
     * 
     * @return
     *     possible object is
     *     {@link Timestamp.CertificateChain }
     *     
     */
    public Timestamp.CertificateChain getCertificateChain() {
        return certificateChain;
    }

    /**
     * Sets the value of the certificateChain property.
     * 
     * @param value
     *     allowed object is
     *     {@link Timestamp.CertificateChain }
     *     
     */
    public void setCertificateChain(Timestamp.CertificateChain value) {
        this.certificateChain = value;
    }

    /**
     * Gets the value of the timestampedObjects property.
     * 
     * @return
     *     possible object is
     *     {@link Timestamp.TimestampedObjects }
     *     
     */
    public Timestamp.TimestampedObjects getTimestampedObjects() {
        return timestampedObjects;
    }

    /**
     * Sets the value of the timestampedObjects property.
     * 
     * @param value
     *     allowed object is
     *     {@link Timestamp.TimestampedObjects }
     *     
     */
    public void setTimestampedObjects(Timestamp.TimestampedObjects value) {
        this.timestampedObjects = value;
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

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ChainItem" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Source" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "chainItem"
    })
    public static class CertificateChain {

        @XmlElement(name = "ChainItem", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<Timestamp.CertificateChain.ChainItem> chainItem;

        /**
         * Gets the value of the chainItem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the chainItem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getChainItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Timestamp.CertificateChain.ChainItem }
         * 
         * 
         */
        public List<Timestamp.CertificateChain.ChainItem> getChainItem() {
            if (chainItem == null) {
                chainItem = new ArrayList<Timestamp.CertificateChain.ChainItem>();
            }
            return this.chainItem;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Source" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "source"
        })
        public static class ChainItem {

            @XmlElement(name = "Source", namespace = "http://dss.esig.europa.eu/validation/diagnostic", required = true)
            protected String source;
            @XmlAttribute(name = "Id", required = true)
            protected String id;

            /**
             * Gets the value of the source property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSource() {
                return source;
            }

            /**
             * Sets the value of the source property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSource(String value) {
                this.source = value;
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

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="TimestampedObject" type="{http://dss.esig.europa.eu/validation/diagnostic}TimestampedObject" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "timestampedObject"
    })
    public static class TimestampedObjects {

        @XmlElement(name = "TimestampedObject", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<TimestampedObject> timestampedObject;

        /**
         * Gets the value of the timestampedObject property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the timestampedObject property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTimestampedObject().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TimestampedObject }
         * 
         * 
         */
        public List<TimestampedObject> getTimestampedObject() {
            if (timestampedObject == null) {
                timestampedObject = new ArrayList<TimestampedObject>();
            }
            return this.timestampedObject;
        }

    }

}
