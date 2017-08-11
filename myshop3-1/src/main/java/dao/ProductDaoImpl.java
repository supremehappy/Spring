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
			"select pid, name, pricel from product_info";
	
	public void setDataSource(DataSource source){
		this.template = new SimpleJdbcTemplate(source);
	}
	
	@Override
	public List<Product> findAll() {
		
		RowMapper<Product> mapper = new BeanPropertyRowMapper<Product>(Product.class);
		
		return null;
	}

}
