package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CommunityDao;
import model.BbsGenre;
import model.Header;
import model.Paging;
import model.ReplyGenre;

@Service
public class CommunityCatalogImpl implements CommunityCatalog {
	@Autowired
	private CommunityDao communityDao;
	
	public Integer getBbsCount() {

		return communityDao.getBbsCount();
	}

	public List<BbsGenre> readAll(Paging p) {
		
		return communityDao.readAll(p);
	}

	public BbsGenre readDetail(Integer seq) {

		return communityDao.readDetail(seq);
	}

	public List<Header> readHeader() {
		
		return communityDao.readHeader();
	}
	
	public void insertBbs(BbsGenre bbsGenre) {
		communityDao.insertBbs(bbsGenre);
	}
	
	public Integer getMaxSeq() {
		return communityDao.getMaxSeq();
	}

	public String readUser(String user_id) {
		return communityDao.readUser(user_id);
	}
	
	public void updateViewCount(BbsGenre bbsGenre) {
		communityDao.updateViewCount(bbsGenre);
	}
	
	public void updateBbs(BbsGenre bbsGenre) {
		communityDao.updateBbs(bbsGenre);
	}
	
	public void deleteBbs(Integer seq) {
		communityDao.deleteBbs(seq);
	}
	
	public void updateViewOrder(BbsGenre bbsGenre) {
		communityDao.updateViewOrder(bbsGenre);
	}
	
	public void insertReply(ReplyGenre replyGenre) {
		communityDao.insertReply(replyGenre);
	}
	
	public Integer getMaxReplySeq() {
		
		return communityDao.getMaxReplySeq();
	}
	
	public void updateReView(ReplyGenre replyGenre) {
		communityDao.updateReView(replyGenre);
	}	
	
	public List<ReplyGenre> readReplyAll(Integer SEQ) {
		
		return communityDao.readReplyAll(SEQ);
	}
	
}
