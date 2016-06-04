package docman.services;

import java.io.InputStream;
import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import entities.FileInfo;
import entities.FileRequest;
import entities.FileShare;

@Remote
@WebService
public interface FileServiceRemote {

	@WebMethod
	public boolean addFile(@WebParam(name="file") FileInfo file, @WebParam String ext, @WebParam InputStream is);
	@WebMethod
	public boolean updateFile(@WebParam(name="fileId") int key, @WebParam(name="updates") FileInfo info);
	@WebMethod
	public boolean removeFile(@WebParam(name="fileId") int key);
	@WebMethod
	public boolean downloadFile(@WebParam(name="remotePath")String remotePath, @WebParam(name="localDestionation")String localDest);
	@WebMethod
	public FileInfo getFileById(@WebParam(name="username")String username, @WebParam(name="fileId") int Id);
	@WebMethod
	public FileInfo getFileByUsername(@WebParam(name="username")String username);
	@WebMethod
	public FileInfo findByName(@WebParam(name="fileOwner")String fileOnwer, @WebParam(name="fileName")String fileName);
	@WebMethod
	public List<FileInfo> getFiles();
	@WebMethod
	public List<FileInfo> getFilesByOwner(@WebParam(name="fileOwner") String fileOwner);
	// requests
	@WebMethod
	public boolean saveRequest(@WebParam(name="fileRequest")FileRequest request);
	@WebMethod
	public boolean removeRequest(@WebParam(name="fileRequest")FileRequest request);
	@WebMethod
	public FileRequest findRequestById(@WebParam(name="requestId") int reqId);
	@WebMethod
	public List<FileRequest> getRequests(@WebParam(name="requestsFor" )String forUser);
	// shares
	@WebMethod
	public boolean shareFile(@WebParam(name="fileInfo") FileInfo fi, @WebParam(name="shareWith") String shareWith);
	@WebMethod
	public List<FileShare> getSahres(@WebParam(name="sharedWith") String useredWith);
}
