package ftp;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

public class FTPConnection {
	private String ftpAddress = "localhost";
	private int port = 21;
	private String user = "admin";
	private String pass = "lizo@200903375";
	

	public FTPClient connect() {
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect(ftpAddress, port);
			ftpClient.login(user, pass);
			ftpClient.enterLocalPassiveMode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ftpClient;

	}
}
