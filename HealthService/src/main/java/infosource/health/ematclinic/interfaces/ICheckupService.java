package infosource.health.ematclinic.interfaces;

import infosource.health.ematclinic.models.Checkup;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ICheckupService {
	public Checkup addCheckup(Checkup checkup);

	public List<Checkup> getCheckups();
	public List<Checkup> getCheckups(String fullname);
	public Checkup getCheckupById(int key);
	public Checkup getCheckup(String fullname);

	public List<Checkup> getCheckups(int maternalId);
	
}


