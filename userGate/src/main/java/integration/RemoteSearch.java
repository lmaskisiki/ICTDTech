package integration;

import marshallers.UniversalMarshaller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import userGate.classes.person;
import userGate.classes.personInterface;

@Service
public class RemoteSearch {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath:META-INF/applicationContext.xml");
	BeanFactory factory = context;
	personInterface userService = (personInterface) factory.getBean("ldapUser");

	public String getPerson(String message) {
		UniversalMarshaller marshal = new UniversalMarshaller();

		String searchString = message;
		person psn = userService.findByUsername(searchString);
		String str = marshal.toXML(psn);
		System.out.println("Message Recieved by userGare....(:" + str);
		return str;
	}

	public String getFullname(String searchString) {
		UniversalMarshaller marshal = new UniversalMarshaller();
		
		
		
		person psn = userService.findByUsername(searchString);
		String responseMsg=marshal.toXML(psn);
		String results = psn.getLast_name() + " " + psn.getFirst_name();
		 System.out.println("Response Created @Body | \n"+responseMsg);
		return responseMsg;
	}

}
