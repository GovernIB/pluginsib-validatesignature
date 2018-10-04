
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CertificatePolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CertificatePolicy">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://dss.esig.europa.eu/validation/diagnostic>OID">
 *       &lt;attribute name="cpsUrl" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CertificatePolicy", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
public class CertificatePolicy
    extends OID
{

    @XmlAttribute(name = "cpsUrl")
    protected String cpsUrl;

    /**
     * Gets the value of the cpsUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCpsUrl() {
        return cpsUrl;
    }

    /**
     * Sets the value of the cpsUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpsUrl(String value) {
        this.cpsUrl = value;
    }

}
