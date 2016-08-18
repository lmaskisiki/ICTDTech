package infosource.messaging.rest;

import infosource.messaging.models.Checkup;
import infosource.messaging.models.Child;
import infosource.messaging.models.Labour;
import infosource.messaging.models.Patient;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Path("/")
@Service
public interface WClinicService {
	
	@GET
	@Path("/checkup/list/{patientid}")
	@Consumes("application/json")
	@Produces("application/json")
	public  List<Checkup> checkuplist(@PathParam("patientid") String patientId);
	
	@GET
	@Path("/patient/children/{patientid}")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Child> children(@PathParam("patientid") String patientId);
	
	@GET
	@Path("/patients")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Patient> patients();

	@GET
	@Path("/labour/list/{day}")
	@Consumes("application/json")
	@Produces("application/json")
	public @ResponseBody List<Labour> labourevent(@PathParam("day")String day);
}
