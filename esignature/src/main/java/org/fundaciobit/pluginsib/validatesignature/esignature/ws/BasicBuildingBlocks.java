
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BasicBuildingBlocks complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BasicBuildingBlocks">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FC" type="{http://dss.esig.europa.eu/validation/detailed-report}FC" minOccurs="0"/>
 *         &lt;element name="ISC" type="{http://dss.esig.europa.eu/validation/detailed-report}ISC" minOccurs="0"/>
 *         &lt;element name="VCI" type="{http://dss.esig.europa.eu/validation/detailed-report}VCI" minOccurs="0"/>
 *         &lt;element name="CV" type="{http://dss.esig.europa.eu/validation/detailed-report}CV" minOccurs="0"/>
 *         &lt;element name="SAV" type="{http://dss.esig.europa.eu/validation/detailed-report}SAV" minOccurs="0"/>
 *         &lt;element name="XCV" type="{http://dss.esig.europa.eu/validation/detailed-report}XCV" minOccurs="0"/>
 *         &lt;element name="PSV" type="{http://dss.esig.europa.eu/validation/detailed-report}PSV" minOccurs="0"/>
 *         &lt;element name="PCV" type="{http://dss.esig.europa.eu/validation/detailed-report}PCV" minOccurs="0"/>
 *         &lt;element name="VTS" type="{http://dss.esig.europa.eu/validation/detailed-report}VTS" minOccurs="0"/>
 *         &lt;element name="CertificateChain" type="{http://dss.esig.europa.eu/validation/detailed-report}CertificateChain"/>
 *         &lt;element name="Conclusion" type="{http://dss.esig.europa.eu/validation/detailed-report}Conclusion"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BasicBuildingBlocks", propOrder = {
    "fc",
    "isc",
    "vci",
    "cv",
    "sav",
    "xcv",
    "psv",
    "pcv",
    "vts",
    "certificateChain",
    "conclusion"
})
public class BasicBuildingBlocks {

    @XmlElement(name = "FC")
    protected FC fc;
    @XmlElement(name = "ISC")
    protected ISC isc;
    @XmlElement(name = "VCI")
    protected VCI vci;
    @XmlElement(name = "CV")
    protected CV cv;
    @XmlElement(name = "SAV")
    protected SAV sav;
    @XmlElement(name = "XCV")
    protected XCV xcv;
    @XmlElement(name = "PSV")
    protected PSV psv;
    @XmlElement(name = "PCV")
    protected PCV pcv;
    @XmlElement(name = "VTS")
    protected VTS vts;
    @XmlElement(name = "CertificateChain", required = true)
    protected CertificateChain certificateChain;
    @XmlElement(name = "Conclusion", required = true)
    protected Conclusion conclusion;
    @XmlAttribute(name = "Id", required = true)
    protected String id;
    @XmlAttribute(name = "Type", required = true)
    protected String type;

    /**
     * Gets the value of the fc property.
     * 
     * @return
     *     possible object is
     *     {@link FC }
     *     
     */
    public FC getFC() {
        return fc;
    }

    /**
     * Sets the value of the fc property.
     * 
     * @param value
     *     allowed object is
     *     {@link FC }
     *     
     */
    public void setFC(FC value) {
        this.fc = value;
    }

    /**
     * Gets the value of the isc property.
     * 
     * @return
     *     possible object is
     *     {@link ISC }
     *     
     */
    public ISC getISC() {
        return isc;
    }

    /**
     * Sets the value of the isc property.
     * 
     * @param value
     *     allowed object is
     *     {@link ISC }
     *     
     */
    public void setISC(ISC value) {
        this.isc = value;
    }

    /**
     * Gets the value of the vci property.
     * 
     * @return
     *     possible object is
     *     {@link VCI }
     *     
     */
    public VCI getVCI() {
        return vci;
    }

    /**
     * Sets the value of the vci property.
     * 
     * @param value
     *     allowed object is
     *     {@link VCI }
     *     
     */
    public void setVCI(VCI value) {
        this.vci = value;
    }

    /**
     * Gets the value of the cv property.
     * 
     * @return
     *     possible object is
     *     {@link CV }
     *     
     */
    public CV getCV() {
        return cv;
    }

    /**
     * Sets the value of the cv property.
     * 
     * @param value
     *     allowed object is
     *     {@link CV }
     *     
     */
    public void setCV(CV value) {
        this.cv = value;
    }

    /**
     * Gets the value of the sav property.
     * 
     * @return
     *     possible object is
     *     {@link SAV }
     *     
     */
    public SAV getSAV() {
        return sav;
    }

    /**
     * Sets the value of the sav property.
     * 
     * @param value
     *     allowed object is
     *     {@link SAV }
     *     
     */
    public void setSAV(SAV value) {
        this.sav = value;
    }

    /**
     * Gets the value of the xcv property.
     * 
     * @return
     *     possible object is
     *     {@link XCV }
     *     
     */
    public XCV getXCV() {
        return xcv;
    }

    /**
     * Sets the value of the xcv property.
     * 
     * @param value
     *     allowed object is
     *     {@link XCV }
     *     
     */
    public void setXCV(XCV value) {
        this.xcv = value;
    }

    /**
     * Gets the value of the psv property.
     * 
     * @return
     *     possible object is
     *     {@link PSV }
     *     
     */
    public PSV getPSV() {
        return psv;
    }

    /**
     * Sets the value of the psv property.
     * 
     * @param value
     *     allowed object is
     *     {@link PSV }
     *     
     */
    public void setPSV(PSV value) {
        this.psv = value;
    }

    /**
     * Gets the value of the pcv property.
     * 
     * @return
     *     possible object is
     *     {@link PCV }
     *     
     */
    public PCV getPCV() {
        return pcv;
    }

    /**
     * Sets the value of the pcv property.
     * 
     * @param value
     *     allowed object is
     *     {@link PCV }
     *     
     */
    public void setPCV(PCV value) {
        this.pcv = value;
    }

    /**
     * Gets the value of the vts property.
     * 
     * @return
     *     possible object is
     *     {@link VTS }
     *     
     */
    public VTS getVTS() {
        return vts;
    }

    /**
     * Sets the value of the vts property.
     * 
     * @param value
     *     allowed object is
     *     {@link VTS }
     *     
     */
    public void setVTS(VTS value) {
        this.vts = value;
    }

    /**
     * Gets the value of the certificateChain property.
     * 
     * @return
     *     possible object is
     *     {@link CertificateChain }
     *     
     */
    public CertificateChain getCertificateChain() {
        return certificateChain;
    }

    /**
     * Sets the value of the certificateChain property.
     * 
     * @param value
     *     allowed object is
     *     {@link CertificateChain }
     *     
     */
    public void setCertificateChain(CertificateChain value) {
        this.certificateChain = value;
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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
