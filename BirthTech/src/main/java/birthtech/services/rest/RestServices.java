package birthtech.services.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import birthtech.entities.Checkup;
import birthtech.entities.Labour;
import birthtech.entities.Patient;
import birthtech.services.CheckupService;
import birthtech.services.ChildService;
import birthtech.services.LabourService;
import birthtech.services.PatientService;

@RestController
public class RestServices {
	@Autowired
	private PatientService martenalService;

	@Autowired
	private CheckupService checkupService;
	

	@Autowired
	private LabourService labourService;

	@Autowired
	private ChildService childService;

	/* Checkup Services */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public List<Patient> serviceTest(@PathVariable String name) {
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
	public List<Patient> getMartenal(){
		return martenalService.getMartenal();
		
	}
	/* Labour Services*/
	@RequestMapping(value="/labour", method=RequestMethod.GET)
	public List<Labour> getLabour(){
		return labourService.getLabour();
		
	}
	/* Child Services*/
}
