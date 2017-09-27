package dao;

import java.util.List;

import model.BbsGenre;
import model.Header;
import model.Paging;

public interface CommunityDao {

	public Integer getBbsCount();
	public List<BbsGenre> readAll(Paging p);
	public BbsGenre readDetail(Integer seq);

	public List<Header> readHeader();
	public Integer getMaxSeq();
	public void insertBbs(BbsGenre bbsGenre);
	
	public String readUser(String user_id);
}
