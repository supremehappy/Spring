package dao;

//import model.Bbs_free;
import model.Notice;

public interface WriteDao {

	//------------------------------ free
/*	void insertFreeWriting(Bbs_free free);
	Integer getMaxFreeId();
	
	void updateFreeBBS(Bbs_free free); // -- 글 수정
	Bbs_free findFreeBBSSeq(Integer SEQNO); // 글 찾기 위한 글번호
	
	void deleteFreeBBS(Integer SEQNO); // -- 글 삭제
*/	//------------------------------ notice
	void insertNoticeWriting(Notice notice);
	Integer getMaxNoticeId();
	
	void updateNoticeBBS(Notice notice); // -- 글 수정
	Notice findNoitceBBSSeq(Integer SEQNO); // 글 찾기 위한 글번호
	
	void deleteNoticeBBS(Integer SEQNO); // -- 글 삭제
}
