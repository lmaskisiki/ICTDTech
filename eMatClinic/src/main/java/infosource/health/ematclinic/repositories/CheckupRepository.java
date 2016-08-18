package infosource.health.ematclinic.repositories;

import infosource.health.ematclinic.models.Checkup;

import org.springframework.data.jpa.repository.JpaRepository;
 

public interface CheckupRepository extends JpaRepository<Checkup,Integer> {

}
