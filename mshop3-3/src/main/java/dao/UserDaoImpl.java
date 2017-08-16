package dao;

import org.apache.ibatis.session.SqlSession;

import model.User;

public class UserDaoImpl implements UserDao {

	private SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}

	public void createUser(User user) {
		session.insert("shopMapper.putUser",user);

	}

}
