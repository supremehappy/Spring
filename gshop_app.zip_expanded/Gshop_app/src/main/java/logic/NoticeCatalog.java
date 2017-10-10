package logic;

import java.util.List;

import model.Condition;
import model.Notice;

public interface NoticeCatalog {

	//---------------------------------------read
	List<Notice> readNoticeAll(Condition con);
	Notice readNoticeDetail(Integer seqno);
	Integer getNoticeBbsCount();
	Integer updateNoticeBBSViewCount(Notice notice);
	
	//---------------------------------------write
	void entryNoticeWriting(Notice notice);
	
	void updateNoticeBBS(Notice notice);// 글 수정
	Notice getNoticeBBSSeq(Integer SEQNO);
	
	void deleteNoticeBBS(Integer SEQNO); // 글 삭제
}
