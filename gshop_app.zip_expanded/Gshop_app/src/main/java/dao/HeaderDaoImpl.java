package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Header;

@Service
public class HeaderDaoImpl implements HeaderDao{

	@Autowired
	private SqlSession session;
	
	public List<Header> findHeaderAll() {
		
		return this.session.selectList("noticeMapper.findHeaderAll");
	}

	public List<Header> findFreeBBSHeaderOne(Integer SEQNO) {
		
		return this.session.selectList("noticeMapper.findFreeBBSHeaderOne",SEQNO);
	}

	public List<Header> findNoticeBBSHeaderOne(Integer SEQNO) {
		
		return this.session.selectList("noticeMapper.findNoticeBBSHeaderOne",SEQNO);
	}

}
