package birthcertificate.processors;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import birthcertificate.entities.Labour;
import birthcertificate.services.BCService;

import com.google.gson.Gson;

@Component
public class BCProcessor implements Processor {
	private BCService service;
	@Override
	public void process(Exchange exchange) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		service = context.getBean(BCService.class);
		Gson json = new Gson();
		System.out.println("Inside the processor !!  abot to sleep");
		
		
		String str=exchange.getIn().getBody().toString();
		System.out.println("just got the exchange \n \n"+str);
		Thread.sleep(3000);
		Labour lab =json.fromJson(str, Labour.class);
		System.out.println("staff recieved \n \n"+json.toJson(lab));

	//	Labour lab = json.fromJson(exchange.getIn().getBody().toString(),
	//			Labour.class);
	//	
		
//	service.createCerticate(000, new Date(), lab.getBirthNo() + "", "Bubu",
//			lab.getMartenal().getSurname(), "gender", lab.getMartenal()
//					.getIdnumber() + "");
//
	
	}

}
