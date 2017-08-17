package logic;

import java.util.List;

import model.Cart;
import model.Product;
import model.User;

public interface Shop {

	List<Product> getProductList();
	Product getProductByProductId(Integer id);
	User getUserByUserIdAndPassword(User user);
	void entryUser(User user);
	Cart getCart();
}
