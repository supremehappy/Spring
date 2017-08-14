package dao;

import org.apache.ibatis.session.SqlSession;

import model.User;

public class UserDaoImpl implements UserDao {

	private SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}

	public User findByUserIdAndPassword(User user) {
		
		User item = this.session.selectOne("shopMapper.getUser",user);
		
		return item;
	}

}
