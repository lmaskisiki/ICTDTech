package birthtech.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import birthtech.entities.Checkup;
import birthtech.entities.Maternity;
import birthtech.services.CheckupService;
import birthtech.services.MartenalService;

@Controller
public class HomeController {
	@Autowired
	private MartenalService matService;
	@Autowired
	private CheckupService checkService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homepage() {
		return new ModelAndView("home");
	}
	//CRUD starts
	@RequestMapping(value = "/martenal/getall", method = RequestMethod.GET)
	public ModelAndView findAll() {
		ModelAndView model = new ModelAndView("getallmartenals");
		List<Maternity> getAll = matService.getMartenal();
		model.addObject("results", getAll);
		return model;
	}

	@RequestMapping(value = "/martenal/new", method = RequestMethod.GET)
	public ModelAndView newmartenal() {
		return new ModelAndView("newmartenalform");
	}

	@RequestMapping(value = "/martenal/create", method = RequestMethod.GET)
	public ModelAndView newrecord(ModelMap modelmap,
			HttpServletRequest request, Maternity mat) {
		ModelAndView model = new ModelAndView("viewmaternal");
		modelmap.addAttribute(mat.getNames(), "names");
		modelmap.addAttribute(mat.getNurse(), "nurse");
		modelmap.addAttribute(mat.getSurname(), "surname");
		modelmap.addAttribute(mat.getIdnumber());
		int idNumber = Integer.parseInt(request.getParameter("idNumber"));
		Date date = new Date();
		mat.setIdnumber(idNumber);
		mat.setRegistration(date);
		boolean saved = matService.addMaternity(mat);
		model.addObject("maternal", mat);
		return model;
	}
	@RequestMapping(value = "/martenal/view/{idnumber}", method = RequestMethod.GET)
	public ModelAndView viewmaternal(@RequestParam(value = "idnumber", required = false) String idnumber) {
		ModelAndView model =new ModelAndView("viewmaternal");
		Maternity mat=null;
		mat=matService.getMaternityById(Integer.parseInt(idnumber));
		model.addObject("maternal",mat);
		return model;
	}
	@RequestMapping(value = "/martenal/edit/{idnumber}", method = RequestMethod.GET)
	public ModelAndView editmaternal(@PathVariable(value = "idnumber") String idnumber) {
		ModelAndView model =new ModelAndView("editmaternalform");
		Maternity mat=null; 
		mat=matService.getMaternityById(40);
		System.out.println("\n"+mat.getNames()+" "+mat.getSurname()+" with ID "+mat.getIdnumber()+" is being edited");
		 model.addObject("maternal",mat);
		return model;
	}
	
	@RequestMapping(value="/maternal/search", method=RequestMethod.GET)
	public ModelAndView search(){
		
		return new ModelAndView("current");
	}
	@RequestMapping(value = "/maternal/current", method = RequestMethod.GET)
	public ModelAndView current(HttpServletRequest request) {
		ModelAndView model =new ModelAndView("viewcurrent");
		String idnumber= request.getParameter("idnumber");
		int intId=Integer.parseInt(idnumber);
		Maternity mat=null; 
		mat=matService.getMaternityById(intId);
 		List<Checkup> check= checkService.getCheckups(intId);
		model.addObject("maternal",mat);
		model.addObject("checkup", check);
		return model;
	}
	
	//CRUD ends
	@RequestMapping(value="/checkup/add", method=RequestMethod.GET)
	public ModelAndView addCheckup(ModelMap map, Checkup checkup,HttpServletRequest request){
				
		map.addAttribute("martenalId",checkup.getMartenalId ());
		map.addAttribute("nurse",checkup.getNurse());
		map.addAttribute("place",checkup.getPlace());
		map.addAttribute("comments",checkup.getComments());
		checkup.setDelivered(false);
		checkService.addCheckup(checkup);
		return new ModelAndView("current");
	}
}
