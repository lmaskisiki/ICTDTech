package birthtech.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Labour
 *
 */
@Entity
@XmlRootElement
public class Labour implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int labourId;
	
	 
	@ManyToOne
	private Maternity martenal;
	private Date labourDate;
	private int birthNo;
	private String nurse;
	private int labourStatus;
	private String birthPlace;
	
	public Labour() {
		super();
	}

 	public int getLabourId() {
		return labourId;
	}
 
	public void setLabourId(int labourId) {
		this.labourId = labourId;
	}



	public Maternity getMartenal() {
		return martenal;
	}

	public void setMartenal(Maternity martenal) {
		this.martenal = martenal;
	}

	public Date getLabourDate() {
		return labourDate;
	}

	public void setLabourDate(Date labourDate) {
		this.labourDate = labourDate;
	}

	public int getBirthNo() {
		return birthNo;
	}

	public void setBirthNo(int birthNo) {
		this.birthNo = birthNo;
	}

	public String getNurse() {
		return nurse;
	}

	public void setNurse(String nurse) {
		this.nurse = nurse;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public int getStatus() {
		return labourStatus;
	}

	public void setStatus(int status) {
		this.labourStatus = status;
	}
	
   
}
