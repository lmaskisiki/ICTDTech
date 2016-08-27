
package birthcertificate.ews.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createApplication complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createApplication"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="labour" type="{http://soap.ews.birthcertificate/}labour" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createApplication", propOrder = {
    "labour"
})
public class CreateApplication {

    protected Labour labour;

    /**
     * Gets the value of the labour property.
     * 
     * @return
     *     possible object is
     *     {@link Labour }
     *     
     */
    public Labour getLabour() {
        return labour;
    }

    /**
     * Sets the value of the labour property.
     * 
     * @param value
     *     allowed object is
     *     {@link Labour }
     *     
     */
    public void setLabour(Labour value) {
        this.labour = value;
    }

}
