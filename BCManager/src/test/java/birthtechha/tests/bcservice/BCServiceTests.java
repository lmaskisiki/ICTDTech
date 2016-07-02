package birthtechha.tests.bcservice;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import birthcertificate.entities.BCertificate;
import birthcertificate.processors.Person;
import birthcertificate.services.BCService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/applicationContext.xml")
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class BCServiceTests {

	@Autowired
	private BCService service=null;
 
	public void should_create_certificate(){
		
		//service.createCerticate(6566,new Date(),"birthNumber","childNames","surname","gender","marternalId");
 
	}
 
	public void find(){
		
		System.out.println(service.getAll().get(0).getCreationDate());
	}
	
 
	public void findBCbyChildId(){
	BCertificate cert=	service.getCertificateById("5");
	System.out.println("watttt:"+cert.getSurname());
		
	}
 
	public void findBCbyParentId(){
	BCertificate cert=	service.getCertificateByParentId("600");
	System.out.println("watttt:"+cert.getSurname());
		
	}
	@Test
	 public void update(){
	 service.updateCollectionStatus(false,"Lizo Masikisiki");
		// service.updateCollectionStatus(true,12);
		String str="lizo";
		
		System.out.println(str);
	 }
}
