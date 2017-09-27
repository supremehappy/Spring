package logic;

import java.util.List;

import model.BbsGenre;
import model.Header;
import model.Paging;

public interface CommunityCatalog {

	Integer getBbsCount();
	public List<BbsGenre> readAll(Paging p);
	public BbsGenre readDetail(Integer seq);
	
	public List<Header> readHeader();
	void insertBbs(BbsGenre bbsGenre);

	public String readUser(String user_id);
}
