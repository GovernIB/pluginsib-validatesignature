
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="Signatures" type="{http://dss.esig.europa.eu/validation/detailed-report}Signature" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Certificate" type="{http://dss.esig.europa.eu/validation/detailed-report}Certificate" minOccurs="0"/>
 *         &lt;element name="BasicBuildingBlocks" type="{http://dss.esig.europa.eu/validation/detailed-report}BasicBuildingBlocks" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TLAnalysis" type="{http://dss.esig.europa.eu/validation/detailed-report}TLAnalysis" maxOccurs="unbounded" minOccurs="0"/>
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
    "signatures",
    "certificate",
    "basicBuildingBlocks",
    "tlAnalysis"
})
@XmlRootElement(name = "detailedReport")
public class DetailedReport2 {

    @XmlElement(name = "Signatures")
    protected List<Signature> signatures;
    @XmlElement(name = "Certificate")
    protected Certificate certificate;
    @XmlElement(name = "BasicBuildingBlocks")
    protected List<BasicBuildingBlocks> basicBuildingBlocks;
    @XmlElement(name = "TLAnalysis")
    protected List<TLAnalysis> tlAnalysis;

    /**
     * Gets the value of the signatures property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signatures property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignatures().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Signature }
     * 
     * 
     */
    public List<Signature> getSignatures() {
        if (signatures == null) {
            signatures = new ArrayList<Signature>();
        }
        return this.signatures;
    }

    /**
     * Gets the value of the certificate property.
     * 
     * @return
     *     possible object is
     *     {@link Certificate }
     *     
     */
    public Certificate getCertificate() {
        return certificate;
    }

    /**
     * Sets the value of the certificate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Certificate }
     *     
     */
    public void setCertificate(Certificate value) {
        this.certificate = value;
    }

    /**
     * Gets the value of the basicBuildingBlocks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the basicBuildingBlocks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBasicBuildingBlocks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BasicBuildingBlocks }
     * 
     * 
     */
    public List<BasicBuildingBlocks> getBasicBuildingBlocks() {
        if (basicBuildingBlocks == null) {
            basicBuildingBlocks = new ArrayList<BasicBuildingBlocks>();
        }
        return this.basicBuildingBlocks;
    }

    /**
     * Gets the value of the tlAnalysis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tlAnalysis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTLAnalysis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TLAnalysis }
     * 
     * 
     */
    public List<TLAnalysis> getTLAnalysis() {
        if (tlAnalysis == null) {
            tlAnalysis = new ArrayList<TLAnalysis>();
        }
        return this.tlAnalysis;
    }

}
