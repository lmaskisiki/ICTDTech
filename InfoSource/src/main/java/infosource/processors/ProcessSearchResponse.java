package infosource.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class ProcessSearchResponse  implements Processor{

	@Override
	public void process(Exchange response) throws Exception {
		///response.getIn().setHeader("test", "lizo");
	 System.out.print("lizo \n \n \n");
	 response.getOut().setHeader("operationName", "getAllDomains");
	 response.getOut().setHeader("defaultOperationName", "getAllDomains");
		///System.out.println(   response.getIn().getBody().toString());
	}

}
