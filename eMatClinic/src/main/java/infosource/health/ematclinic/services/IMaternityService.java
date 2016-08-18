package infosource.health.ematclinic.services;

import java.util.List;

public interface IMaternityService<T> {

	boolean save(T object);
	T findById(int id);
	List<T> getList();
}
