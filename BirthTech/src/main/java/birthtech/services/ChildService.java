package birthtech.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import birthtech.entities.Child;
import birthtech.entities.Labour;
import birthtech.entities.Patient;
import birthtech.interfaces.IChildService;
import birthtech.messaging.MessageSender;
import birthtech.messaging.UniversalMarshaller;
import birthtech.repositories.ChildRepository;

@Service
public class ChildService implements IChildService {
	@Autowired
	private ChildRepository repo;

	@Override
	public Child addChild(String gender, String name, String surname,
			Patient mother, Labour labour) {
 
		return null;
	}

	@Override
	public List<Child> getChildren() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Child> getChildren(Patient mother) {
		List<Child> children = new ArrayList<Child>();

		return children;
	}

	@Override
	public Child getChil(int id) {
		List<Child> children = new ArrayList<Child>();
		for (Child child : repo.findAll()) {
			if (child.getChildId() == id) {
				children.add(child);
			}
		}
		return children.get(0);
	}

	@Override
	public Child save(Child newchild) {
		if (newchild==null || newchild.getChildId()<1 || newchild.getMother() < 1 ) {
			throw new NullPointerException("No Identifiers Defined");
		}
		Child child = repo.save(newchild);
		return child;
	}
}
