package mbeans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.TextMessage;

import docman.services.FileService;
import messaging.UFinder;
import entities.FileInfo;
import entities.FileRequest;
import entities.FileShare;

@javax.faces.bean.ManagedBean
@SessionScoped
public class NavController implements Serializable {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@EJB
	private FileService fileservice;

	// /@Resource(name = "Messeger")
	@Inject
	private JMSContext context;

	@Resource(mappedName = "java:/jms/queue/SearchRequest")
	private Queue requestQ;

	@Resource(mappedName = "java:/jms/queue/SearchResponse")
	private Queue resQ;
	private UFinder uf;

	private List<FileInfo> files;
	private List<FileRequest> fileRequests;
	private List<FileShare> shares;

	@PostConstruct
	public void init() {
		String user = FacesContext.getCurrentInstance().getExternalContext()
				.getRemoteUser();
		shares = fileservice.getSahres(user);

	}

	public List<FileShare> getShares() {
		return shares;
	}

	public void setShares(List<FileShare> shares) {
		this.shares = shares;
	}

	public List<FileInfo> getFiles() {
		return files;
	}

	public void setFiles(List<FileInfo> files) {
		this.files = files;
	}

	public String browseFiles() throws JMSException {
		String user = FacesContext.getCurrentInstance()
				.getExternalContext().getRemoteUser();
		files = fileservice.getFilesByOwner(FacesContext.getCurrentInstance()
				.getExternalContext().getRemoteUser());
		files = fileservice.getFilesByOwner(user);
	 
		return "listfiles";
	}

	public String showFile(String fileId) throws FileNotFoundException {
		System.out.println("file Id is:" + fileId);
		FileInfo fi = fileservice
				.getFileById("user3", Integer.parseInt(fileId));
		File f = new File("/home/lizo/Desktop/" + fi.getFileName() + ".pdf");
		// FileOutputStream fos = new FileOutputStream(f.getAbsolutePath());
		System.out.println(f.getAbsolutePath());
		boolean dwn = fileservice.downloadFile(fi.getFilePath(),
				f.getAbsolutePath());
		return "index";
	}

	private String searchName;

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String searchForFile() {
		if (searchName != null) {
			System.out.println("the search string is: " + searchName);
			boolean isBank = FacesContext.getCurrentInstance()
					.getExternalContext().isUserInRole("SAGOV");
			if (isBank) {
				files = fileservice.getFilesByOwner(searchName);
				System.out.println("The user is a member of Bank"
						+ files.size());
			}
		}
		return "search";
	}

	public String requestFile(String Id) {
		FileInfo fi = fileservice.getFileById("", Integer.parseInt(Id));
		FileRequest req = new FileRequest();
		req.setFile(fi);
		req.setReqFrom(FacesContext.getCurrentInstance().getExternalContext()
				.getRemoteUser());
		req.setReqTo(fi.getUploadedBy());
		System.out.println("Save Request Below for file :" + Id);
		fileservice.saveRequest(req);
		return "";
	}

	public List<FileRequest> getFileRequests() {
		return fileRequests;
	}

	public void setFileRequests(List<FileRequest> fileRequests) {
		this.fileRequests = fileRequests;
	}

	public String listRequest() {
		String user = FacesContext.getCurrentInstance().getExternalContext()
				.getRemoteUser();

		fileRequests = fileservice.getRequests(user);
		// listRequest.get(0).getFile().
		return "requests";
	}

	public String shareFile(String Id, String shareWith, String requestId) {
		int fileId = Integer.parseInt(Id);
		int reqId = Integer.parseInt(requestId);
		FileInfo fi = fileservice.getFileById("", fileId);
		boolean fileShared = fileservice.shareFile(fi, shareWith);
		System.out.println("Successfully Shared!!!");
		// remove the request now
		FileRequest fr = fileservice.findRequestById(reqId);
		fileservice.removeRequest(fr);
		return "requests";
	}

	public String myShares() {
		String user = FacesContext.getCurrentInstance().getExternalContext()
				.getRemoteUser();
		shares = fileservice.getSahres(user);
		return "shares";
	}

	public void getSharedFile(String serverPath, String fileName) {

		File f = new File("/home/lizo/Desktop/" + fileName + ".pdf");
		fileservice.downloadFile(serverPath, f.getAbsolutePath());
		System.out.println("The File Was successfully Downloaded"
				+ f.getAbsolutePath());
	}
}