package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import model.InterestGenre;
import model.Login;
import model.User;

@Service
public class UserCatalogImpl implements UserCatalog {
	
	@Autowired
	private UserDao userDao;
		
	public void entryUser(User user) {
		this.userDao.insertUser(user);
	}

	public boolean userOverlapCheck(User user) {
		return this.userDao.userOverlapCheck(user);
	}

	public boolean nicknameOverlapCheck(User user) {
		return this.userDao.nicknameOverlapCheck(user);
	}

	public void insertInterestGenre(InterestGenre interestGenre) {
		this.userDao.insertInterestGenre(interestGenre);		
		
	}

	public void updateInterestGenre(User user) {		
		this.userDao.updateInterestGenre(user);	
	}

	public void selectUserMaPage(User user) {
		this.userDao.selectUserMyPage(user);		
	}

	//-------- 회원 id, pw 찾기
	public User getUserByIdAndPassword(User user) {
		
		return this.userDao.findByUserIdAndPassword(user);
	}

	public Login getUserById(String id) {
		return this.userDao.findByUserId(id);
	}
}
