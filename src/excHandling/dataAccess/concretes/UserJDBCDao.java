package excHandling.dataAccess.concretes;

import java.util.ArrayList;

import excHandling.dataAccess.abstracts.UserDao;
import excHandling.entities.User;

public class UserJDBCDao implements UserDao {

	ArrayList<User> users = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		System.out.println("Added to JDBC.");
		users.add(user);
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Deleted from JDBC");
		users.remove(user);
		
	}

	@Override
	public void update(User userss) {
		for(User user : users) {
			if(user.getId()==userss.getId()) {
				users.set(users.indexOf(user), userss);
			}
		}
		System.out.println("Updated in JDBC");
		
	}

	@Override
	public ArrayList<User> getAll() {
		return users;
	}

}
