package birthcertificate.cxf.clients;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import birthcertificate.processors.Person;
import useraccount.soap.services.PersonInterface;

public class UAServiceClient {
	private PersonInterface client ;
	public UAServiceClient() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"META-INF/cxf-context.xml");
	  client = (PersonInterface) context
				.getBean("UAServiceClient");
	}
	
	public useraccount.soap.services.Person findPersonByFullName(String fullName){
		useraccount.soap.services.Person person=client.findUserByFullName(fullName);
		return person;
	}
}
