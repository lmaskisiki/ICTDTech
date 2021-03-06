package mbeans;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.servlet.http.Part;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import docman.services.FileService;
 import entities.FileInfo;

@ManagedBean
@ViewScoped
public class Upload implements Serializable {
	/**
	 * 
	 */
	@EJB
	private FileService fileservice;
	private String FullName;
	private String FileName;
	private String FPath;
	private Part file;
	private java.util.Date uploaded;

	@Inject
	private JMSContext context;

	@Resource(mappedName = "java:/jms/queue/SearchRequest")
	private Queue requestQ;

	private static final long serialVersionUID = 1L;

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public String getFPath() {
		return FPath;
	}

	public void setFPath(String fPath) {
		FPath = fPath;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public java.util.Date getUploaded() {
		return uploaded;
	}

	public void setUploaded(java.util.Date uploaded) {
		this.uploaded = uploaded;
	}

	public void uploadFile() {
		try {
			Service ser = Service.create(new URL(
					"http://localhost:8080/userGate/AccountService?wsdl"),
					new QName("http://services.soap.useraccount/", "AccountService"));
			useraccount.soap.services.PersonInterface userService = ser.getPort(useraccount.soap.services.PersonInterface.class);
			String user = FacesContext.getCurrentInstance()
					.getExternalContext().getRemoteUser();
			if (user != null) {
				useraccount.soap.services.Person person = null;
				person = userService.findByUsername(user);
				String fullname = null;
				if (person != null) {
					fullname = person.getLastName() + " "
							+ person.getFirstName();
					if (!fullname.equals(null)) {
						FileInfo fi = new FileInfo();
						fi.setUploaded(new java.util.Date());
						fi.setUploadedBy(user);
						fi.setFilePath(fi.getUploadedBy().replace(" ", "_")+"/"+FileName);
						fi.setFileName(FileName);
						InputStream in = file.getInputStream();
						fileservice.addFile(fi, "", in);
						System.out.println("File saved successfully");

					}else{
						System.out.println("This Account Does Not Have Full Name");
					}
				}else{
					System.out.println("No user founf with this username");
				}
			}else{
				System.out.println("Please login again to get a valid session.");
			}

		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
