package webFrame.ws.integration;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceException;

import usergate.classes.Person;
import usergate.classes.PersonInterface;

public class UASclient {
	private Service ser;
	PersonInterface userService;  

	
	
	
	public UASclient() {
		try {
			ser = Service.create(new URL(
					"http://localhost:8080/userGate/personImpl?wsdl"),
					new QName("http://classes.userGate/", "personImplService"));
			userService = ser.getPort(PersonInterface.class);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (WebServiceException e) {
				System.out.println("Could not connect to the service");
			}
	}

	
	public Person findPerson(String username){
		Person person= userService.findByUsername(username);
		return person;
	}
	
	
	
	
	
}
