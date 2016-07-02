package birthcertificate.routebuilders;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sun.jmx.remote.internal.Unmarshal;

import birthcertificate.entities.Labour;
import birthcertificate.processors.Person;
 
public class UniversalMarshaller {

	public String toXML(Labour labour) {
		Labour lab= labour;
		File file;
		String out = null;
		try {
			file = File.createTempFile("Labour", ".xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Labour.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(lab, file);
			out = new String(Files.readAllBytes(file.toPath()));
			file.deleteOnExit();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return out;
	}
	public Person  fromXML(String xmlDcoument){
		JAXBContext jaxbContext;
		Person person=null;
		try {
			jaxbContext = JAXBContext.newInstance(Person.class);
	 		Unmarshaller unmarshal= jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(xmlDcoument);
			  person= (Person) unmarshal.unmarshal(reader);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	
		return person;
	}
}
