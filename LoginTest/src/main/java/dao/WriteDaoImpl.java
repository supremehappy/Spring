package dao;

import java.util.Calendar;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bbs_free;
import model.Notice;

@Repository
public class WriteDaoImpl implements WriteDao {

	@Autowired
	private SqlSession session;
	
	//-----------------------------------------------free
	public void insertFreeWriting(Bbs_free free) {
		free.setSeq(getMaxFreeId()+1);
		
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month=today.get(Calendar.MONTH)+1;
		int date = today.get(Calendar.DATE);
		String freebbsDate = year+""+month+""+date;
		
		free.setReg_date(freebbsDate);
		String fileName="";
		free.setImage1(fileName);
		System.out.println("WriteController getImage1 "+free.getImage1());
		free.setImage2(fileName);
		System.out.println("WriteController getImage2 "+free.getImage2());
		free.setImage3(fileName);
		System.out.println("WriteController getImage3 "+free.getImage3());
		free.setImage4(fileName);
		System.out.println("WriteController getImage4 "+free.getImage4());
		free.setImage5(fileName);
		System.out.println("WriteController getImage5 "+free.getImage5());
		
		this.session.insert("bbsMapper.insertFreeWritingInfo",free);
		
	}

	public Integer getMaxFreeId() {
 
		return this.session.selectOne("bbsMapper.getMaxFreeId");
	}

	//-------------------------------------------------notice
	public void insertNoticeWriting(Notice notice) {

		notice.setSeq(getMaxFreeId()+1);
		
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month=today.get(Calendar.MONTH)+1;
		int date = today.get(Calendar.DATE);
		String freebbsDate = year+"/"+month+"/"+date;
		
		notice.setReg_date(freebbsDate);
		
		this.session.insert("bbsMapper.insertNoticeWritingInfo",notice);
	}

	public Integer getMaxNoticeId() {

		return this.session.selectOne("bbsMapper.getMaxNoticeId");
	}

	

}
