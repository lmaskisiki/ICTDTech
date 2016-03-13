package feedsApp.messageBeans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;

import feedsApp.entities.FeedList;
import feedsApp.entities.Feeds;
import feedsApp.sessionBeans.FeedServiceRemote;

/**
 * Message-Driven Bean implementation class for: FeedMessanger
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "JMSBridgeTargetQ") }, mappedName = "JMSBridgeTargetQ")
public class FeedMessanger implements MessageListener {

	private Destination replyTo;
	@Inject
	private JMSContext jcontext;

	@EJB
	private FeedServiceRemote service;

	public FeedMessanger() {

	}

	// take the marshalled file and convert it Xml data String
	private String Xml_toString(File file) {
		BufferedReader br;
		StringBuilder sb = new StringBuilder();
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line.trim());
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public String singleMarshaller(Feeds feed) {
		String results = null;
		try {
			File file = new File("data.xml");
			JAXBContext jaxbc = JAXBContext.newInstance(Feeds.class);
			Marshaller ms = jaxbc.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(feed, file);
			results = Xml_toString(file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return results;
	}

	public String listMarshaller(List<Feeds> listFeeds) {
		String results = null;
		try {
			File file = new File("data.xml");
			JAXBContext jaxbc = JAXBContext.newInstance(FeedList.class);
			Marshaller ms = jaxbc.createMarshaller();
			FeedList list = new FeedList();
			list.setListFeeds(listFeeds);
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(list, file);
			results = Xml_toString(file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return results;
	}

	public void onMessage(Message message) {
 		// replyTo = message.getJMSReplyTo();
		System.out.println("Inside onMessage method");
		if (message instanceof TextMessage) {
			List<Feeds> fds = service.Listfeeds();

			String textMsg;
			try {
				Feeds fd = new Feeds();
				fd.setFeedId(4);
				fd.setBody("hahahahahahha");
				fd.setCategory("mhmhmhmhm");
				fd.setTitle("tltltltltl");
				textMsg = ((TextMessage) message).getText();
				if (textMsg.equals("loadFeeds")) {
					System.out.println(" message recieved  : " + textMsg);
					String xmlString = listMarshaller(fds);
					System.out.println("your xml date string below : \n "
							+ xmlString);
				}

			} catch (JMSException e) {
				// TODO Auto-generated catch blockfds
				e.printStackTrace();
			}

		}

	}

}
