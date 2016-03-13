package feedsClientApp.marshalling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import feedsApp.entities.Feeds;
public class Marshaler {
	private JAXBContext jcontext;

	public Marshaler() throws JAXBException {
	}

	public String XmlData(Feeds feed) {
		String xmlData = null;
		File file = new File("data.xml");
		try {
			jcontext = JAXBContext.newInstance(feedsApp.entities.Feeds.class);
			Marshaller ms = jcontext.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(feed, new File("data.xml"));
			xmlData = Xml_toString(file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return xmlData;
	}

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

}
