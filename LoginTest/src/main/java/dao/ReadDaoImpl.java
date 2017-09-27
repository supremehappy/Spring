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
		
		return session.selectList("noticeMapper.getFreeBBSList",con);
	}

	public Bbs_free getFreeBBS(Integer seq) {
		
		return session.selectOne("noticeMapper.getFreeBBSDetail",seq);
	}
	
	public Integer getFreeBBSCount() {
		
		return session.selectOne("noticeMapper.getFreeBBSCount");
	}

	public Integer updateFreeBBSViewCount(Bbs_free free) { // 조회수
		
		return session.update("noticeMapper.updateFreeBBSViewCount", free);
	}
	
		//-----------------------------------------------------notice
	public List<Notice> readNoticeBBS(Condition con) {
		
		return session.selectList("noticeMapper.getNoticeBBSList",con);
	}
	
	public Notice getNoticeBBS(Integer seq) {
		
		return session.selectOne("noticeMapper.getNoticeBBSDetail",seq);
	}
	
	public Integer getNoticeBBSCount() {
		
		return session.selectOne("noticeMapper.getNoticeBBSCount");
	}
	
	public Integer updateNoticeBBSViewCount(Notice notice) {
		
		return session.update("noticeMapper.updateNoticeBBSViewCount", notice);
	}	
}
