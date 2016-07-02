package birthtechha.tests.bcservice;

import org.junit.Test;

import useraccount.soap.services.Person;
import birthcertificate.cxf.clients.UAServiceClient;

public class UAServiceClientTests {
	
	@Test
public void should_find_the_person(){
	UAServiceClient client = new UAServiceClient();
	Person p=client.findPersonByFullName("Lizo Masikisiki");
	 ;
}
}
