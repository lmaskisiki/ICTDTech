package webframe.sys;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SystemMessage implements Serializable {
	private boolean sucess;
	private HashMap<String, String> messages;
	private boolean hasException;

	public boolean isSucess() {
		return sucess;
	}

	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}

	public HashMap<String, String> getMessages() {
		return messages;
	}

	public void setMessages(HashMap<String, String> messages) {
		sucess=false;
		this.messages = messages;
	}

	public boolean HasException() {
				return hasException;
	}

	public void HasException(boolean hasException) {
		sucess=false;
		this.hasException = hasException;
	}
}
