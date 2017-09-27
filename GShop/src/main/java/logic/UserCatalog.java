package logic;

import model.InterestGenre;
import model.Login;
import model.User;

public interface UserCatalog {
	void entryUser(User user);
	
	boolean userOverlapCheck(User user);
	
	boolean nicknameOverlapCheck(User user);
	
	void insertInterestGenre(InterestGenre interestGenre);
	
	void updateInterestGenre(User user);
	
	void selectUserMaPage(User user);
	
	//-------- 회원 id, pw 찾기
	public User getUserByIdAndPassword(User user);
	public Login getUserById(String id);
	
}
