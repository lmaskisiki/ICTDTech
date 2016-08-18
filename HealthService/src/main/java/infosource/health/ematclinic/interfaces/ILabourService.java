package infosource.health.ematclinic.interfaces;

import infosource.health.ematclinic.models.Labour;
import infosource.health.ematclinic.models.Maternity;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ILabourService {

	public boolean addLabour(Date date, String place, int status,
			Maternity parent, String nurse, int birthnumber);

	public Labour getLabour(int lid);

	public List<Labour> getLabour();

	public List<Labour> getLabour(Maternity martenal);

	public List<Labour> getLabour(Date date);

	Labour add(Labour lab);

}
