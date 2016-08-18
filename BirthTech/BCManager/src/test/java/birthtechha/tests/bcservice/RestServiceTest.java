package birthtechha.tests.bcservice;

import java.util.List;

import org.junit.Test;

import birthcertificate.entities.BCertificate;
import birthcertificate.ws.rest.BCRestService;

public class RestServiceTest {


	public RestServiceTest() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void getCollectReadyTest(){
		
		BCRestService service = new BCRestService();
		List<BCertificate> collectReady=service.getCollectReady();
	
	}
	
	@Test
	public void findBCbyChildId(){
		
		
	}
}
