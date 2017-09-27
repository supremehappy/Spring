package dao;

import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.BbsGenre;
import model.Header;
import model.Paging;

@Repository
public class CommunityDaoImpl implements CommunityDao {
	@Autowired
	private SqlSession session;
	
	public Integer getBbsCount() {
		
		return session.selectOne("communityMapper.getBbsCount");
	}

	public List<BbsGenre> readAll(Paging p) {
		
		return session.selectList("communityMapper.getBbs", p);
	}

	public BbsGenre readDetail(Integer seq) {

		return session.selectOne("communityMapper.getBbsDetail", seq);
	}

	public List<Header> readHeader() {
		
		return session.selectList("communityMapper.getHeader");
	};
	
	public String readUser(String user_id) {
		
		return session.selectOne("communityMapper.getUser", user_id);
	}
	
	public Integer getMaxSeq() {
		
		return session.selectOne("communityMapper.getMaxSeq");
	}
	
	public void insertBbs(BbsGenre bbsGenre) {
		Object obj = getMaxSeq();
		
		int seqno = 0;
		
		if(obj != null) {
			seqno = Integer.parseInt(String.valueOf(obj));
		}
		
		seqno++;
		
		bbsGenre.setSeq(seqno);
		
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		String tMonth = null;
		if(month < 10) {
			tMonth = "0" + month;
		}
		else {
			tMonth = "" + month;
		}
		int date = today.get(Calendar.DATE);
		String reg_date = year + tMonth + date;
		bbsGenre.setReg_date(reg_date);
		
		bbsGenre.setView_count(10);
		session.insert("communityMapper.putBbs", bbsGenre);
	}

}
