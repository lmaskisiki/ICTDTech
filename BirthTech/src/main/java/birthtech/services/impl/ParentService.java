package birthtech.services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 

import javax.persistence.PersistenceContext;

import birthtech.entities.Martenal;
import birthtech.services.IParentService;

@Stateless
public class ParentService implements IParentService {

	
	private EntityManagerFactory emf;
	@PersistenceContext
	private EntityManager em;

 

	// ///////////////////////////////////////////////////////
	@Override
	public Martenal getParent(String fullname) {
		System.out.printf("\n Please wait while I search for {0} parent",
				fullname);

		Martenal parent = new Martenal();
		parent.setPid(2);
		parent.setIdnumber(60090);
		parent.setNames(fullname);
		em.persist(parent);
		return null;
	}

	@Override
	public boolean saveLocalParent(Martenal parent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Martenal> listParents() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT e FROM  Martenal e").getResultList();
	}

	@Override
	public void addChild(String newbornName, String newbornSurname,
			Date dateofbith, String birhnumber, String gender, String status) {
		// TODO Auto-generated method stub

	}

	public EntityManagerFactory getEnitityManagerFactory() {
		if (this.emf == null) {
			this.emf = Persistence.createEntityManagerFactory("BirthTech");
		}
		return emf;
	}
}
