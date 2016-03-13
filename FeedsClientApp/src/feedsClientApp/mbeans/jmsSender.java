package feedsClientApp.mbeans;

 
import java.io.File;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.NamingException;

@ApplicationScoped
public class jmsSender {
 
 
	@Inject
	private JMSContext jcontext;
	
	 @Resource(mappedName = "java:/queue/JMSBridgeSourceQ")
	private Queue queue;

	 

	public void sendMessage(String str) {
		try {
			 
			 jcontext.createProducer().send(queue,str);
			System.out.println("message sent!"+jcontext.getSessionMode());
		 
		} catch (Exception c) {
			c.printStackTrace();
		}

		System.out.println("message sender reached");
	}

	//JMS sends a text message to to Destination type: - Queue
	public static void main(String[] args) throws NamingException {
		//new jmsSender().sendMessage("lizo masikisiki");
		

		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
