package infosource.health.ematclinic.soap.client;

import org.apache.cxf.jaxws.JaxWsClientFactoryBean;

import useraccount.soap.services.PersonInterface;

public class Test {

	public static void main(String[] args) {
		JaxWsClientFactoryBean Factory=new JaxWsClientFactoryBean();
		Factory.setAddress("http://localhost:8080/userGate/AccountService");
		Factory.setServiceClass(PersonInterface.class);
		PersonInterface uaservice= (PersonInterface) Factory.create();
		uaservice.getPersons();
	}

}
