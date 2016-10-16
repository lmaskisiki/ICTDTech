package webFrameApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webFrameApp.entites.Domain;

@Repository
public interface DomainRepo extends JpaRepository<Domain, Integer> {

}
