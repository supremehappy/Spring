package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.WriteDao;
import model.Bbs_free;
import model.Notice;

@Service
public class WriteCatalogImpl implements WriteCatalog{

	@Autowired
	private WriteDao writeDao;
	
	//--------------------------------------- free
	public void entryFreeWriting(Bbs_free free) {
		
		this.writeDao.insertFreeWriting(free);
		
	}

	//--------------------------------------- notice
	public void entryNoticeWriting(Notice notice) {
		
		this.writeDao.insertNoticeWriting(notice);
		
	}

}
