package infosource.soap.client.useraccounts;

import org.springframework.stereotype.Component;

import useraccount.soap.services.FindByUsername;
import useraccount.soap.services.FindByUsernameResponse;
import useraccount.soap.services.GetPersons;
import useraccount.soap.services.GetPersonsResponse;
import useraccount.soap.services.Person;


@Component
public class UserAccountClient {
	
	public Person getUserByUsername(FindByUsernameResponse response){
		response.getReturn();
		return response.getReturn();
	}

	public GetPersonsResponse getPersons(){
		GetPersons p=new GetPersons();
		 
		return null;
		
	}
}