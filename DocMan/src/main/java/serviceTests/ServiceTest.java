package serviceTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.swing.JFrame;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import docman.services.FileService;
import entities.FileInfo;

public class ServiceTest {
 

	//@Test
	public void test() throws NamingException, IOException {
		FileService fs = new FileService();
		System.out.println("Done...");
		String fil = "/home/lizo/Desktop/feedback.pdf";
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

	}

}
