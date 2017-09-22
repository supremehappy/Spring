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

	public Bbs_free getFreeBBS(Integer seq) {
		
		return session.selectOne("bbsMapper.getFreeBBSDetail",seq);
	}
	
	public Integer getFreeBBSCount() {
		
		return session.selectOne("bbsMapper.getFreeBBSCount");
	}

	public Integer updateFreeBBSViewCount(Bbs_free free) {
		
		return session.update("bbsMapper.updateFreeBBSViewCount", free);
	}
	//-----------------------------------------------------notice
	public List<Notice> readNoticeBBS(Condition con) {
		
		return session.selectList("bbsMapper.getNoticeBBSList",con);
	}
	
	public Notice getNoticeBBS(Integer seq) {
		
		return session.selectOne("bbsMapper.getNoticeBBSDetail",seq);
	}
	
	public Integer getNoticeBBSCount() {
		
		return session.selectOne("bbsMapper.getNoticeBBSCount");
	}
	
	public Integer updateNoticeBBSViewCount(Notice notice) {
		
		return session.update("bbsMapper.updateNoticeBBSViewCount", notice);
	}
}
