package webFrameApp.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import webFrameApp.entites.SqldataTypes;

public interface TypesDAO {
 
	public SqldataTypes save(SqldataTypes type);
	public int count();
	public List<SqldataTypes> findAll( );
	public  SqldataTypes  findByName(String name );
	
}
