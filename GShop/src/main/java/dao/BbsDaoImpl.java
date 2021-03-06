package dao;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bbs;
import model.BbsCondition;
import model.BbsHeader;
import model.BbsReply;

@Repository
public class BbsDaoImpl implements BbsDao {
	
	@Autowired
	private SqlSession session;
	
	// 댓글 처리
	public void updateBbsReply(Map map) {// 댓글 수정
		this.session.selectOne("bbsMapper.updateBbsReply", map);
	}
	
	public void deleteBbsReply(Map map) {// 댓글 삭제
		this.session.selectOne("bbsMapper.deleteBbsReply", map);
	}
	
	public int updateReView(Map map) {// 글 작성 시 ViewOrder 수정
		int result = this.session.update("bbsMapper.updateReView", map);
		return result;
	}
	
	public Integer getMaxReSeq(Map map) {// 댓글 최대 글번호 조회
		return this.session.selectOne("bbsMapper.getMaxReSeq", map);
	}

	public int selectMaxReGroup(Map map) {// 최대 그룹ID 조회
		Object result = this.session.selectOne("bbsMapper.selectMaxReGroup", map);
		if(result == null) return 0;
		return Integer.parseInt(String.valueOf(result));
	}
	
	public void insertReply(BbsReply bbsReply, Map map) {// 댓글 삽입
		Object obj = getMaxReSeq(map);
		int re_seq = 0;
		if(obj != null) re_seq = Integer.parseInt(String.valueOf(obj));
		re_seq++;
		bbsReply.setRe_seq(re_seq);
		
		map.put("replyBbs", bbsReply);
		this.session.insert("bbsMapper.insertReply", bbsReply);
	}
	
	public int getReplyCount(Map map) {// 댓글 갯수 조회
		return this.session.selectOne("bbsMapper.getReplyCount", map);
	}
	
	public List<BbsReply> getReplyList(Map map) {// 댓글 리스트
		return this.session.selectList("bbsMapper.getReplyList", map);
	}
	
	// 게시글 처리
	public Integer getMaxSeq(Map map) {// 최대 글번호 조회
		return this.session.selectOne("bbsMapper.getMaxSeq", map);
	}

	public List<BbsHeader> getHeader() {// 말머리 목록 조회
		return this.session.selectList("bbsMapper.getHeader");
	}

	public void updateBbs(Bbs bbs, Map map) {// 본문 수정
		this.session.update("bbsMapper.updateBbs", bbs);
	}

	public int updateViewOrder(Map map) {// 글 작성 시 ViewOrder 수정
		int result = this.session.update("bbsMapper.updateViewOrder", map);
		return result;
	}

	public int selectMaxGroupId(Map map) {// 최대 그룹ID 조회
		Object result = this.session.selectOne("bbsMapper.selectMaxGroupId", map);
		if(result == null) return 0;
		return Integer.parseInt(String.valueOf(result));
	}

	public void insertBbs(Bbs bbs, Map map) {// 게시글 삽입
		Object obj = getMaxSeq(map);
		int seq = 0;
		if(obj != null) seq = Integer.parseInt(String.valueOf(obj));
		seq++;
		bbs.setSeq(seq);
		bbs.setView_count(0);
		
		Calendar today = Calendar.getInstance();
		String year = String.valueOf(today.get(Calendar.YEAR));
		String month = String.valueOf(today.get(Calendar.MONTH) + 1);
		if(month.length() == 1) month = "0" + month;
		String gDate = String.valueOf(today.get(Calendar.DATE));
		if(gDate.length() == 1) gDate = "0" + gDate;
		String date = year + month + gDate;
		bbs.setReg_date(date);
		map.put("bbs", bbs);
		this.session.insert("bbsMapper.insertBbs", bbs);
	}
	
	public List<Bbs> getBbsList(Map conMap) {// 게시글 리스트
		if (conMap.get("header").equals("-1")) {
			return this.session.selectList("bbsMapper.getBbsList", conMap);
		} else {
			return this.session.selectList("bbsMapper.getBbsListHeader", conMap);
		}
	}

	public Bbs getBbsDetail(Map map) {// 게시글 본문 읽기
		return this.session.selectOne("bbsMapper.getBbsDetail", map);
	}

	public Integer getBbsCount(Map conMap) {// 게시글 갯수 조회
		if(conMap.get("header").equals("-1")) {
			return this.session.selectOne("bbsMapper.getBbsCount", conMap);
		} else {
			return this.session.selectOne("bbsMapper.getBbsCountHeader", conMap);
		}
	}

	public String getHeaderName(BbsCondition con) {// 말머리 조회
		if(con.getHeader() == -1) {
			return "전체";
		} else {
			return this.session.selectOne("bbsMapper.getHeaderName", con);
		}
	}

	public void updateBbsViewCount(Map map) {// 조회수 증가
		this.session.selectOne("bbsMapper.updateBbsViewCount", map);
	}
	public void deleteBbsReplyByBbsDelete(Map map) {
		this.session.selectOne("bbsMapper.deleteBbsReplyByBbsDelete", map);
	}
	public void deleteBbs(Map map) {// 게시글 삭제
		deleteBbsReplyByBbsDelete(map);
		this.session.selectOne("bbsMapper.deleteBbs", map);
	}
	
	public String getNicknameBySession(HttpSession session) {// 세션에 저장된 ID값으로 닉네임 조회
		String userId = null;
		String nickname = null;
		if(session.getAttribute("user_key") != null) {
			userId = (String) session.getAttribute("user_key");
			nickname = this.session.selectOne("bbsMapper.getUserNicknameBySession", userId); 
		} else if(session.getAttribute("admin_key") != null) {
			userId = (String) session.getAttribute("admin_key");
			nickname = this.session.selectOne("bbsMapper.getAdminNicknameBySession", userId);
		}
		return nickname;
	}

}
