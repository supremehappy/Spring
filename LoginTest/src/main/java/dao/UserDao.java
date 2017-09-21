package dao;

import model.User;

public interface UserDao {

	
	//-------- 회원 id, pw 찾기
	public User findByUserIdAndPassword(User user);
	public String findByUserId(String id);
}
