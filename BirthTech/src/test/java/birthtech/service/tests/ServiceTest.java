package birthtech.service.tests;

import java.io.IOException;
import java.util.Date;

import javax.naming.NamingException;

import org.junit.Test;

import birthtech.entities.Martenal;
import birthtech.services.MartenalService;
 
 

public class ServiceTest {

	
	@Test
	public void test() throws NamingException, IOException {
	 MartenalService ser=new MartenalService();
	 ser.addMartenal("Lizo Masikisiki",new Date(), "Mabhulu");
	 

	}

}
