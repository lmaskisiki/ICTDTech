
package webframeapp.interfaces;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://interfaces.webFrameApp/}domain" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arg2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arg3" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="arg4" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="arg5" type="{http://interfaces.webFrameApp/}sqldataTypes" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="arg6" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="arg7" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="arg8" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="arg9" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateEntity", propOrder = {
    "arg0",
    "arg1",
    "arg2",
    "arg3",
    "arg4",
    "arg5",
    "arg6",
    "arg7",
    "arg8",
    "arg9"
})
public class CreateEntity {

    protected Domain arg0;
    protected String arg1;
    protected String arg2;
    protected List<String> arg3;
    protected List<String> arg4;
    protected List<SqldataTypes> arg5;
    @XmlElement(type = Integer.class)
    protected List<Integer> arg6;
    protected List<String> arg7;
    protected List<String> arg8;
    protected int arg9;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link Domain }
     *     
     */
    public Domain getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Domain }
     *     
     */
    public void setArg0(Domain value) {
        this.arg0 = value;
    }

    /**
     * Gets the value of the arg1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArg1(String value) {
        this.arg1 = value;
    }

    /**
     * Gets the value of the arg2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArg2() {
        return arg2;
    }

    /**
     * Sets the value of the arg2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArg2(String value) {
        this.arg2 = value;
    }

    /**
     * Gets the value of the arg3 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arg3 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArg3().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getArg3() {
        if (arg3 == null) {
            arg3 = new ArrayList<String>();
        }
        return this.arg3;
    }

    /**
     * Gets the value of the arg4 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arg4 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArg4().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getArg4() {
        if (arg4 == null) {
            arg4 = new ArrayList<String>();
        }
        return this.arg4;
    }

    /**
     * Gets the value of the arg5 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arg5 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArg5().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SqldataTypes }
     * 
     * 
     */
    public List<SqldataTypes> getArg5() {
        if (arg5 == null) {
            arg5 = new ArrayList<SqldataTypes>();
        }
        return this.arg5;
    }

    /**
     * Gets the value of the arg6 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arg6 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArg6().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getArg6() {
        if (arg6 == null) {
            arg6 = new ArrayList<Integer>();
        }
        return this.arg6;
    }

    /**
     * Gets the value of the arg7 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arg7 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArg7().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getArg7() {
        if (arg7 == null) {
            arg7 = new ArrayList<String>();
        }
        return this.arg7;
    }

    /**
     * Gets the value of the arg8 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arg8 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArg8().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getArg8() {
        if (arg8 == null) {
            arg8 = new ArrayList<String>();
        }
        return this.arg8;
    }

    /**
     * Gets the value of the arg9 property.
     * 
     */
    public int getArg9() {
        return arg9;
    }

    /**
     * Sets the value of the arg9 property.
     * 
     */
    public void setArg9(int value) {
        this.arg9 = value;
    }

}
