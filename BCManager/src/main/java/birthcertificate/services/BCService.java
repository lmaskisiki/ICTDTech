package birthcertificate.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import birthcertificate.entities.BCertificate;
import birthcertificate.repositories.BCRepository;

@Service
public class BCService {

	@Autowired
	private BCRepository repo;

	public int createCerticate(int bcNumber, Date creationDate,
			String birthNumber, String childNames, String surname,
			String gender, String maternalId) {

		BCertificate certificate = new BCertificate();
		certificate.setBcNumber(bcNumber);
		certificate.setCreationDate(creationDate);
		certificate.setBirthNumber(birthNumber);
		certificate.setChildNames(childNames);
		certificate.setSurname(surname);
		certificate.setGender(gender);
		certificate.setMaternalId(maternalId);
		repo.save(certificate);
		return 0;
	}

	public List<BCertificate> getAll() {

		return repo.findAll();
	}

	public List<BCertificate> getCollectReady() {
		List<BCertificate> collectReady = new ArrayList<BCertificate>();
		for (BCertificate bc : repo.findAll()) {
			if (bc.isCollectReady()) {
				collectReady.add(bc);
			}
		}
		return collectReady;
	}

	public BCertificate getCertificateById(String Id) {
		BCertificate certifice = repo.findOne(Integer.parseInt(Id));
		return certifice;
		// TODO Auto-generated method stub

	}

	public BCertificate getCertificateByParentId(String idNumber) {
		for (BCertificate bc : repo.findAll()) {
			if (bc.getMaternalId().equals(idNumber)) {
				return bc;
			}
		}
		return null;
	}

}