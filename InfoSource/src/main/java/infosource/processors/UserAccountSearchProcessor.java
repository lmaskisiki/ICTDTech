package infosource.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class UserAccountSearchProcessor implements Processor {
	@Override
	public void process(Exchange exchange) throws Exception {

			exchange.getOut().setHeader("operationName", "findUserByUsername");
			exchange.getOut().setHeader("operationNamespace", "http://interfaces.webFrameApp/");
	}
}
