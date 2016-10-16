package birthcertificate.ews.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

import bcmanager.system.SystemMessage;
import birthcertificate.entities.BCertificate;
import birthcertificate.entities.Labour;

@Service
@WebService(portName = "IBEServicePort", serviceName = "IBEService")
public interface IBEService {

	@WebMethod
	public List<CollectionStatus> applications();

	@WebMethod
	public CollectionStatus checkStatus(
			@WebParam(name = "parentId") int parentId);

	@WebMethod
	public SystemMessage createApplication(
			@WebParam(name = "labour") Labour labour);

	@WebMethod
	public List<BCertificate> approved();

	@WebMethod
	public SystemMessage BatchApplication(String jsonData);
}
