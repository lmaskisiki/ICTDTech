package birthcertificate.ws.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import sun.print.resources.serviceui;
import birthcertificate.entities.BCertificate;
import birthcertificate.services.BCService;

@Component
@Path("/")
public class BCRestService extends SpringBeanAutowiringSupport implements
		IBCRestService {
	@Autowired
	private BCService bcService;

	@GET
	@Path("/collectready")
	@Produces("application/xml")
	@Override
	public List<BCertificate> getCollectReady() {
		List<BCertificate> allCertificates = bcService.getCollectReady();
		
		return allCertificates;
	}

	@GET
	@Path("/certificate/id/{id}")
	@Produces("application/json")
	public BCertificate byName(@PathParam("id") String Id) {

		return bcService.getCertificateById(Id);

	}

	@GET
	@Path("/certificates/all")
	@Produces("application/json")
	@Override
	public List<BCertificate> getAllCertificates() {
		List<BCertificate> collectReady = bcService.getAll();
		return collectReady;
	}
	@GET
	@Path("/certificate/parent/{id}")
	@Produces("application/xml")
	@Override
	public BCertificate getCertificateByParentId(@PathParam("id") String Id) {
		BCertificate certificate = bcService.getCertificateByParentId(Id);
		return certificate;
	}


	@GET
	@Path("/test")
 public String CollectReady() {
		List<BCertificate> allCertificates =  bcService.getAll();
		
		return "<message>Success!! from the service:</message>";
	}
}
