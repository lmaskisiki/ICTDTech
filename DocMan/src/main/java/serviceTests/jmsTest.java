package serviceTests;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.jms.JMSException;

import messaging.UFinder;

 
public class jmsTest {
	 
 

	public static void main(String[] args) throws JMSException {
UFinder uf= new UFinder();
		uf.findRequest("admin");

	}

}
