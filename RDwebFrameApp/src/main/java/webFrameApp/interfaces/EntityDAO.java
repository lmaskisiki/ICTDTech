package webFrameApp.interfaces;

import java.util.List;

import javax.jws.WebService;


import webFrameApp.entites.Domain;
import webFrameApp.entites.OrgEntity;
import webFrameApp.entites.SqldataTypes;

@WebService(name="IEntityService")
public interface EntityDAO {
	

	public void CreateEntity(Domain Domain,String ObjectName,String accessType,String [] attributes,String[] types,List<SqldataTypes> sqlDataTypes, int []  length,String [] other,String [] optionValues,int att_number);
	
	 
	public List<OrgEntity> findByName(String name);
	public List<OrgEntity> findAll();
	public List<OrgEntity> findByDomain(String Domain);
	public void relateEntities(OrgEntity addTo,OrgEntity addFrom,String column1, String column2, boolean existingField);
	public boolean newRelationship(String domain,String entity,String attribute,String refEntity, String refAttribute);
	public boolean delete(OrgEntity ent);
}
