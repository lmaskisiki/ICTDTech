package birthtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import birthtech.entities.Patient;
 

@Repository
public interface MartenalRepository  extends JpaRepository<Patient,Integer>{

}
