package dao;

import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Product;

@Service
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SqlSession session;

	public List<Product> findAll() {
		
		List<Product> list = session.selectList("productMapper.getProductList");
		
		return list;
	}

	public Product findByPrimaryKey(Integer id) {
		
		Product product = session.selectOne("productMapper.getProduct",id);
		
		return product;
	}

}
