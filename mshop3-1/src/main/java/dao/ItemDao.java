//------------------------------------------------------------------------------------ add(8.14:1h)
package dao;

import java.util.List;

import model.Item;

public interface ItemDao {
	
	List<Item> findAll();
	Item findByPrimaryKey(Integer id);
}
