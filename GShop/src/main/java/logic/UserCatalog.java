package logic;

import java.util.List;

import model.InterestGenre;
import model.Login;
import model.User;

public interface UserCatalog {
void entryUser(User user);
	
	boolean userOverlapCheck(User user);
	
	boolean nicknameOverlapCheck(User user);
	
	void insertInterestGenre(InterestGenre interestGenre);
	
	void updateInterestGenre(User user);
	
	User selectUserMyPage(String user_id);
	
	User selectUser(String user_id);
	
	List<InterestGenre> selectInterestGenre(String user_id);
	
	void deleteUser(User user);
	
	void updateUser(User user);
	
	void deleteInterestGenre(User user);
	
	String selectUser_id(User user);
	
	String selectPassword(User user);
	
	//-------- 회원 id, pw 찾기
	public User getUserByIdAndPassword(User user);
	public Login getUserById(String id);
	
}
