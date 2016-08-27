package infosource.upservice.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.message.MessageContentsList;

public class UAServiceProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		MessageContentsList m = new MessageContentsList();
		m.add(exchange.getIn().getBody(String.class));
		exchange.getOut().setBody(m);
	 
	}

}
