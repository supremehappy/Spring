package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Item;
import model.User;

@Service
public class ShopImpl implements Shop {
	@Autowired
	private ItemCatalog itemCatalog;
	@Autowired
	private UserCatalog userCatalog;
	
	public List<Item> getItemList() {
		
		return this.itemCatalog.getItemList();
	}

	public Item getItemByItemId(Integer id) {
		
		return this.itemCatalog.getItemByItemId(id);
	}

	public User getUserByUserIdAndPassword(User user) {
		 
		return this.userCatalog.getUserByIdAndPassword(user);
	}

	public void entryUser(User user) {
		this.userCatalog.entryUser(user); 

	}

}
