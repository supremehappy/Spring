package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import dao.NoticeDao;
import model.Condition;
import model.Notice;

@Service
public class NoticeCatalogImpl implements NoticeCatalog{

	@Autowired
	private NoticeDao noticeDao;
	
	//-------------------------------------------------------read
	public List<Notice> readNoticeAll(Condition con) {
		
		return this.noticeDao.readNoticeBBS(con);
	}

	public Notice readNoticeDetail(Integer seqno) {
		
		return this.noticeDao.getNoticeBBS(seqno);
	}

	public Integer getNoticeBbsCount() {
		
		return this.noticeDao.getNoticeBBSCount();
	}
	
	public Integer updateNoticeBBSViewCount(Notice notice) {
		
		return this.noticeDao.updateNoticeBBSViewCount(notice);
	}
	
	//-------------------------------------------------------read
	public void entryNoticeWriting(Notice notice) {
		
		this.noticeDao.insertNoticeWriting(notice);
		
	}

	public void updateNoticeBBS(Notice notice) {
		
		this.noticeDao.updateNoticeBBS(notice);
		
	}
	
	public Notice getNoticeBBSSeq(Integer SEQNO) {
		
		return this.noticeDao.findNoitceBBSSeq(SEQNO);
	}

	public void deleteNoticeBBS(Integer SEQNO) {
		
		this.noticeDao.deleteNoticeBBS(SEQNO);
		
	}
}
