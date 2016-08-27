package infosource.upsclient.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.camel.Consume;
import org.codehaus.jackson.map.util.JSONPObject;

 
@Path("/")
public class UPService {

	@Path("/full/{username}")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String full(@PathParam("username") String username) {
		return null;
		}
 
	@GET
	@Path("/docs/{username}")
	@Consumes("application/json")
	@Produces("application/json")
	public String docs(@PathParam("username") String username) {
		return null;
	}

	@Path("/basic/{username}")
	@GET
	@Produces("application/json")
	@Consumes("application/json")
	public String basic(@PathParam("username") String username) {
		return null;
	}
}
