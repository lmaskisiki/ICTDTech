package infosource.health.ematclinic.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.camel.Consume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.inject.Injector;

import infosource.health.ematclinic.models.Checkup;

@Path("/checkup")
@Service
public class ClinicService implements IClinicService {
	
private EntityManager em;
public ClinicService() {
	em= Persistence.createEntityManagerFactory("BirthTech").createEntityManager();

}
	@Autowired
	private MaternityService matService;
	@Autowired
	private CheckupService checkService;
	@Autowired
	private LabourService labService;
	@Autowired
	private ChildService childService;

	/* CHECKUP OPERTION */
	/* (non-Javadoc)
	 * @see infosource.health.ematclinic.services.IClinicService#getCheckups()
	 */
	@Override
	@GET
	@Path("/getall")
	@Produces("application/json")
	public @ResponseBody List<Checkup> getCheckups() {
		List<Checkup> list = null;
		try {
			   Query query = em.createQuery("SELECT e FROM Checkup e");
			    list=(List<Checkup>) query.getResultList();
			    em.close();
		} catch (Exception e) {}
		return list;
	}
	/* (non-Javadoc)
	 * @see infosource.health.ematclinic.services.IClinicService#findById(java.lang.String)
	 */
	@Override
	@GET
	@Path("/find/{id}")
	@Produces("application/json")
	public @ResponseBody Checkup findById(@PathParam("id") String id) {
		Checkup checkup = null;
		try {
			int key = Integer.parseInt(id);
			checkup = checkService.getCheckupById(key);
		} catch (Exception e) {
		}
		return checkup;
	}
	/* (non-Javadoc)
	 * @see infosource.health.ematclinic.services.IClinicService#saveAsJson(infosource.health.ematclinic.models.Checkup)
	 */
	@Override
	@POST
	@Path("/save1")
	@Produces("application/json")
	@Consumes("application/json")
	public void saveAsJson(@RequestBody Checkup checkup) {
	}
	/* (non-Javadoc)
	 * @see infosource.health.ematclinic.services.IClinicService#saveAsObject(java.lang.String)
	 */
	@Override
	@POST
	@Path("/save")
	@Produces("application/json")
	@Consumes("application/json")
	public @ResponseBody Checkup saveAsObject(@RequestBody String jsonString) {
		Gson gson = new Gson();
		Checkup checkup = null;
		try {
			checkup = gson.fromJson(jsonString, Checkup.class);
		} catch (Exception e) {
		}
		return checkup;
		}

}
