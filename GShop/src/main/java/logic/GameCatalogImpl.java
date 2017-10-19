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
	
	public void updateUserFavoriteGameCount(Game game) {
		this.gameDao.updateUserFavoriteGameCount(game);
	}
	
	public void deleteFavoriteGame(Game game) {
		this.gameDao.deleteFavoriteGame(game);
	}
	
	public void insertFavoriteGame(Game game) {
		this.gameDao.insertFavoriteGame(game);
	}
	
	public int getFavoriteCountByGameId(Game game) {
		return gameDao.getFavoriteCountByGameId(game);
	}
	
	public int getFavoriteCount(Game game) {
		return gameDao.getFavoriteCount(game);
	}
	
	public void modifyGameStatus(Game game) {
		this.gameDao.modifyGameStatus(game);
	}

	public void updateGame(Game game) {
		this.gameDao.updateGame(game);
	}
	
	public int getGameStatus(Integer GAMEID) {
		return this.gameDao.getGameStatus(GAMEID);
	}

	public void createBbsTable(Map map) {
		this.gameDao.createBbsTable(map);
	}

	public void createBbsReplyTable(Map map) {
		this.gameDao.createBbsReplyTable(map);
	}

	public void insertGameGenres(Game game) {
		this.gameDao.insertGameGenres(game);
	}
	
	public void insertImages(Game game) {
		this.gameDao.insertImages(game);
	}
	
	public void insertGame(Game game) {
		this.gameDao.insertGame(game);
	}

	public List<Game> getGameListBySearch(Condition con) {// 리스트 조회
		return this.gameDao.getGameListBySearch(con);
	}
	
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
