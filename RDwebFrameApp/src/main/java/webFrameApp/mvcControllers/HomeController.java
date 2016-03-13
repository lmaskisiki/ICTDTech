package webFrameApp.mvcControllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import webFrameApp.entites.Domain;
import webFrameApp.entites.FeedPost;
import webFrameApp.enumerations.DomainCategory;
import webFrameApp.enumerations.ListEnumerations;
import webFrameApp.serviceLgoic.DomainDAOImpl;
import webFrameApp.serviceLgoic.FeedPostImpl;

@Controller
public class HomeController {
	@Autowired
	private DomainDAOImpl domainImp;
	@Autowired
	 private FeedPostImpl service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homepage(HttpServletRequest request) {
		ModelAndView model= new ModelAndView("welcome");;
		// categories
		List<DomainCategory> domainCategories = new ArrayList<DomainCategory>();
		 List<FeedPost> feeds=service.listPosts();
		for (DomainCategory c : DomainCategory.values()) {
			domainCategories.add(c);
		}
		model.addObject("categories",domainCategories);
		model.addObject("feeds",feeds);
		

		return model;
	}

	@RequestMapping(value = "username", method = RequestMethod.GET)
	public ModelAndView flagstaff(final HttpServletRequest request,
			Principal principal) {
		ModelAndView model = new ModelAndView("flagstaff");

		// model.addObject("userName",
		// request.getUserPrincipal().getName().toString());
		return model;

	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView home() {

		List<Domain> d = domainImp.getAllDomains();
		System.out.println("the size of domain list is:" + d.size());
		return new ModelAndView("home");

	}

	@RequestMapping(value = "getAllDomains", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<Domain> getAllDomainst(
			HttpServletRequest request, HttpServletResponse response) {

		return domainImp.getAllDomains();

	}

	@RequestMapping(value = "createdomain", method = RequestMethod.GET)
	public ModelAndView createDomain(HttpServletRequest request,
			HttpServletResponse response) {
		String domainCreator = request.getParameter("domainCreator");
		String domainName = request.getParameter("domainName");
		String domainOrg = request.getParameter("domainOrg");
		String contact = request.getParameter("contact");
		String category = request.getParameter("category");
		String description = request.getParameter("description");

		domainImp.createDomain(domainCreator, domainName, category, domainOrg,
				contact, description);

		return new ModelAndView("home");

	}
}
