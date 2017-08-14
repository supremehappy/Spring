//------------------------------------------------------------------------------------ add(8.14:1h)
package logic;

import java.util.List;

import model.Item;

public class ShopImpl implements Shop {

	private ItemCatalog itemCatalog;
	
	public void setItemCatalog(ItemCatalog itemCatalog) {
		this.itemCatalog = itemCatalog;
	}

	public List<Item> getItemList() {
		
		return itemCatalog.getItemList();
	}
	
	public Item getItemByItemId(Integer id) {
		
		return itemCatalog.getItemByItemId(id);
	}

}
