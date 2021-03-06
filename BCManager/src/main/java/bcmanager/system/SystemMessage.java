package bcmanager.system;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SystemMessage {
	String message;
	MessageType messageType;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public boolean HasExceptions() {
		return message.equals(messageType.Exception) ? true : false;
	}
}
