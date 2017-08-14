package logic;

import java.util.List;

public interface Shop {

	List<Item> getItemList();
	//------------------------------------------------------------------------------------ add(8.14:9h)
	Item getItemByItemId(Integer id);
}
