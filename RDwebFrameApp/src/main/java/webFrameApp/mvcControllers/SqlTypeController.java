package webFrameApp.mvcControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import webFrameApp.entites.Domain;
import webFrameApp.entites.SqldataTypes;
import webFrameApp.serviceLgoic.DomainDAOImpl;
import webFrameApp.serviceLgoic.EntityDAOImpl;
import webFrameApp.serviceLgoic.TypeDAOImpl;

@Controller
public class SqlTypeController {
	 
	@Autowired
	private TypeDAOImpl typeIMPL;

	@RequestMapping(value = "createSQLType", method = RequestMethod.GET)
	public void CreateSQLType() {
		 SqldataTypes type=new  SqldataTypes();		
		 type.setDefaultSize(254);
		 type.setName("CHAR2");
		 type.setType("VARCHAR");
		 typeIMPL.save(type);
		 
		//entityIMPL.CreateEntity(d, "testENT", atts, tps, typeIMPL.findAll(),len,ot, 3);
	}

}
