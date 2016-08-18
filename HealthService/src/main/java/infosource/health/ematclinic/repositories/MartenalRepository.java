package infosource.health.ematclinic.repositories;

import infosource.health.ematclinic.models.Maternity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 

@Repository
public interface MartenalRepository  extends JpaRepository<Maternity,Integer>{

}
