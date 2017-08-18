package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Sale;
@Repository
public class SaleDaoImpl implements SaleDao {
	@Autowired
	private SqlSession session;
	public void create(Sale sale) {
		this.session.insert("shopMapper.putSale",sale);
	}

	public Integer findMaxSaleId() {
		Object obj=this.session.selectOne(
				"shopMapper.getMaxSaleId");
		if(obj == null) {
			return 0;
		}else{
			return Integer.parseInt(String.valueOf(obj));
		}
	}

}









