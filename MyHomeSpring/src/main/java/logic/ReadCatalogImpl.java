package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReadDao;
import model.Bbs;
import model.Condition;
@Service
public class ReadCatalogImpl implements ReadCatalog {
	@Autowired
	private ReadDao readDao;
	
	public List<Bbs> readAll(Condition con) {
		return this.readDao.readBBS(con);
	}

	public Bbs readDetail(Integer seqno) {
		return this.readDao.getBBs(seqno);
	}

	public Integer getBbsCount() {
		return this.readDao.getBBSCount();
	}

}










