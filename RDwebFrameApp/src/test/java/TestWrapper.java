import static org.junit.Assert.*;

import org.junit.Test;

import usergate.classes.Person;
import webFrame.ws.integration.DocsClient;
import webFrame.ws.integration.PersonWrapper;
import webFrame.ws.integration.UASclient;
import webFrame.ws.integration.UniversalMarshaller;


public class TestWrapper {

	//@Test
	public void test() {
		 UASclient cl=new UASclient(); 
		 Person ps=cl.findPerson("admin");
		PersonWrapper pw=new PersonWrapper();
	
		pw.setP(ps);
		pw.setFiles(new DocsClient().getFile("admin"));
		
		UniversalMarshaller u= new UniversalMarshaller();
		
		System.out.print("Cell:"+u.toXML(pw));
	}

}
