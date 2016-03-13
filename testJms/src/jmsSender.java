

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@ApplicationScoped
public class jmsSender {

	@Resource(mappedName = "jms/RemoteConnectionFactory")
	private ConnectionFactory cf;

	@Inject
	private JMSContext jcontext;
	@Resource(mappedName = "jms/queue/testQueue")
	private Queue queue;

	public jmsSender() throws NamingException {
		// this.cf=InitialContext.doLookup("jms/RemoteConnectionFactory");
		// this.queue=InitialContext.doLookup("jms/queue/testQueue");

	}

	public void sendMessage(String msg) {
		try {
			 
			jcontext.createProducer().send(queue, msg);
			System.out.println("message sent!");
		} catch (Exception c) {
			c.printStackTrace();
		}

		System.out.println("message sender reached");
	}

	public static void main(String[] args) throws NamingException {
		new jmsSender().sendMessage("lizo masikisiki");
		

		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@PostConstruct
	public void init() throws NamingException{
		
	 
		
	}

}
