
package birthcertificate.ews.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for labour complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="labour"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="birthNo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="birthPlace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="child" type="{http://soap.ews.birthcertificate/}child" minOccurs="0"/&gt;
 *         &lt;element name="labourDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="labourId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="labourStatus" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="maternal" type="{http://soap.ews.birthcertificate/}maternity" minOccurs="0"/&gt;
 *         &lt;element name="nurse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "labour", propOrder = {
    "birthNo",
    "birthPlace",
    "child",
    "labourDate",
    "labourId",
    "labourStatus",
    "maternal",
    "nurse",
    "status"
})
public class Labour {

    protected int birthNo;
    protected String birthPlace;
    protected Child child;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar labourDate;
    protected int labourId;
    protected int labourStatus;
    protected Maternity maternal;
    protected String nurse;
    protected int status;

    /**
     * Gets the value of the birthNo property.
     * 
     */
    public int getBirthNo() {
        return birthNo;
    }

    /**
     * Sets the value of the birthNo property.
     * 
     */
    public void setBirthNo(int value) {
        this.birthNo = value;
    }

    /**
     * Gets the value of the birthPlace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthPlace() {
        return birthPlace;
    }

    /**
     * Sets the value of the birthPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthPlace(String value) {
        this.birthPlace = value;
    }

    /**
     * Gets the value of the child property.
     * 
     * @return
     *     possible object is
     *     {@link Child }
     *     
     */
    public Child getChild() {
        return child;
    }

    /**
     * Sets the value of the child property.
     * 
     * @param value
     *     allowed object is
     *     {@link Child }
     *     
     */
    public void setChild(Child value) {
        this.child = value;
    }

    /**
     * Gets the value of the labourDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLabourDate() {
        return labourDate;
    }

    /**
     * Sets the value of the labourDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLabourDate(XMLGregorianCalendar value) {
        this.labourDate = value;
    }

    /**
     * Gets the value of the labourId property.
     * 
     */
    public int getLabourId() {
        return labourId;
    }

    /**
     * Sets the value of the labourId property.
     * 
     */
    public void setLabourId(int value) {
        this.labourId = value;
    }

    /**
     * Gets the value of the labourStatus property.
     * 
     */
    public int getLabourStatus() {
        return labourStatus;
    }

    /**
     * Sets the value of the labourStatus property.
     * 
     */
    public void setLabourStatus(int value) {
        this.labourStatus = value;
    }

    /**
     * Gets the value of the maternal property.
     * 
     * @return
     *     possible object is
     *     {@link Maternity }
     *     
     */
    public Maternity getMaternal() {
        return maternal;
    }

    /**
     * Sets the value of the maternal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Maternity }
     *     
     */
    public void setMaternal(Maternity value) {
        this.maternal = value;
    }

    /**
     * Gets the value of the nurse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNurse() {
        return nurse;
    }

    /**
     * Sets the value of the nurse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNurse(String value) {
        this.nurse = value;
    }

    /**
     * Gets the value of the status property.
     * 
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     */
    public void setStatus(int value) {
        this.status = value;
    }

}
