package useraccount.services.tests;

import infosource.open.services.access.TransactionManager;

import org.apache.cxf.message.MessageContentsList;
import org.junit.Test;

public class When_Creating_An_Account {
	@Test
	public void should_invoke_web_service_method_to_find_someone() {
		TransactionManager ser = new TransactionManager();
		String res = ser.fullProfile("admin");

		System.out.println("\n final response " + res);
	}
}
