package birthtech.service.tests;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import useraccount.soap.services.Person;
import useraccount.soap.services.PersonInterface;
import birthtech.entities.Checkup;
import birthtech.entities.Labour;
import birthtech.entities.Maternity;
import birthtech.enums.EmploymentEnum;
import birthtech.enums.LabourStatusEnum;
import birthtech.services.CheckupService;
import birthtech.services.LabourService;
import birthtech.services.MaternityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/applicationContext.xml")
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class ServiceTest {

	@Autowired
	private MaternityService martenalService = null;
	@Autowired
	private CheckupService checkService = null;
	@Autowired
	private LabourService labourService = null;

	 @Test
	public void should_create_maternity() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"META-INF/cxf-context.xml");
		PersonInterface service = (PersonInterface) context
				.getBean("UAServiceClient");
		Person psn = null;
		Maternity maternity = new Maternity();
		try {
			psn = service.findByUsername("pnomngasss");
		} catch (Exception e) {
		System.out.print(""+e.getClass()+" :was thrown\n");
		}
		if(psn !=null){
			maternity.setMid(1);
			maternity.setIdnumber(901);
			maternity.setSurname(psn.getLastName());
			maternity.setNames(psn.getFirstName());
			maternity.setEmployementStatus(EmploymentEnum.GOVERNMENT.name());
			maternity.setRegistration(new Date());
	
		  System.out.println("Ok.");
		}
		else{
 		maternity.setIdnumber(6009081);
		maternity.setNames("Nonkonzo");
		maternity.setSurname("Shiqa");
		maternity.setNurse("Dr. Sinqa");
		maternity.setRegistration(new Date());
		maternity.setEmployementStatus(EmploymentEnum.SELF.name());

		}
		martenalService.addMaternity(maternity);

	}

	// @Test
	public void should_add_checkup() {

		 Checkup c= new Checkup();
		 c.setComments("Expect the baby in 3 Months and 1 Week");
		 c.setDelivered(false);
		 c.setPlace("Nkozo Hospital");
		 c.setNurse("Ms Zenzele");
		 c.setMartenalId(6009081);
		 c.setDate(new Date());
		 Maternity mat = martenalService.getMartenal().get(0);
		 checkService.addCheckup(c);
		 checkService.getCheckups().size();
		 
	}

	//@Test
	public void shoud_add_labour() {

		Labour labour = new Labour();
		Maternity parent = martenalService.getMartenal().get(1);
		labour.setBirthNo(9010);
		labour.setBirthPlace("Bizana");
		labour.setNurse("Mabhulu");
 		labour.setStatus(LabourStatusEnum.SUCCESS.getEnumInt());
		System.out.println("Parent found....." + parent.getNames());
		  
	}

	//@Test
	public void should_find_chechup_by_fullname() {
		Checkup c = checkService.getCheckup("Bahle Masikisiki");
		System.out.println(c == null ? "yes null" : c.getComments());
	}

}
