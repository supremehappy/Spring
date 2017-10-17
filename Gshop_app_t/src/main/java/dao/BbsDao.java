package dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import model.Bbs;
import model.BbsCondition;
import model.BbsHeader;
import model.BbsReply;

public interface BbsDao {
	
	/*댓글*/
	void updateBbsReply(Map map);
	int selectMaxReGroup(Map map);
	void deleteBbsReply(Map map);
	public int updateReView(Map map);
	Integer getMaxReSeq(Map map);
	void insertReply(BbsReply bbsReply, Map map);
	List<BbsReply> getReplyList(Map map);// 댓글 리스트 조회
	int getReplyCount(Map map);// 댓글 갯수 조회
	
	/*게시글 수정*/
	void updateBbs(Bbs bbs, Map map);
	/*게시글 작성*/
	Integer getMaxSeq(Map map);// 최대 글 번호 조회
	List<BbsHeader> getHeader();// 말머리 리스트 조회
	int selectMaxGroupId(Map map);// 최대 그룹ID 조회
	int updateViewOrder(Map map);

	void insertBbs(Bbs bbs, Map map);// 게시글 삽입
	
	/*게시글 읽기*/
	List<Bbs> getBbsList(Map con);// 리스트 조회
	Bbs getBbsDetail(Map map);// 본문 읽기
	Integer getBbsCount(Map con);// 게시글 수 조회
	String getHeaderName(BbsCondition con);// 말머리 조회
	void updateBbsViewCount(Map map);// 조회수 증가
	
	/*게시글 삭제*/
	void deleteBbs(Map map);// 본문 삭제
	
	String getNicknameBySession(HttpSession session);
}
