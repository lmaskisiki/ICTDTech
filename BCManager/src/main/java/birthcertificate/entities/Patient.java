package birthcertificate.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

 

 
@Entity
@XmlRootElement
public class Patient implements Serializable {  
 	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pid;
	private String names;
	private String surname;
	private int idnumber;
	private String employementStatus;
	private String nurse;
	private Date registration;
 
	private static final long serialVersionUID = 1L;

	public String getEmployementStatus() {
		return employementStatus;
	}

	public void setEmployementStatus(String employementStatus) {
		this.employementStatus = employementStatus;
	}


	public int getPid() {
		return pid;
		
	}

	public void setPid(int mid) {
		this.pid = mid;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(int idnumber) {
		this.idnumber = idnumber;
	}

	public String getNurse() {
		return nurse;
	}

	public void setNurse(String nurse) {
		this.nurse = nurse;
	}

	public Date getRegistration() {
		return registration;
	}

	public void setRegistration(Date registration) {
		this.registration = registration;
	}

 
   
}
