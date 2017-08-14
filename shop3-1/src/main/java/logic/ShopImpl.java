package logic;

import java.util.List;

public class ShopImpl implements Shop {

	private ItemCatalog itemCatalog;
	
	public void setItemCatalog(ItemCatalog itemCatalog) {
		this.itemCatalog = itemCatalog;
	}

	public List<Item> getItemList() {
		
		return itemCatalog.getItemList();
	}
	
	//------------------------------------------------------------------------------------ add(8.14:9h)
	public Item getItemByItemId(Integer id) {
		
		return itemCatalog.getItemByItemId(id);
	}

}
