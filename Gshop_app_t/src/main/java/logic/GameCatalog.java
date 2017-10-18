package logic;

import java.util.List;

import model.Condition;
import model.Game;
import model.Genre;

public interface GameCatalog {

	List<Game> getGameList(Condition con);// 리스트 조회
	Integer getMaxGameId();// 가장 큰 게임ID 조회
	Game getGameDetail(Integer GAMEID);// 본문 조회
	Integer getGameCount();// 게임 수 조회
	List<Genre> getGenreList();// 장르 조회
	
}
