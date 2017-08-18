package logic;

import java.util.List;

import model.Cart;
import model.Item;
import model.ItemSet;
import model.User;

public interface Shop {
	Integer calculateTotalAmount(List<ItemSet> itemList);
	void checkout(User user, Cart cart);
	
	Cart getCart();
	List<Item> getItemList();
	Item getItemByItemId(Integer id);
	User getUserByUserIdAndPassword(User user);
	void entryUser(User user);
}
