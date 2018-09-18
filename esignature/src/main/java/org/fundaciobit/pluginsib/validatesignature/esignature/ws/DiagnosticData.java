
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
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
 *         &lt;element name="DocumentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ValidationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ContainerInfo" type="{http://dss.esig.europa.eu/validation/diagnostic}ContainerInfo" minOccurs="0"/>
 *         &lt;element name="Signatures" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Signature" type="{http://dss.esig.europa.eu/validation/diagnostic}Signature" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="UsedCertificates" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Certificate" type="{http://dss.esig.europa.eu/validation/diagnostic}Certificate" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TrustedLists" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TrustedList" type="{http://dss.esig.europa.eu/validation/diagnostic}TrustedList" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ListOfTrustedLists" type="{http://dss.esig.europa.eu/validation/diagnostic}TrustedList" minOccurs="0"/>
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
    "documentName",
    "validationDate",
    "containerInfo",
    "signatures",
    "usedCertificates",
    "trustedLists",
    "listOfTrustedLists"
})
@XmlRootElement(name = "diagnosticData", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
public class DiagnosticData {

    @XmlElement(name = "DocumentName", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
    protected String documentName;
    @XmlElement(name = "ValidationDate", namespace = "http://dss.esig.europa.eu/validation/diagnostic", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validationDate;
    @XmlElement(name = "ContainerInfo", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
    protected ContainerInfo containerInfo;
    @XmlElement(name = "Signatures", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
    protected DiagnosticData.Signatures signatures;
    @XmlElement(name = "UsedCertificates", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
    protected DiagnosticData.UsedCertificates usedCertificates;
    @XmlElement(name = "TrustedLists", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
    protected DiagnosticData.TrustedLists trustedLists;
    @XmlElement(name = "ListOfTrustedLists", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
    protected TrustedList listOfTrustedLists;

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
     * Gets the value of the validationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidationDate() {
        return validationDate;
    }

    /**
     * Sets the value of the validationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidationDate(XMLGregorianCalendar value) {
        this.validationDate = value;
    }

    /**
     * Gets the value of the containerInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ContainerInfo }
     *     
     */
    public ContainerInfo getContainerInfo() {
        return containerInfo;
    }

    /**
     * Sets the value of the containerInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContainerInfo }
     *     
     */
    public void setContainerInfo(ContainerInfo value) {
        this.containerInfo = value;
    }

    /**
     * Gets the value of the signatures property.
     * 
     * @return
     *     possible object is
     *     {@link DiagnosticData.Signatures }
     *     
     */
    public DiagnosticData.Signatures getSignatures() {
        return signatures;
    }

    /**
     * Sets the value of the signatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiagnosticData.Signatures }
     *     
     */
    public void setSignatures(DiagnosticData.Signatures value) {
        this.signatures = value;
    }

    /**
     * Gets the value of the usedCertificates property.
     * 
     * @return
     *     possible object is
     *     {@link DiagnosticData.UsedCertificates }
     *     
     */
    public DiagnosticData.UsedCertificates getUsedCertificates() {
        return usedCertificates;
    }

    /**
     * Sets the value of the usedCertificates property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiagnosticData.UsedCertificates }
     *     
     */
    public void setUsedCertificates(DiagnosticData.UsedCertificates value) {
        this.usedCertificates = value;
    }

    /**
     * Gets the value of the trustedLists property.
     * 
     * @return
     *     possible object is
     *     {@link DiagnosticData.TrustedLists }
     *     
     */
    public DiagnosticData.TrustedLists getTrustedLists() {
        return trustedLists;
    }

    /**
     * Sets the value of the trustedLists property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiagnosticData.TrustedLists }
     *     
     */
    public void setTrustedLists(DiagnosticData.TrustedLists value) {
        this.trustedLists = value;
    }

    /**
     * Gets the value of the listOfTrustedLists property.
     * 
     * @return
     *     possible object is
     *     {@link TrustedList }
     *     
     */
    public TrustedList getListOfTrustedLists() {
        return listOfTrustedLists;
    }

    /**
     * Sets the value of the listOfTrustedLists property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrustedList }
     *     
     */
    public void setListOfTrustedLists(TrustedList value) {
        this.listOfTrustedLists = value;
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
     *         &lt;element name="Signature" type="{http://dss.esig.europa.eu/validation/diagnostic}Signature" maxOccurs="unbounded" minOccurs="0"/>
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
        "signature"
    })
    public static class Signatures {

        @XmlElement(name = "Signature", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<Signature2> signature;

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
         * {@link Signature2 }
         * 
         * 
         */
        public List<Signature2> getSignature() {
            if (signature == null) {
                signature = new ArrayList<Signature2>();
            }
            return this.signature;
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
     *         &lt;element name="TrustedList" type="{http://dss.esig.europa.eu/validation/diagnostic}TrustedList" maxOccurs="unbounded" minOccurs="0"/>
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
        "trustedList"
    })
    public static class TrustedLists {

        @XmlElement(name = "TrustedList", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<TrustedList> trustedList;

        /**
         * Gets the value of the trustedList property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the trustedList property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTrustedList().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TrustedList }
         * 
         * 
         */
        public List<TrustedList> getTrustedList() {
            if (trustedList == null) {
                trustedList = new ArrayList<TrustedList>();
            }
            return this.trustedList;
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
     *         &lt;element name="Certificate" type="{http://dss.esig.europa.eu/validation/diagnostic}Certificate" maxOccurs="unbounded" minOccurs="0"/>
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
        "certificate"
    })
    public static class UsedCertificates {

        @XmlElement(name = "Certificate", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<Certificate3> certificate;

        /**
         * Gets the value of the certificate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the certificate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCertificate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Certificate3 }
         * 
         * 
         */
        public List<Certificate3> getCertificate() {
            if (certificate == null) {
                certificate = new ArrayList<Certificate3>();
            }
            return this.certificate;
        }

    }

}
