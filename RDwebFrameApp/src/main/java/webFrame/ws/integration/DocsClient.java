package webFrame.ws.integration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceException;

import sessionbeans.FileInfo;
import sessionbeans.FileServiceRemote;

public class DocsClient {
	private Service ser;
	FileServiceRemote docService;

	public String[] getFile(String username) {
		List<FileInfo> files = docService.getFilesByOwner(username);
		String[] names = null;
		if (files != null) {
			names = new String[files.size()];
			int count = 0;
			for (FileInfo fi : files) {
				names[count] = fi.getFileName();
				count++;
			}
		}
		return names;
	}

	public DocsClient() {
		try {
			ser = Service.create(new URL(
					"http://localhost:8080/DocMan/FileService?wsdl"),
					new QName("http://sessionBeans/", "FileServiceService"));
			docService = ser.getPort(FileServiceRemote.class);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WebServiceException e) {
			System.out.println("Service could not be contacted");
		}
	}

}
