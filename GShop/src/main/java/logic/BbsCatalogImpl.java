package logic;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BbsDao;
import model.Bbs;
import model.BbsCondition;
import model.BbsHeader;
import model.BbsReply;

@Service
public class BbsCatalogImpl implements BbsCatalog {
	
	@Autowired
	private BbsDao bbsDao;
	
	public void updateBbsReply(Map map) {
		this.bbsDao.updateBbsReply(map);
	}
	
	public int selectMaxReGroup(Map map) {
		return this.bbsDao.selectMaxReGroup(map);
	}
	
	public void deleteBbsReply(Map map) {
		this.bbsDao.deleteBbsReply(map);
	}
	
	public int updateReView(Map map) {
		return bbsDao.updateReView(map);
	}
	
	public Integer getMaxReSeq(Map map) {
		return this.bbsDao.getMaxReSeq(map);
	}
	
	public void insertReply(BbsReply bbsReply, Map map) {
		this.bbsDao.insertReply(bbsReply, map);
	}
	
	public int getReplyCount(Map map) {
		return this.bbsDao.getReplyCount(map);
	}
	
	public List<BbsHeader> getHeader() {
		return this.bbsDao.getHeader();
	}
	
	public void updateBbs(Bbs bbs, Map map) {// 게시글 수정
		this.bbsDao.updateBbs(bbs, map);
	}
	
	public void insertBbs(Bbs gameBbs, Map map) {// 게시글 등록
		this.bbsDao.insertBbs(gameBbs, map);
	}

	public List<Bbs> getBbsList(Map con) {// 게시글 리스트
		return this.bbsDao.getBbsList(con);
	}

	public Bbs getBbsDetail(Map map) {// 본문 읽기
		return this.bbsDao.getBbsDetail(map);
	}

	public Integer getBbsCount(Map con) {// 게시글 갯수
		return this.bbsDao.getBbsCount(con);
	}

	public String getHeaderName(BbsCondition con) {
		return this.bbsDao.getHeaderName(con);
	}

	public void updateBbsViewCount(Map map) {
		this.bbsDao.updateBbsViewCount(map);
	}

	public void deleteBbs(Map map) {
		this.bbsDao.deleteBbs(map);
	}

	public String getNicknameBySession(HttpSession session) {
		return this.bbsDao.getNicknameBySession(session);
	}

	public int selectMaxGroupId(Map map) {
		return this.bbsDao.selectMaxGroupId(map);
	}

	public int updateViewOrder(Map map) {
		return this.bbsDao.updateViewOrder(map);
	}

	public List<BbsReply> getReplyList(Map map) {
		return this.bbsDao.getReplyList(map);
	}

}
