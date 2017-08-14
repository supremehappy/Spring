package logic;

import java.util.List;

public interface MyShop {

	List<Product> getIProductList();
	Product getItemByItemId(Integer id);
}
