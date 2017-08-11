package dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import logic.Item;

public class ItemDaoImpl implements ItemDao {
	
	private SimpleJdbcTemplate template;
	private static final String SELECT_ALL = 
			"select item_id, item_name, price, description, picture_url from item";
	
	public void setDataSource(DataSource source) {
		this.template = new SimpleJdbcTemplate(source);
	}

	public List<Item> findAll() {
		
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		
		return this.template.query(ItemDaoImpl.SELECT_ALL, mapper);
		
	}

	
}
