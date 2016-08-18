package birthtech.service.tests;

import infosource.health.ematclinic.enums.EmploymentEnum;

import org.junit.Test;

public class EmploymentStatusEnum {

	@Test
	public void testenum() {
		String employementStatus=EmploymentEnum.GOVERNMENT.name();
		System.out.println(employementStatus);
	}
}
