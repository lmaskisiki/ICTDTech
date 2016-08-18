package infosource.open.services.routing;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageAgentRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
 		from("timer://simpleTimer?fixedRate=true&period=5000")
				.setHeader("message").simple("Hello there, how is everything")
				.setBody().simple("ok, sure :${header.message} at ${header.firedTime}")
				.to("stream:out");
    
 	}
}
