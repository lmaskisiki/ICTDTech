package infosource.health.ematclinic.interfaces;

import infosource.health.ematclinic.models.Child;
import infosource.health.ematclinic.models.Labour;
import infosource.health.ematclinic.models.Maternity;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IChildService {

	public Child addChild(String gender,String name,String surname,Maternity mother,Labour labour);
	public List<Child> getChildren();
	public List<Child> getChildren(Maternity mother);
	public  Child getChil(int id);
	Child save(Child child);
}
