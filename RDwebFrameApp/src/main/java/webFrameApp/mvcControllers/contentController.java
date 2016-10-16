package webFrameApp.mvcControllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import webFrame.helpers.InputPresenterHelper;
import webFrameApp.contentManagers.addContent;
import webFrameApp.contentManagers.contentLoader;
import webFrameApp.entites.Domain;
import webFrameApp.entites.OrgEntity;
import webFrameApp.entites.SqldataTypes;
import webFrameApp.serviceLgoic.DomainDAOImpl;
import webFrameApp.serviceLgoic.EntityDAOImpl;
import webFrameApp.serviceLgoic.GetAutoIncrement;
import webFrameApp.serviceLgoic.TypeDAOImpl;

@Controller
public class contentController {

	@Autowired
	private DomainDAOImpl domainIMPL;
	@Autowired
	private EntityDAOImpl OrgEntityService;

	@Autowired
	private TypeDAOImpl typeIMPL;

	// Show all domains >> user selects one to view content
	@RequestMapping(value = "requestContent", method = RequestMethod.POST)
	public ModelAndView requestContent(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("requestContent");
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		List<Domain> doms = null;
		String user;
		if (auth != null) {
			String roles = auth.getAuthorities().toString();
			user = auth.getName();
			if (user != null && roles.contains("ROLE_Master")) {
				doms = domainIMPL.getAllDomains();
			} else {
				doms = domainIMPL.findByCreator(user);
			}
		}
		model.addObject("AllDomains", doms);
		return model;
	}

	// Load data for given entity
	
	@RequestMapping(value = "web/viewcontent", method = RequestMethod.GET)
	public ModelAndView viewContent(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("viewcontent");
		String getDataFrom = request.getParameter("entity");
		List<OrgEntity> ents = OrgEntityService.findByName(getDataFrom);
		OrgEntity ent = ents.get(0);
		String domain = ent.getDomain();
		contentLoader loader = new contentLoader();
		String[] columns = loader.getCoulumn(domain, getDataFrom);
		List<List<Object>> allData = loader.getData(domain, getDataFrom);
		model.addObject("labels", columns);
		model.addObject("data", allData);
		return model;
	}

	@RequestMapping(value = "web/viewcontentrequest", method = RequestMethod.GET)
	public ModelAndView viewContentrequest(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("viewcontentrequest");
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		List<Domain> doms = null;
		String user;
		if (auth != null) {
			String roles = auth.getAuthorities().toString();
			user = auth.getName();
			if (user != null && roles.contains("ROLE_Master")) {
				doms = domainIMPL.getAllDomains();
			} else {
				doms = domainIMPL.findByCreator(user);
			}
		}
		model.addObject("domains", doms);
		return model;
	}

	@RequestMapping(value = "web/contentUpdate", method = RequestMethod.POST)
	public ModelAndView update(
			@ModelAttribute("addDataType_process") ModelMap modelmp,
			SqldataTypes types, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("contAddForm");
		String table = request.getParameter("getDataFrom");
		List<OrgEntity> ent = OrgEntityService.findAll();
		model.addObject("entities", OrgEntityService.findAll());
		return model;
	}

	@RequestMapping(value = "relateRequest", method = RequestMethod.POST)
	public ModelAndView relateRequest(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("NewFile");
		return model;
	}

	@RequestMapping(value = "web/saveUpdate", method = RequestMethod.POST)
	public ModelAndView saveUpdate(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("requestupdate");
		String domainName = request.getParameter("domain");
		String entity = request.getParameter("entity");
		addContent cont = new addContent();
		ArrayList<String> attributes = cont.getTableAttributes(OrgEntityService
				.findByName(entity).get(0));
		String[] values = new String[attributes.size()];
		int attrNumber = values.length;
		for (int i = 0; i < attributes.size(); i++) {
			values[i] = request.getParameter(attributes.get(i));
		}
		String variables = "";
		String Qmarks = "";
		if (attrNumber > 1) {
			variables = attributes.get(0);
			Qmarks = "?";
			for (int x = 1; x < attrNumber; x++) {
				variables = variables + "," + attributes.get(x);
				Qmarks = Qmarks + ", ?";
			}
		} else {
			variables = attributes.get(0);
			Qmarks = "?";
		}
		String sqlInsert = "INSERT INTO tbl_" + entity.trim() + "";
		String fullSqlquery = sqlInsert + " (" + variables + " ) VALUES ( "
				+ Qmarks + ")";
		boolean save = cont.saveContent(fullSqlquery, values, domainName,
				entity);
		model.addObject("domainName", domainName);
		return model;
	}

