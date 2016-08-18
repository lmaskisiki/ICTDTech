package infosource.health.ematclinic.interfaces;

import infosource.health.ematclinic.models.Maternity;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface IMartenalService {
	public boolean addMaternity(Maternity mat);
	public Maternity getMaternityById(int registeredId);
	public Maternity getMaternityByFullname(String fullname);
	public List<Maternity> getMartenal();
}
//savedCheckup
//maternity