package infosource.processors;
 

import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import webframeapp.interfaces.GetAllDomains;
 

public class ProcessSOAPOUT  implements Processor{
	private   Logger log =(Logger) LoggerFactory.getLogger(ProcessSOAPOUT.class);

	@Override
	public void process(Exchange msg) throws Exception {
		String [] arr={"Lizo Masikisiki","IntDomain","Integration","intOrg","0788329139","tests integration"};
		
		List<String> lst=new ArrayList<String>();
		for(String s:arr){
			lst.add(s);
		}
	 
		msg.getOut().setBody(lst);
		msg.getOut().setHeader("OperationNamespace", "http://interfaces.webFrameApp/");
			
	}

}
