package infosource.health.ematclinic.soap.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.cxf.message.MessageContentsList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import useraccount.soap.services.FindByUsernameResponse;
import useraccount.soap.services.GetPersonsResponse;
import useraccount.soap.services.Person;

public class CamelApp {
	public static void main(String[] args) {
		try {
			ApplicationContext springCtx = new ClassPathXmlApplicationContext(
					"META-INF/camel-context.xml");
			CamelContext context = springCtx.getBean("searchRoutes",
					CamelContext.class);
			context.start();
			ProducerTemplate producerTemplate = context
					.createProducerTemplate();

			MessageContentsList ls = new MessageContentsList();
			ls.add("lizo");
			FindByUsernameResponse response ;
		 producerTemplate.requestBody("direct:start","lizo",Person.class);
			context.stop();
		//	 System.out.print("lizo " + response.getReturn().getDn() + "\n");
				 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

}
