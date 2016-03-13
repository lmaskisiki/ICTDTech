package sessionBeans;

import java.util.List;

import javax.ejb.Local;

import entities.FileInfo;

@Local
public interface FileServiceLocal {
	public boolean addFile(FileInfo file,String fileSource);
	public boolean updateFile(int key,FileInfo info);
	public boolean removeFile(int key);
	public FileInfo findByName(String fileOnwer,String fileName);
	public List<FileInfo> getFiles();
	public List<FileInfo> getFiles(String fileOwner);

}
