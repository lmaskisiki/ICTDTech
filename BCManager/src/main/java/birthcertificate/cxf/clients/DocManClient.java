package birthcertificate.cxf.clients;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import docman.services.FileInfo;
import docman.services.FileService;
import docman.services.FileServiceRemote;
import useraccount.soap.services.PersonInterface;

public class DocManClient {
	private FileServiceRemote client ;
	public DocManClient() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"META-INF/cxf-context.xml");
	  client = (FileServiceRemote) context
				.getBean("DocManClient");
	}
	
	 public List<FileInfo> getDocument(String requester,String docOwner){
		 List<FileInfo> docs= new ArrayList<FileInfo>();
		 try{
			docs= client.getUserDocuments(requester,docOwner);
		 }catch(Exception ex){
			 System.out.println("Exception thrown while searching for docmument : \n"+ex.getClass());
		 }
	 return docs;
	 }
}
