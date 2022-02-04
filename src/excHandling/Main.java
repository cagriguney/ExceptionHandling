package excHandling;

import java.util.ArrayList;

import excHandling.business.abstracts.UserService;
import excHandling.business.concretes.UserManager;
import excHandling.core.concretes.BusinessException;
import excHandling.dataAccess.concretes.UserJDBCDao;
import excHandling.entities.User;
public class Main {

	public static void main(String[] args) throws BusinessException {
		
		//int id, String firstName, String lastName, String password, String email
		User user1 = new User(1,"Çağrı","Güney","123456","cg@gmail.com");
		User user2 = new User(2,"Naci","Güney","224526","cg@gmail.com");
		User user3 = new User(3,"Berat","Güney","123456","bg@gmail.com");
		User user4 = new User(1,"Hakan","Goktas","12223456","hg@gmail.com");
		
		UserService userManager=new UserManager(new UserJDBCDao());
		
		try {
			userManager.add(user1);
			userManager.add(user2);
			userManager.add(user3);
			userManager.update(user4);
			userManager.delete(user4);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		ArrayList<User> users = userManager.getAll();
		for (User userss : users) {
			System.out.println(userss.getFirstName());
		
		}

	}
}
