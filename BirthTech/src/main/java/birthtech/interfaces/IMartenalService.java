package birthtech.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import birthtech.entities.Patient;
@Service
public interface IMartenalService {
	public boolean addMaternity(Patient mat);
	public Patient getMaternityById(int registeredId);
	public Patient getMaternityByFullname(String fullname);
	public List<Patient> getMartenal();
}
//savedCheckup
//maternity