package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Condition;
import model.Game;
import model.Genre;

@Repository
public class GameDaoImpl implements GameDao {

	@Autowired
	private SqlSession session;

	public List<Game> getGameList(Condition con) {// 게임 목록
		return this.session.selectList("gameMapper.getGameList", con);
	}

	public Integer getMaxGameId() {// 최대 Game_Id 조회
		return this.session.selectOne("gameMapper.getMaxGameId");
	}

	public Game getGameDetail(Integer GAMEID) {// 게임 본문 조회
		return this.session.selectOne("gameMapper.getGameDetail", GAMEID);
	}

	public Integer getGameCount() {// 등록된 게임 갯수 조회
		return this.session.selectOne("gameMapper.getGameCount");
	}

	public List<Genre> getGenreList() {// 게임 장르 목록 조회
		return this.session.selectList("gameMapper.getGenreList");
	}
}
