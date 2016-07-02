package birthtech.messaging;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
@Component
public class BCRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		 
		from("direct:start1")
			.choice()
				.when(xpath("/child/maternity/employmentStatus='GOVERNMENT'"))
					.to("activemq:rejectGrantApplication")
				.otherwise()
					.to("activemq:grantapplication")
				.end()
		.to("activemq:queue:queue.birthIDs");
	}

}
