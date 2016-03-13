package webFrameApp.mvcControllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import webFrameApp.entites.Domain;
import webFrameApp.entites.OrgEntity;
import webFrameApp.serviceLgoic.DomainDAOImpl;
import webFrameApp.serviceLgoic.EntityDAOImpl;
import webFrameApp.serviceLgoic.TypeDAOImpl;

@Controller
public class OrgEntityController {
	@Autowired
	private DomainDAOImpl domainImp;
	@Autowired
	private EntityDAOImpl entityIMPL;
	
	@Autowired
	private TypeDAOImpl typeIMPL;

	@RequestMapping(value = "createEntity", method = RequestMethod.GET)
	public void createEntity() {
		Domain d=domainImp.findDomain("ufhGIS");
		String [] atts={"eid","ename","edesc"};
		String [] tps={"INT","VARCHAR","VARCHAR"};
		String [] ot={"","NOT NULL","NOT NULL"};
		int [] len={11,255,255};
		System.out.println(entityIMPL.findAll().size()+"  is the size of entites");
	//entityIMPL.CreateEntity(d, "testENT1", "PUBLIC",atts, tps, typeIMPL.findAll(),len,ot, 3);
	}
	
	@RequestMapping(value = "listEntities", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<OrgEntity> getAllEntities(HttpServletRequest request,
			HttpServletResponse response) {

		return entityIMPL.findAll();

	}

}
