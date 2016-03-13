import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;



@Stateless
@LocalBean
@Path("/hellows")
public class Hellorest {
	
	@GET
    @Produces("text/plain")
	public String sayHi(){
		
		return "Hello Lizo, How are you...s";
	}

}
