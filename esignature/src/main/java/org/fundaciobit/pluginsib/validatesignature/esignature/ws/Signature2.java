
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
 * <p>Java class for Signature complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Signature">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SignatureFilename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ParentId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="SignatureFormat" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StructuralValidation" type="{http://dss.esig.europa.eu/validation/diagnostic}StructuralValidation" minOccurs="0"/>
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
 *         &lt;element name="ContentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContentIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContentHints" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SignatureProductionPlace" type="{http://dss.esig.europa.eu/validation/diagnostic}SignatureProductionPlace" minOccurs="0"/>
 *         &lt;element name="CommitmentTypeIndication" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Indication" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ClaimedRoles" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ClaimedRoles" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CertifiedRoles" type="{http://dss.esig.europa.eu/validation/diagnostic}CertifiedRole" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Policy" type="{http://dss.esig.europa.eu/validation/diagnostic}Policy" minOccurs="0"/>
 *         &lt;element name="Timestamps" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Timestamp" type="{http://dss.esig.europa.eu/validation/diagnostic}Timestamp" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SignatureScopes" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SignatureScope" type="{http://dss.esig.europa.eu/validation/diagnostic}SignatureScope" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CounterSignature" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Signature", namespace = "http://dss.esig.europa.eu/validation/diagnostic", propOrder = {
    "signatureFilename",
    "parentId",
    "errorMessage",
    "dateTime",
    "signatureFormat",
    "structuralValidation",
    "basicSignature",
    "signingCertificate",
    "certificateChain",
    "contentType",
    "contentIdentifier",
    "contentHints",
    "signatureProductionPlace",
    "commitmentTypeIndication",
    "claimedRoles",
    "certifiedRoles",
    "policy",
    "timestamps",
    "signatureScopes"
})
public class Signature2 {

    @XmlElement(name = "SignatureFilename", required = true)
    protected String signatureFilename;
    @XmlElement(name = "ParentId")
    protected String parentId;
    @XmlElement(name = "ErrorMessage")
    protected String errorMessage;
    @XmlElement(name = "DateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTime;
    @XmlElement(name = "SignatureFormat", required = true)
    protected String signatureFormat;
    @XmlElement(name = "StructuralValidation")
    protected StructuralValidation structuralValidation;
    @XmlElement(name = "BasicSignature", required = true)
    protected BasicSignature basicSignature;
    @XmlElement(name = "SigningCertificate")
    protected SigningCertificate signingCertificate;
    @XmlElement(name = "CertificateChain")
    protected Signature2 .CertificateChain certificateChain;
    @XmlElement(name = "ContentType")
    protected String contentType;
    @XmlElement(name = "ContentIdentifier")
    protected String contentIdentifier;
    @XmlElement(name = "ContentHints")
    protected String contentHints;
    @XmlElement(name = "SignatureProductionPlace")
    protected SignatureProductionPlace signatureProductionPlace;
    @XmlElement(name = "CommitmentTypeIndication")
    protected Signature2 .CommitmentTypeIndication commitmentTypeIndication;
    @XmlElement(name = "ClaimedRoles")
    protected Signature2 .ClaimedRoles claimedRoles;
    @XmlElement(name = "CertifiedRoles")
    protected List<CertifiedRole> certifiedRoles;
    @XmlElement(name = "Policy")
    protected Policy policy;
    @XmlElement(name = "Timestamps")
    protected Signature2 .Timestamps timestamps;
    @XmlElement(name = "SignatureScopes")
    protected Signature2 .SignatureScopes signatureScopes;
    @XmlAttribute(name = "Id", required = true)
    protected String id;
    @XmlAttribute(name = "CounterSignature")
    protected Boolean counterSignature;

    /**
     * Gets the value of the signatureFilename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignatureFilename() {
        return signatureFilename;
    }

    /**
     * Sets the value of the signatureFilename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignatureFilename(String value) {
        this.signatureFilename = value;
    }

    /**
     * Gets the value of the parentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * Sets the value of the parentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentId(String value) {
        this.parentId = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the dateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTime(XMLGregorianCalendar value) {
        this.dateTime = value;
    }

    /**
     * Gets the value of the signatureFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignatureFormat() {
        return signatureFormat;
    }

    /**
     * Sets the value of the signatureFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignatureFormat(String value) {
        this.signatureFormat = value;
    }

    /**
     * Gets the value of the structuralValidation property.
     * 
     * @return
     *     possible object is
     *     {@link StructuralValidation }
     *     
     */
    public StructuralValidation getStructuralValidation() {
        return structuralValidation;
    }

    /**
     * Sets the value of the structuralValidation property.
     * 
     * @param value
     *     allowed object is
     *     {@link StructuralValidation }
     *     
     */
    public void setStructuralValidation(StructuralValidation value) {
        this.structuralValidation = value;
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
     *     {@link Signature2 .CertificateChain }
     *     
     */
    public Signature2 .CertificateChain getCertificateChain() {
        return certificateChain;
    }

    /**
     * Sets the value of the certificateChain property.
     * 
     * @param value
     *     allowed object is
     *     {@link Signature2 .CertificateChain }
     *     
     */
    public void setCertificateChain(Signature2 .CertificateChain value) {
        this.certificateChain = value;
    }

    /**
     * Gets the value of the contentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets the value of the contentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentType(String value) {
        this.contentType = value;
    }

    /**
     * Gets the value of the contentIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentIdentifier() {
        return contentIdentifier;
    }

    /**
     * Sets the value of the contentIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentIdentifier(String value) {
        this.contentIdentifier = value;
    }

    /**
     * Gets the value of the contentHints property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentHints() {
        return contentHints;
    }

    /**
     * Sets the value of the contentHints property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentHints(String value) {
        this.contentHints = value;
    }

    /**
     * Gets the value of the signatureProductionPlace property.
     * 
     * @return
     *     possible object is
     *     {@link SignatureProductionPlace }
     *     
     */
    public SignatureProductionPlace getSignatureProductionPlace() {
        return signatureProductionPlace;
    }

    /**
     * Sets the value of the signatureProductionPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureProductionPlace }
     *     
     */
    public void setSignatureProductionPlace(SignatureProductionPlace value) {
        this.signatureProductionPlace = value;
    }

    /**
     * Gets the value of the commitmentTypeIndication property.
     * 
     * @return
     *     possible object is
     *     {@link Signature2 .CommitmentTypeIndication }
     *     
     */
    public Signature2 .CommitmentTypeIndication getCommitmentTypeIndication() {
        return commitmentTypeIndication;
    }

    /**
     * Sets the value of the commitmentTypeIndication property.
     * 
     * @param value
     *     allowed object is
     *     {@link Signature2 .CommitmentTypeIndication }
     *     
     */
    public void setCommitmentTypeIndication(Signature2 .CommitmentTypeIndication value) {
        this.commitmentTypeIndication = value;
    }

    /**
     * Gets the value of the claimedRoles property.
     * 
     * @return
     *     possible object is
     *     {@link Signature2 .ClaimedRoles }
     *     
     */
    public Signature2 .ClaimedRoles getClaimedRoles() {
        return claimedRoles;
    }

    /**
     * Sets the value of the claimedRoles property.
     * 
     * @param value
     *     allowed object is
     *     {@link Signature2 .ClaimedRoles }
     *     
     */
    public void setClaimedRoles(Signature2 .ClaimedRoles value) {
        this.claimedRoles = value;
    }

    /**
     * Gets the value of the certifiedRoles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the certifiedRoles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCertifiedRoles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CertifiedRole }
     * 
     * 
     */
    public List<CertifiedRole> getCertifiedRoles() {
        if (certifiedRoles == null) {
            certifiedRoles = new ArrayList<CertifiedRole>();
        }
        return this.certifiedRoles;
    }

    /**
     * Gets the value of the policy property.
     * 
     * @return
     *     possible object is
     *     {@link Policy }
     *     
     */
    public Policy getPolicy() {
        return policy;
    }

    /**
     * Sets the value of the policy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Policy }
     *     
     */
    public void setPolicy(Policy value) {
        this.policy = value;
    }

    /**
     * Gets the value of the timestamps property.
     * 
     * @return
     *     possible object is
     *     {@link Signature2 .Timestamps }
     *     
     */
    public Signature2 .Timestamps getTimestamps() {
        return timestamps;
    }

    /**
     * Sets the value of the timestamps property.
     * 
     * @param value
     *     allowed object is
     *     {@link Signature2 .Timestamps }
     *     
     */
    public void setTimestamps(Signature2 .Timestamps value) {
        this.timestamps = value;
    }

    /**
     * Gets the value of the signatureScopes property.
     * 
     * @return
     *     possible object is
     *     {@link Signature2 .SignatureScopes }
     *     
     */
    public Signature2 .SignatureScopes getSignatureScopes() {
        return signatureScopes;
    }

    /**
     * Sets the value of the signatureScopes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Signature2 .SignatureScopes }
     *     
     */
    public void setSignatureScopes(Signature2 .SignatureScopes value) {
        this.signatureScopes = value;
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
     * Gets the value of the counterSignature property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCounterSignature() {
        return counterSignature;
    }

    /**
     * Sets the value of the counterSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCounterSignature(Boolean value) {
        this.counterSignature = value;
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
        protected List<Signature2 .CertificateChain.ChainItem> chainItem;

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
         * {@link Signature2 .CertificateChain.ChainItem }
         * 
         * 
         */
        public List<Signature2 .CertificateChain.ChainItem> getChainItem() {
            if (chainItem == null) {
                chainItem = new ArrayList<Signature2 .CertificateChain.ChainItem>();
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
     *         &lt;element name="ClaimedRoles" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "claimedRoles"
    })
    public static class ClaimedRoles {

        @XmlElement(name = "ClaimedRoles", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<String> claimedRoles;

        /**
         * Gets the value of the claimedRoles property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the claimedRoles property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getClaimedRoles().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getClaimedRoles() {
            if (claimedRoles == null) {
                claimedRoles = new ArrayList<String>();
            }
            return this.claimedRoles;
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
     *         &lt;element name="Indication" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "indication"
    })
    public static class CommitmentTypeIndication {

        @XmlElement(name = "Indication", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<String> indication;

        /**
         * Gets the value of the indication property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the indication property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIndication().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getIndication() {
            if (indication == null) {
                indication = new ArrayList<String>();
            }
            return this.indication;
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
     *         &lt;element name="SignatureScope" type="{http://dss.esig.europa.eu/validation/diagnostic}SignatureScope" maxOccurs="unbounded" minOccurs="0"/>
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
        "signatureScope"
    })
    public static class SignatureScopes {

        @XmlElement(name = "SignatureScope", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<SignatureScope> signatureScope;

        /**
         * Gets the value of the signatureScope property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the signatureScope property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSignatureScope().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SignatureScope }
         * 
         * 
         */
        public List<SignatureScope> getSignatureScope() {
            if (signatureScope == null) {
                signatureScope = new ArrayList<SignatureScope>();
            }
            return this.signatureScope;
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
     *         &lt;element name="Timestamp" type="{http://dss.esig.europa.eu/validation/diagnostic}Timestamp" maxOccurs="unbounded" minOccurs="0"/>
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
        "timestamp"
    })
    public static class Timestamps {

        @XmlElement(name = "Timestamp", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<Timestamp> timestamp;

        /**
         * Gets the value of the timestamp property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the timestamp property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTimestamp().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Timestamp }
         * 
         * 
         */
        public List<Timestamp> getTimestamp() {
            if (timestamp == null) {
                timestamp = new ArrayList<Timestamp>();
            }
            return this.timestamp;
        }

    }

}
