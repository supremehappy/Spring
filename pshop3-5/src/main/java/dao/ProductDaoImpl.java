package dao;

import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SqlSession session;
	
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		
		return session.selectList("productMapper.getProductList");
	}

	public Product findByPrimaryKey(Integer pid) {
		// TODO Auto-generated method stub
		return session.selectOne("productMapper.getProduct",pid);
	}

	public List<Product> findByProductName(String name) {
		// TODO Auto-generated method stub
		return session.selectList("productMapper.findProduct",name);
	}

	public void create(Product product) {
		
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH)+1;
		int day = today.get(Calendar.DATE);
		String proDate = year+"년 "+month+"월 "+day+"일 ";
		
		product.setGroup_id(0);
		product.setOrder_no(0);
		product.setParent_id(0);
		product.setId("test");
		product.setP_date(proDate);
		product.setPassword("1");
		
		session.insert("productMapper.putProduct",product);
		
	}

	public void update(Product product) {
		
		session.update("productMapper.updateProduct",product);
		
	}

	public void delete(Integer product) {


		session.delete("productMapper.deleteProduct",product);
		
	}

}
