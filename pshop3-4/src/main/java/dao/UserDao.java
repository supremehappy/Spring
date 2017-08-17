package dao;

import model.User;

public interface UserDao {

	void createUser(User user);
	User findByUserIdAndPassword(User user);
}
