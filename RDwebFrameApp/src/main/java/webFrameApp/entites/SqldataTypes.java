package webFrameApp.entites;
 

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Entity implementation class for Entity: dataTypes
 *
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class SqldataTypes implements Serializable {
   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer typeId;
	
	@Column(unique=true,nullable=false)
	private String name;
	private Integer defaultSize;
	private String type;
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDefaultSize() {
		return defaultSize;
	}
	public void setDefaultSize(Integer defaultSize) {
		this.defaultSize = defaultSize;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	 

}
