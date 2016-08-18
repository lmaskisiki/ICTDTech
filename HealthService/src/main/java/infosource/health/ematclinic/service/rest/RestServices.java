package infosource.health.ematclinic.service.rest;

import infosource.health.ematclinic.models.Checkup;
import infosource.health.ematclinic.models.Labour;
import infosource.health.ematclinic.models.Maternity;
import infosource.health.ematclinic.service.CheckupService;
import infosource.health.ematclinic.service.ChildService;
import infosource.health.ematclinic.service.LabourService;
import infosource.health.ematclinic.service.MaternityService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestServices {
	@Autowired
	private MaternityService martenalService;

	@Autowired
	private CheckupService checkupService;
	

	@Autowired
	private LabourService labourService;

	@Autowired
	private ChildService childService;

	/* Checkup Services */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public List<Maternity> serviceTest(@PathVariable String name) {
		return martenalService.getMartenal();
	}

	@RequestMapping(value = "/checkupbyfullname/{fullname}", method = RequestMethod.GET)
	public Checkup getCheckup(@PathVariable String fullname) {
		return checkupService.getCheckup(fullname);
	}

	@RequestMapping(value = "/checkupbyid/{checkupid}", method = RequestMethod.GET)
	public Checkup getCheckup(@PathVariable int checkupid) {
		String id = "" + checkupid;
		if (checkupid == Integer.parseInt(id)) {
			return checkupService.getCheckupById(checkupid);
		} else
			return null;
	}

	@RequestMapping(value = "/checkups", method = RequestMethod.GET)
	public List<Checkup> getCheckups() {
		return checkupService.getCheckups();

	}
	/* Maternal Services*/
 	
	@RequestMapping(value="/martenal", method=RequestMethod.GET)
	public List<Maternity> getMartenal(){
		return martenalService.getMartenal();
		
	}
	/* Labour Services*/
	@RequestMapping(value="/labour", method=RequestMethod.GET)
	public List<Labour> getLabour(){
		return labourService.getLabour();
		
	}
	/* Child Services*/
}
