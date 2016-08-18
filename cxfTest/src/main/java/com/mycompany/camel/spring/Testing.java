package com.mycompany.camel.spring;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class Testing {
	@GET
	@Path("/")
	@Produces("application/json")
	public String hello() {
		return "hello lizo, how are you.";
	}
}
