package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Header;

@Service
public class HeaderDaoImpl implements HeaderDao{

	@Autowired
	private SqlSession session;
	
	public Header findHeaderAll() {
		
		Header item = this.session.selectOne("bbsMapper.findHeaderAll");
		System.out.println("HeaderDaoImpl "+item.toString());
		
		return item;
	}

}
