//------------------------------------------------------------------------------------ add(8.14:1h)
package logic;

import java.util.List;

import dao.ItemDao;
import model.Item;

public class ItemCatalogImpl implements ItemCatalog {

	private ItemDao itemDao;
	
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public List<Item> getItemList() {
		
		return this.itemDao.findAll();
	}
	
	public Item getItemByItemId(Integer id) {
		
		return this.itemDao.findByPrimaryKey(id);
	}

}
