package webFrameApp.mvcControllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
	private EntityDAOImpl entityIMPL;

	@Autowired
	private TypeDAOImpl typeIMPL;

	// /////////////////////Get Content////////////////////////////////////
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

	@RequestMapping(value = "JSONContent", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String JSONContent(HttpServletRequest request,
			HttpServletResponse response) {
		contentLoader load = new contentLoader();
		String getDataFrom = request.getParameter("getDataFrom");
		System.out.println(getDataFrom);
		List<OrgEntity> ents = entityIMPL.findByName(getDataFrom);
		OrgEntity ent = ents.get(0);
		String domain = ent.getDomain();
		String[] columns = load.getCoulumn(domain, getDataFrom);
		List<List<Object>> allData = load.getData(domain, getDataFrom);
		StringBuffer jsnObject = null;
		jsnObject = new StringBuffer("{ \"content\" : [");
		int dataSize = allData.size();
		int currentRecord = 0;
		for (List<Object> object : allData) {
			currentRecord += 1;
			jsnObject.append("{");
			for (int x = 0; x < object.size(); x++) {

				jsnObject.append("\"" + columns[x] + "\" :  \""
						+ object.get(x).toString() + "\"");
				if (x < object.size() - 1) {
					jsnObject.append(",");
				}
			}
			jsnObject.append("}");
			/*
			 * if (currentRecord < dataSize) { jsnObject.append(","); } this
			 * makes sure that the comma that separates records is not put on
			 * the last record, so if the loop is on the last record not comma
			 * should be put at the end
			 */
			if (currentRecord < dataSize) {

				jsnObject.append(",");
			}
		}
		jsnObject.append("]}");
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		System.out.println("the converted json ;" + jsnObject.toString());
		return jsnObject.toString();
	}

	@RequestMapping(value = "getContent")
	public ModelAndView getContent(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		String viewContentReq = request.getParameter("viewContent");
		if (viewContentReq == null) {
			String table = request.getParameter("getDataFrom");
			model = new ModelAndView("contentUpdate");
		} else {
			model = new ModelAndView("showcontent");

		}

		contentLoader load = new contentLoader();
		String getDataFrom = request.getParameter("getDataFrom");
		System.out.println(getDataFrom);
		List<OrgEntity> ents = entityIMPL.findByName(getDataFrom);
		OrgEntity ent = ents.get(0);
		String domain = ent.getDomain();
		String[] columns = load.getCoulumn(domain, getDataFrom);
		List<List<Object>> allData = load.getData(domain, getDataFrom);
		System.out.println(" \n \n \n  there are " + allData.size()
				+ "  records  found \n \n");
		model.addObject("labels", columns);
		model.addObject("data", allData);

		return model;
	}

	@RequestMapping(value = "web/viewcontent", method = RequestMethod.GET)
	public ModelAndView viewContent(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("viewcontent");
		contentLoader load = new contentLoader();
		String getDataFrom = request.getParameter("entity");
		System.out.println("ajax Request Found : active Entity here:"
				+ getDataFrom);
		System.out.println(getDataFrom);
		List<OrgEntity> ents = entityIMPL.findByName(getDataFrom);
		OrgEntity ent = ents.get(0);
		String domain = ent.getDomain();
		String[] columns = load.getCoulumn(domain, getDataFrom);
		List<List<Object>> allData = load.getData(domain, getDataFrom);
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
		List<OrgEntity> ent = entityIMPL.findAll();
		System.out.println(" this is the    " + ent.size());
		model.addObject("entities", entityIMPL.findAll());
		return model;

	}

	@RequestMapping(value = "relateRequest", method = RequestMethod.POST)
	public ModelAndView relateRequest(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("NewFile");

		// model.addObject("domains", domainIMPL.getAllDomains());

		return model;
	}

	@RequestMapping(value = "web/saveUpdate", method = RequestMethod.POST)
	public ModelAndView saveUpdate(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("requestupdate");

		String domainName = request.getParameter("domain");
		String entity = request.getParameter("entity");
		System.out.println("domain and entity found....");

		String[] values = request.getParameterValues("attributes");
		System.out.println("attributes found....");
		int attrNumber = values.length;
		addContent cont = new addContent();

		ArrayList<String> attributes = cont.getTableAttributes(entityIMPL
				.findByName(entity).get(0));
		System.out.println("table attributes for the entity were found>>>>>..");
		System.out.println("ATTRIBUTES RETURNED:  " + attributes.size());

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
		boolean save = cont
				.saveUpdate(fullSqlquery, values, domainName, entity);
		System.out.println("SQL QUERY STATEMENT :" + fullSqlquery);

		model.addObject("domainName", domainName); /*  */
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
			OrgEntity ent = entityIMPL.findByName(entity.trim()).get(0);
			String[] attributes = ent.getAttributes();
			GetAutoIncrement incrementCheck = new GetAutoIncrement();
			// remove any column that auto_increments-- using the method defined
			// in
			// class 'GetAutoIncrement'
			attributes = incrementCheck.validateColumns(ent.getName(),
					attributes);
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

	@RequestMapping(value = "/web/update", method = RequestMethod.GET)
	public ModelAndView updateData(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("update");
		contentLoader load = new contentLoader();
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String creator = "";
		if (auth != null) {
			System.out.println(" \n \n \n \n \n \n");
			System.out.print(auth.getName() + ": " + auth.getAuthorities());
			System.out.println(" \n \n \n \n \n \n");
			creator = auth.getName();
		}
		List<Domain> domains = domainIMPL.findByCreator(creator);
		List<OrgEntity> ents = entityIMPL.findByDomain(domains.get(0)
				.getDomainName());
		model.addObject("domains", domains);
		model.addObject("entities", ents);

		// String getDataFrom = request.getParameter("getDataFrom");
		// System.out.println(getDataFrom);
		// List<OrgEntity> ents = entityIMPL.findByName(getDataFrom);
		// OrgEntity ent = ents.get(0);
		// String domain = ent.getDomain();
		// String[] columns = load.getCoulumn(domain, getDataFrom);
		// List<List<Object>> allData = load.getData(domain, getDataFrom);
		// //System.out.println(" \n \n \n  there are " + allData.size()
		// + "  records  found \n \n");

		return model;
	}
}
