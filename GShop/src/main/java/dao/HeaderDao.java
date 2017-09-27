package dao;

import java.util.List;

import model.Header;

public interface HeaderDao {

	public List<Header> findHeaderAll();
	public List<Header> findFreeBBSHeaderOne(Integer SEQNO);
	public List<Header> findNoticeBBSHeaderOne(Integer SEQNO);
}
