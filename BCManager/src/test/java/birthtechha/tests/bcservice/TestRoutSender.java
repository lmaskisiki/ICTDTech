package birthtechha.tests.bcservice;

import org.junit.Test;

import birthcertificate.services.MessageSender;

public class TestRoutSender {

	//@Test
	public void should_send_full_as_as_search_string_to_find_parent(){
		
		MessageSender sender= new MessageSender();
		System.out.println(sender.sendMessage("Lizo Masikisiki"));
	}
	//@Test
	public void should_send_full_as_as_search_string_to_find_parent_as_person_object(){
		
		MessageSender sender= new MessageSender();
		System.out.println("RESPONE IN XML"+sender.sendMessage("Lizo Masikisiki"));
	}
}
