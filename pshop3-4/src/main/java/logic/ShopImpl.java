package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Cart;

import model.Product;
import model.User;

@Service
public class ShopImpl implements Shop {
	
	@Autowired
	private ProductCatalog productCatalog;
	@Autowired
	private UserCatalog userCatalog;
	
	public List<Product> getProductList() {
		
		return this.productCatalog.getProductList();
	}

	public Product getProductByProductId(Integer id) {
		
		return this.productCatalog.getProductByProductId(id);
	}

	public User getUserByUserIdAndPassword(User user) {
		 
		return this.userCatalog.getUserByIdAndPassword(user);
	}

	public void entryUser(User user) {
		this.userCatalog.entryUser(user); 

	}

	public Cart getCart() {
		
		return new Cart();
	}
}
