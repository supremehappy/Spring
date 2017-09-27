package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CommunityDao;
import model.BbsGenre;
import model.Header;
import model.Paging;

@Service
public class CommunityCatalogImpl implements CommunityCatalog {
	@Autowired
	private CommunityDao communityDao;
	
	public Integer getBbsCount() {

		return communityDao.getBbsCount();
	}

	public List<BbsGenre> readAll(Paging p) {
		
		return communityDao.readAll(p);
	}

	public BbsGenre readDetail(Integer seq) {

		return communityDao.readDetail(seq);
	}

	public List<Header> readHeader() {
		
		return communityDao.readHeader();
	}
	
	public void insertBbs(BbsGenre bbsGenre) {
		communityDao.insertBbs(bbsGenre);
	}

	public String readUser(String user_id) {
		return communityDao.readUser(user_id);
	}
}
