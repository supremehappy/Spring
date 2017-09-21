package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.User;

@Service
public class UserDaoImpl implements UserDao{

	@Autowired
	private SqlSession session;
	
	//-------- 회원 id, pw 찾기
	public User findByUserIdAndPassword(User user) {
		
		User item = this.session.selectOne("loginAuthorityMapper.getUser",user);
		System.out.println("UserDaoImpl userid "+item.getUserId());
		return item;
	}

}
