package infosource.health.ematclinic.processors;

import java.util.ArrayList;
import java.util.List;

import org.apache.activemq.memory.list.MessageList;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.message.MessageContentsList;

import useraccount.soap.services.FindByUsername;
import useraccount.soap.services.FindByUsernameResponse;

public class UASearchProcessor implements Processor {

	@Override
	public void process(Exchange exc) throws Exception {
		List list = new ArrayList<>();
		//MessageContentsList lst = (MessageContentsList) exc.getIn().getBody();
		//exc.getOut().setBody("lizo",FindByUsername.class);
	// exc.getOut().setHeader("OperationName", "findByUsername");

	}

}
