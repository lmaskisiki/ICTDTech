package webFrame.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
import webFrameApp.entites.SqldataTypes;
import webFrameApp.serviceLgoic.DomainDAOImpl;
import webFrameApp.serviceLgoic.EntityDAOImpl;
import webFrameApp.serviceLgoic.TypeDAOImpl;


@Controller
public class dataTypeController {

	@Autowired
	private DomainDAOImpl domainImp;
	@Autowired
	private EntityDAOImpl entityIMPL;
	
	@Autowired
	private TypeDAOImpl typeIMPL;
	
	
	@RequestMapping(value = "addDataType", method = RequestMethod.POST)
	public ModelAndView addDataType(HttpServletRequest request) {

		ModelAndView model = new ModelAndView("newDataType");
		return model;
	}

	@RequestMapping(value = "addDataType", method = RequestMethod.GET)
	public ModelAndView addDataType_process(
			@ModelAttribute("addDataType_process") ModelMap modelmp,
			SqldataTypes types, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("newDataType");
		modelmp.addAttribute("name", types.getName());
		modelmp.addAttribute("type", types.getType());
		modelmp.addAttribute("defaultSize", types.getDefaultSize());
	typeIMPL.save(types);
		return model;

	}
}
