package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.WriteDao;
import model.Bbs;

@Service
public class WriteCatalogImpl implements WriteCatalog {

	@Autowired
	private WriteDao writeDao;

	public void entryBBS(Bbs bbs) {

		this.writeDao.insertBbs(bbs);
		
	}

}
