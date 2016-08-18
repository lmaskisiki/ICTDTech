package birthcertificate.ews.soap;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CollectionStatus  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int parentId;
	private boolean status;
	private int bcNumber;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getBcNumber() {
		return bcNumber;
	}
	public void setBcNumber(int bcNumber) {
		this.bcNumber = bcNumber;
	}
	
	
}
