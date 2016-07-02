package birthtech.services.soap.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import useraccount.soap.services.AccountService;
import useraccount.soap.services.FindByUsername;
import useraccount.soap.services.FindByUsernameResponse;
import useraccount.soap.services.GetPersons;
import useraccount.soap.services.GetPersonsResponse;
import useraccount.soap.services.Person;


public class UAServiceClient {

	public AccountService accountService;
	
	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public GetPersons getUsersRequest() {
		GetPersons getPersonRequest = new GetPersons();

		return getPersonRequest;
	}

	public GetPersonsResponse getUsersResponse() {
		GetPersonsResponse res = new GetPersonsResponse();

		return res;
	}

	public FindByUsername searchByUsernameRequest(String username) {
		FindByUsername find = new FindByUsername();
		find.setUsername(username);
		return find;
	}

	public Person searchByUsernameResponse(FindByUsernameResponse resp) {
		 
		return resp.getReturn();
	}
}
