package logic;

import java.util.List;

import model.Item;
import model.User;

public interface Shop {

	List<Item> getItemList();
	Item getItemByItemId(Integer id);
	User getUserByUserIdAndPassword(User user);
	void entryUser(User user);
}
