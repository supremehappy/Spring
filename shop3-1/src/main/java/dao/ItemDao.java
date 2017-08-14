package dao;

import java.util.List;

import logic.Item;

public interface ItemDao {
	
	List<Item> findAll();
	//------------------------------------------------------------------------------------ add(8.14:9h)
	Item findByPrimaryKey(Integer id);
}
