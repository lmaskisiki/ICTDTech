package webFrameApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import webFrameApp.entites.SqldataTypes;

@Repository
public interface SqlTypeRepo   extends JpaRepository<SqldataTypes,Integer>{

}
