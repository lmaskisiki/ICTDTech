package infosource.open.services.testing;

import java.util.ArrayList;
import java.util.List;

import infosource.open.services.access.TransactionManager;
import infosource.soap.client.useraccounts.UserAccountClient;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

import com.google.gson.Gson;

import useraccount.soap.services.Person;
import useraccount.soap.services.UpdateUser;
import useraccount.soap.services.UpdateUserAttribute;
import webframeapp.interfaces.FeedPost;

@SuppressWarnings("unchecked")
public class TransactionManagerTests {

	public void should_call_transaction_manager_invoker_service()
			throws JSONException {
		TransactionManager ser = new TransactionManager();
		System.out.println("Test running");
		String resp = ser.getMyProfile("pnomnga");
		System.out.println("Response returned");
		JSONObject on = new JSONObject(resp);
		Gson json = new Gson();
		if (!resp.trim().equals("")) {
			Person person = json.fromJson(resp, Person.class);
			System.out.println(person.getLastName() + " "
					+ person.getFirstName());
			System.out.println(person.getUsername());
			System.out.println(person.getDn());
			System.out.println(person.getCell());
			System.out.println(person.getEmail());

		} else {
			System.out.println("No response found");
		}

	}

	public void shoud_call_news_endpoint() {
		TransactionManager ser = new TransactionManager();
		Person p = new Person();
		p.setCell("0712345689");
		p.setEmail("test@test.com");
		p.setFirstName("tester");
		p.setLastName("tester");
		p.setUsername("tester");
		p.setIdNumber("60090808");
		p.setPassword("tester");

		ser.createAccount(p);
	}

	@Test
	public void news() {
		TransactionManager ser = new TransactionManager();
		String res = ser.fullProfile("bl");
		System.out.println("\n final response " + res);
	}

	public void should_create_a_soap_request_to_update_user_profile() {

		String username = "bukhanye";
		String attributename = "mobile";
		String newValue = "0392521171";

		UpdateUserAttribute request= new UserAccountClient().UpdateUserRequest(username,attributename,newValue);
		
		
		
		
	}

}
