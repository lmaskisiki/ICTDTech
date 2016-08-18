package infosource.health.ematclinic.service;

import infosource.health.ematclinic.models.Checkup;

import java.util.List;
 

public class MatService<T> implements IMaternityService<Checkup> {

	private EntityManager em;
	
	@Override
	public boolean save(Checkup object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Checkup findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Checkup> getList() {
		// TODO Auto-generated method stub
		return null;
	}

 

}
