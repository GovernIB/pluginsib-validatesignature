
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for validateSignature complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="validateSignature">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataToValidateDTO" type="{http://validation.dss.esig.europa.eu/}dataToValidateDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validateSignature", namespace = "http://validation.dss.esig.europa.eu/", propOrder = {
    "dataToValidateDTO"
})
public class ValidateSignature {

    @XmlElement(namespace = "")
    protected DataToValidateDTO dataToValidateDTO;

    /**
     * Gets the value of the dataToValidateDTO property.
     * 
     * @return
     *     possible object is
     *     {@link DataToValidateDTO }
     *     
     */
    public DataToValidateDTO getDataToValidateDTO() {
        return dataToValidateDTO;
    }

    /**
     * Sets the value of the dataToValidateDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataToValidateDTO }
     *     
     */
    public void setDataToValidateDTO(DataToValidateDTO value) {
        this.dataToValidateDTO = value;
    }

}
