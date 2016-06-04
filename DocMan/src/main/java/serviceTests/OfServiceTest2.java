package serviceTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
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

public class OfServiceTest2 {
 

	@Test
	public void test() throws NamingException, IOException {
		FileService fs = new FileService();
		 FileInfo fi=fs.getFileById("user3", 22);
		// boolean dwn=fs.downloadFile(fi.getFilePath(), "/home/Desktop/testDownload");

	}

}
