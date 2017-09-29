package dao;


import java.util.List;

import model.InterestGenre;
import model.Login;
import model.User;

public interface UserDao {
	
	void insertUser(User user);	
	
	boolean userOverlapCheck(User user);
	
	boolean nicknameOverlapCheck(User user);
	
	void insertInterestGenre(InterestGenre interestGenre);
	
	void updateInterestGenre(User user);
	
	User selectUserMyPage(String user_id);
	
	User selectUser(String user_id);
	
	List<InterestGenre> selectInterestGenre(String user_id);
	
	void deleteUser(User user);
	
//	public Integer[] selectIntGid(String user_id);
//	public String[] selectGenre();

	//-------- 회원 id, pw 찾기
	public User findByUserIdAndPassword(User user);
	public Login findByUserId(String id);
}
