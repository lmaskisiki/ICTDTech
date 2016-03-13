package userGate;

import static org.junit.Assert.*;

import java.util.List;

import marshallers.UniversalMarshaller;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ldap.core.DistinguishedName;

import userGate.classes.person;
import userGate.classes.personInterface;
 


public class testing {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		BeanFactory factory = context;
		personInterface userService = (personInterface) factory
				.getBean("ldapUser");
		person p=userService.findByUsername("lmasikisiki");
		UniversalMarshaller um=new UniversalMarshaller();
		String output=um.toXML(p);
		System.out.println("The out put  is: \n"+output);
		
		
		System.out.println(userService.findByUsername("admin"));

	}

}
