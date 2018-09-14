
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TrustedServiceProvider complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrustedServiceProvider">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TSPName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TSPRegistrationIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TrustedServices">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TrustedService" type="{http://dss.esig.europa.eu/validation/diagnostic}TrustedService" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
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
@XmlType(name = "TrustedServiceProvider", namespace = "http://dss.esig.europa.eu/validation/diagnostic", propOrder = {
    "tspName",
    "tspRegistrationIdentifier",
    "countryCode",
    "trustedServices"
})
public class TrustedServiceProvider {

    @XmlElement(name = "TSPName", required = true)
    protected String tspName;
    @XmlElement(name = "TSPRegistrationIdentifier")
    protected String tspRegistrationIdentifier;
    @XmlElement(name = "CountryCode", required = true)
    protected String countryCode;
    @XmlElement(name = "TrustedServices", required = true)
    protected TrustedServiceProvider.TrustedServices trustedServices;

    /**
     * Gets the value of the tspName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTSPName() {
        return tspName;
    }

    /**
     * Sets the value of the tspName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTSPName(String value) {
        this.tspName = value;
    }

    /**
     * Gets the value of the tspRegistrationIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTSPRegistrationIdentifier() {
        return tspRegistrationIdentifier;
    }

    /**
     * Sets the value of the tspRegistrationIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTSPRegistrationIdentifier(String value) {
        this.tspRegistrationIdentifier = value;
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the trustedServices property.
     * 
     * @return
     *     possible object is
     *     {@link TrustedServiceProvider.TrustedServices }
     *     
     */
    public TrustedServiceProvider.TrustedServices getTrustedServices() {
        return trustedServices;
    }

    /**
     * Sets the value of the trustedServices property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrustedServiceProvider.TrustedServices }
     *     
     */
    public void setTrustedServices(TrustedServiceProvider.TrustedServices value) {
        this.trustedServices = value;
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
     *         &lt;element name="TrustedService" type="{http://dss.esig.europa.eu/validation/diagnostic}TrustedService" maxOccurs="unbounded" minOccurs="0"/>
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
        "trustedService"
    })
    public static class TrustedServices {

        @XmlElement(name = "TrustedService", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<TrustedService> trustedService;

        /**
         * Gets the value of the trustedService property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the trustedService property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTrustedService().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TrustedService }
         * 
         * 
         */
        public List<TrustedService> getTrustedService() {
            if (trustedService == null) {
                trustedService = new ArrayList<TrustedService>();
            }
            return this.trustedService;
        }

    }

}
