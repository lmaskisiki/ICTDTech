package birthtech.messaging;

import org.apache.camel.builder.RouteBuilder;

public class BCRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		 
		from("direct:start").to("activemq:queue:queue.birthIDs");
	}

}
