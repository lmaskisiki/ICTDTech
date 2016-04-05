package birthtech.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import birthtech.entities.Martenal;
import birthtech.interfaces.IMartenalService;

@Service
public class MartenalService implements IMartenalService {

	@Override
	public boolean addMartenal(String fullname, Date date, String nurse) {
		Martenal mat= new Martenal();
		mat.setNames(fullname);
		System.out.println("New Martenal was successfully added...");
		return true;
	}

	@Override
	public List<Martenal> getMartenal() {
		// TODO Auto-generated method stub
		return null;
	}



}
