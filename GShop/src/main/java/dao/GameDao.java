package dao;

import java.util.List;
import java.util.Map;

import model.Condition;
import model.Game;
import model.Genre;
import model.Grade;
import model.Os;

public interface GameDao {
	
	void deleteBbs(int	gameId);// 게임 게시판 테이블 삭제
	void deleteBbsReply(int	gameId);// 게임 게시판 댓글 테이블 삭제
	void deleteGame(int	gameId);// 게임 삭제
	
	void modifyGame(Game game);
	void createBbsTable(Map map);// 게임 게시판 테이블 생성
	void createBbsReplyTable(Map map);// 게임 게시판 댓글 테이블 생성
	void insertImages(Game game);// 게임 이미지 등록
	void insertGame(Game game);// 게임 등록
	
	List<Game> getBbsList(Condition con);// 리스트 조회
	Integer getMaxGameId();// 가장 큰 게임ID 조회
	Game getGameDetail(Game game);// 본문 조회
	Integer getGameCount();// 게임 수 조회
	List<Os> getOsList();// Os 조회
	List<Grade> getGradeList();// 등급 조회
	List<Genre> getGenreList();
}
