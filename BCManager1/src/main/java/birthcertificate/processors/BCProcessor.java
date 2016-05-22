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
	public void process(Exchange exch) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/applicationContext.xml"); 
		service= context.getBean(BCService.class);
		System.out.println("Birth Certificate for the :"+exch.getIn().getBody().toString()+" is being proccessed");
		Gson json= new Gson();
		Labour lab= json.fromJson(exch.getIn().getBody().toString(), Labour.class);
		service.createCerticate(000, new Date(), lab.getBirthNo()+"", "Bubu", lab.getMartenal().getSurname(),"gender", lab.getMartenal().getIdnumber()+"");
		
		
		System.out.println("Successfully mapped json to 'labour class' \n");
		System.out.println(lab.getLabourId()+":"+lab.getBirthNo()+":"+lab.getStatus()+""+lab.getMartenal().getSurname()+" "+lab.getMartenal().getNames());
	}

}
