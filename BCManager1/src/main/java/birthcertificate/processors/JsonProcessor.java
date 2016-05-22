package birthcertificate.processors;
 

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
public class JsonProcessor implements Processor {
 ;
	
	
	
	@Override
	public void process(Exchange exch) throws Exception {	
			 
		 JSONParser psr=new JSONParser();
		 Person p= new Person();
		 p.setName("lizo");
		 p.setSurname("masikisiki");
		 JSONObject ob=(JSONObject) psr.parse("\'name\' : \' lizo \'");
	System.out.println("from json object:"+ob.get(0));
	}

}
