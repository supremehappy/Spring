package dao;

import java.util.List;

import model.Bbs_free;
import model.Condition;
import model.Notice;

public interface ReadDao {
	
	//-----------------------------------------free
	List<Bbs_free> readFreeBBS(Condition con);
	Bbs_free getFreeBBS(Integer seq);
	Integer getFreeBBSCount();
	Integer updateFreeBBSViewCount(Bbs_free free);
	//-----------------------------------------notice
	List<Notice> readNoticeBBS(Condition con);
	Notice getNoticeBBS(Integer seq);
	Integer getNoticeBBSCount();
	Integer updateNoticeBBSViewCount(Notice notice);
}
