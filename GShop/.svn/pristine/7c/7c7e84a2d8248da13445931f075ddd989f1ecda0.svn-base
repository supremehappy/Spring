package dao;


import model.InterestGenre;
import model.Login;
import model.User;

public interface UserDao {
	void insertUser(User user);	
	
	boolean userOverlapCheck(User user);
	
	boolean nicknameOverlapCheck(User user);
	
	void insertInterestGenre(InterestGenre interestGenre);
	
	void updateInterestGenre(User user);
	
	void selectUserMyPage(User user);
	
	//-------- 회원 id, pw 찾기
	public User findByUserIdAndPassword(User user);
	public Login findByUserId(String id);
}
