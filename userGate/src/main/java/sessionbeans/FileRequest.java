
package sessionbeans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fileRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fileRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="file" type="{http://sessionBeans/}fileInfo" minOccurs="0"/>
 *         &lt;element name="reqFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reqTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fileRequest", propOrder = {
    "file",
    "reqFrom",
    "reqTo",
    "requestId"
})
public class FileRequest {

    protected FileInfo file;
    protected String reqFrom;
    protected String reqTo;
    protected int requestId;

    /**
     * Gets the value of the file property.
     * 
     * @return
     *     possible object is
     *     {@link FileInfo }
     *     
     */
    public FileInfo getFile() {
        return file;
    }

    /**
     * Sets the value of the file property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileInfo }
     *     
     */
    public void setFile(FileInfo value) {
        this.file = value;
    }

    /**
     * Gets the value of the reqFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqFrom() {
        return reqFrom;
    }

    /**
     * Sets the value of the reqFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqFrom(String value) {
        this.reqFrom = value;
    }

    /**
     * Gets the value of the reqTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqTo() {
        return reqTo;
    }

    /**
     * Sets the value of the reqTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqTo(String value) {
        this.reqTo = value;
    }

    /**
     * Gets the value of the requestId property.
     * 
     */
    public int getRequestId() {
        return requestId;
    }

    /**
     * Sets the value of the requestId property.
     * 
     */
    public void setRequestId(int value) {
        this.requestId = value;
    }

}
