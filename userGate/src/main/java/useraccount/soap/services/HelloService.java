package useraccount.soap.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface HelloService {

	@WebMethod
	public String greating( @WebParam (name="gender")String gender, @WebParam (name="fullname") String fullname);
}
