package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bbs;
import model.Condition;

@Repository
public class ReadDaoImpl implements ReadDao{

	@Autowired
	private SqlSession session;
	
	public List<Bbs> readBBS(Condition con) {
	
		return session.selectList("homeMapper.getBBSList",con);
	}

	public Bbs getBBs(Integer seqno) {
	
		return session.selectOne("homeMapper.getBBSDetail",seqno);
	}

	public Integer getBBSCount() {
		
		return session.selectOne("homeMapper.getBBSCount");
	}

}
