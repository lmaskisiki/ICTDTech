package infosource.messaging.router;

import infosource.messaging.soap.RequestResponseMessage;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import birthcertificate.ews.soap.Approved;

public class GrantApplicationProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		RequestResponseMessage req = new RequestResponseMessage();
		exchange.getIn().setBody(req.RequestApproved(),
				Approved.class);
	}


}
