package intTest.beans;

import javax.jws.WebService;

 
public class Tester implements testEndpoint {

	@Override
	public void sayHi() {
		System.out.print("Hello Lizo, How are you today:_"+new java.util.Date());

	}

}
