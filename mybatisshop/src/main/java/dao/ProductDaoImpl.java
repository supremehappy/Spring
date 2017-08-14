package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Product;

public class ProductDaoImpl implements ProductDao {

	private SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	public List<Product> findAll() {
		
		List<Product> list = session.selectList("myshopMapper.getProductList");
		
		return list;
	}


	public Product findByPrimaryKey(Integer id) {

		Product product = session.selectOne("myshopMapper.getProduct",id);
		
		return product;
	}

}
