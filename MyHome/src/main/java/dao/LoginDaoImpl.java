package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements LoginDao{

	@Autowired
	private SqlSession session;
	
	public String getPassword(String id) {
		
		String pwd = session.selectOne("homeMapper.getPassword",id);
		return pwd;
	}

}
