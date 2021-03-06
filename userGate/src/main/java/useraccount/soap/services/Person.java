package useraccount.soap.services;

import java.io.Serializable;

import javax.naming.directory.Attributes;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person implements Serializable {
	private String first_name;
	private String last_name;
	private String idNumber;
	private String gender;
	private String cell;
	private String email;
	private String username;
	private String password;
	private String orgUnit;
	private String dn;
	private String member;

	private static final long serialVersionUID = 1L;

	public String getIdNumber() {
		return idNumber;
	}

	@XmlElement
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getOrgUnit() {
		return orgUnit;
	}

	public String getMember() {
		return member;
	}

	@XmlElement
	public void setMember(String member) {
		this.member = member;
	}

	public String getDn() {
		return dn;
	}

	@XmlElement
	public void setDn(String dn) {
		this.dn = dn;
	}

	@XmlElement
	public void setOrgUnit(String orgUnit) {
		this.orgUnit = orgUnit;
	}

	@XmlElement
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	@XmlElement
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCell() {
		return cell;
	}

	@XmlElement
	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getEmail() {
		return email;
	}

	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	@XmlElement
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	@XmlElement
	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	@XmlElement
	public void setGender(String gender) {
		this.gender = gender;
	}

}
