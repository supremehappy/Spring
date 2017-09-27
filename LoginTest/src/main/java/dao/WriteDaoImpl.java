package dao;

import java.util.Calendar;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bbs_free;
import model.Notice;

@Repository
public class WriteDaoImpl implements WriteDao {

	@Autowired
	private SqlSession session;
	
	//-----------------------------------------------free
	public void insertFreeWriting(Bbs_free free) {
		free.setSeq(getMaxFreeId()+1);
		
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month=today.get(Calendar.MONTH)+1;
		int date = today.get(Calendar.DATE);
		String freebbsDate = year+""+month+""+date;
		
		free.setReg_date(freebbsDate);
		
		this.session.insert("noticeMapper.insertFreeWritingInfo",free);
		
	}

	public Integer getMaxFreeId() {
 
		return this.session.selectOne("noticeMapper.getMaxFreeId");
	}

	public void updateFreeBBS(Bbs_free free) { // 글 수정

		this.session.update("noticeMapper.updateFreeBBS",free);
	}

	public Bbs_free findFreeBBSSeq(Integer SEQNO) {

		return this.session.selectOne("noticeMapper.findFreeBBSSeq", SEQNO);
	}
	
	public void deleteFreeBBS(Integer SEQNO) {
		
		this.session.selectOne("noticeMapper.deleteFreeBBS",SEQNO);
		
	}
	
	//-------------------------------------------------notice
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
