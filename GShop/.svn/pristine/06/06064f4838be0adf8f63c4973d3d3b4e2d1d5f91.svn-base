package logic;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.GameDao;
import model.Condition;
import model.Game;
import model.Genre;
import model.Grade;
import model.Os;

@Service
public class GameCatalogImpl implements GameCatalog {
	
	@Autowired
	private GameDao gameDao;

	public void deleteBbs(int gameId) {
		this.gameDao.deleteBbs(gameId);
	}

	public void deleteBbsReply(int gameId) {
		this.gameDao.deleteBbsReply(gameId);
	}

	public void deleteGame(int gameId) {
		this.gameDao.deleteGame(gameId);
	}

	public void modifyGame(Game game) {
		this.gameDao.modifyGame(game);
	}

	public void createBbsTable(Map map) {
		this.gameDao.createBbsTable(map);
	}

	public void createBbsReplyTable(Map map) {
		this.gameDao.createBbsReplyTable(map);
	}

	public void insertImages(Game game) {
		this.gameDao.insertImages(game);
	}
	
	public void insertGame(Game game) {
		this.gameDao.insertGame(game);
	}

	public List<Game> getBbsList(Condition con) {
		return this.gameDao.getBbsList(con);
	}

	public Integer getMaxGameId() {
		return this.gameDao.getMaxGameId();
	}

	public Game getGameDetail(Game game) {
		return this.gameDao.getGameDetail(game);
	}

	public Integer getGameCount() {
		return this.gameDao.getGameCount();
	}

	public List<Os> getOsList() {
		return this.gameDao.getOsList();
	}

	public List<Grade> getGradeList() {
		return this.gameDao.getGradeList();
	}
	
	public List<Genre> getGenreList() {
		return this.gameDao.getGenreList();
	}
	
}
