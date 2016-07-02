package birthtech.services.soap.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import useraccount.soap.services.AccountService;
import useraccount.soap.services.Person;
import useraccount.soap.services.PersonInterface;

public class ClientTest {
	public ClientTest() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"META-INF/cxf-context.xml");
		PersonInterface client = (PersonInterface) context
				.getBean("UAServiceClient");
		System.out.print(client.getPersons().size());
		Person p = null;
		try {
			p = client.findUserByFullName("Lizo Masikisiki");
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (p == null) {
			System.out.println("Nulls");
		} else {
			System.out.println("Person" + p.getDn() + "\n................");
		}
	}

	public static void main(String[] args) {
		new ClientTest();
	}
}
