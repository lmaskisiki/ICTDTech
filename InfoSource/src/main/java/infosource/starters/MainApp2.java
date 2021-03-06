package infosource.starters;

import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.SOAPBody;

import infosource.routebuilders.SearchRouteBuilder;
import infosource.routebuilders.UniversalMarshaller;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.main.Main;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import webframeapp.interfaces.CreateDomain;
import webframeapp.interfaces.FindByCreator;
import webframeapp.interfaces.GetAllDomainsResponse;
 
public class MainApp2 {

	private ApplicationContext context;
	private CamelContext camelContext;

	public MainApp2() {

		try {
			this.context = new ClassPathXmlApplicationContext(
					"META-INF/camel-conf.xml");
			this.camelContext = SpringCamelContext.springCamelContext(context);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendMessage(String msg) {

		try {
			ProducerTemplate template = this.camelContext
					.createProducerTemplate();
			template.start();
			///template.setDefaultEndpointUri("cxf:bean:ws");
			 
			String [] arr={"Lizo Masikisiki","IntDomain","Integration","intOrg","0788329139","tests integration"};
			
			List<String> lst=new ArrayList<String>();
			for(String s:arr){
				lst.add(s);
			}
			CreateDomain create = new CreateDomain();
			create.setArg0(arr[0]);
			create.setArg0(arr[1]);
			create.setArg0(arr[2]);
			create.setArg0(arr[3]);
			create.setArg0(arr[4]);
			create.setArg0(arr[5]);
			/**/
	  template.sendBody("direct:go","message");;
			
			//FindByCreator f=new FindByCreator();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		System.out.println("Main App Started...");
	      
		 new MainApp2().sendMessage("Lizo");
	 
	}

}
