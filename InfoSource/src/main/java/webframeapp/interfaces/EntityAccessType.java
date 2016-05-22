
package webframeapp.interfaces;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for entityAccessType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="entityAccessType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PUBLIC"/>
 *     &lt;enumeration value="PRIVATE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "entityAccessType")
@XmlEnum
public enum EntityAccessType {

    PUBLIC,
    PRIVATE;

    public String value() {
        return name();
    }

    public static EntityAccessType fromValue(String v) {
        return valueOf(v);
    }

}
