package birthtech.services;

import java.util.Date;
import java.util.List;

import birthtech.entities.Martenal;

public interface IParentService {
	public Martenal getParent(String fullname);
	public boolean saveLocalParent(Martenal parent);
public List<Martenal> listParents();
	public void addChild(String newbornName, String newbornSurname,
			Date dateofbith, String birhnumber, String gender, String status);
}
