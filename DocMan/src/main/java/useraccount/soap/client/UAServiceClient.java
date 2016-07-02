package useraccount.soap.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceRef;

import useraccount.soap.services.AccountService;
import useraccount.soap.services.PersonInterface;

public class UAServiceClient {
	private PersonInterface AService = null;
	private URL url;
	private QName qname;

	public UAServiceClient()  {
		try {
			url = new URL("http://localhost:8080/userGate/AccountService?wsdl");
			qname = new QName("http://services.soap.useraccount/",
					"AccountService");
			Service service = Service.create(url, qname);
			AService = service.getPort(PersonInterface.class);
		} catch (Exception e) {
				System.out.println("Something went wrong");
		}

	}

	public boolean isUserMemberOf(String username, String rolename) {
		if (AService != null) {
			if (AService.isUserMemberOf(username, rolename)) {
				return true;
			}
		}
		return false;
	}

}
