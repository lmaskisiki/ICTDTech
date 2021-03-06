package birthtech.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import birthtech.entities.Labour;
import birthtech.entities.Patient;

@Service
public interface ILabourService {

	public boolean addLabour(Date date, String place, int status,
			Patient parent, String nurse, int birthnumber);

	public Labour getLabour(int lid);

	public List<Labour> getLabour();

	public List<Labour> getLabour(Patient martenal);

	public List<Labour> getLabour(Date date);

	Labour add(Labour lab);

}
