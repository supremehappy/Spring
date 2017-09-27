package logic;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import model.Bbs;
import model.BbsCondition;
import model.BbsHeader;

public interface BbsCatalog {
	List<BbsHeader> getHeader();
	void updateBbs(Bbs bbs, Map map);
	void insertBbs(Bbs bbs, Map map);
	List<Bbs> getBbsList(Map con);
	int selectMaxGroupId(Map map);
	int updateViewOrder(Map map);
	Bbs getBbsDetail(Map map);
	Integer getBbsCount(Map con);
	String getHeaderName(BbsCondition con);
	void updateBbsViewCount(Map map);
	void deleteBbs(Map map);
	String getNicknameBySession(HttpSession session);
}
