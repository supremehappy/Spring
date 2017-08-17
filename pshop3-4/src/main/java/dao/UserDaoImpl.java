package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.User;

@Service
public class UserDaoImpl implements UserDao{

	@Autowired
	private SqlSession session;
	
	public void createUser(User user) {
		session.insert("productMapper.putUser",user);
		
	}

	public User findByUserIdAndPassword(User user) {
		
		User item = this.session.selectOne("productMapper.getUser",user);
		
		return item;
	}

}
