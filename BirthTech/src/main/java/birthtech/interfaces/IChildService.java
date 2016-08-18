package birthtech.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import birthtech.entities.Child;
import birthtech.entities.Labour;
import birthtech.entities.Patient;

@Service
public interface IChildService {

	public Child addChild(String gender,String name,String surname,Patient mother,Labour labour);
	public List<Child> getChildren();
	public List<Child> getChildren(Patient mother);
	public  Child getChil(int id);
	Child save(Child child);
}
