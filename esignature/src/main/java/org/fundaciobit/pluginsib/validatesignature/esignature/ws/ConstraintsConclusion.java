
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConstraintsConclusion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConstraintsConclusion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Constraint" type="{http://dss.esig.europa.eu/validation/detailed-report}Constraint" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Conclusion" type="{http://dss.esig.europa.eu/validation/detailed-report}Conclusion"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConstraintsConclusion", propOrder = {
    "constraint",
    "conclusion"
})
@XmlSeeAlso({
    Certificate.class,
    TLAnalysis.class,
    ValidationProcessBasicSignatures.class,
    SAV.class,
    XCV.class,
    RFC.class,
    ISC.class,
    ValidationSignatureQualification.class,
    ValidationCertificateQualification.class,
    SubXCV.class,
    ValidationProcessTimestamps.class,
    ValidationProcessLongTermData.class,
    ConstraintsConclusionWithControlTime.class,
    CV.class,
    ValidationProcessArchivalData.class,
    FC.class,
    VCI.class
})
public class ConstraintsConclusion {

    @XmlElement(name = "Constraint")
    protected List<Constraint> constraint;
    @XmlElement(name = "Conclusion", required = true)
    protected Conclusion conclusion;

    /**
     * Gets the value of the constraint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the constraint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConstraint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Constraint }
     * 
     * 
     */
    public List<Constraint> getConstraint() {
        if (constraint == null) {
            constraint = new ArrayList<Constraint>();
        }
        return this.constraint;
    }

    /**
     * Gets the value of the conclusion property.
     * 
     * @return
     *     possible object is
     *     {@link Conclusion }
     *     
     */
    public Conclusion getConclusion() {
        return conclusion;
    }

    /**
     * Sets the value of the conclusion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Conclusion }
     *     
     */
    public void setConclusion(Conclusion value) {
        this.conclusion = value;
    }

}
