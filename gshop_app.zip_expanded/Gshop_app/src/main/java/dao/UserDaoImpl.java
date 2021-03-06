package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.InterestGenre;
import model.Login;
import model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSession session;

	
	public void insertUser(User user) {
		this.session.insert("userMapper.insertUser",user);		
	}	

	public boolean userOverlapCheck(User user) {
		String userId = this.session.selectOne("userMapper.userOverlapCheck",user);
		if(userId == null)
		{
			return true;
		} else {
			return false;
		}
	}

	public boolean nicknameOverlapCheck(User user) {
		String nickname = this.session.selectOne("userMapper.nicknameOverlapCheck",user);
		if(nickname == null)
		{
			return true;
		} else {
			return false;
		}
	}

	public void insertInterestGenre(InterestGenre interestGenre) {
		this.session.insert("userMapper.insertInterestGenre",interestGenre);
		
	}

	public void updateInterestGenre(User user) {
		this.session.insert("userMapper.updateInterestGenre",user);		
	}

	public User selectUserMyPage(String user_id) {
		return session.selectOne("userMapper.selectUserMyPage",user_id);
	}

	public User selectUser(String user_id) {		
		return session.selectOne("userMapper.selectUser",user_id);
	}

	public List<InterestGenre> selectInterestGenre(String user_id) {
		return session.selectList("userMapper.selectInterestGenre",user_id);
	}

//	public Integer[] selectIntGid(String user_id) {
//		return session.selectOne("userMapper.selectIntGid", user_id);
//	}
//
//	public String[] selectGenre(){
//		return session.selectOne("userMapper.selectGenre");
//	}
	
	public void deleteUser(User user) {
		this.session.delete("userMapper.deleteUser", user);
		
	}
	
	
	//-------- 회원 id, pw 찾기
	public User findByUserIdAndPassword(User user) {
		
		User item = this.session.selectOne("loginAuthorityMapper.getUser",user);
		
		return item;
	}

	public Login findByUserId(String id) {
				
		
		return this.session.selectOne("loginAuthorityMapper.getUserId",id);
	}
}
