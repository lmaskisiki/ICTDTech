package webFrame.ws.integration;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import usergate.classes.Person;

@XmlRootElement
public class PersonWrapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Person profile;
	private String[] document;
	

	public PersonWrapper() {

	}

	public PersonWrapper(Person psn, String[] files) {
		this.profile = psn;
		this.document = files;
	}

	public Person getP() {
		return profile;
	}

	public void setP(Person p) {
		this.profile = p;
	}

	public String[] getFiles() {
		return document;
	}

	public void setFiles(String[] files) {
		this.document = files;
	}

}
