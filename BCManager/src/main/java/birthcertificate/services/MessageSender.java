package birthcertificate.services;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageSender {
	private ApplicationContext context;
	private CamelContext camelContext;

	// init appContext and camel context to access to routes
	public MessageSender() {
		try {
			this.context = new ClassPathXmlApplicationContext(
					"META-INF/camel-context.xml");
			this.camelContext = SpringCamelContext.springCamelContext(context);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String sendMessage(String fullname) {
		String response="";
		try {
			ProducerTemplate template = this.camelContext
					.createProducerTemplate();
			template.start();
			System.out.println("\n \n \n now sending the message");
			 response = template.requestBody("direct:start", fullname,
					 
					String.class);
				System.out.println("\n \n \n message sent");
			template.stop();
		} catch (Exception e) {
			System.out.println("could not send the message");
			e.printStackTrace();
		}
		return response;
	}

}
