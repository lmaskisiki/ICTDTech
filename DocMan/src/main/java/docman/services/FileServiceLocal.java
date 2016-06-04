package docman.services;

import java.io.InputStream;
import java.util.List;

import javax.ejb.Local;
import javax.jws.WebService;

import entities.FileInfo;
import entities.FileRequest;
import entities.FileShare;

@Local
@WebService
public interface FileServiceLocal {
	public boolean addFile(FileInfo file,String ext, InputStream is);
	public boolean updateFile(int key,FileInfo info);
	public boolean removeFile(int key);
	public FileInfo getFileById(String username,int Id);
	public FileInfo getFileByUsername(String username);
	public  boolean downloadFile(String remotePath,String localDest);
	public FileInfo findByName(String fileOnwer,String fileName);
	public List<FileInfo> getFiles();
	public List<FileInfo> getFilesByOwner(String fileOwner);
	//requests
	public boolean saveRequest(FileRequest request);
	public boolean removeRequest(FileRequest request);
	public FileRequest findRequestById(int reqId);
	public List<FileRequest> getRequests(String forUser);
	//shares
	public boolean shareFile(FileInfo fi,String shareWith);
	public List<FileShare> getSahres(String useredWith);
	

}
