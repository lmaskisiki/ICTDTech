package ws.rs;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import birthcertificate.services.BCService;
 

@Path("/hello")
@Component
public class Hello {
 
	
	@Path("/")
	@GET
	@Produces("application/json")
	public String saySomething() {
		 
		Object obj= SpringApplicationContext.getBean("BCService");
		System.out.println(obj);
		// BCService service= ctx.getBean("BCService",BCService.class);
		// BCService service = (BCService) SpringApplicationContext
		// .getBean("BCService");

		return "Hello User";
	}

}
