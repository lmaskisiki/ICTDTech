package birthtech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import birthtech.entities.Child;
 

public interface ChildRepository extends JpaRepository<Child,Integer>{

}
