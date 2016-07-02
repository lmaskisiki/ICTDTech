package birthtech.services.routes;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.cxf.message.MessageContentsList;
import org.springframework.stereotype.Component;

import useraccount.soap.services.FindByUsername;
import useraccount.soap.services.GetPersonsResponse;
import useraccount.soap.services.Person;
import birthtech.services.processors.UASearchProcessor;

@Component
public class UserSearchRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:start1")
			  .beanRef("UAServiceClient", "searchByUsernameRequest")
			 .setHeader("OperationName", simple("findByUsername"))
			 .process(new Processor() {
				
				@Override
				public void process(Exchange ex) throws Exception {
					System.out.println(ex.getIn().getBody(FindByUsername.class).getUsername());
					 
					
				}
			})
			 //.to("cxf:bean:UAService")
			 //.beanRef("UAServiceClient", "searchByUsernameResponse")
			 ;
		from("activemq:queue:queue.birthIDs").to("stream:out");
	}

}
