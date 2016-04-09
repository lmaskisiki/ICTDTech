package birthtech.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Checkup
 *
 */
@Entity
public class Checkup implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int checkupId;
	private int martenalId;
	private String comments;
	private String nurse;
	private String place;
	private boolean delivered;
	
	
	private static final long serialVersionUID = 1L;

	public Checkup() {
		super();
	}

	public int getCheckupId() {
		return checkupId;
	}

	public void setCheckupId(int checkupId) {
		this.checkupId = checkupId;
	}

	public int getMartenalId() {
		return martenalId;
	}

	public void setMartenalId(int martenalId) {
		this.martenalId = martenalId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getNurse() {
		return nurse;
	}

	public void setNurse(String nurse) {
		this.nurse = nurse;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}   
 
   
}
