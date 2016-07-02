package birthtech.messaging;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import birthtech.entities.Child;
import birthtech.entities.Labour;
import useraccount.soap.services.Person;

public class UniversalMarshaller {

	public String toXML(Labour labour) {
		Labour lab= labour;
		File file;
		String out = null;
		try {
			file = File.createTempFile("Labour", ".xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(birthtech.entities.Labour.class);
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

}
