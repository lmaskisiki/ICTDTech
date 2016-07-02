package infosource.web.controllers;

import javax.servlet.http.HttpServletRequest;

import infosource.models.UserUpdateModel;
import infosource.open.services.access.TransactionManager;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import useraccount.soap.services.Person;

@Controller
@RestController
public class homeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		TransactionManager transactionService = new TransactionManager();
		String value = transactionService.getNews();
		ModelAndView mol = new ModelAndView("index");
		mol.addObject("value", value);
		return mol;
	}

	@RequestMapping(value = "account/create", method = RequestMethod.GET)
	public ModelAndView createAccountRequest() {

		return new ModelAndView("accountform");
	}

	@RequestMapping(value = "account/process", method = RequestMethod.GET)
	public void processAccountRequest(
			@ModelAttribute("accountform") Person person, Model model) {

		model.addAttribute("firstname", person.getFirstName());
		model.addAttribute("lastname", person.getLastName());
		model.addAttribute("username", person.getUsername());
		model.addAttribute("idNumber", person.getIdNumber());
		model.addAttribute("cell", person.getCell());
		model.addAttribute("password", person.getPassword());
		System.out.println("recieved!!");
	}

	@RequestMapping(value = "feeds", method = RequestMethod.GET, produces = "application/json")
	public String showFeeds() {
		TransactionManager transactionService = new TransactionManager();
		return transactionService.getNews();
	}

	@RequestMapping(value = "account/profile", method = RequestMethod.GET, produces = "application/json")
	public String getuserprofile() {
		String user = "bukhanye";
		TransactionManager transactionService = new TransactionManager();
		return transactionService.fullProfile(user);
	}

	@RequestMapping(value = "account/update", method = RequestMethod.POST)
	public @ResponseBody String processUserUpdates(
			@RequestBody UserUpdateModel model, HttpServletRequest request) {
		String response = "failure";
		if (model != null) {
			if (!model.getAttribute().equals(null)
					|| !model.getUsername().equals(null)
					|| !model.getValue().equals(null)) {
				TransactionManager transactionService = new TransactionManager();
				response = transactionService.updateUserProfile(
						model.getUsername(), model.getAttribute(),
						model.getValue());
			}
		}
		return response;
	}
}
