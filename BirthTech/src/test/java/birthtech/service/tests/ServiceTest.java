package birthtech.service.tests;

import java.io.IOException;

import javax.naming.NamingException;

import org.junit.Test;

import birthtech.services.impl.ParentService;
 

public class ServiceTest {

	
	@Test
	public void test() throws NamingException, IOException {
		ParentService ser=new ParentService();
		ser.getParent("Fata Nobahle");
	 

	}

}