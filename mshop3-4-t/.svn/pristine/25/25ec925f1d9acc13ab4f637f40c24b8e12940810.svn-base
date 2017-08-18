package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSession session;
	public void createUser(User user) {
		session.insert("shopMapper.putUser",user);
	}	
	public User findByUserIdAndPassword(User user) {
		User item = this.session.selectOne(
				"shopMapper.getUser",user);
		return item;
	}

}
