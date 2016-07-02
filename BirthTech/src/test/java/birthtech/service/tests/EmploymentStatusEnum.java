package birthtech.service.tests;

import org.junit.Test;

import birthtech.enums.EmploymentEnum;

public class EmploymentStatusEnum {

	@Test
	public void testenum() {
		String employementStatus=EmploymentEnum.GOVERNMENT.name();
		System.out.println(employementStatus);
	}
}
