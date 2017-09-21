package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements LoginDao {
	@Autowired
	private SqlSession session;
	
	public String getPassword(String user_id) {
		String pwd = 
			session.selectOne("gshopMapper.getPassword",user_id);
		System.out.println("getPassword : "+pwd);
		return pwd;
	}

	public String getAdminId(String user_id) {
		String id = session.selectOne("gshopMapper.getAdminId",user_id);
		System.out.println("getAdminId : "+id);
		return id;
	}

}
