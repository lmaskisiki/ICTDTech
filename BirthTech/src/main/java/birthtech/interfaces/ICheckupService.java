package birthtech.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import birthtech.entities.Checkup;

@Service
public interface ICheckupService {
	public Checkup addCheckup(Checkup checkup);

	public List<Checkup> getCheckups();
	public List<Checkup> getCheckups(String fullname);
	public Checkup getCheckupById(int key);
	public Checkup getCheckup(String fullname);

	public List<Checkup> getCheckups(int maternalId);
	
}


