package logic;

import java.util.List;

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

	public User selectUserMyPage(String user_id) {
		return this.userDao.selectUserMyPage(user_id);
	}

	public User selectUser(String user_id) {		
		return this.userDao.selectUser(user_id);
	}

	public List<InterestGenre> selectInterestGenre(String user_id) {
		return this.userDao.selectInterestGenre(user_id);
	}

	
//	public Integer[] selectIntGid(String user_id) {
//		return userDao.selectIntGid(user_id);
//	}
//	
//	public String[] selectGenre(){
//		return userDao.selectGenre();
//	}

	public void deleteUser(User user) {		
		this.userDao.deleteUser(user);
	}
		
	

	//-------- 회원 id, pw 찾기
	public User getUserByIdAndPassword(User user) {
		
		return this.userDao.findByUserIdAndPassword(user);
	}

	public Login getUserById(String id) {
		return this.userDao.findByUserId(id);
	}
}
