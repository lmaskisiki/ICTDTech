package messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.message.GenericMessage;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class SendSearchRequest {

	@Autowired
	@Qualifier("outChannel")
	private MessageChannel chennel;

	public SendSearchRequest() {
 
		  
		 ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/springIntegration.xml");
		 MessageChannel channel = context.getBean("outChannel", MessageChannel.class);
		 Message<String> message = MessageBuilder.withPayload("World").build();
	}
	
	
	
	
	public static void main(String [] args){
		
		new SendSearchRequest();
		System.out.println("Lizo");
		
	}
	
	
}
