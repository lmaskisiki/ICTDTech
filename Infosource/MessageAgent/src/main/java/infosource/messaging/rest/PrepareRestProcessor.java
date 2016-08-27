package infosource.messaging.rest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.activemq.memory.list.MessageList;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.cxf.endpoint.ClientImpl.EchoContext;
import org.apache.cxf.message.MessageContentsList;

public class PrepareRestProcessor implements org.apache.camel.Processor {
	SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.setPattern(ExchangePattern.InOut);
		Message in = exchange.getIn();
		in.setHeader(CxfConstants.OPERATION_NAME, "labourevent");
		in.setHeader(CxfConstants.CAMEL_CXF_RS_USING_HTTP_API, Boolean.FALSE);
		String today = fmt.format(new Date());
		// String today="2016-06-20"; //TEST DATA
		MessageContentsList Request = new MessageContentsList();
		Request.add(today);
		in.setBody(Request);
		exchange.setOut(in);
		exchange.setIn(in);
	}

}
