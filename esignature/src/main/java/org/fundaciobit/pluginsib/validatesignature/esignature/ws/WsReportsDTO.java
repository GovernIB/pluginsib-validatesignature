
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsReportsDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsReportsDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://dss.esig.europa.eu/validation/diagnostic}diagnosticData" minOccurs="0"/>
 *         &lt;element ref="{http://dss.esig.europa.eu/validation/simple-report}simpleReport" minOccurs="0"/>
 *         &lt;element ref="{http://dss.esig.europa.eu/validation/detailed-report}detailedReport" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsReportsDTO", namespace = "http://validation.dss.esig.europa.eu/", propOrder = {
    "diagnosticData",
    "simpleReport",
    "detailedReport"
})
public class WsReportsDTO {

    @XmlElement(namespace = "http://dss.esig.europa.eu/validation/diagnostic")
    protected DiagnosticData diagnosticData;
    @XmlElement(namespace = "http://dss.esig.europa.eu/validation/simple-report")
    protected SimpleReport simpleReport;
    @XmlElement(namespace = "http://dss.esig.europa.eu/validation/detailed-report")
    protected DetailedReport2 detailedReport;

    /**
     * Gets the value of the diagnosticData property.
     * 
     * @return
     *     possible object is
     *     {@link DiagnosticData }
     *     
     */
    public DiagnosticData getDiagnosticData() {
        return diagnosticData;
    }

    /**
     * Sets the value of the diagnosticData property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiagnosticData }
     *     
     */
    public void setDiagnosticData(DiagnosticData value) {
        this.diagnosticData = value;
    }

    /**
     * Gets the value of the simpleReport property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleReport }
     *     
     */
    public SimpleReport getSimpleReport() {
        return simpleReport;
    }

    /**
     * Sets the value of the simpleReport property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleReport }
     *     
     */
    public void setSimpleReport(SimpleReport value) {
        this.simpleReport = value;
    }

    /**
     * Gets the value of the detailedReport property.
     * 
     * @return
     *     possible object is
     *     {@link DetailedReport2 }
     *     
     */
    public DetailedReport2 getDetailedReport() {
        return detailedReport;
    }

    /**
     * Sets the value of the detailedReport property.
     * 
     * @param value
     *     allowed object is
     *     {@link DetailedReport2 }
     *     
     */
    public void setDetailedReport(DetailedReport2 value) {
        this.detailedReport = value;
    }

}
