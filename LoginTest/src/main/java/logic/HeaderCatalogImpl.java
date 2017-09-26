package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.HeaderDao;
import model.Header;

@Repository
public class HeaderCatalogImpl implements HeaderCatalog{

	@Autowired
	private HeaderDao headerDao;
	
	public List<Header> findHeaderAll() {
		
		return this.headerDao.findHeaderAll();
	}

	public List<Header> findFreeBBSHeaderOne(Integer SEQNO) {
		
		return this.headerDao.findFreeBBSHeaderOne(SEQNO);
	}

	public List<Header> findNoticeBBSHeaderOne(Integer SEQNO) {
		
		return this.headerDao.findNoticeBBSHeaderOne(SEQNO);
	}

}
