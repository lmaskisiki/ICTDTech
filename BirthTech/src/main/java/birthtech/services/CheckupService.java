package birthtech.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import birthtech.entities.Checkup;
import birthtech.entities.Maternity;
import birthtech.interfaces.ICheckupService;
import birthtech.repositories.CheckupRepository;

@Service
public class CheckupService implements ICheckupService {
	@Autowired
	private CheckupRepository repo;

	@Autowired
	private MartenalService MartenalService;

	@Override
	public Checkup addCheckup(Checkup checkup) {
		Checkup savedCheckup=repo.save(checkup);
		
		return savedCheckup;
	}

	@Override
	public List<Checkup> getCheckups() {
		return repo.findAll();
	}

	@Override
	public List<Checkup> getCheckups(String fullname) {
		List<Checkup> checkups = repo.findAll();
		List<Checkup> checkupsFound = new ArrayList<Checkup>();
		if (checkups != null) {
			for (Checkup checkup : checkups) {
				checkupsFound.add(checkup);
			}
		}
		return checkupsFound;
	}
	@Override
	public List<Checkup> getCheckups(int maternalId) {
		List<Checkup> checkups = repo.findAll();
		List<Checkup> checkupsFound = new ArrayList<Checkup>();
		if (checkups != null) {
			for (Checkup checkup : checkups) {
				if(checkup.getMartenalId()==maternalId){
				checkupsFound.add(checkup);
				}
			}
		}
		return checkupsFound;
	}
	@Override
	public Checkup getCheckupById(int key) {
		List<Checkup> checkups = repo.findAll();
		List<Checkup> checkupsFound = new ArrayList<Checkup>();
		if (checkups != null) {
			for (Checkup checkup : checkups) {
				if (checkup.getCheckupId() == key) {
					checkupsFound.add(checkup);
				}

			}
		}
		return checkupsFound.get(0);
	}

	@Override
	public Checkup getCheckup(String fullname) {
		int martenalId = 0;
		Checkup checkup = null;
		List<Maternity> martenal = MartenalService.getMartenal();
		for (Maternity mat : martenal) {
			if ((mat.getNames() + " " + mat.getSurname()).equals(fullname)
					|| (mat.getSurname() + " " + mat.getSurname())
							.equals(fullname)) {
				martenalId = mat.getMid();
				System.out.println("ID found :" + martenalId);
				checkup = repo.findOne(martenalId);
				break;
			}
		}
		return checkup;
	}
}
