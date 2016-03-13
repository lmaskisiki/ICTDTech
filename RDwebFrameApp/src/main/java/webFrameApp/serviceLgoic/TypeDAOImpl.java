package webFrameApp.serviceLgoic;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webFrameApp.entites.SqldataTypes;
import webFrameApp.interfaces.TypesDAO;
import webFrameApp.repositories.SqlTypeRepo;

@Service
public class TypeDAOImpl  implements TypesDAO {
@Autowired 
private SqlTypeRepo Repository;

@Override
public SqldataTypes save(SqldataTypes type) {
	 
 Repository.save(type);
	return type;
}



@Override
public List<SqldataTypes> findAll() {
	// TODO Auto-generated method stub
	return Repository.findAll();
}

@Override
public SqldataTypes findByName(String name) {
	 List<SqldataTypes> tps=Repository.findAll();
	 SqldataTypes dtp=new SqldataTypes();
	 for(SqldataTypes tp: tps){
		 if(tp.getName().equals(name.trim())){
			 dtp=tp;
			 break;
		 }
	 }
	return dtp;
}



@Override
public int count() {
	// TODO Auto-generated method stub
	return 0;
}

	
}
