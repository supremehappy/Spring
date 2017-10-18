package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.GameDao;
import model.Condition;
import model.Game;
import model.Genre;

@Service
public class GameCatalogImpl implements GameCatalog {
	
	@Autowired
	private GameDao gameDao;

	public List<Game> getGameList(Condition con) {
		return this.gameDao.getGameList(con);
	}

	public Integer getMaxGameId() {
		return this.gameDao.getMaxGameId();
	}

	public Game getGameDetail(Integer GAMEID) {
		return this.gameDao.getGameDetail(GAMEID);
	}

	public Integer getGameCount() {
		return this.gameDao.getGameCount();
	}

	public List<Genre> getGenreList() {
		return this.gameDao.getGenreList();
	}
	
}
