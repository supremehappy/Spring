package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.SaleLine;

@Repository
public class SaleLineDaoImpl implements SaleLineDao {
	@Autowired
	private SqlSession session;
	public void create(SaleLine saleLine) {
		this.session.insert("shopMapper.putSaleLine",saleLine);
	}

}
