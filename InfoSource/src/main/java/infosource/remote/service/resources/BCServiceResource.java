package infosource.remote.service.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;


@Path("/")
@Component
public class BCServiceResource {
	@GET
	@Path("/collectready")
	@Produces("application/xml")
	public String CollectReady(){
		return null;
	}
	
	@GET
	@Path("/certificate/parent/{id}")
	@Produces("application/xml")
	public Object getCertificateByParentId(@PathParam("id") String Id){
		return null;
	}


	@GET
	@Path("/certificates/all")
	@Produces("application/xml")
	public List<Object> getAllCertificates(){
		return null;
	}
}
