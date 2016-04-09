package birthtech.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import birthtech.entities.Child;
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
		   repo.save(labour);
		   
		return false;
	}

	@Override
	public Labour getLabour(int lid) {
		List<Labour> listLabour = new ArrayList<Labour>();
		for (Labour labour : repo.findAll()) {
			if (labour.getLabourId() == lid) {
				listLabour.add(labour);
			}
		}
		return listLabour.get(0);
	}

	@Override
	public List<Labour> getLabour() {
		System.out.println("Labour service method- list invoked...");
		return repo.findAll();
	}

	@Override
	public List<Labour> getLabour(Martenal martenal) {
		List<Labour> listLabour = new ArrayList<Labour>();
		for (Labour labour : repo.findAll()) {
			if (labour.getMartenal() == martenal) {
				listLabour.add(labour);
			}
		}
		return listLabour;
	}

	@Override
	public List<Labour> getLabour(Date date) {
		List<Labour> listLabour = new ArrayList<Labour>();
		for (Labour labour : repo.findAll()) {
			if (labour.getLabourDate() == date) {
				listLabour.add(labour);
			}
		}
		return listLabour;
	}

}
