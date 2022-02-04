package excHandling.core.abstracts;

import java.util.ArrayList;

import excHandling.core.concretes.Entity;

public interface CrudRepository <T extends Entity>{

	void add(T entity);
	void delete(T entity);
	void update(T entity);
	ArrayList<T> getAll();
	
}
