package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Condition;
import model.Game;
import model.Genre;
import model.Grade;
import model.Os;

@Repository
public class GameDaoImpl implements GameDao {
	
	@Autowired
	private SqlSession session;

	public void deleteBbs(int gameId) {// 게임 게시판 테이블 삭제
		this.session.delete("gameMapper.deleteBbs", gameId);
	}

	public void deleteBbsReply(int gameId) {// 게임 게시판 댓글 테이블 삭제
		this.session.delete("gameMapper.deleteBbsReply", gameId);
	}

	public void deleteGame(int gameId) {// 게임 삭제
		this.session.delete("gameMapper.deleteGame", gameId);
	}

	public void modifyGame(Game game) {// 게임 수정
		this.session.update("gameMapper.modifyGame", game);
	}

	public void createBbsTable(Map map) {// 게임 게시판 테이블 생성
		this.session.update("gameMapper.createBbsTable", map);
	}

	public void createBbsReplyTable(Map map) {// 게임 게시판 댓글 테이블 생성
		this.session.update("gameMapper.createBbsReplyTable", map);
	}
	
	public void insertImages(Game game) {
		this.session.insert("gameMapper.insertImages", game);
	}

	public void insertGame(Game game) {// 게임 등록
		this.session.insert("gameMapper.insertGame", game);
	}

	public List<Game> getBbsList(Condition con) {// 게임 목록
		return this.session.selectList("gameMapper.getBbsList", con);
	}

	public Integer getMaxGameId() {// 최대 Game_Id 조회
		return this.session.selectOne("gameMapper.getMaxGameId");
	}

	public Game getGameDetail(Game game) {// 게임 본문 조회
		return this.session.selectOne("gameMapper.getGameDetail", game);
	}

	public Integer getGameCount() {// 등록된 게임 갯수 조회
		return this.session.selectOne("gameMapper.getGameCount");
	}

	public List<Os> getOsList() {// 운영체제 목록 조회
		return this.session.selectList("gameMapper.getOsList");
	}

	public List<Grade> getGradeList() {// 등급 목록 조회
		return this.session.selectList("gameMapper.getGradeList");
	}
	
	public List<Genre> getGenreList() {// 게임 장르 목록 조회
		return this.session.selectList("gameMapper.getGenreList");
	}
	
}
