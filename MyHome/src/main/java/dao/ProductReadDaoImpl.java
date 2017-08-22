package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Condition;
import model.Product;

@Repository
public class ProductReadDaoImpl implements ProductReadDao {

	@Autowired
	private SqlSession session;
	
	public List<Product> productReadBBS(Condition con) {
		
		return session.selectList("homeMapper.getProductBBSList",con);
	}

	public Product getProductBBS(Integer pid) {
		
		return session.selectOne("homeMapper.getProductBBSDetail",pid);
	}

	public Integer getProductBBSCount() {
		
		return session.selectOne("homeMapper.getProductBBSCount");
	}

}
