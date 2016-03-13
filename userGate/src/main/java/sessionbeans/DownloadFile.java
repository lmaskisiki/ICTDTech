
package sessionbeans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for downloadFile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="downloadFile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="remotePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="localDestionation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "downloadFile", propOrder = {
    "remotePath",
    "localDestionation"
})
public class DownloadFile {

    protected String remotePath;
    protected String localDestionation;

    /**
     * Gets the value of the remotePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemotePath() {
        return remotePath;
    }

    /**
     * Sets the value of the remotePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemotePath(String value) {
        this.remotePath = value;
    }

    /**
     * Gets the value of the localDestionation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalDestionation() {
        return localDestionation;
    }

    /**
     * Sets the value of the localDestionation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalDestionation(String value) {
        this.localDestionation = value;
    }

}
