package webFrameApp.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Entity implementation class for Entity: Domain
 *
 */
 
 @Entity
 @XmlAccessorType(XmlAccessType.FIELD)
public class Domain  implements Serializable{
 	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer domainId;
 	private String domainName;
    private String orgName;
    private String contactDetails;
    private String creator;
    private String category;
    public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	private String description;
	public Integer getDomainId() {
		return domainId;
	}
	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
 	
    
 	
}