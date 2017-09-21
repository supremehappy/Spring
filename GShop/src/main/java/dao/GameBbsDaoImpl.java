package dao;

import java.util.Calendar;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.GameBbs;

@Repository
public class GameBbsDaoImpl implements GameBbsDao {
	
	@Autowired
	private SqlSession session;
	
	public Integer getMaxId() {
		return this.session.selectOne("gameBbsMapper.getMaxSeq");
	}

	@Override
	public void insertGameBbs(GameBbs gameBbs) {
		Object obj = getMaxId();
		int seq = 0;
		if(obj != null) seq = Integer.parseInt(String.valueOf(obj));
		seq++;
		gameBbs.setSeq(seq);
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int gDate = today.get(Calendar.DATE);
		String date = String.valueOf(year + month + gDate);
		this.session.insert("gameBbsMapper.putGameBbs", gameBbs);
	}

}
