package serviceTests;

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

	private static EJBContainer ejbC;
	private static Context ctx;

	@BeforeClass
	public static void setUp() {
		ejbC = EJBContainer.createEJBContainer();


		System.out.println("OK.");

	}

	@AfterClass
	public static void tearDown() {
		ejbC.close();
		System.out.println("Owryt...");

	}

	@Test
	public void test() throws NamingException {
		FileService fs = (FileService) ejbC.getContext()
				.lookup("java:global/DocManager/FileService!docman.services.FileService");
		String fil = "/home/lizo/Desktop/feedback.pdf";
		FileInfo fi = new FileInfo();
		fi.setFileName("facebookfile");
		fi.setUploadedBy("Lizo Masikisiki");
		fi.setFilePath(fi.getUploadedBy().trim().replace(" ", "_"));
		fi.setUploaded(new Date());
		// fs.addFile(fi, fil);
		System.out.println("Done...");

	}

}
