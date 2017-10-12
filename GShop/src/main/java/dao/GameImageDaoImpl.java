package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.GameImage;
@Repository
public class GameImageDaoImpl implements GameImageDao {

	@Autowired
	SqlSession session;
	
	public List<GameImage> gameImage() {
		
		return this.session.selectList("gameImageMapper.gameImage");
	}

	public List<GameImage> newImage() {

		return this.session.selectList("gameImageMapper.newGame");
	}

	public List<GameImage> bestImage() {
		
		return this.session.selectList("gameImageMapper.bestGame");
	}

	public List<GameImage> saleImage() {

		return this.session.selectList("gameImageMapper.saleGame");
	}
	
	

}
