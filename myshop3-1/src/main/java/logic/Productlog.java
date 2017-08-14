package logic;

import java.util.List;

public interface Productlog {

	List<Product> getProductList();
	Product getItemByItemId(Integer id);
}
