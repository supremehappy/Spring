package dao;

import java.util.List;

import model.Condition;
import model.Notice;

public interface NoticeDao {

	//------------------------------ read
	List<Notice> readNoticeBBS(Condition con);
	Notice getNoticeBBS(Integer seq);
	Integer getNoticeBBSCount();
	Integer updateNoticeBBSViewCount(Notice notice); //-- 조회수
	
	//------------------------------ write
	void insertNoticeWriting(Notice notice);
	Integer getMaxNoticeId();
	
	void updateNoticeBBS(Notice notice); // -- 글 수정
	Notice findNoitceBBSSeq(Integer SEQNO); // 글 찾기 위한 글번호
	
	void deleteNoticeBBS(Integer SEQNO); // -- 글 삭제
}
