package birthtech.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import birthtech.entities.Labour;
import birthtech.entities.Martenal;
import birthtech.interfaces.ILabourService;
import birthtech.repositories.LabourRepository;

@Service
public class LabourService implements ILabourService {
	@Autowired
	private LabourRepository repo;

	@Override
	public boolean addLabour(Date date, String place, int status,
			Martenal parent, String nurse, int birthnumber) {
		Labour labour = new Labour();
		labour.setBirthNo(birthnumber);
		labour.setLabourDate(date);
		labour.setMartenal(parent);
		labour.setStatus(status);
		labour.setNurse(nurse);
		Labour labourSaved = repo.save(labour);
		return labourSaved == null ? false : true;
	}

	@Override
	public Labour getLabour(int lid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Labour> getLabour() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Labour> getLabour(Martenal martenal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Labour> getLabour(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

}
