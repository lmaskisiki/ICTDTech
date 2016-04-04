package serviceTests;

import static org.junit.Assert.*;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.jms.JMSException;

import messaging.UFinder;

public class Test {

	@Inject
	private UFinder uf;
	@org.junit.Test
	public void test() throws JMSException {
		  
	}

}
