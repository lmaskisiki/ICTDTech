package bcmanager.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import birthcertificate.entities.BCertificate;
import birthcertificate.services.BCService;


@Controller
public class HomeController {

		@Autowired
		private  BCService service;
	
@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView home(){
			ModelAndView model= new ModelAndView("getall");
			List<BCertificate> list =null;
			list=service.getAll();
			model.addObject("results", list);
			return model;
	}
	
}