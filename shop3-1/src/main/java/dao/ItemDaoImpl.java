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
	//------------------------------------------------------------------------------------ add(8.14:9h)
	private static final String SELECT_ONE = 
			"select item_id, item_name, price, description, picture_url from item where item_id=?";
	
	public void setDataSource(DataSource source) {
		this.template = new SimpleJdbcTemplate(source);
	}

	public List<Item> findAll() {
		
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		
		return this.template.query(ItemDaoImpl.SELECT_ALL, mapper);
		
	}

	//------------------------------------------------------------------------------------ add(8.14:9h)
	public Item findByPrimaryKey(Integer id) {
		
		RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
		
		return this.template.queryForObject(SELECT_ONE, mapper, id);
	}

	
}
