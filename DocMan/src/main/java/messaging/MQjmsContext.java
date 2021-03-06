package messaging;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MQjmsContext {
	public boolean getJMSContextAMQ(Destination dest,Object object){
		Connection connection =null;
		try {
			 
	        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
	          connection = connectionFactory.createConnection();
	        connection.start();
	        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        Destination destination = dest;
	        MessageProducer producer = session.createProducer(destination);
	        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        // Create a messages
	        TextMessage message = (TextMessage) object;
	        producer.send(message);
	        
	        
	        String text = "Hello world! From: " + Thread.currentThread().getName();
	       
	        // Tell the producer to send the message
	        System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
	   
		}
		
		catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return false;
	}
}
