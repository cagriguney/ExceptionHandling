package excHandling.business.abstracts;

import java.util.ArrayList;

import excHandling.core.concretes.BusinessException;
import excHandling.entities.User;

public interface UserService {

	void add(User user) throws BusinessException;
	void delete(User user) throws BusinessException;
	void update(User user) throws BusinessException;
	ArrayList<User> getAll();
	
}
