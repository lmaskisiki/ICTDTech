package birthcertificate.ws.rest;

import java.util.List;

import org.springframework.stereotype.Component;

import birthcertificate.entities.BCertificate;

@Component
public interface IBCRestService {

	public List<BCertificate> getCollectReady();

	public List<BCertificate> getAllCertificates();


	public BCertificate getCertificateByParentId(String Id);
	 
 
	
}
