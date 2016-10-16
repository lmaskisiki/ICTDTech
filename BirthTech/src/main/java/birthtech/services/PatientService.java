package birthtech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import useraccount.soap.services.AccountService;
import useraccount.soap.services.FindByUsernameResponse;
import useraccount.soap.services.FindSomeoneResponse;
import useraccount.soap.services.Person;
import useraccount.soap.services.PersonInterface;
import birthtech.entities.Patient;
import birthtech.interfaces.IMartenalService;
import birthtech.repositories.MartenalRepository;

@Service
public class PatientService implements IMartenalService {

	@Autowired
	private MartenalRepository repo;
	private AccountService remoteService;

	@Override
	public boolean addMaternity(Patient mat) {
		boolean done = false;
		if (mat == null) {
			throw new NullPointerException("Null Reference");
		}
		if(mat.getIdnumber()==0  || mat.getSurname()==null || mat.getNames()==null){
			throw new NullPointerException("Null or Empty Idenfifier Detected");
		}
		try {
			Patient patient = repo.save(mat);
			done = (patient == null) ? false : true;
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}
		return done;
	}

	@Override
	public List<Patient> getMartenal() {
		return repo.findAll();
	}

	@Override
	public Patient getMaternityById(int id) {
		Patient found = null;
		for (Patient mat : repo.findAll()) {
			if (mat.getIdnumber() == id) {
				found = mat;
				break;
			}
		}
		return found;
	}

	@Override
	public Patient getMaternityByFullname(String fullname) {
		if (fullname == null) {
			throw new NullPointerException();
		}
		Patient found = null;
		for (Patient mat : repo.findAll()) {
			if (mat.getSurname() + " " + mat.getNames() == fullname) {
				found = mat;
				break;
			}
		}
		return found;
	}

}
