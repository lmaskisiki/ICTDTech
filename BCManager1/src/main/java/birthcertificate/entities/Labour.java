package birthcertificate.entities;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Labour
 *
 */
 @XmlRootElement
public class Labour {
 
	private int labourId;
	private Martenal martenal;
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



	public Martenal getMartenal() {
		return martenal;
	}

	public void setMartenal(Martenal martenal) {
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
