package infosource.upservice.tests;

 
import infosource.upservice.usergate.client.UsergateClient;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.main.Main;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import useraccount.soap.services.FindByUsername;

 
 
@Component
public class timerRouting {

	private ApplicationContext context;
	private CamelContext camelContext;

	public timerRouting() {

		try {
			this.context = new ClassPathXmlApplicationContext(
					"META-INF/spring/camel-context.xml");
			this.camelContext = SpringCamelContext.springCamelContext(context);
		} catch (Exception e) {
 			e.printStackTrace();
		}
	}

	public void sendMessage(String msg) {
		try {
			ProducerTemplate template = this.camelContext
					.createProducerTemplate();
			 template.start();
			 
			 template.sendBodyAndHeader("direct:userProfile","admin", "profileMode","docsOnly");
		 System.out.println("Done!!");
			template.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("Main App Started...");
		new timerRouting().sendMessage("send");

	}

}