import java.net.MalformedURLException;

import org.junit.Test;

import useraccount.soap.client.UAServiceClient;

public class testWS {

	@Test
	public void testname() throws MalformedURLException {
System.out.println("test");
UAServiceClient v = new  UAServiceClient();
System.out.println( v.isUserMemberOf("bahle", "Admin"));
	}
}
