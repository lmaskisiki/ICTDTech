package birthcertificate.routebuilders;
 
import birthcertificate.processors.BCProcessor;
import birthcertificate.processors.JsonProcessor;

public class RouteBuilder extends org.apache.camel.builder.RouteBuilder{

	@Override
	public void configure() throws Exception {

		from("activemq:queue:queue.birthcertificates").process(new JsonProcessor()).to("stream:out");
		from("activemq:queue:queue.birthIDs").process(new BCProcessor() );
		 
	}

}
