package birthcertificate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import birthcertificate.entities.BCertificate;

@Component
public interface BCRepository extends JpaRepository<BCertificate,Integer> {
	@Modifying
	@Query("UPDATE BCertificate bc SET bc.collectReady=?1 WHERE bc.parentFullNames=?2")
	int updateCollectionStatus(boolean status, String parent);
	
	@Modifying
	@Query("UPDATE BCertificate bc SET bc.collectReady=?1 WHERE bc.bcNumber=?2")
	int updateCollectionStatus(boolean status, int certificateNo);
}
