
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="Policy">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PolicyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="PolicyDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ValidationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="DocumentName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ValidSignaturesCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SignaturesCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ContainerType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Signature" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Filename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SigningTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="BestSignatureTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="SignedBy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="CertificateChain" type="{http://dss.esig.europa.eu/validation/simple-report}CertificateChain"/>
 *                   &lt;element name="SignatureLevel" type="{http://dss.esig.europa.eu/validation/simple-report}SignatureLevel" minOccurs="0"/>
 *                   &lt;element name="Indication" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="SubIndication" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Errors" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="Warnings" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="Infos" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="SignatureScope" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="scope" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="CounterSignature" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="ParentId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="SignatureFormat" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    "policy",
    "validationTime",
    "documentName",
    "validSignaturesCount",
    "signaturesCount",
    "containerType",
    "signature"
})
@XmlRootElement(name = "SimpleReport", namespace = "http://dss.esig.europa.eu/validation/simple-report")
public class SimpleReport2 {

    @XmlElement(name = "Policy", namespace = "http://dss.esig.europa.eu/validation/simple-report", required = true)
    protected SimpleReport2 .Policy policy;
    @XmlElement(name = "ValidationTime", namespace = "http://dss.esig.europa.eu/validation/simple-report", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validationTime;
    @XmlElement(name = "DocumentName", namespace = "http://dss.esig.europa.eu/validation/simple-report", required = true)
    protected String documentName;
    @XmlElement(name = "ValidSignaturesCount", namespace = "http://dss.esig.europa.eu/validation/simple-report")
    protected int validSignaturesCount;
    @XmlElement(name = "SignaturesCount", namespace = "http://dss.esig.europa.eu/validation/simple-report")
    protected int signaturesCount;
    @XmlElement(name = "ContainerType", namespace = "http://dss.esig.europa.eu/validation/simple-report")
    protected String containerType;
    @XmlElement(name = "Signature", namespace = "http://dss.esig.europa.eu/validation/simple-report")
    protected List<SimpleReport2 .Signature> signature;

    /**
     * Gets the value of the policy property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleReport2 .Policy }
     *     
     */
    public SimpleReport2 .Policy getPolicy() {
        return policy;
    }

    /**
     * Sets the value of the policy property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleReport2 .Policy }
     *     
     */
    public void setPolicy(SimpleReport2 .Policy value) {
        this.policy = value;
    }

    /**
     * Gets the value of the validationTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidationTime() {
        return validationTime;
    }

    /**
     * Sets the value of the validationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidationTime(XMLGregorianCalendar value) {
        this.validationTime = value;
    }

    /**
     * Gets the value of the documentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentName() {
        return documentName;
    }

    /**
     * Sets the value of the documentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentName(String value) {
        this.documentName = value;
    }

    /**
     * Gets the value of the validSignaturesCount property.
     * 
     */
    public int getValidSignaturesCount() {
        return validSignaturesCount;
    }

    /**
     * Sets the value of the validSignaturesCount property.
     * 
     */
    public void setValidSignaturesCount(int value) {
        this.validSignaturesCount = value;
    }

    /**
     * Gets the value of the signaturesCount property.
     * 
     */
    public int getSignaturesCount() {
        return signaturesCount;
    }

    /**
     * Sets the value of the signaturesCount property.
     * 
     */
    public void setSignaturesCount(int value) {
        this.signaturesCount = value;
    }

    /**
     * Gets the value of the containerType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContainerType() {
        return containerType;
    }

    /**
     * Sets the value of the containerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContainerType(String value) {
        this.containerType = value;
    }

    /**
     * Gets the value of the signature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimpleReport2 .Signature }
     * 
     * 
     */
    public List<SimpleReport2 .Signature> getSignature() {
        if (signature == null) {
            signature = new ArrayList<SimpleReport2 .Signature>();
        }
        return this.signature;
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
     *         &lt;element name="PolicyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="PolicyDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "policyName",
        "policyDescription"
    })
    public static class Policy {

        @XmlElement(name = "PolicyName", namespace = "http://dss.esig.europa.eu/validation/simple-report", required = true)
        protected String policyName;
        @XmlElement(name = "PolicyDescription", namespace = "http://dss.esig.europa.eu/validation/simple-report", required = true)
        protected String policyDescription;

