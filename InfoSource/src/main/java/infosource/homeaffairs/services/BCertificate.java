package infosource.homeaffairs.services;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BCertificate {

	int bcNumber;
	Date creationDate;
	String birthNumber;
	String childNames;
	String surname;
	String gender;
	String maternalId;
	boolean collectReady;

	public boolean isCollectReady() {
		return collectReady;
	}

	public void setCollectReady(boolean collectReady) {
		this.collectReady = collectReady;
	}

	public int getBcNumber() {
		return bcNumber;
	}

	public void setBcNumber(int bcNumber) {
		this.bcNumber = bcNumber;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getBirthNumber() {
		return birthNumber;
	}

	public void setBirthNumber(String birthNumber) {
		this.birthNumber = birthNumber;
	}

	public String getChildNames() {
		return childNames;
	}

	public void setChildNames(String childNames) {
		this.childNames = childNames;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaternalId() {
		return maternalId;
	}

	public void setMaternalId(String maternalId) {
		this.maternalId = maternalId;
	}

}
