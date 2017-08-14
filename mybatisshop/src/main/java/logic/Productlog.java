package logic;

import java.util.List;

import model.Product;

public interface Productlog {

	List<Product> getProductList();
	Product getItemByItemId(Integer id);
}
