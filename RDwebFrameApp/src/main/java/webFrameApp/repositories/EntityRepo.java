package webFrameApp.repositories;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import webFrameApp.entites.Domain;
import webFrameApp.entites.OrgEntity;

@Repository
public interface EntityRepo extends  JpaRepository<OrgEntity,Integer>{
	 
 
}
