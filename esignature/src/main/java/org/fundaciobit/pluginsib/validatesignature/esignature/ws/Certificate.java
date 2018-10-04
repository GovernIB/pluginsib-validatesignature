
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Certificate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Certificate">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dss.esig.europa.eu/validation/detailed-report}ConstraintsConclusion">
 *       &lt;sequence>
 *         &lt;element name="ValidationCertificateQualification" type="{http://dss.esig.europa.eu/validation/detailed-report}ValidationCertificateQualification" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Certificate", propOrder = {
    "validationCertificateQualification"
})
public class Certificate
    extends ConstraintsConclusion
{

    @XmlElement(name = "ValidationCertificateQualification")
    protected List<ValidationCertificateQualification> validationCertificateQualification;

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

}
