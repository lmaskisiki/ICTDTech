package birthcertificate.services;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import docman.services.FileInfo;
import birthcertificate.cxf.clients.DocManClient;
import birthcertificate.cxf.clients.UAServiceClient;
import birthcertificate.entities.BCertificate;
import birthcertificate.entities.Labour;
import birthcertificate.processors.Person;
import birthcertificate.repositories.BCRepository;
import birthcertificate.routebuilders.UniversalMarshaller;

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
		// repo.save(certificate);
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

	public void createCerticate(Labour labour) {

		BCertificate certificate = new BCertificate();
		certificate.setBcNumber(1222);
		System.out.println("\n \n all most done in service 1");

		certificate.setBirthNumber("" + labour.getBirthNo());
		certificate.setChildNames(labour.getChild().getName());
		certificate.setSurname(labour.getChild().getSurname());
		certificate.setGender(labour.getChild().getGender());
		certificate.setParentFullNames(labour.getMaternal().getSurname() + " "
				+ labour.getMaternal().getNames());
		System.out.println("\n \n almost done in service");

		certificate.setMaternalId("" + labour.getMaternal().getMid());
		certificate.setCollectReady(false);
		certificate.setCreationDate(new Date());
		repo.save(certificate);

	}

	public useraccount.soap.services.Person findParent(String fullName) {
		UAServiceClient client = new UAServiceClient();
		useraccount.soap.services.Person person = client
				.findPersonByFullName(fullName);
		return person;
	}

	public List<FileInfo> getUserDocument(String requester, String docOwner) {
		DocManClient client = new DocManClient();
		return client.getDocument(requester, docOwner);
	}
	@Transactional
public int updateCollectionStatus(boolean status, String parent){
		return repo.updateCollectionStatus(status, parent);
	
}
@Transactional
public int updateCollectionStatus(boolean status,  int certificateNo){
	return repo.updateCollectionStatus(status, certificateNo);

}
}
