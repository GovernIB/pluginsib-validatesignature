
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ValidationProcessBasicSignatures complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValidationProcessBasicSignatures">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dss.esig.europa.eu/validation/detailed-report}ConstraintsConclusion">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="BestSignatureTime" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidationProcessBasicSignatures")
public class ValidationProcessBasicSignatures
    extends ConstraintsConclusion
{

    @XmlAttribute(name = "BestSignatureTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar bestSignatureTime;

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

}
