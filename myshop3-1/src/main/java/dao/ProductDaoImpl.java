package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import logic.Product;

public class ProductDaoImpl implements ProductDao {

	private SimpleJdbcTemplate template;
	private static final String SELECT_ALL = 
			"select pid,group_id,order_no,parent_id, name, price,p_date,content,id from product_info";
	private static final String SELECT_ONE = 
			"select pid,group_id,order_no,parent_id, name, price,p_date,content,id from product_info where pid=?";
	
	public void setDataSource(DataSource source){
		this.template = new SimpleJdbcTemplate(source);
	}
	
	
	public List<Product> findAll() {
		
		RowMapper<Product> mapper = new BeanPropertyRowMapper<Product>(Product.class);
		
		return this.template.query(ProductDaoImpl.SELECT_ALL,mapper);
	}


	public Product findByPrimaryKey(Integer id) {

		RowMapper<Product> mapper = new BeanPropertyRowMapper<Product>(Product.class);
		
		return this.template.queryForObject(SELECT_ONE, mapper, id);
	}

}
