
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for XCV complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="XCV">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dss.esig.europa.eu/validation/detailed-report}ConstraintsConclusion">
 *       &lt;sequence>
 *         &lt;element name="SubXCV" type="{http://dss.esig.europa.eu/validation/detailed-report}SubXCV" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XCV", propOrder = {
    "subXCV"
})
public class XCV
    extends ConstraintsConclusion
{

    @XmlElement(name = "SubXCV")
    protected List<SubXCV> subXCV;

    /**
     * Gets the value of the subXCV property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subXCV property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubXCV().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubXCV }
     * 
     * 
     */
    public List<SubXCV> getSubXCV() {
        if (subXCV == null) {
            subXCV = new ArrayList<SubXCV>();
        }
        return this.subXCV;
    }

}
