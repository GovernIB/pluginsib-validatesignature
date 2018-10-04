
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataToValidateDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataToValidateDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="originalDocument" type="{http://validation.dss.esig.europa.eu/}remoteDocument" minOccurs="0"/>
 *         &lt;element name="policy" type="{http://validation.dss.esig.europa.eu/}remoteDocument" minOccurs="0"/>
 *         &lt;element name="signedDocument" type="{http://validation.dss.esig.europa.eu/}remoteDocument" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataToValidateDTO", namespace = "http://validation.dss.esig.europa.eu/", propOrder = {
    "originalDocument",
    "policy",
    "signedDocument"
})
public class DataToValidateDTO {

    @XmlElement(namespace = "")
    protected RemoteDocument originalDocument;
    @XmlElement(namespace = "")
    protected RemoteDocument policy;
    @XmlElement(namespace = "")
    protected RemoteDocument signedDocument;

    /**
     * Gets the value of the originalDocument property.
     * 
     * @return
     *     possible object is
     *     {@link RemoteDocument }
     *     
     */
    public RemoteDocument getOriginalDocument() {
        return originalDocument;
    }

    /**
     * Sets the value of the originalDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemoteDocument }
     *     
     */
    public void setOriginalDocument(RemoteDocument value) {
        this.originalDocument = value;
    }

    /**
     * Gets the value of the policy property.
     * 
     * @return
     *     possible object is
     *     {@link RemoteDocument }
     *     
     */
    public RemoteDocument getPolicy() {
        return policy;
    }

    /**
     * Sets the value of the policy property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemoteDocument }
     *     
     */
    public void setPolicy(RemoteDocument value) {
        this.policy = value;
    }

    /**
     * Gets the value of the signedDocument property.
     * 
     * @return
     *     possible object is
     *     {@link RemoteDocument }
     *     
     */
    public RemoteDocument getSignedDocument() {
        return signedDocument;
    }

    /**
     * Sets the value of the signedDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemoteDocument }
     *     
     */
    public void setSignedDocument(RemoteDocument value) {
        this.signedDocument = value;
    }

}
