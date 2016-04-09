package birthtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import birthtech.entities.Checkup;
 

public interface CheckupRepository extends JpaRepository<Checkup,Integer> {

}
