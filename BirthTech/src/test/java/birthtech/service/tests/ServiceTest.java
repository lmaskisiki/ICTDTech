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
import birthtech.entities.Patient;
import birthtech.enums.EmploymentEnum;
import birthtech.enums.LabourStatusEnum;
import birthtech.services.CheckupService;
import birthtech.services.LabourService;
import birthtech.services.PatientService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/applicationContext.xml")
@Transactional
@TransactionConfiguration(defaultRollback = false)
@Ignore
public class ServiceTest {

	@Autowired
	private PatientService martenalService = null;
	@Autowired
	private CheckupService checkService = null;
	@Autowired
	private LabourService labourService = null;

	// @Test
	public void should_create_maternity() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"META-INF/cxf-context.xml");
		PersonInterface service = (PersonInterface) context
				.getBean("UAServiceClient");
		Person psn = null;
		Patient patient = new Patient();
		try {
			psn = service.findByUsername("pnomnga");
		} catch (Exception e) {
		System.out.print(""+e.getClass()+" :was thrown\n");
		}
		if(psn !=null){
			patient.setPid(1);
			patient.setIdnumber(901);
			patient.setSurname(psn.getLastName());
			patient.setNames(psn.getFirstName());
			patient.setEmployementStatus(EmploymentEnum.GOVERNMENT.name());
			patient.setRegistration(new Date());
	
		  System.out.println("Ok.");
		}
		else{
 		patient.setIdnumber(6009081);
		patient.setNames("Nonkonzo");
		patient.setSurname("Shiqa");
		patient.setNurse("Dr. Sinqa");
		patient.setRegistration(new Date());
		patient.setEmployementStatus(EmploymentEnum.SELF.name());

		}
		martenalService.addMaternity(patient);

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
		 Patient mat = martenalService.getMartenal().get(0);
		 checkService.addCheckup(c);
		 checkService.getCheckups().size();
		 
	}

	//@Test
	public void shoud_add_labour() {

		Labour labour = new Labour();
		Patient parent = martenalService.getMartenal().get(1);
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
