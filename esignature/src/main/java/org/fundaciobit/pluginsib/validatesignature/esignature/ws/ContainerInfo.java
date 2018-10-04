
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContainerInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContainerInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ContainerType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZipComment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MimeTypeFilePresent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="MimeTypeContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ManifestFiles" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ManifestFile" type="{http://dss.esig.europa.eu/validation/diagnostic}ManifestFile" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ContentFiles" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ContentFile" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContainerInfo", namespace = "http://dss.esig.europa.eu/validation/diagnostic", propOrder = {
    "containerType",
    "zipComment",
    "mimeTypeFilePresent",
    "mimeTypeContent",
    "manifestFiles",
    "contentFiles"
})
public class ContainerInfo {

    @XmlElement(name = "ContainerType")
    protected String containerType;
    @XmlElement(name = "ZipComment")
    protected String zipComment;
    @XmlElement(name = "MimeTypeFilePresent")
    protected Boolean mimeTypeFilePresent;
    @XmlElement(name = "MimeTypeContent")
    protected String mimeTypeContent;
    @XmlElement(name = "ManifestFiles")
    protected ContainerInfo.ManifestFiles manifestFiles;
    @XmlElement(name = "ContentFiles")
    protected ContainerInfo.ContentFiles contentFiles;

    /**
     * Gets the value of the containerType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContainerType() {
        return containerType;
    }

    /**
     * Sets the value of the containerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContainerType(String value) {
        this.containerType = value;
    }

    /**
     * Gets the value of the zipComment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZipComment() {
        return zipComment;
    }

    /**
     * Sets the value of the zipComment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZipComment(String value) {
        this.zipComment = value;
    }

    /**
     * Gets the value of the mimeTypeFilePresent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMimeTypeFilePresent() {
        return mimeTypeFilePresent;
    }

    /**
     * Sets the value of the mimeTypeFilePresent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMimeTypeFilePresent(Boolean value) {
        this.mimeTypeFilePresent = value;
    }

    /**
     * Gets the value of the mimeTypeContent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMimeTypeContent() {
        return mimeTypeContent;
    }

    /**
     * Sets the value of the mimeTypeContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMimeTypeContent(String value) {
        this.mimeTypeContent = value;
    }

    /**
     * Gets the value of the manifestFiles property.
     * 
     * @return
     *     possible object is
     *     {@link ContainerInfo.ManifestFiles }
     *     
     */
    public ContainerInfo.ManifestFiles getManifestFiles() {
        return manifestFiles;
    }

    /**
     * Sets the value of the manifestFiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContainerInfo.ManifestFiles }
     *     
     */
    public void setManifestFiles(ContainerInfo.ManifestFiles value) {
        this.manifestFiles = value;
    }

    /**
     * Gets the value of the contentFiles property.
     * 
     * @return
     *     possible object is
     *     {@link ContainerInfo.ContentFiles }
     *     
     */
    public ContainerInfo.ContentFiles getContentFiles() {
        return contentFiles;
    }

    /**
     * Sets the value of the contentFiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContainerInfo.ContentFiles }
     *     
     */
    public void setContentFiles(ContainerInfo.ContentFiles value) {
        this.contentFiles = value;
    }


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
     *         &lt;element name="ContentFile" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "contentFile"
    })
    public static class ContentFiles {

        @XmlElement(name = "ContentFile", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<String> contentFile;

        /**
         * Gets the value of the contentFile property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contentFile property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContentFile().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getContentFile() {
            if (contentFile == null) {
                contentFile = new ArrayList<String>();
            }
            return this.contentFile;
        }

    }


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
     *         &lt;element name="ManifestFile" type="{http://dss.esig.europa.eu/validation/diagnostic}ManifestFile" maxOccurs="unbounded" minOccurs="0"/>
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
        "manifestFile"
    })
    public static class ManifestFiles {

        @XmlElement(name = "ManifestFile", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<ManifestFile> manifestFile;

        /**
         * Gets the value of the manifestFile property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the manifestFile property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getManifestFile().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ManifestFile }
         * 
         * 
         */
        public List<ManifestFile> getManifestFile() {
            if (manifestFile == null) {
                manifestFile = new ArrayList<ManifestFile>();
            }
            return this.manifestFile;
        }

    }

}
