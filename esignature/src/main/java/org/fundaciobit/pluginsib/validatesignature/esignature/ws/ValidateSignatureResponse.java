
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for validateSignatureResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="validateSignatureResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WSReportsDTO" type="{http://validation.dss.esig.europa.eu/}wsReportsDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validateSignatureResponse", namespace = "http://validation.dss.esig.europa.eu/", propOrder = {
    "wsReportsDTO"
})
public class ValidateSignatureResponse {

    @XmlElement(name = "WSReportsDTO", namespace = "")
    protected WsReportsDTO wsReportsDTO;

    /**
     * Gets the value of the wsReportsDTO property.
     * 
     * @return
     *     possible object is
     *     {@link WsReportsDTO }
     *     
     */
    public WsReportsDTO getWSReportsDTO() {
        return wsReportsDTO;
    }

    /**
     * Sets the value of the wsReportsDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsReportsDTO }
     *     
     */
    public void setWSReportsDTO(WsReportsDTO value) {
        this.wsReportsDTO = value;
    }

}
