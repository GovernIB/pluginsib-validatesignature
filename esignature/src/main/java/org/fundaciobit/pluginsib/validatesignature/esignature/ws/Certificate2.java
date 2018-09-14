
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Certificate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Certificate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SubjectDistinguishedName" type="{http://dss.esig.europa.eu/validation/diagnostic}DistinguishedName" maxOccurs="unbounded"/>
 *         &lt;element name="IssuerDistinguishedName" type="{http://dss.esig.europa.eu/validation/diagnostic}DistinguishedName" maxOccurs="unbounded"/>
 *         &lt;element name="SerialNumber" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="CommonName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Locality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrganizationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GivenName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrganizationalUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Surname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Pseudonym" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuthorityInformationAccessUrls" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Url" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CRLDistributionPoints" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Url" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OCSPAccessUrls" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Url" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DigestAlgoAndValues" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DigestAlgoAndValue" type="{http://dss.esig.europa.eu/validation/diagnostic}DigestAlgoAndValue" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="NotAfter" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="NotBefore" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PublicKeySize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PublicKeyEncryptionAlgo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="KeyUsageBits" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="KeyUsage" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ExtendedKeyUsages" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="oid" type="{http://dss.esig.europa.eu/validation/diagnostic}OID" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="IdPkixOcspNoCheck" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="BasicSignature" type="{http://dss.esig.europa.eu/validation/diagnostic}BasicSignature"/>
 *         &lt;element name="SigningCertificate" type="{http://dss.esig.europa.eu/validation/diagnostic}SigningCertificate" minOccurs="0"/>
 *         &lt;element name="CertificateChain" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ChainItem" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Source" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Trusted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SelfSigned" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CertificatePolicies" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="certificatePolicy" type="{http://dss.esig.europa.eu/validation/diagnostic}CertificatePolicy" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="QCStatementIds" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="oid" type="{http://dss.esig.europa.eu/validation/diagnostic}OID" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="QCTypes" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="oid" type="{http://dss.esig.europa.eu/validation/diagnostic}OID" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TrustedServiceProviders">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TrustedServiceProvider" type="{http://dss.esig.europa.eu/validation/diagnostic}TrustedServiceProvider" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Revocations" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Revocation" type="{http://dss.esig.europa.eu/validation/diagnostic}Revocation" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Info" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Message" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Base64Encoded" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Certificate", namespace = "http://dss.esig.europa.eu/validation/diagnostic", propOrder = {
    "subjectDistinguishedName",
    "issuerDistinguishedName",
    "serialNumber",
    "commonName",
    "locality",
    "state",
    "countryName",
    "organizationName",
    "givenName",
    "organizationalUnit",
    "surname",
    "pseudonym",
    "email",
    "authorityInformationAccessUrls",
    "crlDistributionPoints",
    "ocspAccessUrls",
    "digestAlgoAndValues",
    "notAfter",
    "notBefore",
    "publicKeySize",
    "publicKeyEncryptionAlgo",
    "keyUsageBits",
    "extendedKeyUsages",
    "idPkixOcspNoCheck",
    "basicSignature",
    "signingCertificate",
    "certificateChain",
    "trusted",
    "selfSigned",
    "certificatePolicies",
    "qcStatementIds",
    "qcTypes",
    "trustedServiceProviders",
    "revocations",
    "info",
    "base64Encoded"
})
public class Certificate2 {

    @XmlElement(name = "SubjectDistinguishedName", required = true)
    protected List<DistinguishedName> subjectDistinguishedName;
    @XmlElement(name = "IssuerDistinguishedName", required = true)
    protected List<DistinguishedName> issuerDistinguishedName;
    @XmlElement(name = "SerialNumber", required = true)
    protected BigInteger serialNumber;
    @XmlElement(name = "CommonName")
    protected String commonName;
    @XmlElement(name = "Locality")
    protected String locality;
    @XmlElement(name = "State")
    protected String state;
    @XmlElement(name = "CountryName")
    protected String countryName;
    @XmlElement(name = "OrganizationName")
    protected String organizationName;
    @XmlElement(name = "GivenName")
    protected String givenName;
    @XmlElement(name = "OrganizationalUnit")
    protected String organizationalUnit;
    @XmlElement(name = "Surname")
    protected String surname;
    @XmlElement(name = "Pseudonym")
    protected String pseudonym;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "AuthorityInformationAccessUrls")
    protected Certificate2 .AuthorityInformationAccessUrls authorityInformationAccessUrls;
    @XmlElement(name = "CRLDistributionPoints")
    protected Certificate2 .CRLDistributionPoints crlDistributionPoints;
    @XmlElement(name = "OCSPAccessUrls")
    protected Certificate2 .OCSPAccessUrls ocspAccessUrls;
    @XmlElement(name = "DigestAlgoAndValues")
    protected Certificate2 .DigestAlgoAndValues digestAlgoAndValues;
    @XmlElement(name = "NotAfter", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar notAfter;
    @XmlElement(name = "NotBefore", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar notBefore;
    @XmlElement(name = "PublicKeySize")
    protected int publicKeySize;
    @XmlElement(name = "PublicKeyEncryptionAlgo", required = true)
    protected String publicKeyEncryptionAlgo;
    @XmlElement(name = "KeyUsageBits")
    protected Certificate2 .KeyUsageBits keyUsageBits;
    @XmlElement(name = "ExtendedKeyUsages")
    protected Certificate2 .ExtendedKeyUsages extendedKeyUsages;
    @XmlElement(name = "IdPkixOcspNoCheck")
    protected Boolean idPkixOcspNoCheck;
    @XmlElement(name = "BasicSignature", required = true)
    protected BasicSignature basicSignature;
    @XmlElement(name = "SigningCertificate")
    protected SigningCertificate signingCertificate;
    @XmlElement(name = "CertificateChain")
    protected Certificate2 .CertificateChain certificateChain;
    @XmlElement(name = "Trusted")
    protected boolean trusted;
    @XmlElement(name = "SelfSigned")
    protected boolean selfSigned;
    @XmlElement(name = "CertificatePolicies")
    protected Certificate2 .CertificatePolicies certificatePolicies;
    @XmlElement(name = "QCStatementIds")
    protected Certificate2 .QCStatementIds qcStatementIds;
    @XmlElement(name = "QCTypes")
    protected Certificate2 .QCTypes qcTypes;
    @XmlElement(name = "TrustedServiceProviders", required = true)
    protected Certificate2 .TrustedServiceProviders trustedServiceProviders;
    @XmlElement(name = "Revocations")
    protected Certificate2 .Revocations revocations;
    @XmlElement(name = "Info")
    protected Certificate2 .Info info;
    @XmlElement(name = "Base64Encoded")
    protected byte[] base64Encoded;
    @XmlAttribute(name = "Id", required = true)
    protected String id;

    /**
     * Gets the value of the subjectDistinguishedName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subjectDistinguishedName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubjectDistinguishedName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DistinguishedName }
     * 
     * 
     */
    public List<DistinguishedName> getSubjectDistinguishedName() {
        if (subjectDistinguishedName == null) {
            subjectDistinguishedName = new ArrayList<DistinguishedName>();
        }
        return this.subjectDistinguishedName;
    }

    /**
     * Gets the value of the issuerDistinguishedName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the issuerDistinguishedName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIssuerDistinguishedName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DistinguishedName }
     * 
     * 
     */
    public List<DistinguishedName> getIssuerDistinguishedName() {
        if (issuerDistinguishedName == null) {
            issuerDistinguishedName = new ArrayList<DistinguishedName>();
        }
        return this.issuerDistinguishedName;
    }

    /**
     * Gets the value of the serialNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the value of the serialNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSerialNumber(BigInteger value) {
        this.serialNumber = value;
    }

    /**
     * Gets the value of the commonName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommonName() {
        return commonName;
    }

    /**
     * Sets the value of the commonName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommonName(String value) {
        this.commonName = value;
    }

    /**
     * Gets the value of the locality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocality() {
        return locality;
    }

    /**
     * Sets the value of the locality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocality(String value) {
        this.locality = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the countryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Sets the value of the countryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryName(String value) {
        this.countryName = value;
    }

    /**
     * Gets the value of the organizationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * Sets the value of the organizationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationName(String value) {
        this.organizationName = value;
    }

    /**
     * Gets the value of the givenName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGivenName() {
        return givenName;
    }

    /**
     * Sets the value of the givenName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGivenName(String value) {
        this.givenName = value;
    }

    /**
     * Gets the value of the organizationalUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationalUnit() {
        return organizationalUnit;
    }

    /**
     * Sets the value of the organizationalUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationalUnit(String value) {
        this.organizationalUnit = value;
    }

    /**
     * Gets the value of the surname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the value of the surname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurname(String value) {
        this.surname = value;
    }

    /**
     * Gets the value of the pseudonym property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPseudonym() {
        return pseudonym;
    }

    /**
     * Sets the value of the pseudonym property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPseudonym(String value) {
        this.pseudonym = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the authorityInformationAccessUrls property.
     * 
     * @return
     *     possible object is
     *     {@link Certificate2 .AuthorityInformationAccessUrls }
     *     
     */
    public Certificate2 .AuthorityInformationAccessUrls getAuthorityInformationAccessUrls() {
        return authorityInformationAccessUrls;
    }

    /**
     * Sets the value of the authorityInformationAccessUrls property.
     * 
     * @param value
     *     allowed object is
     *     {@link Certificate2 .AuthorityInformationAccessUrls }
     *     
     */
    public void setAuthorityInformationAccessUrls(Certificate2 .AuthorityInformationAccessUrls value) {
        this.authorityInformationAccessUrls = value;
    }

    /**
     * Gets the value of the crlDistributionPoints property.
     * 
     * @return
     *     possible object is
     *     {@link Certificate2 .CRLDistributionPoints }
     *     
     */
    public Certificate2 .CRLDistributionPoints getCRLDistributionPoints() {
        return crlDistributionPoints;
    }

    /**
     * Sets the value of the crlDistributionPoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link Certificate2 .CRLDistributionPoints }
     *     
     */
    public void setCRLDistributionPoints(Certificate2 .CRLDistributionPoints value) {
        this.crlDistributionPoints = value;
    }

    /**
     * Gets the value of the ocspAccessUrls property.
     * 
     * @return
     *     possible object is
     *     {@link Certificate2 .OCSPAccessUrls }
     *     
     */
    public Certificate2 .OCSPAccessUrls getOCSPAccessUrls() {
        return ocspAccessUrls;
    }

    /**
     * Sets the value of the ocspAccessUrls property.
     * 
     * @param value
     *     allowed object is
     *     {@link Certificate2 .OCSPAccessUrls }
     *     
     */
    public void setOCSPAccessUrls(Certificate2 .OCSPAccessUrls value) {
        this.ocspAccessUrls = value;
    }

    /**
     * Gets the value of the digestAlgoAndValues property.
     * 
     * @return
     *     possible object is
     *     {@link Certificate2 .DigestAlgoAndValues }
     *     
     */
    public Certificate2 .DigestAlgoAndValues getDigestAlgoAndValues() {
        return digestAlgoAndValues;
    }

    /**
     * Sets the value of the digestAlgoAndValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link Certificate2 .DigestAlgoAndValues }
     *     
     */
    public void setDigestAlgoAndValues(Certificate2 .DigestAlgoAndValues value) {
        this.digestAlgoAndValues = value;
    }

    /**
     * Gets the value of the notAfter property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNotAfter() {
        return notAfter;
    }

    /**
     * Sets the value of the notAfter property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNotAfter(XMLGregorianCalendar value) {
        this.notAfter = value;
    }

    /**
     * Gets the value of the notBefore property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNotBefore() {
        return notBefore;
    }

    /**
     * Sets the value of the notBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNotBefore(XMLGregorianCalendar value) {
        this.notBefore = value;
    }

    /**
     * Gets the value of the publicKeySize property.
     * 
     */
    public int getPublicKeySize() {
        return publicKeySize;
    }

    /**
     * Sets the value of the publicKeySize property.
     * 
     */
    public void setPublicKeySize(int value) {
        this.publicKeySize = value;
    }

    /**
     * Gets the value of the publicKeyEncryptionAlgo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicKeyEncryptionAlgo() {
        return publicKeyEncryptionAlgo;
    }

    /**
     * Sets the value of the publicKeyEncryptionAlgo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicKeyEncryptionAlgo(String value) {
        this.publicKeyEncryptionAlgo = value;
    }

    /**
     * Gets the value of the keyUsageBits property.
     * 
     * @return
     *     possible object is
     *     {@link Certificate2 .KeyUsageBits }
     *     
     */
    public Certificate2 .KeyUsageBits getKeyUsageBits() {
        return keyUsageBits;
    }

    /**
     * Sets the value of the keyUsageBits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Certificate2 .KeyUsageBits }
     *     
     */
    public void setKeyUsageBits(Certificate2 .KeyUsageBits value) {
        this.keyUsageBits = value;
    }

    /**
     * Gets the value of the extendedKeyUsages property.
     * 
     * @return
     *     possible object is
     *     {@link Certificate2 .ExtendedKeyUsages }
     *     
     */
    public Certificate2 .ExtendedKeyUsages getExtendedKeyUsages() {
        return extendedKeyUsages;
    }

    /**
     * Sets the value of the extendedKeyUsages property.
     * 
     * @param value
     *     allowed object is
     *     {@link Certificate2 .ExtendedKeyUsages }
     *     
     */
    public void setExtendedKeyUsages(Certificate2 .ExtendedKeyUsages value) {
        this.extendedKeyUsages = value;
    }

    /**
     * Gets the value of the idPkixOcspNoCheck property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIdPkixOcspNoCheck() {
        return idPkixOcspNoCheck;
    }

    /**
     * Sets the value of the idPkixOcspNoCheck property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIdPkixOcspNoCheck(Boolean value) {
        this.idPkixOcspNoCheck = value;
    }

    /**
     * Gets the value of the basicSignature property.
     * 
     * @return
     *     possible object is
     *     {@link BasicSignature }
     *     
     */
    public BasicSignature getBasicSignature() {
        return basicSignature;
    }

    /**
     * Sets the value of the basicSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link BasicSignature }
     *     
     */
    public void setBasicSignature(BasicSignature value) {
        this.basicSignature = value;
    }

    /**
     * Gets the value of the signingCertificate property.
     * 
     * @return
     *     possible object is
     *     {@link SigningCertificate }
     *     
     */
    public SigningCertificate getSigningCertificate() {
        return signingCertificate;
    }

    /**
     * Sets the value of the signingCertificate property.
     * 
     * @param value
     *     allowed object is
     *     {@link SigningCertificate }
     *     
     */
    public void setSigningCertificate(SigningCertificate value) {
        this.signingCertificate = value;
    }

    /**
     * Gets the value of the certificateChain property.
     * 
     * @return
     *     possible object is
     *     {@link Certificate2 .CertificateChain }
     *     
     */
    public Certificate2 .CertificateChain getCertificateChain() {
        return certificateChain;
    }

    /**
     * Sets the value of the certificateChain property.
     * 
     * @param value
     *     allowed object is
     *     {@link Certificate2 .CertificateChain }
     *     
     */
    public void setCertificateChain(Certificate2 .CertificateChain value) {
        this.certificateChain = value;
    }

    /**
     * Gets the value of the trusted property.
     * 
     */
    public boolean isTrusted() {
        return trusted;
    }

    /**
     * Sets the value of the trusted property.
     * 
     */
    public void setTrusted(boolean value) {
        this.trusted = value;
    }

    /**
     * Gets the value of the selfSigned property.
     * 
     */
    public boolean isSelfSigned() {
        return selfSigned;
    }

    /**
     * Sets the value of the selfSigned property.
     * 
     */
    public void setSelfSigned(boolean value) {
        this.selfSigned = value;
    }

    /**
     * Gets the value of the certificatePolicies property.
     * 
     * @return
     *     possible object is
     *     {@link Certificate2 .CertificatePolicies }
     *     
     */
    public Certificate2 .CertificatePolicies getCertificatePolicies() {
        return certificatePolicies;
    }

    /**
     * Sets the value of the certificatePolicies property.
     * 
     * @param value
     *     allowed object is
     *     {@link Certificate2 .CertificatePolicies }
     *     
     */
    public void setCertificatePolicies(Certificate2 .CertificatePolicies value) {
        this.certificatePolicies = value;
    }

    /**
     * Gets the value of the qcStatementIds property.
     * 
     * @return
     *     possible object is
     *     {@link Certificate2 .QCStatementIds }
     *     
     */
    public Certificate2 .QCStatementIds getQCStatementIds() {
        return qcStatementIds;
    }

    /**
     * Sets the value of the qcStatementIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link Certificate2 .QCStatementIds }
     *     
     */
    public void setQCStatementIds(Certificate2 .QCStatementIds value) {
        this.qcStatementIds = value;
    }

    /**
     * Gets the value of the qcTypes property.
     * 
     * @return
     *     possible object is
     *     {@link Certificate2 .QCTypes }
     *     
     */
    public Certificate2 .QCTypes getQCTypes() {
        return qcTypes;
    }

    /**
     * Sets the value of the qcTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Certificate2 .QCTypes }
     *     
     */
    public void setQCTypes(Certificate2 .QCTypes value) {
        this.qcTypes = value;
    }

    /**
     * Gets the value of the trustedServiceProviders property.
     * 
     * @return
     *     possible object is
     *     {@link Certificate2 .TrustedServiceProviders }
     *     
     */
    public Certificate2 .TrustedServiceProviders getTrustedServiceProviders() {
        return trustedServiceProviders;
    }

    /**
     * Sets the value of the trustedServiceProviders property.
     * 
     * @param value
     *     allowed object is
     *     {@link Certificate2 .TrustedServiceProviders }
     *     
     */
    public void setTrustedServiceProviders(Certificate2 .TrustedServiceProviders value) {
        this.trustedServiceProviders = value;
    }

    /**
     * Gets the value of the revocations property.
     * 
     * @return
     *     possible object is
     *     {@link Certificate2 .Revocations }
     *     
     */
    public Certificate2 .Revocations getRevocations() {
        return revocations;
    }

    /**
     * Sets the value of the revocations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Certificate2 .Revocations }
     *     
     */
    public void setRevocations(Certificate2 .Revocations value) {
        this.revocations = value;
    }

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link Certificate2 .Info }
     *     
     */
    public Certificate2 .Info getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link Certificate2 .Info }
     *     
     */
    public void setInfo(Certificate2 .Info value) {
        this.info = value;
    }

    /**
     * Gets the value of the base64Encoded property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getBase64Encoded() {
        return base64Encoded;
    }

    /**
     * Sets the value of the base64Encoded property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setBase64Encoded(byte[] value) {
        this.base64Encoded = ((byte[]) value);
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Url" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "url"
    })
    public static class AuthorityInformationAccessUrls {

        @XmlElement(name = "Url", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<String> url;

        /**
         * Gets the value of the url property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the url property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUrl().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getUrl() {
            if (url == null) {
                url = new ArrayList<String>();
            }
            return this.url;
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
     *         &lt;element name="Url" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "url"
    })
    public static class CRLDistributionPoints {

        @XmlElement(name = "Url", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<String> url;

        /**
         * Gets the value of the url property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the url property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUrl().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getUrl() {
            if (url == null) {
                url = new ArrayList<String>();
            }
            return this.url;
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
     *         &lt;element name="ChainItem" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Source" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    @XmlType(name = "", propOrder = {
        "chainItem"
    })
    public static class CertificateChain {

        @XmlElement(name = "ChainItem", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<Certificate2 .CertificateChain.ChainItem> chainItem;

        /**
         * Gets the value of the chainItem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the chainItem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getChainItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Certificate2 .CertificateChain.ChainItem }
         * 
         * 
         */
        public List<Certificate2 .CertificateChain.ChainItem> getChainItem() {
            if (chainItem == null) {
                chainItem = new ArrayList<Certificate2 .CertificateChain.ChainItem>();
            }
            return this.chainItem;
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
         *         &lt;element name="Source" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "source"
        })
        public static class ChainItem {

            @XmlElement(name = "Source", namespace = "http://dss.esig.europa.eu/validation/diagnostic", required = true)
            protected String source;
            @XmlAttribute(name = "Id", required = true)
            protected String id;

            /**
             * Gets the value of the source property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSource() {
                return source;
            }

            /**
             * Sets the value of the source property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSource(String value) {
                this.source = value;
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
     *         &lt;element name="certificatePolicy" type="{http://dss.esig.europa.eu/validation/diagnostic}CertificatePolicy" maxOccurs="unbounded" minOccurs="0"/>
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
        "certificatePolicy"
    })
    public static class CertificatePolicies {

        @XmlElement(namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<CertificatePolicy> certificatePolicy;

        /**
         * Gets the value of the certificatePolicy property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the certificatePolicy property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCertificatePolicy().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CertificatePolicy }
         * 
         * 
         */
        public List<CertificatePolicy> getCertificatePolicy() {
            if (certificatePolicy == null) {
                certificatePolicy = new ArrayList<CertificatePolicy>();
            }
            return this.certificatePolicy;
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
     *         &lt;element name="DigestAlgoAndValue" type="{http://dss.esig.europa.eu/validation/diagnostic}DigestAlgoAndValue" maxOccurs="unbounded" minOccurs="0"/>
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
        "digestAlgoAndValue"
    })
    public static class DigestAlgoAndValues {

        @XmlElement(name = "DigestAlgoAndValue", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<DigestAlgoAndValue> digestAlgoAndValue;

        /**
         * Gets the value of the digestAlgoAndValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the digestAlgoAndValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDigestAlgoAndValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DigestAlgoAndValue }
         * 
         * 
         */
        public List<DigestAlgoAndValue> getDigestAlgoAndValue() {
            if (digestAlgoAndValue == null) {
                digestAlgoAndValue = new ArrayList<DigestAlgoAndValue>();
            }
            return this.digestAlgoAndValue;
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
     *         &lt;element name="oid" type="{http://dss.esig.europa.eu/validation/diagnostic}OID" maxOccurs="unbounded" minOccurs="0"/>
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
        "oid"
    })
    public static class ExtendedKeyUsages {

        @XmlElement(namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<OID> oid;

        /**
         * Gets the value of the oid property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the oid property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOid().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OID }
         * 
         * 
         */
        public List<OID> getOid() {
            if (oid == null) {
                oid = new ArrayList<OID>();
            }
            return this.oid;
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
     *         &lt;element name="Message" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
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
    @XmlType(name = "", propOrder = {
        "message"
    })
    public static class Info {

        @XmlElement(name = "Message", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<Certificate2 .Info.Message> message;

        /**
         * Gets the value of the message property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the message property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMessage().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Certificate2 .Info.Message }
         * 
         * 
         */
        public List<Certificate2 .Info.Message> getMessage() {
            if (message == null) {
                message = new ArrayList<Certificate2 .Info.Message>();
            }
            return this.message;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="Id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Message {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "Id", required = true)
            protected int id;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the id property.
             * 
             */
            public int getId() {
                return id;
            }

            /**
             * Sets the value of the id property.
             * 
             */
            public void setId(int value) {
                this.id = value;
            }

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
     *         &lt;element name="KeyUsage" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "keyUsage"
    })
    public static class KeyUsageBits {

        @XmlElement(name = "KeyUsage", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<String> keyUsage;

        /**
         * Gets the value of the keyUsage property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the keyUsage property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getKeyUsage().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getKeyUsage() {
            if (keyUsage == null) {
                keyUsage = new ArrayList<String>();
            }
            return this.keyUsage;
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
     *         &lt;element name="Url" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "url"
    })
    public static class OCSPAccessUrls {

        @XmlElement(name = "Url", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<String> url;

        /**
         * Gets the value of the url property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the url property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUrl().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getUrl() {
            if (url == null) {
                url = new ArrayList<String>();
            }
            return this.url;
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
     *         &lt;element name="oid" type="{http://dss.esig.europa.eu/validation/diagnostic}OID" maxOccurs="unbounded" minOccurs="0"/>
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
        "oid"
    })
    public static class QCStatementIds {

        @XmlElement(namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<OID> oid;

        /**
         * Gets the value of the oid property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the oid property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOid().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OID }
         * 
         * 
         */
        public List<OID> getOid() {
            if (oid == null) {
                oid = new ArrayList<OID>();
            }
            return this.oid;
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
     *         &lt;element name="oid" type="{http://dss.esig.europa.eu/validation/diagnostic}OID" maxOccurs="unbounded" minOccurs="0"/>
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
        "oid"
    })
    public static class QCTypes {

        @XmlElement(namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<OID> oid;

        /**
         * Gets the value of the oid property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the oid property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOid().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OID }
         * 
         * 
         */
        public List<OID> getOid() {
            if (oid == null) {
                oid = new ArrayList<OID>();
            }
            return this.oid;
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
     *         &lt;element name="Revocation" type="{http://dss.esig.europa.eu/validation/diagnostic}Revocation" maxOccurs="unbounded" minOccurs="0"/>
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
        "revocation"
    })
    public static class Revocations {

        @XmlElement(name = "Revocation", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<Revocation> revocation;

        /**
         * Gets the value of the revocation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the revocation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRevocation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Revocation }
         * 
         * 
         */
        public List<Revocation> getRevocation() {
            if (revocation == null) {
                revocation = new ArrayList<Revocation>();
            }
            return this.revocation;
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
     *         &lt;element name="TrustedServiceProvider" type="{http://dss.esig.europa.eu/validation/diagnostic}TrustedServiceProvider" maxOccurs="unbounded" minOccurs="0"/>
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
        "trustedServiceProvider"
    })
    public static class TrustedServiceProviders {

        @XmlElement(name = "TrustedServiceProvider", namespace = "http://dss.esig.europa.eu/validation/diagnostic")
        protected List<TrustedServiceProvider> trustedServiceProvider;

        /**
         * Gets the value of the trustedServiceProvider property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the trustedServiceProvider property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTrustedServiceProvider().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TrustedServiceProvider }
         * 
         * 
         */
        public List<TrustedServiceProvider> getTrustedServiceProvider() {
            if (trustedServiceProvider == null) {
                trustedServiceProvider = new ArrayList<TrustedServiceProvider>();
            }
            return this.trustedServiceProvider;
        }

    }

}
