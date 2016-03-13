import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import sessionbeans.*;;

public class App {

	public static void main(String[] args) throws MalformedURLException {
		Service ser=Service.create(new URL("http://localhost:8080/DocMan/FileService?wsdl"), 
				new QName("http://sessionBeans/", "FileServiceService"));
		FileServiceRemote fs =  ser.getPort(FileServiceRemote.class);
		FileInfo file=fs.getFilesByOwner("admin").get(1);
		System.out.println(file.getFileName()+" "+file.getUploadedBy()+" "+file.getFilePath());
		
		

	}

}
