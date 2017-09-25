package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.WriteDao;
import model.Bbs_free;
import model.Notice;

@Service
public class WriteCatalogImpl implements WriteCatalog{

	@Autowired
	private WriteDao writeDao;
	
	//--------------------------------------- free
	public void entryFreeWriting(Bbs_free free) {
		
		this.writeDao.insertFreeWriting(free);
		
	}

	public void updateFreeBBS(Bbs_free free) { // 글 수정
		
		this.writeDao.updateFreeBBS(free);
	}
	
	public Bbs_free getFreeBBSSeq(Integer SEQNO) {
	
		return this.writeDao.findFreeBBSSeq(SEQNO);
	}

	public void deleteFreeBBS(Integer SEQNO) { // 글 삭제
		
		this.writeDao.deleteFreeBBS(SEQNO);
		
	}
	//--------------------------------------- notice
	public void entryNoticeWriting(Notice notice) {
		
		this.writeDao.insertNoticeWriting(notice);
		
	}

	public void updateNoticeBBS(Notice notice) {
		
		this.writeDao.updateNoticeBBS(notice);
		
	}
	
	public Notice getNoticeBBSSeq(Integer SEQNO) {
		
		return this.writeDao.findNoitceBBSSeq(SEQNO);
	}

	public void deleteNoticeBBS(Integer SEQNO) {
		
		this.writeDao.deleteNoticeBBS(SEQNO);
		
	}

	
}
