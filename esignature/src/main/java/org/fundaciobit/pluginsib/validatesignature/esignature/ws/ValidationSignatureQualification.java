
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ValidationSignatureQualification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValidationSignatureQualification">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dss.esig.europa.eu/validation/detailed-report}ConstraintsConclusion">
 *       &lt;sequence>
 *         &lt;element name="ValidationCertificateQualification" type="{http://dss.esig.europa.eu/validation/detailed-report}ValidationCertificateQualification" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SignatureQualification" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidationSignatureQualification", propOrder = {
    "validationCertificateQualification"
})
public class ValidationSignatureQualification
    extends ConstraintsConclusion
{

    @XmlElement(name = "ValidationCertificateQualification")
    protected List<ValidationCertificateQualification> validationCertificateQualification;
    @XmlAttribute(name = "Id", required = true)
    protected String id;
    @XmlAttribute(name = "SignatureQualification")
    protected String signatureQualification;

    /**
     * Gets the value of the validationCertificateQualification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the validationCertificateQualification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValidationCertificateQualification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValidationCertificateQualification }
     * 
     * 
     */
    public List<ValidationCertificateQualification> getValidationCertificateQualification() {
        if (validationCertificateQualification == null) {
            validationCertificateQualification = new ArrayList<ValidationCertificateQualification>();
        }
        return this.validationCertificateQualification;
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
     * Gets the value of the signatureQualification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignatureQualification() {
        return signatureQualification;
    }

    /**
     * Sets the value of the signatureQualification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignatureQualification(String value) {
        this.signatureQualification = value;
    }

}
