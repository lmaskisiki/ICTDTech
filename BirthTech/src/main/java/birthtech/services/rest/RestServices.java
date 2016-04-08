package birthtech.services.rest;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class RestServices {
	
	@RequestMapping( value="/home")
	public void serviceTest(){
		System.out.println("Masikisiki Lizo Printed from a service");
	}

}
