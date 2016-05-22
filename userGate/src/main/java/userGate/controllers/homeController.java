package userGate.controllers;
 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
 





import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import useraccount.soap.services.groups;
import useraccount.soap.services.person;
import useraccount.soap.services.personInterface;
import useraccount.soap.services.userRoles;

@Controller
public class homeController {

	@RequestMapping("home/register")
	public String apply() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		BeanFactory factory = context;
		personInterface userService = (personInterface) factory
				.getBean("ldapUser");

		return "userform";
	}

	@RequestMapping("/private/default")
	public ModelAndView privateaccess() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		String user = "";
		user = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("the user is ...." + user);
		ModelAndView model = new ModelAndView("private");
		model.addObject("user", user);
		return model;
	}

	@RequestMapping(value="private/profile/edit/{username}",  method = RequestMethod.GET)
	public ModelAndView editprofile(@PathVariable String username) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		BeanFactory factory = context;
		personInterface userInterface = (personInterface) factory
				.getBean("ldapUser");

		person psn = userInterface.findByUsername(username);
		List<userRoles> roles=userInterface.personRoles(psn.getUsername());
 
		ModelAndView model = new ModelAndView("edit");

		model.addObject("person", psn);
		model.addObject("roles",roles);
		return model;
	}

	@RequestMapping(value = "home/submit_appl", method = RequestMethod.GET)
	public String applic_submit(@ModelAttribute("userWeb") person person,
			ModelMap model) {

		model.addAttribute("last_name", person.getLast_name());
		model.addAttribute("first_name", person.getFirst_name());
		model.addAttribute("cell", person.getCell());
		model.addAttribute("email", person.getEmail());
		model.addAttribute("username", person.getUsername());
		model.addAttribute("password", person.getPassword());

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		BeanFactory factory = context;
		personInterface create = (personInterface) factory.getBean("ldapUser");
		create.createPerson(person);

		return "applic_submit_success";
	}

	@RequestMapping(value = "private/profile/edit/update", method = RequestMethod.GET)
	public String update(@ModelAttribute("userWeb") person person,
			ModelMap model) {

		model.addAttribute("last_name", person.getLast_name());
		model.addAttribute("first_name", person.getFirst_name());
		model.addAttribute("cell", person.getCell());
		model.addAttribute("email", person.getEmail());
		model.addAttribute("username", person.getUsername());
		model.addAttribute("dn", person.getDn());

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		BeanFactory factory = context;
		personInterface create = (personInterface) factory.getBean("ldapUser");
		System.out.println("\n \n  hahahahah it works");
		create.updateUser(person);

		return "viewuser";
	}

	@RequestMapping(value = "showUsers", method = RequestMethod.GET)
	public ModelAndView showUsers(HttpServletRequest request) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		BeanFactory factory = context;
		personInterface personList = (personInterface) factory
				.getBean("ldapUser");
		List<person> people = personList.getPersons();

		System.out.println("security Context is :"
				+ SecurityContextHolder.getContext().getAuthentication()
						.getName());

		for (person p : people) {

			System.out.print(p.getFirst_name() + " ");
			System.out.print(p.getLast_name() + " ");
			System.out.println();
		}
		request.setAttribute("users", people);

		ModelAndView model = new ModelAndView("showAllusers");
		model.addObject("persons", people);
		return model;
	}

	@RequestMapping(value = "searches/{name}", method = RequestMethod.GET)
	public ModelAndView searches(@ModelAttribute("userWeb") person prsn,
			ModelMap modelmp, @PathVariable String name) {

		modelmp.addAttribute("last_name", prsn.getLast_name());
		ModelAndView model = new ModelAndView("search_results");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		System.out.println("hahahahahah" + name);
		BeanFactory factory = context;
		personInterface findPerson = (personInterface) factory
				.getBean("ldapUser");
		List<person> persons = findPerson.findSomeone(name);
		model.addObject("found", persons);

		return model;
	}

	@RequestMapping(value = "private/getUserByUsername" , method = RequestMethod.GET, produces="application/json")
	public  @ResponseBody  List<person> search(HttpServletRequest request) {
		String username = request.getParameter("search_name");
		ModelAndView model = new ModelAndView("search_results");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		BeanFactory factory = context;
		personInterface findPerson = (personInterface) factory
				.getBean("ldapUser");
		List<person> persons = findPerson.findSomeone(username);
		model.addObject("found", persons);
		System.out.println("\n \n called+++ hahahah");
		return persons;
	}

	@RequestMapping(value = "selfUpdate")
	public ModelAndView selfUpdate(@ModelAttribute("userGate") person psn,
			ModelMap modelmp) {
		ModelAndView model = new ModelAndView("userUpdate");
		modelmp.addAttribute("last_name", psn.getLast_name());
		modelmp.addAttribute("first_name", psn.getFirst_name());
		modelmp.addAttribute("email", psn.getEmail());
		modelmp.addAttribute("cell", psn.getCell());

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		BeanFactory factory = context;
		personInterface prsn = (personInterface) factory.getBean("ldapUser");
		prsn.updateUser(psn);
		return model;
	}

	// /////////////////////////////// Login
	// ///////////////////////////////////////////////////

	@RequestMapping(value = "loginRequest", method = RequestMethod.GET)
	public ModelAndView loginRequest() {
		ModelAndView model = new ModelAndView("login");
		return model;
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "loginproces", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("userGate") person user,
			ModelMap modelmp) {

		modelmp.addAttribute("username", user.getUsername());
		modelmp.addAttribute("password", user.getPassword());

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		BeanFactory factory = context;
		personInterface prsn = (personInterface) factory.getBean("ldapUser");

		boolean userFound = prsn.login(user.getUsername(), user.getPassword());

		ModelAndView model;

		person psn;
		String rs = "";
		if (userFound == true) {
			System.out.print("user Found");
			model = new ModelAndView("userProfile");
			psn = prsn.userProfile(user.getUsername());
			model.addObject("user", psn);

			return model;
		}

		else {
			System.out.print("user not Found");
			model = new ModelAndView("login");
			rs = "login Failure";
			model.addObject("results", rs);

			return model;
		}

	}

	@RequestMapping(value = "private/migrateUser")
	public ModelAndView migrateUser(@ModelAttribute("userGate") person p,
			ModelMap modelmp, HttpServletRequest request) {

		final String name;
		String full_name = request.getParameter("full_name");
		ModelAndView model;
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		BeanFactory factory = context;
		personInterface prsn = (personInterface) factory.getBean("ldapUser");

		List<person> requests = prsn.getPersons();
		 List<groups>  roles=prsn.userGroup();
		

		if (full_name != null) {
			person newp = (prsn.findSomeone(full_name)).get(0);
			List list = prsn.getOrgUnit();
			List<userRoles> rols= prsn.personRoles(newp.getUsername());
			model = new ModelAndView("migrateUIprofile");
			model.addObject("profile", newp);
			model.addObject("ou", list);
			model.addObject("rols", rols);//already assigned roles
			model.addObject("roles", roles);//available roles to assign
		} else {
			model = new ModelAndView("migrateUI");
			model.addObject("requests", requests);
		}

		return model;
	}

	@RequestMapping(value = "migrateprocess")
	public ModelAndView migrateprocess(@ModelAttribute("userGate") person p,
			ModelMap modelmp, HttpServletRequest request) {

		modelmp.addAttribute("last_name", p.getLast_name());
		modelmp.addAttribute("first_name", p.getFirst_name());

		ModelAndView model;

		String oUnit = request.getParameter("orgUnit");

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		BeanFactory factory = context;
		personInterface prsn = (personInterface) factory.getBean("ldapUser");

		// System.out.println("ADD "+prsn.addUserToGroup(p, "users"));
		System.out.println(" the role is \n" + prsn.findRole());

		// prsn.migrateUser(p, oUnit);
		model = new ModelAndView("migrateUIprofile");
		return model;
	}

	@RequestMapping(value = "private/assignrole", method = RequestMethod.GET)
	public ModelAndView assignRole(HttpServletRequest request) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		BeanFactory factory = context;
		personInterface service = (personInterface) factory.getBean("ldapUser");
		
		String username =request.getParameter("username");
		String groupdn=request.getParameter("roleDN");
		person p=service.findByUsername(username);
		service.assignRole(p, groupdn);
		
		return null;
 }
	@RequestMapping(value = "private/removerole", method = RequestMethod.GET)
	public ModelAndView romoveRole(HttpServletRequest request) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		BeanFactory factory = context;
		personInterface service = (personInterface) factory.getBean("ldapUser");
		
		String username =request.getParameter("username");
		String  rolename=request.getParameter("role");
	 	String groupdn="";
	 	groupdn=service.getRoleByName(rolename);
		person p=service.findByUsername(username);
		 service.removeRole(p, groupdn);
		
		return null;
 }
	
	@RequestMapping(value = "private/testing", method = RequestMethod.GET)
	public @ResponseBody String test() {

		return "this is return text";
	}

	// getUserByUsername

}
