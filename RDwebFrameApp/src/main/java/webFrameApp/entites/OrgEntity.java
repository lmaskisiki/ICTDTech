package webFrameApp.entites;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import webFrameApp.enumerations.EntityAccessType;

/**
 * Entity implementation class for Entity: OrgEntity
 *
 */
@Entity 
@XmlAccessorType(XmlAccessType.FIELD)
public class OrgEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7076896084950967950L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer eid;
	@Column(unique=true)
	private String name;
	private String domain;
	private String[] attributes;
	private String[] types;
	private String[] other;
	private String[] optionValues;
	public String[] getOptionValues() {
		return optionValues;
	}
	public void setOptionValues(String[] optionValues) {
		this.optionValues = optionValues;
	}
	private int att_number;
	private EntityAccessType accessType;
	
	public EntityAccessType getAccessType() {
		return accessType;
	}
	public void setAccessType(EntityAccessType accessType) {
		this.accessType = accessType;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	 
	}
	public String[] getAttributes() {
		return attributes;
	}
	public void setAttributes(String[] attributes) {
		this.attributes = attributes;
	}
	public String[] getTypes() {
		return types;
	}
	public void setTypes(String[] types) {
		this.types = types;
	}
	public String[] getOther() {
		return other;
	}
	public void setOther(String[] other) {
		this.other = other;
	}
	public int getAtt_number() {
		return att_number;
	}
	public void setAtt_number(int att_number) {
		this.att_number = att_number;
	}
	 
	
 

}
