package dao;

import java.util.List;
import java.util.Map;

import model.Condition;
import model.Game;
import model.Genre;
import model.Grade;
import model.Os;

public interface GameDao {
	
	void deleteFavoriteGame(Game game);// 좋아요(찜하기) 삭제
	void insertFavoriteGame(Game game);// 좋아요(찜하기) 등록
	int getFavoriteCount(Game game);// 좋아요(찜하기) 상태 조회
	
	void updateGameGenres(Game game);// 게임 장르 수정
	void updateGameImages(Game game);// 게임 이미지 수정
	void updateGame(Game game);// 게임 수정
	void modifyGameStatus(Game game);// 게임 상태 변경
	int getGameStatus(Integer GAMEID);// 게임 상태 조회
	
	void createBbsTable(Map map);// 게임 게시판 테이블 생성
	void createBbsReplyTable(Map map);// 게임 게시판 댓글 테이블 생성
	void insertGameGenres(Game game);// 게임 장르 등록
	void insertImages(Game game);// 게임 이미지 등록
	void insertGame(Game game);// 게임 등록
	
	List<Game> getGameListBySearch(Condition con);// 리스트 조회
	List<Game> getGameList(Condition con);// 리스트 조회
	Integer getMaxGameId();// 가장 큰 게임ID 조회
	Game getGameDetail(Integer GAMEID);// 본문 조회
	Integer getGameCount();// 게임 수 조회
	List<Os> getOsList();// Os 조회
	List<Grade> getGradeList();// 등급 조회
	List<Genre> getGenreList();// 장르 조회
}
