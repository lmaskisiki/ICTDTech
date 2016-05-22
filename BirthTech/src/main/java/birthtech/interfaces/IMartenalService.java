package birthtech.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import birthtech.entities.Maternity;
@Service
public interface IMartenalService {
	public boolean addMaternity(Maternity mat);
	public Maternity getMaternityById(int registeredId);
	public Maternity getMaternityByFullname(String fullname);
	public List<Maternity> getMartenal();
}
//savedCheckup
//maternity