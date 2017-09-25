package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReadDao;
import model.Bbs_free;
import model.Condition;
import model.Notice;

@Service
public class ReadCatalogImpl implements ReadCatalog{

	@Autowired
	private ReadDao readDao;
	
	//-------------------------------------------------------free
	public List<Bbs_free> readFreeAll(Condition con) {
		
		return this.readDao.readFreeBBS(con);
	}

	public Bbs_free readFreeDetail(Integer seqno) {
		
		return this.readDao.getFreeBBS(seqno);
	}

	public Integer getFreeBbsCount() {
		
		return this.readDao.getFreeBBSCount();
	}

	public Integer updateFreeBBSViewCount(Bbs_free free) { // 조회수
		
		return this.readDao.updateFreeBBSViewCount(free);
	}
	
	public void selectDate(Integer SEQNO) {
	
		this.readDao.selectDate(SEQNO);
		
	}
	
	//-------------------------------------------------------notice
	public List<Notice> readNoticeAll(Condition con) {
		
		return this.readDao.readNoticeBBS(con);
	}

	public Notice readNoticeDetail(Integer seqno) {
		
		return this.readDao.getNoticeBBS(seqno);
	}

	public Integer getNoticeBbsCount() {
		
		return this.readDao.getNoticeBBSCount();
	}
	
	public Integer updateNoticeBBSViewCount(Notice notice) {
		
		return this.readDao.updateNoticeBBSViewCount(notice);
	}

	
}
