package infosource.routebuilders;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import webframeapp.interfaces.FindByCreator;
import webframeapp.servicelogic.DomainService;
 
 
public class UniversalMarshaller {

	public String toXML() {
		FindByCreator userfile=new FindByCreator();;
		userfile.setArg0("Lizo");
		File file;
		String out = null;
		try {
			file = File.createTempFile("person", ".xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(FindByCreator.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(userfile, file);
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
