package birthtech.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import birthtech.entities.Checkup;
import birthtech.entities.Patient;
import birthtech.interfaces.ICheckupService;
import birthtech.repositories.CheckupRepository;

@Service
public class CheckupService implements ICheckupService {
	@Autowired
	private CheckupRepository checkupRepo;

	@Autowired
	private PatientService MartenalService;

	@Override
	public Checkup addCheckup(Checkup checkup) {
		Checkup result = null;
		if (checkup == null) {
			throw new NullPointerException("Checkup object not initialized");
		}
		try {
			result = checkupRepo.save(checkup);
		} catch (Exception e) {
			
			System.out.print("\n Exception Thrown");
		}

		return result;
	}

	@Override
	public List<Checkup> getCheckups() {
		return checkupRepo.findAll();
	}

	@Override
	public List<Checkup> getCheckups(String fullname) {
		List<Checkup> checkups = checkupRepo.findAll();
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
		List<Checkup> checkups = checkupRepo.findAll();
		List<Checkup> checkupsFound = new ArrayList<Checkup>();
		if (checkups != null) {
			for (Checkup checkup : checkups) {
				if (checkup.getMartenalId() == maternalId) {
					checkupsFound.add(checkup);
				}
			}
		}
		return checkupsFound;
	}

	@Override
	public Checkup getCheckupById(int key) {
		List<Checkup> checkups = checkupRepo.findAll();
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
		List<Patient> martenal = MartenalService.getMartenal();
		for (Patient mat : martenal) {
			if ((mat.getNames() + " " + mat.getSurname()).equals(fullname)
					|| (mat.getSurname() + " " + mat.getSurname())
							.equals(fullname)) {
				martenalId = mat.getPid();
				System.out.println("ID found :" + martenalId);
				checkup = checkupRepo.findOne(martenalId);
				break;
			}
		}
		return checkup;
	}
}
