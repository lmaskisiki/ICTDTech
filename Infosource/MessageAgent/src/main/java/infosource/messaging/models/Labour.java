package infosource.messaging.models;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Labour implements Serializable {

	private int labourId;
	private Date labourDate;
	private int birthNo;
	private String nurse;
	private int labourStatus;
	private String birthPlace;
	private Patient patient;
	private Child child;

	public Labour() {
		super();
	}

	public int getLabourId() {
		return labourId;
	}

	public void setLabourId(int labourId) {
		this.labourId = labourId;
	}

	public Patient getMaternal() {
		return patient;
	}

	public void setMaternal(Patient patient) {
		this.patient = patient;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public int getLabourStatus() {
		return labourStatus;
	}

	public void setLabourStatus(int labourStatus) {
		this.labourStatus = labourStatus;
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