        /**
         * Gets the value of the policyName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPolicyName() {
            return policyName;
        }

        /**
         * Sets the value of the policyName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPolicyName(String value) {
            this.policyName = value;
        }

        /**
         * Gets the value of the policyDescription property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPolicyDescription() {
            return policyDescription;
        }

        /**
         * Sets the value of the policyDescription property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPolicyDescription(String value) {
            this.policyDescription = value;
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
     *         &lt;element name="Filename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SigningTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="BestSignatureTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="SignedBy" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="CertificateChain" type="{http://dss.esig.europa.eu/validation/simple-report}CertificateChain"/>
     *         &lt;element name="SignatureLevel" type="{http://dss.esig.europa.eu/validation/simple-report}SignatureLevel" minOccurs="0"/>
     *         &lt;element name="Indication" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="SubIndication" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Errors" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="Warnings" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="Infos" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="SignatureScope" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="scope" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="CounterSignature" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="ParentId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="SignatureFormat" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "filename",
        "signingTime",
        "bestSignatureTime",
        "signedBy",
        "certificateChain",
        "signatureLevel",
        "indication",
        "subIndication",
        "errors",
        "warnings",
        "infos",
        "signatureScope"
    })
    public static class Signature {

        @XmlElement(name = "Filename", namespace = "http://dss.esig.europa.eu/validation/simple-report")
        protected String filename;
        @XmlElement(name = "SigningTime", namespace = "http://dss.esig.europa.eu/validation/simple-report")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar signingTime;
        @XmlElement(name = "BestSignatureTime", namespace = "http://dss.esig.europa.eu/validation/simple-report")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar bestSignatureTime;
        @XmlElement(name = "SignedBy", namespace = "http://dss.esig.europa.eu/validation/simple-report", required = true)
        protected String signedBy;
        @XmlElement(name = "CertificateChain", namespace = "http://dss.esig.europa.eu/validation/simple-report", required = true)
        protected CertificateChain2 certificateChain;
        @XmlElement(name = "SignatureLevel", namespace = "http://dss.esig.europa.eu/validation/simple-report")
        protected SignatureLevel signatureLevel;
        @XmlElement(name = "Indication", namespace = "http://dss.esig.europa.eu/validation/simple-report", required = true)
        protected String indication;
        @XmlElement(name = "SubIndication", namespace = "http://dss.esig.europa.eu/validation/simple-report")
        protected String subIndication;
        @XmlElement(name = "Errors", namespace = "http://dss.esig.europa.eu/validation/simple-report")
        protected List<String> errors;
        @XmlElement(name = "Warnings", namespace = "http://dss.esig.europa.eu/validation/simple-report")
        protected List<String> warnings;
        @XmlElement(name = "Infos", namespace = "http://dss.esig.europa.eu/validation/simple-report")
        protected List<String> infos;
        @XmlElement(name = "SignatureScope", namespace = "http://dss.esig.europa.eu/validation/simple-report")
        protected List<SimpleReport2 .Signature.SignatureScope> signatureScope;
        @XmlAttribute(name = "Id", required = true)
        protected String id;
        @XmlAttribute(name = "CounterSignature")
        protected Boolean counterSignature;
        @XmlAttribute(name = "ParentId")
        protected String parentId;
        @XmlAttribute(name = "SignatureFormat", required = true)
        protected String signatureFormat;

        /**
         * Gets the value of the filename property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFilename() {
            return filename;
        }

        /**
         * Sets the value of the filename property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFilename(String value) {
            this.filename = value;
        }

        /**
         * Gets the value of the signingTime property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getSigningTime() {
            return signingTime;
        }

        /**
         * Sets the value of the signingTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setSigningTime(XMLGregorianCalendar value) {
            this.signingTime = value;
        }

        /**
         * Gets the value of the bestSignatureTime property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getBestSignatureTime() {
            return bestSignatureTime;
        }

        /**
         * Sets the value of the bestSignatureTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setBestSignatureTime(XMLGregorianCalendar value) {
            this.bestSignatureTime = value;
        }

        /**
         * Gets the value of the signedBy property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSignedBy() {
            return signedBy;
        }

        /**
         * Sets the value of the signedBy property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSignedBy(String value) {
            this.signedBy = value;
        }

        /**
         * Gets the value of the certificateChain property.
         * 
         * @return
         *     possible object is
         *     {@link CertificateChain2 }
         *     
         */
        public CertificateChain2 getCertificateChain() {
            return certificateChain;
        }

        /**
         * Sets the value of the certificateChain property.
         * 
         * @param value
         *     allowed object is
         *     {@link CertificateChain2 }
         *     
         */
        public void setCertificateChain(CertificateChain2 value) {
            this.certificateChain = value;
        }

        /**
         * Gets the value of the signatureLevel property.
         * 
         * @return
         *     possible object is
         *     {@link SignatureLevel }
         *     
         */
        public SignatureLevel getSignatureLevel() {
            return signatureLevel;
        }

        /**
         * Sets the value of the signatureLevel property.
         * 
         * @param value
         *     allowed object is
         *     {@link SignatureLevel }
         *     
         */
        public void setSignatureLevel(SignatureLevel value) {
            this.signatureLevel = value;
        }

        /**
         * Gets the value of the indication property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIndication() {
            return indication;
        }

        /**
         * Sets the value of the indication property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIndication(String value) {
            this.indication = value;
        }

        /**
         * Gets the value of the subIndication property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSubIndication() {
            return subIndication;
        }

        /**
         * Sets the value of the subIndication property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSubIndication(String value) {
            this.subIndication = value;
        }

        /**
         * Gets the value of the errors property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the errors property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getErrors().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getErrors() {
            if (errors == null) {
                errors = new ArrayList<String>();
            }
            return this.errors;
        }

        /**
         * Gets the value of the warnings property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the warnings property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getWarnings().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getWarnings() {
            if (warnings == null) {
                warnings = new ArrayList<String>();
            }
            return this.warnings;
        }

        /**
         * Gets the value of the infos property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the infos property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInfos().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getInfos() {
            if (infos == null) {
                infos = new ArrayList<String>();
            }
            return this.infos;
        }

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
         * {@link SimpleReport2 .Signature.SignatureScope }
         * 
         * 
         */
        public List<SimpleReport2 .Signature.SignatureScope> getSignatureScope() {
            if (signatureScope == null) {
                signatureScope = new ArrayList<SimpleReport2 .Signature.SignatureScope>();
            }
            return this.signatureScope;
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
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="scope" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class SignatureScope {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "name")
            protected String name;
            @XmlAttribute(name = "scope")
            protected String scope;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the scope property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getScope() {
                return scope;
            }

            /**
             * Sets the value of the scope property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setScope(String value) {
                this.scope = value;
            }

        }

    }

}
