package dao;

import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import model.Condition;
import model.Notice;

@Repository
public class NoticeDaoImpl implements NoticeDao{

	@Autowired
	private SqlSession session;
	
	
	//-------------------------------------------------------- read
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
	

	//-------------------------------------------------------- write
	public void insertNoticeWriting(Notice notice) {

		notice.setSeq(getMaxNoticeId()+1);
		
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month=today.get(Calendar.MONTH)+1;
		int date = today.get(Calendar.DATE);
		String noticebbsDate = year+""+month+""+date;
		
		notice.setReg_date(noticebbsDate);
		
		this.session.insert("noticeMapper.insertNoticeWritingInfo",notice);
	}

	public Integer getMaxNoticeId() {

		return this.session.selectOne("noticeMapper.getMaxNoticeId");
	}

	public void updateNoticeBBS(Notice notice) {
	
		this.session.selectOne("noticeMapper.updateNoticeBBS",notice);
		
	}
	
	public Notice findNoitceBBSSeq(Integer SEQNO) {
		
		return this.session.selectOne("noticeMapper.findNoticeBBSSeq",SEQNO);
	}

	public void deleteNoticeBBS(Integer SEQNO) {
		
		this.session.selectOne("noticeMapper.deleteNoticeBBS",SEQNO);
		
	}
}
