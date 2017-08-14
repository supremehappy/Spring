//------------------------------------------------------------------------------------ add(8.14:1h)
package logic;

import java.util.List;

import model.Item;

public interface Shop {

	List<Item> getItemList();
	Item getItemByItemId(Integer id);
}
