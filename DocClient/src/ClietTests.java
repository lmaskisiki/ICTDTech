import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sessionBeans.FileService;
import sessionBeans.FileServiceRemote;
import entities.FileInfo;

public class ClietTests  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClietTests() {

	}

	public static void main(String[] args) throws NamingException,
			IOException {

		FileServiceRemote fs = (FileServiceRemote) InitialContext
				.doLookup("DocProject/DocMan/FileService!sessionBeans.FileServiceRemote");
		System.out.println("Done...");
		String fil = "/home/lizo/Desktop/feedback3.pdf";
		
		FileInfo fi = new FileInfo();
		fi.setFileName("facebookFile");
		fi.setUploadedBy("Lizo_Masikisiki");
		fi.setFilePath(fi.getUploadedBy().trim().replace(" ", "_"));
		fi.setUploaded(new Date());

		File firstLocalFile = new File(fil);
		InputStream inputStream;
		inputStream = new FileInputStream(firstLocalFile);
		 
		System.out.println(inputStream);
		fs.addFile(fi, "", inputStream);
		inputStream.close();
		//fs.findByName(fi.getUploadedBy(), fi.getFileName());*/

		System.out.println("Done...");

		try {
			Thread.sleep(Integer.MAX_VALUE);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
