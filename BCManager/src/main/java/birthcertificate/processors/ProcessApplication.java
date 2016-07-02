package birthcertificate.processors;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import birthcertificate.entities.Labour;
import birthcertificate.services.BCService;
 
@Component
public class ProcessApplication implements Processor {
	 
	private BCService service;

	@Override
	public void process(Exchange exch) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		service = context.getBean(BCService.class);
		StringReader reader = new StringReader(exch.getIn().getBody(
				String.class));
		JAXBContext jaxbContext = JAXBContext.newInstance(Labour.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Labour labour = (Labour) jaxbUnmarshaller.unmarshal(reader);
		System.out.println("\n \n done unmarshalling");
		 service.createCerticate(labour);
	}

}
