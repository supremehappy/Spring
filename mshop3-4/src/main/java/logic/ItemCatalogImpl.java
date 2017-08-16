//------------------------------------------------------------------------------------ add(8.14:1h)
package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.ItemDao;
import model.Item;

@Repository
public class ItemCatalogImpl implements ItemCatalog {

	@Autowired
	private ItemDao itemDao;
	
	public List<Item> getItemList() {
		
		return this.itemDao.findAll();
	}
	
	public Item getItemByItemId(Integer id) {
		
		return this.itemDao.findByPrimaryKey(id);
	}

}
