package userGate.security.authprovider;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	@RequestMapping(value="/user" , method = RequestMethod.GET )
	public Principal user(Principal user) {
		System.out.print("\n fuchhhhhhhhhh "+user.getName());
		return user;

	}

}
