import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;



public class RestClient {
	
	Client client = ClientBuilder.newBuilder().build();
	WebTarget target = client.target("http://localhost:8080/BCManager/");
	//Response response = target..request().get();
 public RestClient() {
		Response response =target.path("/certificates/all").request().get();
}
	
	// You should close connections!

	
public static void main(String[] args) {
	
	new RestClient();
	System.out.println("Lizo");
}
}
