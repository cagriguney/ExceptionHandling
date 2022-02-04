package excHandling.business.concretes;

import java.util.ArrayList;

import excHandling.business.abstracts.UserService;
import excHandling.core.concretes.BusinessException;
import excHandling.dataAccess.abstracts.UserDao;
import excHandling.entities.User;

public class UserManager implements UserService{

	private UserDao userDao;
	boolean id;
	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	private boolean checkFirstName(User user) throws BusinessException {
		int minSize=2;
		if(user.getFirstName().length()>minSize) {
			return true;
		}
		else {
			throw new BusinessException("İsminiz 2 karakterden küçük olamaz.");
		}
	}
	
	private boolean checkLastName(User user) throws BusinessException {
		int minSize=2;
		if(user.getLastName().length()>minSize) {
			return true;
		}
		else {
			throw new BusinessException("Soyisminiz 2 karakterden küçük olamaz.");
		}
	}
	
	private boolean checkPassword(User user) throws BusinessException {
		int minSize=6;
		if(user.getPassword().length()>=minSize) {
			return true;
		}
		else {
			throw new BusinessException("Şifreniz 6 karakterden küçük olamaz.");
		}
	}
	
	private boolean checkEmail(User user) throws BusinessException {
		if(user.getEmail().contains("@")) {
			return true;
		}
		else {
			throw new BusinessException("Lütfen geçerli bir e-mail adresi giriniz.");
		}
	}
	
	private boolean checkID(User user) throws BusinessException {
		
		for(int i=0;i<this.getAll().size();i++) {
			if(user.getId()==this.getAll().get(i).getId()) {
				id=true;
			}
		}
		if(id) {
			throw new BusinessException("ID numaranız başka biriyle aynı olamaz.");
		}
		else {
			return true;
		}
	}

	@Override
	public void add(User user) throws BusinessException {
		if(checkEmail(user)&&checkFirstName(user)&&checkID(user)&&checkLastName(user)&&checkPassword(user)) {
			this.userDao.add(user);
		}
		
	}

	@Override
	public void delete(User user) throws BusinessException {
		this.userDao.delete(user);
		
	}

	@Override
	public void update(User user) throws BusinessException {
		if(checkEmail(user)&&checkFirstName(user)&&checkLastName(user)&&checkPassword(user)) {
			this.userDao.update(user);
		}
		else {
			throw new BusinessException("Bilgilerinizi kontrol ediniz.");
		}
		
	}

	@Override
	public ArrayList<User> getAll() {
		return this.userDao.getAll();
	}

}
