package userGate;

import static org.junit.Assert.*;

import java.util.List;

import marshallers.UniversalMarshaller;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ldap.core.DistinguishedName;

import useraccount.soap.services.Person;
import useraccount.soap.services.UserAttributes;
import useraccount.soap.services.personInterface;
 


public class testing {

 
	 public void testAttribueExists() {
		System.out.print("results below :"+UserAttributes.exists("cell"));
	}
	
	 public void should_update_user_profile() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		BeanFactory factory = context;
		personInterface userService = (personInterface) factory
				.getBean("ldapUser");
		Person p=userService.findByUsername("admin");
		
		System.out.println(userService.updateUserAttribute("bl", "uid", "bukhanye"));
	}
	
	 @Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		BeanFactory factory = context;
		personInterface userService = (personInterface) factory
				.getBean("ldapUser");
		Person p= new Person();
		p.setCell("0395003291");
		p.setEmail("mxm@mail.com");
		p.setFirst_name("lname");
		p.setLast_name("fname");
		p.setPassword("lizzzzzz");
		p.setUsername("uname");
		p.setGender("Male");
		userService.createAccount(p);
		//Person p=userService.findByUsername("lmasikisiki");
		//UniversalMarshaller um=new UniversalMarshaller();
		//String output=um.toXML(p);
		//System.out.println("The out put  is: \n"+output);
		//
		
		System.out.println(userService.findByUsername("admin"));

	}
	//@Test
public void should_find_user_by_fullname(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		BeanFactory factory = context;
		personInterface userService = (personInterface) factory
				.getBean("ldapUser");
		System.out.println(userService.isUserMemberOf("admin", "Admin"));
	/*Person p=userService.findUserByFullName("Lizo Masikisiki");
		if(p !=null){
			System.out.println("user found :"+p.getDn());
			
		}
*/
	}
}
