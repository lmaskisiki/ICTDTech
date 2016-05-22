package birthtech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import useraccount.soap.services.AccountService;
import useraccount.soap.services.FindByUsernameResponse;
import useraccount.soap.services.FindSomeoneResponse;
import useraccount.soap.services.Person;
import useraccount.soap.services.PersonInterface;
import birthtech.entities.Maternity;
import birthtech.interfaces.IMartenalService;
import birthtech.repositories.MartenalRepository;

@Service
public class MartenalService implements IMartenalService {

	@Autowired
	private MartenalRepository repo;
private 		AccountService remoteService;
	@Override
	public boolean addMaternity(Maternity mat) {
		Person user=findRemoteAccount("pnomnga");
		//repo.save(mat);
		
		System.out.println(user.getLastName()+" "+user.getFirstName()+" :"+user.getDn());
		System.out.println("New Maternity was successfully added...");
		return true;
	}

	@Override
	public List<Maternity> getMartenal() {
		return repo.findAll();
	}

	@Override
	public Maternity getMaternityById(int id) {
		Maternity found = null;
		for (Maternity mat : repo.findAll()) {
			if (mat.getIdnumber() == id) {
				found = mat;
				break;
			}
		}
		return found;
	}
	@Override
	public Maternity getMaternityByFullname(String fullname) {
		Maternity found = null;
		for (Maternity mat : repo.findAll()) {
			if (mat.getSurname()+" "+mat.getNames() == fullname) {
				found = mat;
				break;
			}
		}
		return found;
	}
	
	public Person findRemoteAccount(String idNumber){
		PersonInterface servicePort=remoteService.getAccountSOAPOverHTTP();
		Person user=	servicePort.findByUsername(idNumber);
		return user;
	}
}
