package webFrameApp.mvcControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import webFrameApp.entites.Domain;
import webFrameApp.serviceLgoic.DomainDAOImpl;
import webFrameApp.serviceLgoic.EntityDAOImpl;
import webFrameApp.serviceLgoic.TypeDAOImpl;

@Controller
public class OpenDataAccessController {
	@Autowired
	private DomainDAOImpl domainService;
	@Autowired
	private EntityDAOImpl entityService;

	@Autowired
	private TypeDAOImpl typeIMPL;
	
	@RequestMapping("public")
	public ModelAndView showDomain(){
		ModelAndView model = new ModelAndView("showdomain");
		List<Domain> domains=domainService.getAllDomains();
		return model;
	}
}
