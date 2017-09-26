package logic;

import java.util.List;

import model.Bbs_free;
import model.Condition;
import model.Notice;

public interface ReadCatalog {

	//---------------------------------------free
	List<Bbs_free> readFreeAll(Condition con);
	Bbs_free readFreeDetail(Integer seqno);
	Integer getFreeBbsCount();
	Integer updateFreeBBSViewCount(Bbs_free free); // 조회수
	
	//---------------------------------------notice
	List<Notice> readNoticeAll(Condition con);
	Notice readNoticeDetail(Integer seqno);
	Integer getNoticeBbsCount();
	Integer updateNoticeBBSViewCount(Notice notice);
}
