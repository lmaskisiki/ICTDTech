package sessionBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.net.ftp.FTPClient;

import entities.FileInfo;
import ftp.FTPConnection;

/**
 * Session Bean implementation class FileService
 */
@Stateless
@LocalBean
public class FileService implements FileServiceRemote, FileServiceLocal {

	@PersistenceContext(unitName = "DocManager")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public FileService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addFile(FileInfo file, String fileSource) {
		FTPClient ftpClient = new FTPConnection().connect();
		File firstLocalFile = new File(fileSource);
		InputStream inputStream;
		boolean done = false;
		try {
			inputStream = new FileInputStream(firstLocalFile);
			System.out.println("Start uploading first file");

			boolean newdir = ftpClient.makeDirectory(file.getFilePath());
			String filePath = file.getFilePath() + "//" + file.getFileName();
			done = ftpClient.storeFile(filePath, inputStream);
			if (done) {
				file.setFilePath(filePath);
				em.persist(file);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (done) {
			System.out.println("File was successfully uploaded!!!");
		} else {
			System.out.println("Something went wrong :( ");
		}

		return false;
	}

	@Override
	public FileInfo findByName(String fileOnwer, String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateFile(int key, FileInfo info) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeFile(int key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<FileInfo> getFiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileInfo> getFiles(String fileOwner) {
		// TODO Auto-generated method stub
		return null;
	}

}