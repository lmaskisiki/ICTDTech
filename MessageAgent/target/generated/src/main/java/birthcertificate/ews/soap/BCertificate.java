
package birthcertificate.ews.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for bCertificate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bCertificate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bcNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="birthNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="childNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="collectReady" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="creationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="gender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="maternalId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="parentFullNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="surname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bCertificate", propOrder = {
    "bcNumber",
    "birthNumber",
    "childNames",
    "collectReady",
    "creationDate",
    "gender",
    "maternalId",
    "parentFullNames",
    "surname"
})
public class BCertificate {

    protected int bcNumber;
    protected String birthNumber;
    protected String childNames;
    protected boolean collectReady;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationDate;
    protected String gender;
    protected String maternalId;
    protected String parentFullNames;
    protected String surname;

    /**
     * Gets the value of the bcNumber property.
     * 
     */
    public int getBcNumber() {
        return bcNumber;
    }

    /**
     * Sets the value of the bcNumber property.
     * 
     */
    public void setBcNumber(int value) {
        this.bcNumber = value;
    }

    /**
     * Gets the value of the birthNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthNumber() {
        return birthNumber;
    }

    /**
     * Sets the value of the birthNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthNumber(String value) {
        this.birthNumber = value;
    }

    /**
     * Gets the value of the childNames property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChildNames() {
        return childNames;
    }

    /**
     * Sets the value of the childNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChildNames(String value) {
        this.childNames = value;
    }

    /**
     * Gets the value of the collectReady property.
     * 
     */
    public boolean isCollectReady() {
        return collectReady;
    }

    /**
     * Sets the value of the collectReady property.
     * 
     */
    public void setCollectReady(boolean value) {
        this.collectReady = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
    }

    /**
     * Gets the value of the maternalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaternalId() {
        return maternalId;
    }

    /**
     * Sets the value of the maternalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaternalId(String value) {
        this.maternalId = value;
    }

    /**
     * Gets the value of the parentFullNames property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentFullNames() {
        return parentFullNames;
    }

    /**
     * Sets the value of the parentFullNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentFullNames(String value) {
        this.parentFullNames = value;
    }

    /**
     * Gets the value of the surname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the value of the surname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurname(String value) {
        this.surname = value;
    }

}
