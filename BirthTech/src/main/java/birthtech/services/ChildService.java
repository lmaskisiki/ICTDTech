package birthtech.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import birthtech.entities.Child;
import birthtech.entities.Labour;
import birthtech.entities.Maternity;
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
			Maternity mother, Labour labour) {
		Child child = new Child();
		child.setGender(gender);
		child.setSurname(surname);
		child.setName(name);
			Child savedChild = repo.save(child);
		return savedChild;
	}

	@Override
	public List<Child> getChildren() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Child> getChildren(Maternity mother) {
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
		Child child=repo.save(newchild);
		if(child !=null){
		MessageSender sender = new MessageSender();
				UniversalMarshaller marshal = new UniversalMarshaller();
			//	sender.sendMessage(marshal.toXML(child));
		}
		return child;
	}
}
