package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: FileRequest
 *
 */
@Entity
public class FileRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int requestId;
	private String reqFrom;
	private String reqTo;
	
	@JoinColumn(name="file",nullable = true)
	@ManyToOne(cascade=CascadeType.MERGE)
	private FileInfo file;
	
	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	
	public String getReqFrom() {
		return reqFrom;
	}

	public void setReqFrom(String reqFrom) {
		this.reqFrom = reqFrom;
	}

	public String getReqTo() {
		return reqTo;
	}

	public void setReqTo(String reqTo) {
		this.reqTo = reqTo;
	}

	public FileInfo getFile() {
		return file;
	}

	public void setFile(FileInfo file) {
		this.file = file;
	}

	public FileRequest() {
		super();
	}
   
}
