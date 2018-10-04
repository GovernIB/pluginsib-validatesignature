
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Signature complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Signature">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ValidationProcessBasicSignatures" type="{http://dss.esig.europa.eu/validation/detailed-report}ValidationProcessBasicSignatures" minOccurs="0"/>
 *         &lt;element name="ValidationProcessTimestamps" type="{http://dss.esig.europa.eu/validation/detailed-report}ValidationProcessTimestamps" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ValidationProcessLongTermData" type="{http://dss.esig.europa.eu/validation/detailed-report}ValidationProcessLongTermData" minOccurs="0"/>
 *         &lt;element name="ValidationProcessArchivalData" type="{http://dss.esig.europa.eu/validation/detailed-report}ValidationProcessArchivalData" minOccurs="0"/>
 *         &lt;element name="ValidationSignatureQualification" type="{http://dss.esig.europa.eu/validation/detailed-report}ValidationSignatureQualification" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CounterSignature" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Signature", propOrder = {
    "validationProcessBasicSignatures",
    "validationProcessTimestamps",
    "validationProcessLongTermData",
    "validationProcessArchivalData",
    "validationSignatureQualification"
})
public class Signature {

    @XmlElement(name = "ValidationProcessBasicSignatures")
    protected ValidationProcessBasicSignatures validationProcessBasicSignatures;
    @XmlElement(name = "ValidationProcessTimestamps")
    protected List<ValidationProcessTimestamps> validationProcessTimestamps;
    @XmlElement(name = "ValidationProcessLongTermData")
    protected ValidationProcessLongTermData validationProcessLongTermData;
    @XmlElement(name = "ValidationProcessArchivalData")
    protected ValidationProcessArchivalData validationProcessArchivalData;
    @XmlElement(name = "ValidationSignatureQualification")
    protected ValidationSignatureQualification validationSignatureQualification;
    @XmlAttribute(name = "Id", required = true)
    protected String id;
    @XmlAttribute(name = "CounterSignature")
    protected Boolean counterSignature;

    /**
     * Gets the value of the validationProcessBasicSignatures property.
     * 
     * @return
     *     possible object is
     *     {@link ValidationProcessBasicSignatures }
     *     
     */
    public ValidationProcessBasicSignatures getValidationProcessBasicSignatures() {
        return validationProcessBasicSignatures;
    }

    /**
     * Sets the value of the validationProcessBasicSignatures property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidationProcessBasicSignatures }
     *     
     */
    public void setValidationProcessBasicSignatures(ValidationProcessBasicSignatures value) {
        this.validationProcessBasicSignatures = value;
    }

    /**
     * Gets the value of the validationProcessTimestamps property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the validationProcessTimestamps property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValidationProcessTimestamps().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValidationProcessTimestamps }
     * 
     * 
     */
    public List<ValidationProcessTimestamps> getValidationProcessTimestamps() {
        if (validationProcessTimestamps == null) {
            validationProcessTimestamps = new ArrayList<ValidationProcessTimestamps>();
        }
        return this.validationProcessTimestamps;
    }

    /**
     * Gets the value of the validationProcessLongTermData property.
     * 
     * @return
     *     possible object is
     *     {@link ValidationProcessLongTermData }
     *     
     */
    public ValidationProcessLongTermData getValidationProcessLongTermData() {
        return validationProcessLongTermData;
    }

    /**
     * Sets the value of the validationProcessLongTermData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidationProcessLongTermData }
     *     
     */
    public void setValidationProcessLongTermData(ValidationProcessLongTermData value) {
        this.validationProcessLongTermData = value;
    }

    /**
     * Gets the value of the validationProcessArchivalData property.
     * 
     * @return
     *     possible object is
     *     {@link ValidationProcessArchivalData }
     *     
     */
    public ValidationProcessArchivalData getValidationProcessArchivalData() {
        return validationProcessArchivalData;
    }

    /**
     * Sets the value of the validationProcessArchivalData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidationProcessArchivalData }
     *     
     */
    public void setValidationProcessArchivalData(ValidationProcessArchivalData value) {
        this.validationProcessArchivalData = value;
    }

    /**
     * Gets the value of the validationSignatureQualification property.
     * 
     * @return
     *     possible object is
     *     {@link ValidationSignatureQualification }
     *     
     */
    public ValidationSignatureQualification getValidationSignatureQualification() {
        return validationSignatureQualification;
    }

    /**
     * Sets the value of the validationSignatureQualification property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidationSignatureQualification }
     *     
     */
    public void setValidationSignatureQualification(ValidationSignatureQualification value) {
        this.validationSignatureQualification = value;
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

}
