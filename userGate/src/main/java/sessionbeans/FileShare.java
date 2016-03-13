
package sessionbeans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fileShare complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fileShare">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="file" type="{http://sessionBeans/}fileInfo" minOccurs="0"/>
 *         &lt;element name="shareId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sharedWith" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fileShare", propOrder = {
    "file",
    "shareId",
    "sharedWith"
})
public class FileShare {

    protected FileInfo file;
    protected int shareId;
    protected String sharedWith;

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
     * Gets the value of the shareId property.
     * 
     */
    public int getShareId() {
        return shareId;
    }

    /**
     * Sets the value of the shareId property.
     * 
     */
    public void setShareId(int value) {
        this.shareId = value;
    }

    /**
     * Gets the value of the sharedWith property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSharedWith() {
        return sharedWith;
    }

    /**
     * Sets the value of the sharedWith property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSharedWith(String value) {
        this.sharedWith = value;
    }

}
