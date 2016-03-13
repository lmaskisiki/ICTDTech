
package sessionbeans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for shareFile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="shareFile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fileInfo" type="{http://sessionBeans/}fileInfo" minOccurs="0"/>
 *         &lt;element name="shareWith" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shareFile", propOrder = {
    "fileInfo",
    "shareWith"
})
public class ShareFile {

    protected FileInfo fileInfo;
    protected String shareWith;

    /**
     * Gets the value of the fileInfo property.
     * 
     * @return
     *     possible object is
     *     {@link FileInfo }
     *     
     */
    public FileInfo getFileInfo() {
        return fileInfo;
    }

    /**
     * Sets the value of the fileInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileInfo }
     *     
     */
    public void setFileInfo(FileInfo value) {
        this.fileInfo = value;
    }

    /**
     * Gets the value of the shareWith property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShareWith() {
        return shareWith;
    }

    /**
     * Sets the value of the shareWith property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShareWith(String value) {
        this.shareWith = value;
    }

}
