package feedsApp.messageBeans;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Message-Driven Bean implementation class for: FeedMessanger
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"), @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "JMSBridgeTargetQ")
		}, 
		mappedName = "JMSBridgeTargetQ")
public class FeedMessanger implements MessageListener {

    /**
     * Default constructor. 
     */
    public FeedMessanger() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
       System.out.println("Message Recieved!!!");
        
    }

}
