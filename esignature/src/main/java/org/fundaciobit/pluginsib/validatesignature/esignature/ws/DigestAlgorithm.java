
package org.fundaciobit.pluginsib.validatesignature.esignature.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for digestAlgorithm.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="digestAlgorithm">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SHA1"/>
 *     &lt;enumeration value="SHA224"/>
 *     &lt;enumeration value="SHA256"/>
 *     &lt;enumeration value="SHA384"/>
 *     &lt;enumeration value="SHA512"/>
 *     &lt;enumeration value="SHA3_224"/>
 *     &lt;enumeration value="SHA3_256"/>
 *     &lt;enumeration value="SHA3_384"/>
 *     &lt;enumeration value="SHA3_512"/>
 *     &lt;enumeration value="RIPEMD160"/>
 *     &lt;enumeration value="MD2"/>
 *     &lt;enumeration value="MD5"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "digestAlgorithm", namespace = "http://validation.dss.esig.europa.eu/")
@XmlEnum
public enum DigestAlgorithm {

    @XmlEnumValue("SHA1")
    SHA_1("SHA1"),
    @XmlEnumValue("SHA224")
    SHA_224("SHA224"),
    @XmlEnumValue("SHA256")
    SHA_256("SHA256"),
    @XmlEnumValue("SHA384")
    SHA_384("SHA384"),
    @XmlEnumValue("SHA512")
    SHA_512("SHA512"),
    @XmlEnumValue("SHA3_224")
    SHA_3_224("SHA3_224"),
    @XmlEnumValue("SHA3_256")
    SHA_3_256("SHA3_256"),
    @XmlEnumValue("SHA3_384")
    SHA_3_384("SHA3_384"),
    @XmlEnumValue("SHA3_512")
    SHA_3_512("SHA3_512"),
    @XmlEnumValue("RIPEMD160")
    RIPEMD_160("RIPEMD160"),
    @XmlEnumValue("MD2")
    MD_2("MD2"),
    @XmlEnumValue("MD5")
    MD_5("MD5");
    private final String value;

    DigestAlgorithm(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DigestAlgorithm fromValue(String v) {
        for (DigestAlgorithm c: DigestAlgorithm.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
