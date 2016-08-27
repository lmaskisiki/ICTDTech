package infosource.upservice.usergate.client;

import useraccount.soap.services.FindByUsername;
import useraccount.soap.services.FindByUsernameResponse;

public class UsergateClient {

	public FindByUsername findUser(String username){
		FindByUsername user= new FindByUsername();
		user.setUsername(username);
				return	user;
	}
	
	public FindByUsernameResponse findUserResponse(FindByUsernameResponse response){
		System.out.println("Response found..."+response.getReturn().getEmail());
		return response;
	}
}
