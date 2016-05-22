package birthtech.messaging;

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
	public void sendObject(Object object) {
		try {
			ProducerTemplate template = this.camelContext
					.createProducerTemplate();
			template.start();
			template.sendBody(
					"direct:start", object);
			template.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void sendMessage(String jsonStringMessage) {
		try {
			ProducerTemplate template = this.camelContext
					.createProducerTemplate();
			template.start();
			template.sendBody(
					"direct:start", jsonStringMessage);
			template.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
