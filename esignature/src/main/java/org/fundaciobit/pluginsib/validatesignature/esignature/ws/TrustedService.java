
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TrustedService complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrustedService">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServiceName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ServiceType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="CapturedQualifiers" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Qualifier" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AdditionalServiceInfoUris" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="URI" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ServiceSupplyPoints" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="URI" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="expiredCertsRevocationInfo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrustedService", namespace = "http://dss.esig.europa.eu/validation/diagnostic", propOrder = {
    "serviceName",
    "serviceType",
    "status",
    "startDate",
    "endDate",
    "capturedQualifiers",
    "additionalServiceInfoUris",
    "serviceSupplyPoints",
    "expiredCertsRevocationInfo"
})
public class TrustedService {

    @XmlElement(name = "ServiceName", required = true)
    protected String serviceName;
    @XmlElement(name = "ServiceType", required = true)
    protected String serviceType;
    @XmlElement(name = "Status", required = true)
    protected String status;
    @XmlElement(name = "StartDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "EndDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "CapturedQualifiers")
    protected TrustedService.CapturedQualifiers capturedQualifiers;
    @XmlElement(name = "AdditionalServiceInfoUris")
    protected TrustedService.AdditionalServiceInfoUris additionalServiceInfoUris;
    @XmlElement(name = "ServiceSupplyPoints")
    protected TrustedService.ServiceSupplyPoints serviceSupplyPoints;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expiredCertsRevocationInfo;

    /**
     * Gets the value of the serviceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Sets the value of the serviceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
    }

    /**
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceType(String value) {
        this.serviceType = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the capturedQualifiers property.
     * 
     * @return
     *     possible object is
     *     {@link TrustedService.CapturedQualifiers }
     *     
     */
    public TrustedService.CapturedQualifiers getCapturedQualifiers() {
        return capturedQualifiers;
    }

    /**
     * Sets the value of the capturedQualifiers property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrustedService.CapturedQualifiers }
     *     
     */
    public void setCapturedQualifiers(TrustedService.CapturedQualifiers value) {
        this.capturedQualifiers = value;
    }

    /**
     * Gets the value of the additionalServiceInfoUris property.
     * 
     * @return
     *     possible object is
     *     {@link TrustedService.AdditionalServiceInfoUris }
     *     
     */
    public TrustedService.AdditionalServiceInfoUris getAdditionalServiceInfoUris() {
        return additionalServiceInfoUris;
    }

    /**
     * Sets the value of the additionalServiceInfoUris property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrustedService.AdditionalServiceInfoUris }
     *     
     */
    public void setAdditionalServiceInfoUris(TrustedService.AdditionalServiceInfoUris value) {
        this.additionalServiceInfoUris = value;
    }

    /**
     * Gets the value of the serviceSupplyPoints property.
     * 
     * @return
     *     possible object is
     *     {@link TrustedService.ServiceSupplyPoints }
     *     
     */
    public TrustedService.ServiceSupplyPoints getServiceSupplyPoints() {
        return serviceSupplyPoints;
    }

    /**
     * Sets the value of the serviceSupplyPoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrustedService.ServiceSupplyPoints }
     *     
     */
    public void setServiceSupplyPoints(TrustedService.ServiceSupplyPoints value) {
        this.serviceSupplyPoints = value;
    }

    /**
     * Gets the value of the expiredCertsRevocationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpiredCertsRevocationInfo() {
        return expiredCertsRevocationInfo;
    }

    /**
     * Sets the value of the expiredCertsRevocationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpiredCertsRevocationInfo(XMLGregorianCalendar value) {
        this.expiredCertsRevocationInfo = value;
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
     *         &lt;element name="URI" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "uri"
    })
    public static class AdditionalServiceInfoUris {

        @XmlElement(name = "URI", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<String> uri;

        /**
         * Gets the value of the uri property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the uri property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getURI().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getURI() {
            if (uri == null) {
                uri = new ArrayList<String>();
            }
            return this.uri;
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
     *         &lt;element name="Qualifier" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "qualifier"
    })
    public static class CapturedQualifiers {

        @XmlElement(name = "Qualifier", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<String> qualifier;

        /**
         * Gets the value of the qualifier property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the qualifier property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getQualifier().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getQualifier() {
            if (qualifier == null) {
                qualifier = new ArrayList<String>();
            }
            return this.qualifier;
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
     *         &lt;element name="URI" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "uri"
    })
    public static class ServiceSupplyPoints {

        @XmlElement(name = "URI", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<String> uri;

        /**
         * Gets the value of the uri property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the uri property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getURI().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getURI() {
            if (uri == null) {
                uri = new ArrayList<String>();
            }
            return this.uri;
        }

    }

}
