package infosource.starters;

import infosource.routebuilders.SearchRouteBuilder;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.main.Main;
import org.apache.camel.spring.SpringCamelContext;
import org.apache.cxf.message.MessageContentsList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp1 {

	private ApplicationContext context;
	private CamelContext camelContext;

	public MainApp1() {

		try {
			this.context = new ClassPathXmlApplicationContext(
					"META-INF/service-endpoints.xml");
			this.camelContext = SpringCamelContext.springCamelContext(context);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendMessage(String msg) {

		try {
			ProducerTemplate template = this.camelContext
					.createProducerTemplate();
			template.start();
			MessageContentsList ms = new MessageContentsList();
			ms.add("admin");
			String res = template.requestBody("direct:getProfile", ms,
				 String.class);
			System.out.println("\nRESPONSE::" + res);
			template.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		System.out.println("Main App Started...");
		new MainApp1().sendMessage("admin");
		;

	}

}