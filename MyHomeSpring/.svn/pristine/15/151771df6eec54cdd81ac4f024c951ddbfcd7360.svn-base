package dao;

import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bbs;
import model.Writing;

@Repository
public class WriteDaoImpl implements WriteDao {
	@Autowired
	private SqlSession session;
	public void insertWriting(Writing writing) {
		writing.setWriting_id(getMaxWritingId()+1);
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month=today.get(Calendar.MONTH)+1;
		int date = today.get(Calendar.DATE);
		String bbsDate = year+"/"+month+"/"+date;
		writing.setRegister_date(bbsDate);
		this.session.insert("shopMapper.insertWritingInfo",writing);
	}
	public Integer getMaxWritingId() {
		return this.session.selectOne("shopMapper.getMaxWritingId");
	}
	public List<Writing> getWriting() {
		return this.session.selectList("shopMapper.getWritingInfo");
	}
	public Integer getMaxId() {
		Integer seqno=session.selectOne("shopMapper.getMaxBbsId");
		return seqno;
	}
	public void insertBbs(Bbs bbs) {
		Object obj = getMaxId();
		int seqno = 0;
		if(obj != null) 
			seqno = Integer.parseInt(String.valueOf(obj));
		seqno++;
		bbs.setSeqno(seqno);
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month=today.get(Calendar.MONTH)+1;
		int date = today.get(Calendar.DATE);
		String bbsDate = year+"/"+month+"/"+date;
		bbs.setBbs_date(bbsDate);
		this.session.insert("shopMapper.putBBS",bbs);
	}

}








