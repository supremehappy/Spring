package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.WriteDao;
import model.Bbs;
import model.Writing;

@Service
public class WriteCatalogImpl implements WriteCatalog {
	@Autowired
	private WriteDao writeDao;

	public void entryBBS(Bbs bbs) {
		this.writeDao.insertBbs(bbs);
	}

	public List<Writing> getWriting() {
		return this.writeDao.getWriting();
	}

	public void entryWriting(Writing writing) {
		this.writeDao.insertWriting(writing);
	}

}
