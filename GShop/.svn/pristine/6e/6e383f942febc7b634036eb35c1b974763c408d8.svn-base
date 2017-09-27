package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Admin;

@Service
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private SqlSession session;
	
	//-------- 관리자 id 찾기
	public Admin findByAdminId(Admin admin) {
		
		Admin item = this.session.selectOne("loginAuthorityMapper.getAdmin",admin); 
		System.out.println("AdminDaoImpl id "+item.getAdminId());
		return item;
	}

	public String findId(String id){
		String item = this.session.selectOne("loginAuthorityMapper.getId",id);
		System.out.println("AdminDaoImpl id2 "+item);
		return item;
	}
}
