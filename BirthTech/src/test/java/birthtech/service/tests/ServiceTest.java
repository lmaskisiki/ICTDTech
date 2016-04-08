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

import birthtech.entities.Checkup;
import birthtech.entities.Labour;
import birthtech.entities.Martenal;
import birthtech.services.CheckupService;
import birthtech.services.LabourService;
import birthtech.services.MartenalService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/applicationContext.xml")
@Transactional
public class ServiceTest {

	@Autowired
	private MartenalService ser = null;
	@Autowired
	private CheckupService checkService = null;
	@Autowired
	private LabourService labourService = null;

	@Test
	public void test() throws NamingException, IOException {
		Date d = new Date();
		ser.addMartenal("Lizo Masikisiki", d, "Mabhulu");
		System.out.println("The size is :" + ser.getMartenal().size());
	}

	@Test
	public void should_add_checkup() {
		System.out.println("lizo");
		Martenal mat = ser.getMartenal().get(0);
		checkService.addCheckup(false, mat.getIdnumber(), "mabhule",
				"holy cross", "Petient is fine, the baby is fine");
		System.out.println("The size is :" + checkService.getCheckups().size());
	}

	@Test
	public void shoud_add_labour() {

		Labour labour = new Labour();
		labour.setBirthNo(123);
		labour.setBirthPlace("Flagstaff");
		labour.setNurse("Mabhulu");
		labour.setMartenal(ser.getMartenal().get(0));
		labour.setStatus(1);
		System.out.println(labourService.addLabour(labour.getLabourDate(),
				labour.getBirthPlace(), labour.getStatus(),
				labour.getMartenal(), labour.getNurse(), labour.getBirthNo()));
		System.out.println(labourService.getLabour().size());

	}
}
