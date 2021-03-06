package infosource.starters;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class RouteBuilserTest{
	CamelContext context=null;
	ProducerTemplate template =null;
	public RouteBuilserTest() {
		System.out.println("Test the route below...\n");
	  context = new DefaultCamelContext();
	  template = context.createProducerTemplate();
		try {
			context.addRoutes(new RouteBuilder() {
			    public void configure() {
			        from("direct:starts").to("file://test");
			    }
			});
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		try {
			template.start();
			for (int i = 0; i < 10; i++) {
			    template.sendBody("direct:start", "Test Message: " + i);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
	
	new RouteBuilserTest();

	}

 
}
