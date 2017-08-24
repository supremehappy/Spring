package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Product;
@Repository
public class ProductListDaoImpl implements ProductListDao {
	@Autowired
	private SqlSession session;
	public List<Product> getProducts() {
		return this.session.selectList("shopMapper.getProductList");
	}

}
