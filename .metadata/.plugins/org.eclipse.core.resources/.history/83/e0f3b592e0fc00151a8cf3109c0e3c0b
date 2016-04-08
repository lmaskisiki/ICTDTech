package birthtech.service.tests;

import java.io.IOException;
import java.util.Date;

import javax.naming.NamingException;
 


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import birthtech.services.MartenalService;
 
 
 @RunWith(SpringJUnit4ClassRunner.class)
 @ContextConfiguration("/META-INF/applicationContext.xml")
 @Transactional
public class ServiceTest {

	@Autowired
	private  MartenalService ser=null;
	
	
	@Test 
	public void test() throws NamingException, IOException {
 Date d=new Date();
	 ser.addMartenal("Lizo Masikisiki",d, "Mabhulu");
	 System.out.println("The size is :"+ser.getMartenal().size());

	}

}
