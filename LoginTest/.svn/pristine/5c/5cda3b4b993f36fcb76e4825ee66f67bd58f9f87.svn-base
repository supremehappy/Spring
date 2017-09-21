package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.UserDao;
import model.User;

@Repository
public class UserCatalogImpl implements UserCatalog{

	@Autowired
	private UserDao userDao;
	
	//-------- 회원 id, pw 찾기
	public User getUserByIdAndPassword(User user) {
		
		return this.userDao.findByUserIdAndPassword(user);
	}

}
