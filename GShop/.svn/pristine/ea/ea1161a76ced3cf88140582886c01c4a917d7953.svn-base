package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.GameBbsDao;
import model.GameBbs;

@Service
public class GameBbsCatalogImpl implements GameBbsCatalog {
	@Autowired
	private GameBbsDao gameBbsDao;
	
	/*게시글 등록*/
	@Override
	public void entryGameBbs(GameBbs gameBbs) {
		this.gameBbsDao.insertGameBbs(gameBbs);
	}

}
