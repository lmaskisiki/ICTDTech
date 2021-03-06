package bcmanager.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.bcel.internal.generic.NEW;

import docman.services.FileInfo;
import bcmanager.string.processor.StringProccessor;
import birthcertificate.entities.BCertificate;
import birthcertificate.processors.Person;
import birthcertificate.services.BCService;

@Controller
public class HomeController {

	@Autowired
	private BCService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("home");
		List<BCertificate> list = null;
		list = service.getAll();
		// model.addObject("results", list);
		return model;

	}

	@RequestMapping(value = "bc/applications/all", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<BCertificate> getll(HttpServletRequest request) {
		List<BCertificate> certificates = new ArrayList<BCertificate>();
		try {
			String parent = request.getParameter("parent");
			if (parent  == null || parent.trim().equals("")) {
				certificates = service.getAll();

			} else {
				for (BCertificate cert : service.getAll()) {
					if (cert.getParentFullNames().contains(parent)) {
						 
						certificates.add(cert);
					}
				}
			}

		} catch (Exception e) {

			System.out.println("Something went wrong \n" + e.getClass());
		}
		  return certificates;

	}

	@RequestMapping(value = "/maternal/search", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody useraccount.soap.services.Person getMaternal(
			HttpServletRequest request) {
		String fullname = request.getParameter("fullname");
		useraccount.soap.services.Person person = service.findParent(fullname);
		System.out.println("\n \n \n yea  \n \n" + person.getDn());
		return person;

	}

	@RequestMapping(value = "application/parent/profile", method = RequestMethod.GET)
	public ModelAndView profile(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("profile");
		List<FileInfo> docs = null;
		String fullname = request.getParameter("fullname");
		useraccount.soap.services.Person person = service.findParent(fullname);
		try {
			docs = service.getUserDocument("admin", person.getUsername());
		} catch (Exception e) {
			System.out.println("error occured while loading documents");
		}
		System.out.println("\n documents size: " + docs.size());
		model.addObject("person", person);
		model.addObject("documents", docs);
		return model;

	}

	@RequestMapping(value = "application/parent/documents", method = RequestMethod.GET)
	public @ResponseBody List<FileInfo> getDocument() {
		List<FileInfo> docs = null;
		try {
			docs = service.getUserDocument("admin", "admin");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return docs;
	}

	@RequestMapping(value = "application/approve/", method = RequestMethod.POST)
	public @ResponseBody String approveBCApplication(@RequestBody String parent) {
		String response = "bad request";
		try {
			if (parent != null) {
				String fullname = StringProccessor.toTitleCase(parent, " ");
				service.updateCollectionStatus(true, fullname.trim());
				response = "success";
			}
		} catch (Exception e) {
			System.out
					.println("Something went went wrong, could not perform update");
			System.out.println(e.getMessage());
		}
		return response;
	}
}
