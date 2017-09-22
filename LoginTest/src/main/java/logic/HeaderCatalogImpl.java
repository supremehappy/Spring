package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.HeaderDao;
import model.Header;

@Repository
public class HeaderCatalogImpl implements HeaderCatalog{

	@Autowired
	private HeaderDao headerDao;
	
	public Header findHeaderAll() {
		
		return this.headerDao.findHeaderAll();
	}

}
