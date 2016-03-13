package webFrame.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webFrameApp.entites.Domain;
import webFrameApp.entites.FeedPost;
import webFrameApp.enumerations.DomainCategory;
import webFrameApp.serviceLgoic.DomainDAOImpl;
import webFrameApp.serviceLgoic.FeedPostImpl;

@Controller
public class FeedPostController {
	@Autowired
	private DomainDAOImpl domainImp;
	@Autowired
	private FeedPostImpl feedService;
	@RequestMapping(value = "web/newpostrequest", method = RequestMethod.GET)
	public ModelAndView createPostRequest(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("newfeed");
		String user = SecurityContextHolder.getContext().getAuthentication()
				.getName();
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String roles = auth.getAuthorities().toString();
		List categories = new ArrayList();
		categories.add("GENERAL");
		for (DomainCategory c : DomainCategory.values()) {
			categories.add(c);
		}
		List<Domain> domains = new ArrayList<Domain>();
		if (auth != null) {
			Domain d = new Domain();
			d.setDomainName("NONE");
			domains.add(d);

			if (user != null && roles.contains("ROLE_Master")) {
				domains.addAll(domainImp.getAllDomains());
				model.addObject("domains", domains);
			} else {
				domains.addAll(domainImp.findByCreator(user));
				model.addObject("domains", domains);
			}

		}

		model.addObject("categories", categories);
		model.addObject("user", user);
		model.addObject("domains", domains);

		return model;
	}

	// web/savepost
	@RequestMapping(value = "web/savepost", method = RequestMethod.GET)
	public ModelAndView savepost(HttpServletRequest request,
			HttpServletResponse response) {

		String category = request.getParameter("category");
		String domain = request.getParameter("domain");
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		String author = request.getParameter("author");

		FeedPost feed = new FeedPost();
		feed.setAuthor(author);
		feed.setTitle(title);
		feed.setBody(body);
		feed.setCategory(category);
		feed.setDomain(domain);
		feed.setPostDate(new Date());
		feedService.createPost(feed);

		return null;

	}

}
