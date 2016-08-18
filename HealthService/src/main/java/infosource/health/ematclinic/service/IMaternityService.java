package infosource.health.ematclinic.service;

import java.util.List;

public interface IMaternityService<T> {

	boolean save(T object);
	T findById(int id);
	List<T> getList();
}