	@RequestMapping(value = "requestupdate", method = RequestMethod.POST)
	public ModelAndView requestupdate(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("requestContent");
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		List<Domain> doms = null;
		String user;
		if (auth != null) {
			String roles = auth.getAuthorities().toString();
			user = auth.getName();
			if (user != null && roles.contains("ROLE_Master")) {
				doms = domainIMPL.getAllDomains();
			} else {
				doms = domainIMPL.findByCreator(user);
			}
		}
		model.addObject("AllDomains", doms);
		return model;
	}

	@RequestMapping(value = "web/updateForm", method = RequestMethod.GET)
	public ModelAndView updateForm(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ModelAndView model = new ModelAndView("addcontent");
		addContent cont = new addContent();
		String entity = request.getParameter("entity");
		if (!"".equals(entity) || (entity != null)) {
			OrgEntity ent = OrgEntityService.findByName(entity.trim()).get(0);
			GetAutoIncrement incrementCheck = new GetAutoIncrement();
			String[] attributes = incrementCheck.validateColumns(ent.getName(),
					ent.getAttributes(), ent.getTypes(), ent.getOptionValues())
					.get("attrinutes");
			model.addObject("attrNumber", attributes.length);
			model.addObject("attributes", attributes);
			model.addObject("entity", ent.getName());
			model.addObject("domainName", ent.getDomain());
			model.addObject("request", entity);
			return model;
		} else {
			PrintWriter out = response.getWriter();
			out.write("Invalid entry supplied...");
			out.close();
			return model;
		}
	}

	@RequestMapping(value = "web/Cupdate", method = RequestMethod.GET)
	public @ResponseBody String showupdateForm(HttpServletRequest request) {
		String entity = request.getParameter("entity");
		List<OrgEntity> listEnts = OrgEntityService.findAll();
		if (entity == null) {
			System.out.println("emtity input cannot be null");
			throw new NullPointerException();
		}
		OrgEntity ent = null;
		for (OrgEntity e : listEnts) {
			if (e.getName().trim().equals(entity.trim())) {
				ent = e;
				break;
			}
		}
		GetAutoIncrement incrementCheck = new GetAutoIncrement();
		String[] types = ent.getTypes();
		String[] attributes = ent.getAttributes();
		String[] optValues = ent.getOptionValues();
		HashMap<String, String[]> map = incrementCheck.validateColumns(
				ent.getName(), attributes, types, optValues);
		attributes = map.get("attributes");
		types = map.get("types");
		optValues = map.get("InputOptionValues");
		List<InputPresenterHelper> inputList = new ArrayList<InputPresenterHelper>();
		for (int i = 0; i < attributes.length; i++) {
			InputPresenterHelper input = new InputPresenterHelper();
			input.setAttribute(attributes[i]);
			input.setType(types[i]);
			if (optValues[i].trim().length() >= 2) {
				String[] options = optValues[i].trim().split(",|;");
				input.setInputOptionValues(options);
			}
			inputList.add(input);
		}
		Gson gson = new Gson();
		return gson.toJson(inputList);
	}

	@RequestMapping(value = "/web/update", method = RequestMethod.GET)
	public ModelAndView updateData(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("update");
		contentLoader load = new contentLoader();
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String creator = "";
		if (auth != null) {
			creator = auth.getName();
		}
		List<Domain> domains = domainIMPL.findByCreator(creator);
		List<OrgEntity> ents = OrgEntityService.findByDomain(domains.get(0)
				.getDomainName());
		model.addObject("domains", domains);
		model.addObject("entities", ents);
		return model;
	}
}
