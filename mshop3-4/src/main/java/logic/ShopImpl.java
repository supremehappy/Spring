package logic;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Cart;
import model.Item;
import model.ItemSet;
import model.User;

@Service
public class ShopImpl implements Shop {
	@Autowired
	private ItemCatalog itemCatalog;
	@Autowired
	private UserCatalog userCatalog;
	@Autowired
	private SaleCatalog saleCatalog;
	
	//---------------------------------------------------------
	public List<Item> getItemList() {
		
		return this.itemCatalog.getItemList();
	}

	public Item getItemByItemId(Integer id) {
		
		return this.itemCatalog.getItemByItemId(id);
	}
	//---------------------------------------------------------
	public User getUserByUserIdAndPassword(User user) {
		 
		return this.userCatalog.getUserByIdAndPassword(user);
	}

	public void entryUser(User user) {
		this.userCatalog.entryUser(user); 

	}
	//---------------------------------------------------------
	public Cart getCart() {
		
		return new Cart();
	}
	//---------------------------------------------------------
	public Integer calculateTotalAmount(List<ItemSet> itemList) {
		int totalAmount = 0;
		
		for(ItemSet itemSet : itemList){
			int price = itemSet.getItem().getPrice();
			int quantity = itemSet.getQuantity();
			
			totalAmount = totalAmount + (price * quantity);
		}
		
		return totalAmount;
	}

	public void checkout(User user, Cart cart) {

		Sale sale = createSale(user, cart);
		entrySale(sale);
		
	}
	
	private Sale createSale(User user, Cart cart){
		Sale sale = new Sale();
		
		sale.setSaleId(getNewSaleId());
		sale.setUser(user);
		sale.setUserId(user.getUserId());
		
		Timestamp currentTime = getCurrentTime();
		
		sale.setUdateTime(currentTime);
		
		List<ItemList> itemList = cart.getItemList();
		
		for(int i =0 ; i <itemList.size;i++){
			ItemSet itemSet = (ItemSet)itemList.get(i);
			int saleLineId = i+1;
			SaleLine saleLine = createSaleLine(sale, saleLineId, itemSet, currentTime);
			
			sale.addSaleLine(saleLine);
		}
	}

}
