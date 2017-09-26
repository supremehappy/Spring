package logic;

import java.util.List;

import model.Header;

public interface HeaderCatalog {

	public List<Header> findHeaderAll();
	public List<Header> findFreeBBSHeaderOne(Integer SEQNO);
	public List<Header> findNoticeBBSHeaderOne(Integer SEQNO);
}
