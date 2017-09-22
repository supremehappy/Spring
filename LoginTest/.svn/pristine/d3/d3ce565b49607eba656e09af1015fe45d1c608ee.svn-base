package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bbs_free;
import model.Condition;
import model.Notice;

@Repository
public class ReadDaoImpl implements ReadDao{

	@Autowired
	private SqlSession session;
	
	//-----------------------------------------------------free
	public List<Bbs_free> readFreeBBS(Condition con) {
		
		return session.selectList("bbsMapper.getFreeBBSList",con);
	}

	public Bbs_free getFreeBBS(Integer seqno) {
		
		return session.selectOne("bbsMapper.getFreeBBSDetail",seqno);
	}
	
	public Integer getFreeBBSCount() {
		
		return session.selectOne("bbsMapper.getFreeBBSCount");
	}

	//-----------------------------------------------------notice
	public List<Notice> readNoticeBBS(Condition con) {
		
		return session.selectList("bbsMapper.getNoticeBBSList",con);
	}
	
	public Notice getNoticeBBS(Integer seqno) {
		
		return session.selectOne("bbsMapper.getNoticeBBSDetail",seqno);
	}
	
	public Integer getNoticeBBSCount() {
		
		return session.selectOne("bbsMapper.getNoticeBBSCount");
	}
}
