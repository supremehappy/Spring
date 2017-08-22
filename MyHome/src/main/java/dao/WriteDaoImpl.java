package dao;

import java.util.Calendar;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bbs;

@Repository
public class WriteDaoImpl implements WriteDao {
	
	@Autowired
	private SqlSession session;
	
	public Integer getMaxId() {
		
		Integer seqno = session.selectOne("homeMapper.getMaxBbsId");
		
		return seqno;
	}

	public void insertBbs(Bbs bbs) {
		
		Object obj = getMaxId();
		int seqno =0;
		
		if(obj!=null) {
			seqno = Integer.parseInt(String.valueOf(obj));
		}
		
		seqno++;
		
		bbs.setSeqno(seqno);
		
		Calendar today=Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH)+1;
		int date = today.get(Calendar.DATE);
		String bbsDate = year+"/"+month+"/"+date;
				
		bbs.setBbs_date(bbsDate);
		
		this.session.insert("homeMapper.putBBS",bbs);
	}

}
