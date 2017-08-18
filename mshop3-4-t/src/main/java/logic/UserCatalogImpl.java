package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import model.User;
@Service
public class UserCatalogImpl implements UserCatalog {
	@Autowired
	private UserDao userDao;
	public void entryUser(User user) {
		userDao.createUser(user);
	}
	public User getUserByIdAndPassword(User user) {
		return this.userDao.findByUserIdAndPassword(user);
	}

}
