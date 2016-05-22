package birthtech.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import birthtech.entities.Child;
import birthtech.entities.Labour;
import birthtech.entities.Maternity;

@Service
public interface IChildService {

	public Child addChild(String gender,String name,String surname,Maternity mother,Labour labour);
	public List<Child> getChildren();
	public List<Child> getChildren(Maternity mother);
	public  Child getChil(int id);
}
