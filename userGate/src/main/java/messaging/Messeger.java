package messaging;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import marshallers.UniversalMarshaller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import useraccount.soap.services.Person;
import useraccount.soap.services.personInterface;

@MessageDriven(name = "Messeger", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "findUser") })
public class Messeger implements MessageListener {

	public Messeger() {

	}

	public void onMessage(Message message) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		BeanFactory factory = context;
		personInterface userService = (personInterface) factory
				.getBean("ldapUser");
		try {
			if (message instanceof TextMessage) {
				TextMessage msg = (TextMessage) message;
				String tmsg= msg.getText();
				Person p =userService.findUserByFullName(tmsg);
				UniversalMarshaller um=new UniversalMarshaller();
				String output=um.toXML(p);
				System.out.println("request recieved!!!");
				

			}
		} catch (JMSException e) {
			e.printStackTrace();

		}

	}

}
