package infosource.open.services.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.message.MessageContentsList;

public class RemoteMethodHandler implements Processor{

	@Override
	public void process(Exchange exc) throws Exception {
	 	exc.getOut().setHeader("OperationName", exc.getIn().getHeader("methodName"));
	 	exc.getOut().setBody(exc.getIn().getBody());
		exc.getOut().setHeader("OperationNamespace", "http://interfaces.webFrameApp/");
	
}

}
