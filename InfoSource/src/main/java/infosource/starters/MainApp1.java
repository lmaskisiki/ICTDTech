package infosource.starters;

import infosource.routebuilders.SearchRouteBuilder;
import infosource.soap.client.useraccounts.UserAccountClient;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.main.Main;
import org.apache.camel.spring.SpringCamelContext;
import org.apache.cxf.message.MessageContentsList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import useraccount.soap.services.FindByUsername;
import useraccount.soap.services.UpdateUserAttribute;

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
			ms.add("mobile");
			ms.add("0735222555");
			 
  
UpdateUserAttribute u= new UpdateUserAttribute();
u.setUsername("admin");
u.setAttribute("mobile");
u.setValue("0362521171");
		 template.requestBody("direct:UpdateUser", u);

			// System.out.println("\nRESPONSE::" + res);
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
