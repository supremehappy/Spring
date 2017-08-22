package dao;

import java.util.List;

import model.Bbs;
import model.Condition;

public interface ReadDao {

	List<Bbs> readBBS(Condition con);
	Bbs getBBs(Integer seqno);
	Integer getBBSCount();
}
