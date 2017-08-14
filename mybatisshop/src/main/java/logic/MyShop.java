package logic;

import java.util.List;

import model.Product;

public interface MyShop {

	List<Product> getIProductList();
	Product getItemByItemId(Integer id);
}
