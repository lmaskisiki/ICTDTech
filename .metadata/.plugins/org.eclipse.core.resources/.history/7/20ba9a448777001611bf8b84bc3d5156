package webFrame.controllers;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import webFrameApp.contentManagers.contentLoader;
import webFrameApp.entites.Domain;
import webFrameApp.entites.OrgEntity;
import webFrameApp.security.personDAOimpl;
import webFrameApp.serviceLgoic.DomainDAOImpl;
import webFrameApp.serviceLgoic.EntityDAOImpl;
import webFrameApp.serviceLgoic.GetAutoIncrement;
import webFrameApp.serviceLgoic.TypeDAOImpl;

@Controller
public class AjaxHandlerController {

	@Autowired
	private DomainDAOImpl domainImp;
	@Autowired
	private EntityDAOImpl entityIMPL;

	@Autowired
	private TypeDAOImpl typeIMPL;

	@RequestMapping(value = "getdomainbycategory", method = RequestMethod.GET)
	public @ResponseBody String[] findbycategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String cat = request.getParameter("category");
		
		List<Domain> doms = domainImp.findByCategory(cat);
		System.out.println("\n \n String domains by category...\n \n");
		String[] dms = new String[doms.size()];
		int x = 0;
		for (Domain d : doms) {
			dms[x] = d.getDomainName();
			x++;
		}
		return dms;
	}

	@RequestMapping(value = "getentities", method = RequestMethod.GET)
	public @ResponseBody String[] getentities(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String domain = request.getParameter("domain");
		List<OrgEntity> ents = entityIMPL.findByDomain(domain);
		String[] ent = new String[ents.size()];
		int x = 0;
		for (OrgEntity e : ents) {
			ent[x] = e.getName();
			x++;
		}
		return ent;
	}

	@RequestMapping(value = "activeDomain", method = RequestMethod.GET)
	public @ResponseBody String activeDomain(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String activedomain = request.getParameter("activeDomain");
		Domain dom = domainImp.findDomain(activedomain.trim());
		List<OrgEntity> ents = entityIMPL.findByDomain(dom.getDomainName());

		String arr = "<form><table><tr> <td>Select Entity</td><td><select onchange='loadContent()' name='activeEntity' id='activeEntity' >";

		for (OrgEntity e : ents) {
			arr = arr + "<option value='" + e.getName() + "'> " + e.getName()
					+ "</option>";

		}
		arr = arr + "</select></td></tr></table></form>";
		// <td><input type='button' value='Load' onclick='loadContent()'/></td>
		return arr;
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "web/entupdate", method = RequestMethod.GET)
	public @ResponseBody String entupdate(HttpServletRequest request) {
		String ents = "";
		ModelAndView model;
		try {
			model = new ModelAndView("requestContent");
			String domain = request.getParameter("domainName");
			System.out.println(domain + " was found");
			List<OrgEntity> ent = entityIMPL.findByDomain(domain);

			ents = "<select name='OrgEntity'  id='OrgEntity'  onchange='updateForm()'>";
			String str = "";
			for (int x = 0; x < ent.size(); x++) {
				str = str + "<option value=" + ent.get(x).getName() + "> "
						+ ent.get(x).getName() + "</option>";
			}
			ents = ents + str + "</select>";

			return ents;

		} catch (Exception e) {

			return "Sorry...Something went wrong. try again or contact the admin";

		}

	}

	@RequestMapping(value = "web/Cupdate", method = RequestMethod.GET)
	public @ResponseBody String showupdateForm(HttpServletRequest request) {
		String entity = request.getParameter("entity");
		List<OrgEntity> listEnts = entityIMPL.findAll();
		OrgEntity ent = null;
		for (OrgEntity e : listEnts) {
			if (e.getName().trim().equals(entity.trim())) {
				ent = e;

			}
		}
		String[] types = ent.getTypes();
		String[] attributes = ent.getAttributes();
		GetAutoIncrement incrementCheck = new GetAutoIncrement();
		// remove any column that auto_increments-- using the method defined in
		// class 'GetAutoIncrement'
		// attributes = incrementCheck.validateColumns(ent.getName(),
		// attributes);
		String[] other = ent.getOther();
		String[] optValue = ent.getOptionValues();
		String table = "";
		int att_num = ent.getAtt_number();
		table = "<table>";
		for (int x = 0; x < attributes.length; x++) {
			String opts = "";
			if ((!optValue[x].equals("")) && (types[x].equals("VARCHAR"))) {
				String[] tkens = createOption(optValue[x]);
				for (int z = 0; z < tkens.length; z++) {
					opts = opts + "<option value='" + tkens[z] + "'>"
							+ tkens[z] + "</option>";
				}
				table = table + "<tr>" + "<td>" + attributes[x] + "</td>"
						+ "<td> <select name='attributes'>" + opts
						+ "</select>" + "</td>" + "</tr>";
			} else if (types[x].equals("INT")) {
				table = table + "<tr>" + "<td>" + attributes[x] + "</td>"
						+ "<td><input type='text' name='attributes' /></td>"
						+ "</tr>";
			} else if ((optValue[x].equals("")) || (optValue[x] == null)) {
				table = table + "<tr>" + "<td>" + attributes[x] + "</td>"
						+ "<td><input type='text' name='attributes' /></td>"
						+ "</tr>";
			}

		}
		table = table + "</table>";
		System.out.println(table);
		return table;
	}

	public String[] createOption(String str) {
		StringTokenizer tokens = new StringTokenizer(str, ",");
		String[] tkns = new String[tokens.countTokens()];
		int x = 0;
		while (tokens.hasMoreTokens()) {
			tkns[x] = tokens.nextToken().trim();
			x++;
		}
		return tkns;
	}

	@RequestMapping(value = "getjsoncontent", method = RequestMethod.GET)
	public @ResponseBody String viewContent(HttpServletRequest request) {

		contentLoader load = new contentLoader();
		String getDataFrom = request.getParameter("entity");
		List<OrgEntity> ents = entityIMPL.findByName(getDataFrom);
		OrgEntity ent = ents.get(0);
		String domain = ent.getDomain();
		String[] columns = load.getCoulumn(domain, getDataFrom);
		List<List<Object>> allData = load.getData(domain, getDataFrom);
		StringBuilder jsnStr = new StringBuilder("");
		jsnStr.append("{  \"data\" : [");
		for (int x = 0; x < allData.size(); x++) {
			jsnStr.append("{");
			for (int z = 0; z < columns.length; z++) {
				jsnStr.append(" \""+ columns[z] +"\":\""
						+ allData.get(x).get(z) + "\"");
				if (z < columns.length - 1) {
					jsnStr.append(",");
				}
			}
			jsnStr.append("}");
			if (x < allData.size() - 1) {
				jsnStr.append(",");
			}
		}
		jsnStr.append("]}");
		System.out.print(jsnStr.toString());
		return jsnStr.toString();
	}
}
